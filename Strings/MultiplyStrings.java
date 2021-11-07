class MultiplyStrings{

	private static String multiply(String num1, String num2){
		int n1 = num1.length(), n2= num2.length();
        
        int res[]= new int[n1 + n2];
        
        for(int i=n1-1; i>=0; i--){
            for(int j=n2-1; j>=0; j--){
                int n1Char = num1.charAt(i) - '0';
                int n2Char = num2.charAt(j) - '0';
                
                int product = n1Char * n2Char;
                //Adding the char stored prev in the res arr
                product += res[i + j +1];
                
                //Adding the product in the res array
                res[i + j + 1]= product % 10;   //Adding the last digit
                res[i + j] += product / 10;      //Adding the carry
            }
        }
        
        StringBuilder sb= new StringBuilder();
        for(int i: res){
            if(sb.length() == 0 && i == 0) continue;// ignore the leading zeros
            sb.append(i);
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
        
        
	}



	public static void main(String[] args) {
		String a="2";
		String b="5";
		System.out.println(multiply(a, b));
	}
}