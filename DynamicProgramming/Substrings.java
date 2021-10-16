class Substrings{
	public static void main(String[] args) {
		String s="Aditya";
		for(int i=1; i<s.length(); i++){
			for(int j=0; j<i; j++){
						System.out.println(s.substring(i, j+1));
			}
		}
	}
}