//package Trie;
//
//class Trie{
//    Trie child[]= new Trie[2];
//    static final int M  = 4, N = 3;
//    static int mat[][] = {{1, 0, 0},
//            {1, 1, 1},
//            {1, 0, 0},
//            {0, 1, 0}};
//    static Trie root;
//    static int countDis(){
//        Trie root= new Trie();
//        int res=0;
//        for(int row=0;row<M;row++){
//            if(insert(root, row))
//                res++;
//        }
//        return res;
//    }
//    static boolean insert(Trie root, int row){
//        Trie curr= root;
//        boolean flag=false;
//        for(int i=0;i<row; i++){
//            int index=mat[row][i];
//            if(curr.child[index]==null){
//                curr.child[index]=new Trie();
//                flag=true;
//
//            }
//            curr=curr.child[index];
//         }
//        return flag;
//    }
//
//}
//
//
//public class CountDistinctRowsInABinaryMatrix {
//    public static void main(String[] args) {
//
//        System.out.println(new Trie().countDis());
//    }
//}
