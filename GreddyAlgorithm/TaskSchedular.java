import java.util.*;

class TaskSchedular{

	public int leastInterval(char tasks[] , int n){
		HashMap<Character, Integer> map= new HashMap<>();
		//First store the char in order of their freq present
		for(char c: tasks)
			map.put(c, map.getOrDefault(c, 0) + 1);

		//Stores them inside a max heap
		PriorityQueue<Map.Entry<Character, Integer>> pq= new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
		pq.addAll(map.entrySet());


		//When pq is not empty there are remaining tasks that we have to fill
		int count=0;
		while(!pq.isEmpty()){

			//Fill for each interval
			int interval =n+1;

			//List used to update the pq
			List<Map.Entry<Character, Integer>> list= new ArrayList<>();

			while(interval >0 && !pq.isEmpty()){
				Map.Entry<Character, Integer> temp= pq.poll();

				temp.setValue(temp.getValue() -1);
				list.add(temp);
				// System.out.println(list);

				//One interval is filled
				interval--;

				//One slot is taken
				count++;
			}

			// System.out.println(list);

					//upadting value in map
			for(Map.Entry<Character, Integer> it: list){
				if(it.getValue() > 0)
					pq.offer(it);
			}


			if(pq.isEmpty()) break;

			count += interval;

		}
		return count;
	}

	public static void main(String[] args) {
		char tasks[]={'A', 'A','A', 'A', 'A', 'A', 'B','C','D','E','F','G'};
		int n=2;
		/*
		Output: 8
		Explanation: 
		A -> B -> idle -> A -> B -> idle -> A -> B
		*/
		TaskSchedular obj= new TaskSchedular();

		System.out.println(obj.leastInterval(tasks, n));
	}
}