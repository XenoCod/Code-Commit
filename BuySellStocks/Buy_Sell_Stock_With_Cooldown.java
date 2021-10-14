public class Buy_Sell_Stock_With_Cooldown{

	static void maxProfit(int prices[]){
		/*
		Since here we can only buy again after completing the cooldown period

		so the process becomes
		Buy Sell CoolDown

		Here instead of cal the next buy with the sold we will calc with the cooldown proft 
		and it is just similar as Buy sell stock with transcation fee we are just comparing it with cooldown instead of sold state
		for more info watcht the pepcoding video of it

		*/


		/*
		For buying

		During buying
		1. We can keep having a previous old_buy
		2. We can change from the prev cool down


		During Selling
		1. We can keep the prev sold_state profit
		2. We come from selling the prev buying state profit

		During Cooldown
		1. We can keep the prev cooldown profit
		2. We can change the state from old sold state profit
		*/

		int old_bought_state_profit= -prices[0];
		int old_sold_state_profit= 0;
		int old_cooldown_state_profit=0;

		for(int i=1; i< prices.length; i++){
			int new_bought_state_profit=0;
			int new_sold_state_profit=0;
			int new_cooldown_state_profit=0;

			//For buying check with prev buying state and check with old cooldown period
			if(old_cooldown_state_profit - prices[i] > old_bought_state_profit){
				new_bought_state_profit= old_cooldown_state_profit - prices[i];
			}
			else{
				new_bought_state_profit= old_bought_state_profit;
			}


			//For selling we check with the prev sold state profit and check we old bought state profit
			if(old_bought_state_profit + prices[i] > old_sold_state_profit){
				new_sold_state_profit= old_bought_state_profit + prices[i] ;
			}
			else{
				new_sold_state_profit= old_sold_state_profit;
			}

			//For checking with cooldown profit we check with prev cooldown period vs old_sold_state profit
			if(old_sold_state_profit > old_cooldown_state_profit){
				new_cooldown_state_profit= old_sold_state_profit;
			}
			else{
				new_cooldown_state_profit= old_cooldown_state_profit;
			}

			old_cooldown_state_profit= new_cooldown_state_profit;
			old_sold_state_profit= new_sold_state_profit;
			old_bought_state_profit= new_bought_state_profit;
		}
				System.out.println(old_sold_state_profit);
	}

	public static void main(String[] args) {
		int prices[]={1,2,3,0,2};
		maxProfit(prices);
	}
}