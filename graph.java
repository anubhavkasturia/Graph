import java.util.ArrayList;
import java.util.LinkedList;

public class graph{
    private static class Edge{
        int v;
        float w;
        Edge(int v,float w){
            this.v=v;
            this.w=w;

        }
    }
    static ArrayList<ArrayList<Edge>> graph=new ArrayList<>();
    
    public static void main(String[] args) {
        construct();
        display();
        // BFS(0);
        DFS(0, new boolean[graph.size()]);
        }
    public static void construct(){
        int n=7;
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        // graph.get(0).add(new Edge(1, 7));
        // graph.get(0).add(new Edge(3, 6));
//instead we use our own created *ADDEDGE FUNCTION*
        addEdge(0, 1, 7);
        addEdge(0, 3, 6);
        addEdge(1, 2, 8);
        addEdge(2, 3, 9);
        addEdge(3, 4, 3);
        addEdge(4, 5, 2);
        addEdge(4, 6, 5);
        addEdge(5, 6, 1);
        
        // removeEdge(0, 3);
        // removeVertex(0);
        
        
    // similarly add for other edges in the same way    
    }
    public static void display(){
        for(int i=0;i<graph.size();i++){
            System.out.print(i+ " -> ");
            for(Edge e:graph.get(i)){
                System.out.print("("+e.v+","+e.w+")");
            }
        System.out.println();
        }
        
    }
    public static void addEdge(int u,int v,int w){
        if(u<0||v<0||u>graph.size()||v>graph.size()){
            return;
        }
        graph.get(u).add(new Edge(v, w));
        graph.get(v).add(new Edge(u, w));
    }

    public static void removeEdge(int u,int v){
        int i=0;
        for(Edge e:graph.get(u)){
            if(e.v==v){
                break;
            }
        i++;
        }
    graph.get(u).remove(i);
    
    
        int j=0;
        for(Edge e:graph.get(v)){
            if(e.v==u){
            break;
        }
        j++;
    }
    graph.get(v).remove(j); 
 }

  public static void removeVertex(int u){
      ArrayList<Edge> listcopy=graph.get(u); //ArrayList creates copy of all v in that arraylist 
      while(listcopy.size()!=0){
          Edge e= listcopy.get(listcopy.size()-1); //to prevent o(n2) complexity we start from end of ArrayList
          removeEdge(u, e.v);

      }
  } 
  public static void BFS(int src){
      LinkedList<Integer> queue=new LinkedList<>();
      queue.add(src); // first ever element inserted in the queue
      //keep track of visited vertices
      
      boolean[] visited=new boolean[graph.size()]; //?initially everything is false in the array as soon as there is a value it changes to true?
      
      while(queue.size()!=0){
      int u=queue.removeFirst(); //stores the value of the element being removed from the queue so as to insert all its neighbours
      if(!visited[u]){ //checks whether u is visited or not if not visited then only prints it 
          System.out.println(u);
      }
      visited[u]=true;

      for(Edge e:graph.get(u)){
        if(!visited[e.v]){ //checks if the v value is present in the array or not if it is present it would have been marked true and hence would not allow to add again
        queue.add(e.v); //inserts the neighbours(all)

        
        }
      }

  }

}
    public static void DFS(int src,boolean visited[]){
        System.out.println(src);
        visited[src]=true;
        
        for(Edge e:graph.get(src)){
            if(!visited[e.v]){
                DFS(e.v, visited);
            }

        }
    }
}
