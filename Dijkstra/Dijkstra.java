import java.util.*;
public class Dijkstra{
    public static void main(String[] args) {
        int[][] a={{0,6,0,1,0},
                   {6,0,5,2,2},
                   {0,5,0,0,5},
                   {1,2,0,0,1},
                   {0,2,5,1,0}};
        int n=5;
        Set<Integer> visited=new HashSet<>();
        int[] distance=new int[n];
        int[] previous=new int[n];
        int start=0;
        int finish=2;
        for(int i=0; i<n; i++){
            distance[i]=Integer.MAX_VALUE;
        }
        distance[start]=0;
        //
        
        while(visited.size()<n){
            int dangXet=0;
            int min=Integer.MAX_VALUE;
            for(int i=0;i<n;i++){
                if(visited.contains(i)==false && min>distance[i]){
                    min=distance[i];
                    dangXet=i;
                }
            }
            for(int i=0; i<n; i++){
                if(visited.contains(i)==false && a[dangXet][i]!=0){
                    int minDistance=distance[dangXet]+a[dangXet][i];
                    if(minDistance<distance[i]){
                        distance[i]=minDistance;
                        previous[i]=dangXet;
                    }

                }
            }
            visited.add(dangXet);
        }
        int i=finish;
        while(i!=start){
            System.out.print(i+" <- ");
            i=previous[i];
        }
        System.out.print(i);
    

    }
}