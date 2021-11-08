class isRobotBounded{

	private static boolean isBounded(String instructions){
		
		int x =0, y=0;
        char dir='N';
        //N= North, S= South, E=East, W= West
        for(char c: instructions.toCharArray()){
            
            if(c == 'G'){
                if(dir == 'N') x += 1;
                else if(dir == 'S') x -= 1;
                else if(dir == 'E') y+= 1;
                else y -= 1;
            }
            
            
            else if(c == 'L'){
                if(dir == 'N') dir = 'W';
                else if(dir == 'W') dir ='S';
                else if(dir == 'S') dir = 'E';
                else dir = 'N';
            }
            
            else if(c == 'R'){
                if(dir == 'N') dir = 'E';
                else if(dir == 'E') dir = 'S';
                else if(dir == 'S') dir = 'W';
                else dir = 'N';
            }
        }
        
        if(x == 0 && y == 0) return true;
        if(dir == 'N') return false; //If the x != 0 && y !=0 but the dir is N then i have drift away
        return true;
        
	}

	public static void main(String[] args) {

// On an infinite plane, a robot initially stands at (0, 0) and faces north. The robot can receive one of three instructions:

// "G": go straight 1 unit;
// "L": turn 90 degrees to the left;
// "R": turn 90 degrees to the right.
// The robot performs the instructions given in order, and repeats them forever.

// Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.

 

// Example 1:

// Input: instructions = "GGLLGG"
// Output: true
// Explanation: The robot moves from (0,0) to (0,2), turns 180 degrees, and then returns to (0,0).
// When repeating these instructions, the robot remains in the circle of radius 2 centered at the origin.

		String inst= "GGLLGG";
				System.out.println(isBounded(inst));
	}
}