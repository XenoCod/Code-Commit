public class Buy_Sell_Stock_With_Fee{
	
	static void maxProfit(int prices[], int fee){

//We maintain 2 states bought state and sold state
		// on every bought state we have 2 choice 
		/*
		1. We can either continue to stay on the previous bought state 
		2. Or we can buy a stock with previous profit we have after selling the stock
		*/

		//On every sold state we have 2 options
		/*
		1. We can either continue with the previous sold state
		2. Or we can sell the already bought stock on the day if the stock price is higher is than the day we bought the stock
		*/


		//key terms used in code

		//bsp= bought state profit
		//ssp= sold state profit
		//nbsp= new bought state profit
		//nssp= new sold state profit


		int old_bought_state_profit= -prices[0];
		int old_sold_state_profit= 0;
		

		for(int i=1; i< prices.length; i++){
			int new_bought_state_profit= 0;
			int new_sold_state_profit= 0;

			//Calcluating when buying the stock
			if(old_sold_state_profit - prices[i] > old_bought_state_profit){
				new_bought_state_profit = old_sold_state_profit - prices[i];
			}
			else{
				new_bought_state_profit = old_bought_state_profit;
			}


			//Calcuating when selling the stock
			if(old_bought_state_profit + prices[i] - fee > old_sold_state_profit){
				new_sold_state_profit =old_bought_state_profit + prices[i] - fee;
			}
			else{
				new_sold_state_profit= old_sold_state_profit;
			}


			//Updaitng the old values
			old_bought_state_profit= new_bought_state_profit;
			old_sold_state_profit= new_sold_state_profit;
		}
				System.out.println(old_sold_state_profit);
	}

	public static void main(String[] args) {
		int prices[]={1,3,2,8,4,9};
		int fee=2;
		maxProfit(prices, fee);
	}
}