class PrevPermute{
	int[] prevPermute(int nums[]){
		int n= nums.length;
		int lastElement=-1;

		//Find the index of the element which is greate than the last element
		for(int i=n-1; i>=1; i--){
			if(nums[i-1] > nums[i]){
				lastElement=i-1;
				break;
			}
		}

		//Edge case if the nums is increasing then simplt return

		if(lastElement == -1) return nums;

		for(int i=n-1; i>lastElement; i--){
			if(nums[i] < nums[lastElement] && nums[i] != nums[i-1]){
				swap(nums, lastElement, i);
				break;
			}
		}




		return nums;

	}

	private void swap(int nums[], int a, int b){
			int temp= nums[a];
			nums[a]= nums[b];
			nums[b]= temp;
	}

	public static void main(String[] args) {
		int nums[]={1,9,4,6,7};
		//Find the prev permutation
		PrevPermute obj= new PrevPermute();
		obj.prevPermute(nums);
		for(int i: nums) System.out.print(i+" ");
	}
}