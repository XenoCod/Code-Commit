import java.util.List;
import java.util.ArrayList;
import java.lang.StringBuilder;

class RestoreIPAddress{

	private static List<String> restoreIP(String s){
		//Using the backtracking approach
		List<String> list= new ArrayList<>();
		backtrack(list, s, new StringBuilder(), 0, 0);
		return list;
	}


	private static void backtrack(List<String> list, String s, StringBuilder sb, int ind, int level){
		//If its already out of limit then just return backl
		if(ind > s.length() || level > 4) return;
		else if(ind == s.length() && level == 4){
			list.add(sb.toString());
			return;
		}

		for(int i=1; i<=3; i++){
			if(ind + i > s.length()) break;
			int num= Integer.parseInt(s.substring(ind, ind + i));
			//Checking if the number is single didgit then if is in under greather than 1 and 99 or if its 3 didgit num then is it less than 255 then do the task
			sb.append(num);
			//If there is still space then proceed 
			if(level < 3) sb.append(".");
			//Call for next
			backtrack(list, s, sb, ind + i, level + 1);
			//when the condition fails then backtrack
			if(level < 3) sb.deleteCharAt(sb.length() -1);
			sb.delete(sb.length() - i, sb.length());
		}
	}

	public static void main(String[] args) {

// Input: s = "25525511135"
// Output: ["255.255.11.135","255.255.111.35"]

		String s="25525511135";
				System.out.println(restoreIP(s));


	}
}