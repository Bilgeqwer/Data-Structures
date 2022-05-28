

public class Data_Graph{
    public static void main(String[] args) {
       Graph g = new Graph(5); // Graph is created with 5 nodes
       int a[][] = { {0,1,0,1,1}, {1,0,1,1,0}, {0,1,0,1,1}, {1,1,1,0,0}, 
       {1,0,1,0,0}};
       g.createAdjList(a);
       g.dfs(0); // starting node to bfs is 0
       g.bfs(0);  // starting node to bfs is 0
    }
}
//Breadth-First Search
class Node{
    int label;
    Node next; // this object indicates the next one after it.
    Node(int b){
        label = b;
    }
}
class Queue{
    private int maxSize; // max queue size
    private int[] que; // que is an array of integers
    private int front;
    private int rear;
    private int count; // count of items in queue
    public Queue(int s){// constructor
      maxSize = s;
      que = new int[maxSize];
      front = rear = -1;
    }
    public void qinsert(int item){
        if(rear == maxSize-1)
        System.out.println("Queue is Full");
        else{
            rear = rear + 1 ;
            que[rear] = item;
            if( front == -1)
            front = 0;
        }
    }
    public int qdelete(){
        int item;
        if(IsEmpty()){
            System.out.println("\n  Queue is Empty");
            return(-1);
        }
        item = que[front];
        if( front == rear)
        front = rear = -1;
        else front = front + 1;
        return(item);
    }
    public boolean IsEmpty(){
        return(front == -1);
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
    public void bfs(int head)
    { int v; Node adj;
    Queue q = new Queue(size);
    v = head;
    mark[v] = 1; System.out.print(v + "");
    q.qinsert(v);
    while( !q.IsEmpty() ){ 
        v = q.qdelete(); 
        adj = adjList[v];
          while( adj != null ){ 
              v = adj.label;
              if( mark[v] == 0 ){ 
                  q.qinsert(v);
                  mark[v] = 1; 
                  System.out.print(v + "");}
                  adj = adj.next;
                }
            }
        }
    } // end of Graph class
