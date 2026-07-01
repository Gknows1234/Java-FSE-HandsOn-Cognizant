

import java.util.Arrays;

public class SearchAlgorithms {

    public static Product linearSearch(Product[] arr, int idToFind) {
        int index = 0;
        while (index < arr.length) {
            Product currentProd = arr[index];
            if (currentProd.getProductId() == idToFind) {
                return currentProd;
            }
            index++;
        }
        return null;
    }

    public static Product binarySearch(Product[] sortedArr, int idToFind) {
        Arrays.sort(sortedArr);
        
        int start = 0;
        int end = sortedArr.length - 1;

        while (start <= end) {
            int middlePosition = (start + end) / 2;
            Product midProd = sortedArr[middlePosition];
            
            int midId = midProd.getProductId();

            if (midId == idToFind) {
                return midProd;
            } 
            
            if (midId < idToFind) {
                start = middlePosition + 1;
            } else {
                end = middlePosition - 1;
            }
        }
        return null;
    }
}
