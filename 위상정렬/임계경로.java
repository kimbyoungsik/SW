package 위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class 임계경로 {

    static int T,N,M;
    static ArrayList<Node>[] adj;
    static int[][] cost;
    static boolean[] visited;
    static int isCycle = 0;
    static boolean[] finish;
    static Stack stack;
    static long[] dist;  // 1번공정에서 i NODE 공정까지의 거리


    public static class Node{
        private int s;
        private int e;
        private int c;

        Node(int s, int e, int c){
            this.s = s;
            this.e = e;
            this.c = c;
        }

    }

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
            cost = new int[N+1][2];
            visited = new boolean[N+1];
            finish = new boolean[N+1];
            dist = new long[N+1];
            Node[] nodes = new Node[M+1];


            for (int i = 0; i <= N; i++) adj[i] = new ArrayList();

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                nodes[i] = new Node(a,b,c);

                adj[a].add(nodes[i]);

            }

            dfs(1);

            while(!stack.isEmpty()){
                int here = (int)stack.pop();
                for (int i = 0; i < adj[here].size(); i++) {
                    Node node = (Node)adj[here].get(i);
                    int there = node.e;
                    int cost = node.c;

                    dist[there] = Math.max(dist[there],dist[here] + cost);
                }

            }


            System.out.println("#" + tc +" " + dist[N]);
        }

    }

    public static void dfs(int here){

       visited[here] = true;

        for (int i = 0; i < adj[here].size(); i++) {
            Node node = (Node)adj[here].get(i);
            int there = node.e;
            int cost = node.c;

            if(!visited[there]){
                dfs(there);
            }
        }

        stack.push(here);

    }


}
