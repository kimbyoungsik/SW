package Ʈ��;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ������Ű�C����_LCA {

    static int T,N,Q;
    static int[][] node;
    static boolean[] visited; // �湮 ���
    static int[] depth; // ����
    static int[][] par; // �θ��� par[i][j] : i ��° ����� 2*j �� �θ�
    static ArrayList[] adj;  //�������
    static int HEIGHT;
    static int[] maxH;   //maxH[i]  root ~ i �� ������ �ִ� Ű


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

        if(depth[x] < depth[y]){  //x�� �׻� �� ����
            int tmp = x;
            y = x;
            x = tmp;
        }


        for (int i = HEIGHT ; i >= 0  ; i--) {  // ���� ������ �ǵ��� ����
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



            node = new int[N+1][2]; // [][0] : �θ��� , [][1] : Ű
            adj = new ArrayList[N+1];
            par = new int[N+1][HEIGHT+1];
            maxH = new int[N+1];
            visited = new boolean[N+1];
            depth = new int[N+1];

            for (int i = 0; i <= N ; i++) adj[i] = new ArrayList();



            for (int i = 1; i <= N ; i++) {
                st = new StringTokenizer(br.readLine());

                node[i][0] = Integer.parseInt(st.nextToken());  //�θ���
                node[i][1] = Integer.parseInt(st.nextToken());  //�������� Ű

                maxH[i] = node[i][1];  //i �� ������ �ִ��� Ű�� ���� ����� Ű�� �ʱ�ȭ
                adj[node[i][0]].add(i); // i��° �θ����� ������� ����

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
