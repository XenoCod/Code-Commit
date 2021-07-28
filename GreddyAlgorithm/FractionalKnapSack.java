package Codes.GreddyAlgorithm;

import java.util.Arrays;

class Item implements Comparable<Item>{
    int val, weight;
    Item(int w, int v){
        val=v;
        weight=w;
    }
    public int compareTo(Item i){
        return weight * i.val - val * i.weight;
    }
}

public class FractionalKnapSack {

    static double fractionalKnapSack(Item arr[], int w){
        double res=0.0;
        Arrays.sort(arr);

        for(int i = 0; i < arr.length; i++){
            if(arr[i].weight <= w){
                res += arr[i].val;
                w = w - arr[i].weight;
            }
            else {
                res += arr[i].val * ((double) w / arr[i].weight);
                break;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Item arr[]={new Item(10, 60),
                new Item(40, 40),
                new Item(20, 100),
                new Item(30, 120)};
        int W=50;
        System.out.println(fractionalKnapSack(arr,W));
    }
}
