package Codes.Queue;

public class FirstCircularTour {
    static int circularTour(int petrol[], int distances[]){
        int start=0, curr_pet=0, prev_pet=0;
        for(int i=0;i<petrol.length;i++){
            curr_pet+=petrol[i]-distances[i];
            if(curr_pet<0){
                start=i+1;
                prev_pet+=curr_pet;
                curr_pet=0;
            }
        }
        return (curr_pet+prev_pet>=0)?start+1:-1;
    }
    public static void main(String[] args) {
        int petrol[]= {4, 8, 7,4};
        int distance[]={6,5,3,5};
        System.out.println(circularTour(petrol, distance));
    }
}
