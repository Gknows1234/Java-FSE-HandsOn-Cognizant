



public class ForecastingTest {
    public static void main(String[] args) {
        double money = 1000.0;
        double rate = 0.05;
        int years = 5;

        double finalAmount = FinancialForecasting.predictFutureValue(money, rate, years);
        
        System.out.println("Initial money: " + money);
        System.out.println("Interest rate: " + rate);
        System.out.println("Years: " + years);
        System.out.println("Predicted value: " + finalAmount);
    }
}
