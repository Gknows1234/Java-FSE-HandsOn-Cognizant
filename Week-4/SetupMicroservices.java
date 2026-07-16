import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

public class SetupMicroservices {
    public static void main(String[] args) throws Exception {
        String baseDirStr = "d:/Java/Digital-Nurture-JavaFSE-main (1)/Digital-Nurture-JavaFSE-main/Java FSE/Deepskilling/Week-4/microservices";
        Path baseDir = Paths.get(baseDirStr);
        Files.createDirectories(baseDir);

        class Project {
            String name;
            String deps;
            Project(String name, String deps) {
                this.name = name;
                this.deps = deps;
            }
        }
        
        List<Project> projects = Arrays.asList(
            new Project("account", "web,devtools,cloud-eureka"),
            new Project("loan", "web,devtools,cloud-eureka"),
            new Project("eureka-discovery-server", "cloud-eureka-server"),
            new Project("greet-service", "web,devtools,cloud-eureka"),
            new Project("api-gateway", "cloud-gateway,devtools,cloud-eureka")
        );

        HttpClient client = HttpClient.newBuilder().followRedirects(HttpClient.Redirect.NORMAL).build();

        for (Project p : projects) {
            String name = p.name;
            String deps = p.deps;
            String packageName = "com.cognizant." + name.replace("-", "");
            String url = String.format("https://start.spring.io/starter.zip?type=maven-project&language=java&baseDir=%s&groupId=com.cognizant&artifactId=%s&name=%s&packageName=%s&packaging=jar&javaVersion=17&dependencies=%s",
                name, name, name, packageName, deps);

            System.out.println("Downloading " + name + "...");
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();
            
            Path zipPath = baseDir.resolve(name + ".zip");
            HttpResponse<Path> response = client.send(request, HttpResponse.BodyHandlers.ofFile(zipPath));
            
            System.out.println("Extracting " + name + "...");
            try (InputStream is = Files.newInputStream(zipPath);
                 ZipInputStream zis = new ZipInputStream(is)) {
                
                ZipEntry entry;
                while ((entry = zis.getNextEntry()) != null) {
                    Path resolvedPath = baseDir.resolve(entry.getName()).normalize();
                    if (!resolvedPath.startsWith(baseDir)) {
                        throw new RuntimeException("Entry is outside of the target dir: " + entry.getName());
                    }
                    if (entry.isDirectory()) {
                        Files.createDirectories(resolvedPath);
                    } else {
                        Files.createDirectories(resolvedPath.getParent());
                        Files.copy(zis, resolvedPath, StandardCopyOption.REPLACE_EXISTING);
                    }
                }
            }
            Files.delete(zipPath);
            System.out.println("Finished " + name);
        }
        System.out.println("All projects created.");
    }
}
