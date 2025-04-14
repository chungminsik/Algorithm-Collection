package algorithm.그래프와순회;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 알고리즘수업_깊이우선탐색1 {

    static int n, m, r;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] order; // 각 정점의 방문 순서를 저장 (방문하지 않은 정점은 0)
    static int cnt = 1; // 방문 순서 카운터

    public static void main(String[] args) {

        generateGraph();

        visited = new boolean[n+1];
        order = new int[n+1];

        dfs(r);

        for (int i = 0; i <= n; i++){
            System.out.println(order[i]);
        }

    }

    //dfs
    private static void dfs(int r){

        visited[r] = true;
        order[r] = cnt++;

        for (int next : graph[r]){
            if (!visited[next]){
                dfs(next);
            }
        }
    }

    //그래프 생성
    private static void generateGraph(){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); //정점 갯수
        m = sc.nextInt(); // 간선 갯수
        r = sc.nextInt(); // 시작 정점

        //그래프 초기화
        graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        //그래프 만들기(무방향)
        for (int i = 0; i < m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph[u].add(v);
            graph[v].add(u);
        }
        sc.close();

        // 각 정점의 인접 리스트를 오름차순 정렬
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }
    }
}
