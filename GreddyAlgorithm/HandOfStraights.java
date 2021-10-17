import java.util.*;

//Hands of straghts or divide the in sets of groups of k

class HandOfStraights{
   static boolean isPossible(int nums[], int size){
      //Mapping all the nums element according to their freq with the hekp of tree map
      TreeMap<Integer, Integer> map= new TreeMap<>();

      for(int i: nums) map.put(i, map.getOrDefault(i, 0) + 1);

      //Then try to build k group untill the map is emepty
       while(map.size() > 0){
       	int curr= map.firstKey();//gives us the key with the least freq

       	for(int i=curr; i< curr + size; i++){

       		if(!map.containsKey(i)) return false;//if the next consuctive element is not present in the map then simply return false

       		if(map.get(i)  == 1) map.remove(i);//if the freq of the eleemnent has beecome to 1 we can simplt remove the element
       		else map.put(i, map.get(i) - 1);

       	}
       }
       return true;
      }
   public static void main(String[] args) {
      int nums[]={ 1,2,3,6,2,3,4,7,8};
      int grpSize= 3;
      //Divide the array in groups of size with consucutive elements
      /*
      Output: true
      Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
      */
            System.out.println(isPossible(nums, grpSize));
   }
}