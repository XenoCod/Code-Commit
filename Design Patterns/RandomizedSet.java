//Design Randomize set
// Insert Delete GetRandom O(1)
/*
mplement the RandomizedSet class:

RandomizedSet() Initializes the RandomizedSet object.
bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
You must implement the functions of the class such that each function works in average O(1) time complexity.


*/
import java.util.*;


class RandomizedSet{
	Map<Integer, Integer> map;
	List<Integer> list;

	public RandomizedSet(){
		map= new HashMap<>();
		list= new ArrayList<>();
	}

	public boolean insert(int val){
		if(map.containsKey(val)) return false;

		list.add(val);
		map.put(val, list.size()-1);
		return true;
	}

	public boolean remove(int val){
		if(!map.containsKey(val)) return false;

		int index = map.get(val);
		Collections.swap(list, index, list.size()-1);
		int swapVal= list.get(index);
		map.put(swapVal, index);
		list.remove(list.size() -1);
		map.remove(val);
		return true;
	}

	public int getRandom(){
		int min=0;
		int max=list.size();
		int ind= (int) (Math.random() * (max - min) + min);
		return list.get(ind);
	}

	public static void main(String[] args) {
		RandomizedSet set= new RandomizedSet();
				System.out.println(set.insert(1));
						System.out.println(set.remove(2));
								System.out.println(set.insert(2));
										System.out.println(set.getRandom());
												System.out.println(set.remove(1));
														System.out.println(set.insert(2));
																System.out.println(set.getRandom());

	}
}