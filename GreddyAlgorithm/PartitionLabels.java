import java.util.ArrayList;

class PartitionLabels{

	void getPartition(String s){
		//We store the last seen index for every character
		int lastSeen[]= new int[26];
		for(int i=0; i< s.length(); i++){
			char c= s.charAt(i);
			lastSeen[c - 'a'] =i;
		}

		int start=0, end=0;
		ArrayList<Integer> list= new ArrayList<>();
		//We get the end of every char when we encounter the last seen index of a char we capature the length with help of sliding windiw 
		for(int i=0; i<s.length(); i++){
			char c= s.charAt(i);
			end = Math.max(end, lastSeen[c - 'a']);

			if(i == end){
				list.add(end - start +1);
				start= end+1;
			}
		}
				System.out.println(list);
	}


	public static void main(String[] args) {
		String s="ababcbacadefegdehijhklij";
		PartitionLabels obj= new PartitionLabels();
				obj.getPartition(s);
	}
}