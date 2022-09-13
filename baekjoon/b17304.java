package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b17304{
	static List<Integer> d[];
	static List<int[]> v;
	static boolean visited[];
	static int parent[], size[], rank[], edge[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stz;
		stz = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stz.nextToken());
		int m = Integer.parseInt(stz.nextToken());
		visited = new boolean[n + 1];
		d = new ArrayList[n + 1];
		parent = new int[n + 1];
		size = new int[n + 1];
		rank = new int[n + 1];
		edge = new int[n + 1];
		v = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			d[i] = new ArrayList<>();
			parent[i] = i;
			size[i] = 1;
		}

		for (int i = 0; i < m; i++) {
			stz = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(stz.nextToken());
			int B = Integer.parseInt(stz.nextToken());
			// from은 to를 변호할 수 있다.
			d[A].add(B); // 진입차수 등록
		}

		for (int i = 1; i <= n; i++) {
			for (int j : d[i]) {
				if (d[j].contains(i)) {
					v.add(new int[] { i, j });
					edge[i]++;
				} else {
					visited[j] = true;
				}
			}
		}

		for (int i = 0; i < v.size(); i++) {
			int temp[] = v.get(i);
			union(temp[0], temp[1]);
		}
		for (int i = 1; i <= n; i++) {
			int x = find(i);
			if (edge[x] == 2 * size[x] - 2 && !visited[x]) {
				System.out.print("NO");
				return;
			}
		}
		System.out.print("YES");
	}

	private static int find(int x) {
		if (x == parent[x])
			return x;

		return parent[x] = find(parent[x]);
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a == b)
			return;

		if (rank[a] < rank[b]) {
			parent[a] = b;
			size[b] += size[a];
			edge[b] += edge[a];
			visited[b] |= visited[a];
		} else if (rank[a] > rank[b]) {
			parent[b] = a;
			size[a] += size[b];
			edge[a] += edge[b];
			visited[a] |= visited[b];
		} else {
			parent[a] = b;
			rank[b]++;
			size[b] += size[a];
			edge[b] += edge[a];
			visited[b] |= visited[a];
		}
	}

}