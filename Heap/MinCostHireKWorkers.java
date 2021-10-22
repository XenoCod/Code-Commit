//Min cost to hire k workers
import java.util.*;

class Worker{
    int quality;
    int wage;
    double ratio;
    public Worker(int _quality, int _wage){
        quality= _quality;
        wage= _wage;
        ratio= wage * 1.0 / quality;
    }
}


class MinCostHireKWorkers{

	 public static double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        List<Worker> workers= new ArrayList<>();
        
        for(int i=0; i< wage.length; i++)
            workers.add(new Worker(quality[i], wage[i]));
        
        Collections.sort(workers, (a, b) -> Double.compare(a.ratio, b.ratio));
        
        PriorityQueue<Worker> pq= new PriorityQueue<>((a, b) -> b.quality - a.quality);
        
        double minCost= Double.MAX_VALUE;
        int totalQuality=0;
        
        for(Worker worker: workers){
            pq.offer(worker);
            totalQuality += worker.quality;
            
            if(pq.size() > k){
                Worker removed= pq.poll();
                totalQuality -= removed.quality;
            }
            
            if(pq.size() == k){
                minCost= Math.min(minCost, totalQuality * worker.ratio);
            }
        }
        
        return minCost;
        
    }

	public static void main(String[] args) {
		int quality[]={10, 20, 5};
		int wage[]={70, 50, 30};
		int k=2;
		System.out.println(mincostToHireWorkers(quality, wage, k));
		
	}
}