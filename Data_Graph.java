public class Data_Graph{
    public static void main(String[] args) {
       Graph g = new Graph(5); // Graph is created with 5 nodes
       int a[][] = { {0,1,0,1,1}, {1,0,1,1,0}, {0,1,0,1,1}, {1,1,1,0,0}, 
       {1,0,1,0,0}};
       g.createAdjList(a);
       g.dfs(0); // starting node to dfs is 0
    }
}
//Depth-First Search
class Node{
    int label;
    Node next; // this object indicates the next one after it.
    Node(int b){
        label = b;
    }
}
class Graph{
    int size; // include of the number of nodes is up to
    Node adjList[];
    int mark[];
    Graph(int n){
        adjList = new Node[size];// include of the number of nodes is up to
        mark = new int[size]; // elements of the mark initialized to 0
    }
    public void createAdjList(int a[][]){

        Node p; int i, k;
        for(i = 0; i<size; i++){
            p = adjList[i] = new Node(i); // create first node of ith adj. list
            for(k = 0; k<size; k++){
                if(a[i][k] == 1){
                    p.next = new Node(k); // create next node of ith adj. List
                    p=p.next;
                }
            }
        }
    }
    public void dfs(int head){// recursive depth-first search
      Node w;
      int v;
      mark[head] = 1;
      System.out.print(head +" ");
      w = adjList[head];
      while( w != null){
          v = w.label;
          if( mark[v] == 0)
          dfs(v);
          w = w.next;
      }
    } 
}
