import java.util.ArrayList;

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
}

