package Codes.LinkedLists;


import java.util.HashMap;

class Nodel{
    int key, value;
    Nodel next, prev;
    int data;
    Nodel(int key,int value){
        this.key=key;
        this.value=value;
    }
}

class LRUCache{
    private HashMap<Integer, Nodel>map;
    private int capacity, count;
    private Nodel head, tail;

    public LRUCache(int capacity){
        this.capacity=capacity;
        map= new HashMap<>();
        head= new Nodel(0,0);
        tail= new Nodel(0,0);
        head.next=tail;
        tail.prev=head;
        head.prev=tail.next=null;
        count=0;
    }
    public void deleteNode(Nodel node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    public void addToHead(Nodel node){
        node.next=head.next;
        node.next.prev=node;
        node.prev=head;
        head.next=node;
    }

    public int get(int key){
        if(map.get(key)!=null){
            Nodel node= map.get(key);
            int result=node.value;
            deleteNode(node);
            addToHead(node);
            System.out.println("Got the value : " +
                    result + " for the key: " + key);
            return  result;
        }
        System.out.println("Did not get any value" +
                " for the key: " + key);
        return -1;
    }

    public void set(int key, int value){
        System.out.println("Going to set the (key, "+
                "value) : (" + key + ", " + value + ")");
        if(map.get(key)!=null){
            Nodel node=map.get(key);
            node.value=value;
            deleteNode(node);
            addToHead(node);
        }
        else {
            Nodel node = new Nodel(key, value);
            map.put(key, node);
            if(count<capacity){
                count++;
                addToHead(node);
            }
            else {
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
                addToHead(node);
            }
        }

    }
}

public class LRUCacheDesign {


    public static void main(String[] args) {
        LRUCache cache= new LRUCache(2);

        // it will store a key (1) with value
        // 10 in the cache.
        cache.set(1, 10);

        // it will store a key (2) with value 20 in the cache.
        cache.set(2, 20);
        System.out.println("Value for the key: 1 is " + cache.get(1)); // returns 10

        // removing key 2 and store a key (3) with value 30 in the cache.
        cache.set(3, 30);

        System.out.println("Value for the key: 2 is " +
                cache.get(2)); // returns -1 (not found)

        // removing key 1 and store a key (4) with value 40 in the cache.
        cache.set(4, 40);
        System.out.println("Value for the key: 1 is " +
                cache.get(1)); // returns -1 (not found)
        System.out.println("Value for the key: 3 is " +
                cache.get(3)); // returns 30
        System.out.println("Value for the key: 4 is " +
                cache.get(4)); // return 40


    }
}
