class KthSmallestNumberInMultiplicationTable{

	private static int findKthVal(int m, int n, int k){
		int low= 0, high=m * n; 
		while(low <= high){
			int mid = low + (high - low) / 2;
			if(countTheElementsLessThanMid(m, n, mid) < k) low= mid + 1;
			else high= mid -1;
		}
		return low;
	}


	private static int countTheElementsLessThanMid(int m, int n, int k){
		int res=0;
		for(int i=1; i<= m; i++) res += Math.min(k / i, n);
		return res;
	}

	public static void main(String[] args) {
// Input: m = 3, n = 3, k = 5
// nums=1 * 1, 1 * 2, 1 * 3, 2 * 1, 2 * 3,.... to 3 * 3;
// Output: 3
// Explanation: The 5th smallest number is 3.

		int m=3, n=3, k=5;
				System.out.println(findKthVal(m, n, k));
	}
}