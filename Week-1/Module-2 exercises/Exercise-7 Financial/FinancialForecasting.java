

public class FinancialForecasting {

    public static double predictFutureValue(double currentVal, double interest, int yearsLeft) {
        if (yearsLeft == 0) {
            return currentVal;
        }
        
        double nextYearVal = currentVal + (currentVal * interest);
        int remainingYears = yearsLeft - 1;
        
        return predictFutureValue(nextYearVal, interest, remainingYears);
    }
}
