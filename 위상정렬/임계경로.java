package 위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class 임계경로 {

    static int T,N,M;
    static ArrayList[] adj;
    static int[][] cost;
    static boolean[] visited;
    static int isCycle = 0;
    static boolean[] finish;
    static Stack stack;
    static int[] dist;  // 1번공정에서 i NODE 공정까지의 거리

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T ; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            isCycle = 0;

            stack = new Stack();

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            adj = new ArrayList[N+1];
            cost = new int[N+1][N+1];
            visited = new boolean[N+1];
            finish = new boolean[N+1];
            dist = new int[N+1];

            for (int i = 0; i <= N; i++) adj[i] = new ArrayList();

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                adj[a].add(b);

                cost[a][b] = c;

            }

            dfs(1);

            System.out.println("#" + tc +" " + dist[N]);
        }

    }

    public static void dfs(int here){

       visited[here] = true;

        for (int i = 0; i < adj[here].size(); i++) {
            int there = (int)adj[here].get(i);

            if(!visited[there]){

                dist[there] = Math.max(dist[there],dist[here]+ cost[here][there]);

                dfs(there);
            }else if( !finish[there] ){
                isCycle = 1;
            }
        }

        stack.push(here);
        finish[here] = true;

    }


}
