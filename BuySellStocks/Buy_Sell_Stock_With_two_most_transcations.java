public class Buy_Sell_Stock_With_two_most_transcations{
	
	static void maxProfit(int prices[]){

		/*
		We make 2 assumption

		1. From Left we find the maxProfit we can make if we sold on each day starting from the left

		2. From right we find the maxProfit we can make if we buy on each day and so we find the max seen on the right 

		3. Then we find the total dpfromleft and dpfromright find thr max of dp 
		*/

		int n= prices.length;

		int maxProfitFromLeft= 0;
		int minSeenFromLeft= prices[0];
		int dpFromLeft[]= new int[n];

		//Traversing from leftś
		for(int i=1; i< n; i++){
			minSeenFromLeft= Math.min(minSeenFromLeft, prices[i]);

			maxProfitFromLeft= prices[i] - minSeenFromLeft;
			dpFromLeft[i]= Math.max(dpFromLeft[i- 1], maxProfitFromLeft);
		}


		//Travseing from right
		int maxSeenSofar= prices[n-1];
		int maxProfitFromRight=0;
		int dpFromRight[]= new int[n];

		for(int i=n-2; i>=0; i--){
			maxSeenSofar= Math.max(maxSeenSofar, prices[i]);

			maxProfitFromRight= maxSeenSofar - prices[i];
			dpFromRight[i]= Math.max(dpFromRight[i+1], maxProfitFromRight);
		}


		int totalProfit=0;
		for(int i=0; i<n; i++){
			totalProfit= Math.max(totalProfit, dpFromRight[i] + dpFromLeft[i]);
		}

				System.out.println(totalProfit);
	}

	public static void main(String[] args) {
		int prices[]={3,3,5,0,0,3,1,4};
		maxProfit(prices);
	}
}