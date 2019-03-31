	static class Graph {
		private ArrayList<Integer> con[];
		private boolean[] visited;

		public Graph(int n) {
			con = new ArrayList[n];
			for (int i = 0; i < n; ++i)
				con[i] = new ArrayList();
			visited = new boolean[n];
		}
		public void reset() {
			Arrays.fill(visited, false);
		}
		public void addEdge(int v, int w) {
			con[v].add(w);
		}

		public void dfs(int cur) {
			visited[cur] = true;
			for (Integer v : con[cur]) {
				if (!visited[v]) {
					dfs(v);
				}
			}
		}
		public void bfs(int cur) {
			Queue<Integer> q = new LinkedList<>();
			q.add(cur);
			visited[cur] = true;
			while(!q.isEmpty()) {
				cur = q.poll();
				for (Integer v : con[cur]) {
					if (!visited[v]) {
						visited[v] = true;
						q.add(v);
					}
				}
			}
		}
	}
