import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class dfs {

    static ArrayList<Integer>[] graph;
    static boolean[] used;
    static int[] label;
    static boolean res = true;


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int strap1, strap2;
        int n = in.nextByte(), m = in.nextByte();
        label = new int[n+1];
        graph = new ArrayList[n+1];
        used = new boolean[n+1];
        for (int i = 0; i < n+1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            strap1 = in.nextByte();
            strap2 = in.nextByte();
            graph[strap1].add(strap2);
            graph[strap2].add(strap1);
        }
        dfs(1, 1);
        System.out.println(res);
    }

    static void dfs(int v, int label1) {
        used[v] = true;
        label[v] = label1;
            for (int next : graph[v]) {
               if(!used[next] && label1 == 1) {
                   dfs(next, 2);
               }
               if(!used[next] && label1 == 2) {
                   dfs(next, 1);
               }
               if(used[next] && label[v] == label[next]) res = false;
            }
    }
}

