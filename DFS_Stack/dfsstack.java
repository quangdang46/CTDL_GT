import java.util.*;
public class dfsstack{

    public static void DFS(int u,int[][] graph,Set<Integer> visited){
        visited.add(u);
        System.out.print(u+" ");
        for(int v=0;v<graph.length;v++){
            if(graph[u][v]==1 && !visited.contains(v)){
                DFS(v,graph,visited);
            }
        }
    }
    public static void main(String[] args) {
        int[][] graph={{0,1,0,0,0,0,0},
                        {1,0,1,1,1,0,0},
                       {0,1,0,0,0,1,0},
                       {0,1,0,0,0,1,1},
                       {0,1,0,0,0,0,1},
                       {0,0,1,1,0,0,0},
                       {0,0,0,1,1,0,0}};
        // Set<Integer> visited=new HashSet<>();
        // Stack<Integer> stack=new Stack<>();
        // stack.push(0);
        // visited.add(0);
        // while(!stack.isEmpty()){
        //     int u=stack.pop();
        //     //Xu li
        //     System.out.println(u);
        //     //Them cac dinh chua duyet vao stack
        //     for(int v=0;v<graph.length;v++){
        //         if(graph[u][v]==1 && !visited.contains(v)){
        //             stack.push(v);
        //             //Danh dau da duyet
        //             visited.add(v);
        //         }
        //     }
        // }

        // De Qui
        Set<Integer> visited=new HashSet<>();
        DFS(0,graph,visited);


    }


}