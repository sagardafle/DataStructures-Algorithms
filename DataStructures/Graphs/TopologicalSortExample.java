import java.util.*;
public class TopologicalSortExample {
    int n = 6;
    int shirt = 0;
    int belt = 1;
    int trouser = 2;
    int shocks = 3;
    int shoes = 4;
    int tie = 5;
    int[][] graph = new int[n][n];

    TopologicalSortExample(){
        graph[shirt][tie] = 1;
        graph[shirt][belt] = 1;
        graph[trouser][belt] = 1;
        graph[trouser][shocks] = 1;
        graph[shocks][shoes] = 1;
    }

    private void dfs(String order, int cur, List<Integer> list, int[] mark, int[] inDegree, int count){
//        System.out.println(list);
//        System.out.println("#### "+order);
        if(count == n){
            System.out.println(order);
            return;
        }
        int num = 0;
        for(int j = 0 ; j < n ; ++j){
            if(graph[cur][j] == 1){
                inDegree[j] --;
                if(inDegree[j] == 0){
                    num++;
                    list.add(j);
                }
            }
        }

        int size = list.size();
        for(int i = 0 ; i < size ; ++i){
            if(mark[list.get(i)] == 0){
                mark[list.get(i)] = 1;
                dfs(order+" "+list.get(i), list.get(i), list, mark, inDegree, count+1);
                mark[list.get(i)] = 0;
            }
        }

        while(num != 0){
            num--;
            int a = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            inDegree[a]++;
        }

    }


    public void solve(int[][] graph){
        int[] inDegree = new int[n];
        for(int i = 0 ; i < n ; ++i){
            for(int j = 0 ; j < n; ++j){
                if(graph[i][j] == 1){
                    inDegree[j] ++;
                }
            }
        }

        int[] mark = new int[n];
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < n ; ++i){
            if(inDegree[i] == 0) {
                list.add(i);
            }
        }
        int size = list.size();
        for(int i = 0 ; i < size ; ++i){
            if(mark[list.get(i)] == 0){
                mark[list.get(i)] = 1;
                dfs(list.get(i)+"", list.get(i), list, mark, inDegree, 1);
                mark[list.get(i)] = 0;
            }
        }

    }

    public static void main(String[] args){
        TopologicalSortExample solution = new TopologicalSortExample();
        solution.solve(solution.graph);
    }
}