package leetcode;

public class buyStockWithFee {
    public static int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[] dp = new int[n];
        int[] count = new int[n];
        // int[] res = new int[n];
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                int curDP = dp[j] + prices[i] - prices[j];
                int curCount = 1 + count[j];
                if (curDP - fee * curCount >= max) {
                    dp[i] = curDP;
                    count[i] = curCount;
                    max = curDP - fee * curCount;
                }
            }
            if (dp[i - 1] - fee * count[i - 1] > max) {
                dp[i] = dp[i - 1] - fee * count[i - 1];
                count[i] = count[i - 1];
            }
            //System.out.println(max);
            // System.out.println(dp[i]);
            // System.out.println(count[i]);
        }
        return dp[n - 1] - fee * count[n - 1];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1,3,2,8,4};
        int fee = 2;
        System.out.println(maxProfit(prices, fee));
    }
}
