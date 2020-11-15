package 트리;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 조상이키멌으면_LCA {

    static int T,N,Q;
    static int[][] node;
    static boolean[] visited; // 방문 노드
    static int[] depth; // 레벨
    static int[][] par; // 부모노드 par[i][j] : i 번째 노드의 2*j 승 부모
    static ArrayList[] adj;  //인접노드
    static int HEIGHT;
    static int[] maxH;   //maxH[i]  root ~ i 번 노드까지 최대 키


    public static void dfs (int cur, int level){

        if (visited[cur]) return;

        if(cur == N) return;

        visited[cur] = true;
        depth[cur] = level;

        for (int i = 0; i < adj[cur].size(); i++) {
            int next = (int) adj[cur].get(i);

            if(!visited[next]){
                par[next][0] = cur;
                maxH[next] = Math.max(maxH[cur], maxH[next]);
                dfs(next,level+1);

            }

        }
    }


    public static void makeParent(){
        dfs(0,0);


        for (int i = 1; i <= N ; i++) {
            for (int j = 1; j <= HEIGHT; j++) {
                par[i][j] = par[par[i][j-1]][j-1];
            }
        }
    }


    public static int  lca(int x, int y ){

        if(depth[x] < depth[y]){  //x가 항상 더 깊도록
            int tmp = x;
            y = x;
            x = tmp;
        }


        for (int i = HEIGHT ; i >= 0  ; i--) {  // 같은 레벨이 되도록 설정
            if(depth[x] - depth[y] >= 1 << i){
                x = par[x][i];
            }
        }



        if( x == y ) return x;


        for(int i = HEIGHT; i >= 0 ; i--){
           if(par[x][i] != par[y][i]){
               x = par[x][i];
               y = par[y][i];
           }
        }


        return par[x][0] ;
    }





    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T ; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            Q = Integer.parseInt(st.nextToken());
            StringBuilder sb = new StringBuilder();

            for (int i = 1; i <= N; i = i*2) HEIGHT = i;



            node = new int[N+1][2]; // [][0] : 부모노드 , [][1] : 키
            adj = new ArrayList[N+1];
            par = new int[N+1][HEIGHT+1];
            maxH = new int[N+1];
            visited = new boolean[N+1];
            depth = new int[N+1];

            for (int i = 0; i <= N ; i++) adj[i] = new ArrayList();



            for (int i = 1; i <= N ; i++) {
                st = new StringTokenizer(br.readLine());

                node[i][0] = Integer.parseInt(st.nextToken());  //부모노드
                node[i][1] = Integer.parseInt(st.nextToken());  //현재노드의 키

                maxH[i] = node[i][1];  //i 번 노드까지 최대의 키는 현재 노드의 키로 초기화
                adj[node[i][0]].add(i); // i번째 부모노드의 인접노드 삽입

            }

            makeParent();

            sb.append("#" + tc +" ");
            for (int i = 0; i < Q; i++) {
                st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());


                int x = Integer.parseInt(st.nextToken());


                while ( n-- > 1){
                    int y = Integer.parseInt(st.nextToken());

                    x = lca(x,y);

                    if ( x == 1) {
                        return;
                    }

                }

                sb.append(maxH[x]+" ");


            }

            sb.append("\n");
            System.out.println(sb.toString());
        }





    }

}
