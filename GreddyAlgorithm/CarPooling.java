class CarPooling{
	static boolean isPossibleToDropAllPasssangers(int trips[][], int capacity){
		//Using the concepts of diff array
        int currCapacity[]= new int[1001];
        
        
        //The main idea is that we increase an bucket when with passanger in from and decrease it when by
        
        /*
        trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11
        
        So initially, curr = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        After trip 1 curr = [0, 0, 3, 0, 0, 0, 0, -3, 0, 0]
        After trip 2 curr = [0, 0, 3, 0, 0, 0, 0, 0, 0, -3]
        After trip 3 curr = [0, 0, 3, 8, 0, 0, 0, -3, 0, -11]
        */
        
        // After processing all trips, a positive value for the specific location tells that we are getting more passengers; negative - more empty seats.
        
        for(int trip[]: trips){
            int pass=trip[0];
            int from = trip[1];
            int to= trip[2];
            currCapacity[from] += pass;
            currCapacity[to] -= pass;
        }
        
        int sum=0;
        for(int i: currCapacity){
            sum += i;
            if(sum > capacity) return false;
        }
        return true;
	}
	public static void main(String[] args) {
		int trips[][]={{3,2,7},{3,7,9},{8,3,9}};
		int capacity=11;
		// Return true if it is possible to pick up and drop off all passengers for all the given trips, or false otherwise.
		// Array reprsentation=> [passanger at curr stop, from , to]
				System.out.println(isPossibleToDropAllPasssangers(trips, capacity));
	}
}