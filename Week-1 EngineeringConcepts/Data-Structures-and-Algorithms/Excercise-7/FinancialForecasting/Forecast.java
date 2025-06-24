public class Forecast {
    public static double predictFutureValue(int years, double currentValue, double growthRate) {
        if (years == 0) {
            return currentValue;
        }
        return predictFutureValue(years - 1, currentValue, growthRate) * (1 + growthRate);
    }

    public static double predictFutureValueMemo(int years, double currentValue, double growthRate, double[] memo) {
        if (years == 0) {
            return currentValue;
        }
        if (memo[years] != 0) {
            return memo[years];
        }
        memo[years] = predictFutureValueMemo(years - 1, currentValue, growthRate, memo) * (1 + growthRate);
        return memo[years];
    }
}
