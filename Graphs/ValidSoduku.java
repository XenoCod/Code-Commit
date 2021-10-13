import java.util.*;

public class ValidSoduku{
	static boolean isValid(char board[][]){
		int N=9;
		Set<Character> [] rowSet= new HashSet[N];
		Set<Character> [] colSet= new HashSet[N];
		Set<Character> [] squareSet= new HashSet[N];

		for(int i=0; i<N; i++){
			rowSet[i]= new HashSet<>();
			colSet[i]= new HashSet<>();
			squareSet[i]= new HashSet<>();
		}

		for(int r=0; r<N; r++){
			for(int c=0; c<N; c++){
				char val= board[r][c];

				if(val == '.') continue;

				int squareIndex = (r / 3) * 3 + c /3;
				if(rowSet[r].contains(val) || colSet[c].contains(val) || squareSet[squareIndex].contains(val))
					return false;

				rowSet[r].add(val);
				colSet[c].add(val);
				squareSet[squareIndex].add(val);
			}
		}
		return true;
	}
	public static void main(String[] args) {
		char board[][]={{'5','3','.','.','7','.','.','.','.'},
		{'6','.','.','1','9','5','.','.','.'},
		{'.','9','8','.','.','.','.','6','.'},
		{'8','.','.','.','6','.','.','.','3'},
		{'4','.','.','8','.','3','.','.','1'},
		{'7','.','.','.','2','.','.','.','6'},
		{'.','6','.','.','.','.','2','8','.'},
		{'.','.','.','4','1','9','.','.','5'},
		{'.','.','.','.','8','.','.','7','9'}};

		System.out.println(isValid(board));
	}
}
