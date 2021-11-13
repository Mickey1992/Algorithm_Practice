package leetcode;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args){
        int[] prices1 = {7,1,5,3,6,4};
        System.out.println(maxProfit2(prices1));

        int[] prices2 = {7,6,4,3,1};
        System.out.println(maxProfit2(prices2));
    }
    public static int maxProfit1(int[] prices) {
        int[] maxAfter = new int[prices.length];
        for(int i = prices.length - 2; i >= 0; i--){
            maxAfter[i] = Math.max(maxAfter[i+1], prices[i+1]);
        }

        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++){
            maxProfit = Math.max(maxProfit, Math.max(maxAfter[i]-prices[i], 0));
        }

        return maxProfit;
    }

    public static int maxProfit2(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        for(int i = 1; i < prices.length; i++){
            if(minPrice > prices[i]){
                minPrice = prices[i];
            }
            else if(prices[i] - minPrice > maxProfit){
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

}
