import java.util.*;
public class bfsqueue{

    public static void main(String[] args) {
        int[][] graph={{0,1,0,0,0,0,0},
                        {1,0,1,1,1,0,0},
                       {0,1,0,0,0,1,0},
                       {0,1,0,0,0,1,1},
                       {0,1,0,0,0,0,1},
                       {0,0,1,1,0,0,0},
                       {0,0,0,1,1,0,0}};
        Set<Integer> visited=new HashSet<>();
        Queue<Integer> queue=new LinkedList<>();
        visited.add(0);
        queue.add(0);
        while(!queue.isEmpty()){
            int u=queue.remove();
            System.out.print(u+" ");
            for(int v=graph.length-1;v>=0;v--){
                if(graph[u][v]==1 && !visited.contains(v)){
                    queue.add(v);
                    visited.add(v);
                }
            }
        }

    }

}