public class Tester {
    public static void main(String[] args) {
        double currentValue = 10000;
        double growthRate = 0.1;
        int years = 5;

        double forecast = Forecast.predictFutureValue(years, currentValue, growthRate);
        System.out.println("Recursive Forecast (No Memo): " + forecast);

        double[] memo = new double[years + 1];
        double forecastMemo = Forecast.predictFutureValueMemo(years, currentValue, growthRate, memo);
        System.out.println("Recursive Forecast (With Memo): " + forecastMemo);
    }
}
