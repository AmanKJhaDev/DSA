package org.example;

public class knapsacktabu {
    public static void print(int dp[][]) {
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");

            }
            System.out.println();
        }
        System.out.println();
    }


    public static int knapsacktabu(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                int v = val[i - 1];
                int w = wt[i - 1];
                if (w <= j) {
                    int incProfit = v + dp[i - 1][j - w];
                    int excProfit = dp[i - 1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        print(dp);
        return dp[n][W];
    }


    public static void main(String[] args) {
        int[] val = { 10, 20, 30 };
        int[] wt = { 5, 10, 15 };
        int W = 20;

        System.out.println(knapsacktabu(val, wt, W));

    }
}
