public class Buy_Sell_Stock_II{
	static int maxProfit(int prices[]){
		// we keep the selling data one by one wheenever we are seeing a higher val than prev val
		//when we encounter a prev val > curr val we know futher transcations may lead to loss so we collect our profit and move the buy date to selling date to i
		int buyDate=0, sellDate=0, profit=0;
		for(int i=1; i< prices.length; i++){

			if(prices[i-1] < prices[i]) sellDate++;

			else{
				//when we encounter curr val < prev val
				profit += prices[sellDate] - prices[buyDate];
				buyDate = sellDate =i;
			}
		}
		profit += prices[sellDate] - prices[buyDate];//settling the last profit when we encounter no further dips
		return profit;
	}
	public static void main(String[] args) {
		int prices[]={7,1,5,3,6,4};
		System.out.println(maxProfit(prices));
	}
}