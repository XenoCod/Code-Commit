public class Buy_Sell_Stock_I{
	public static int maxProfit(int[] prices) {
        int maxProfit=0;
        int minSofar=prices[0];
        for(int i=1; i<prices.length; i++){
            minSofar= Math.min(minSofar, prices[i]);
            maxProfit= Math.max(maxProfit, prices[i] - minSofar);
        }
        return maxProfit;
    }
	public static void main(String[] args) {
		int prices[]={7,1,5,3,6,4};
		System.out.println(maxProfit(prices));
	}
}