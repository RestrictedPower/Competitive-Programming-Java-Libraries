	static class Dinic{
		int source, sink;
		int[] level,next;
		ArrayList<Edge> adj[];
		public Dinic(int n, int source, int sink) {
			adj = new ArrayList[n];
			for(int i = 0; i<n; i++) adj[i] = new ArrayList<Edge>();
			level = new int[n];
			this.source = source;
			this.sink = sink;
			next = new int[n];
		}
		
		void addEdge(int u, int v, int cap) {
			Edge e1 = new Edge(u, v, cap);
			Edge e2 = new Edge(v, u, 0);
			e1.residual = e2;
			e2.residual = e1;
			adj[u].add(e1);
			adj[v].add(e2);
		}
		
		int maxFlow() {
			int maxFlow = 0;
			while(bfs()) {
				Arrays.fill(next, 0);
				int extraFlow;
				while((extraFlow = dfs(source, Integer.MAX_VALUE))>0) maxFlow += extraFlow;
			}
			return maxFlow;
		}
		
		boolean bfs() {
			Arrays.fill(level, -1);
			level[source] = 0;
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(source);
			while(!q.isEmpty()) {
				int v = q.poll();
				for(Edge e : adj[v]) {
					if(e.remainingCapacity()>0 && level[e.to] == -1) {
						level[e.to] = level[v] + 1;
						q.add(e.to);
					}
				}
			}
			return level[sink] != -1;
		}
		
		int dfs(int cur, int bottleneck) {
			if(cur == sink) return bottleneck;
			for(; next[cur]<adj[cur].size(); next[cur]++) {
				Edge e = adj[cur].get(next[cur]);
				if(level[e.to] != level[cur] + 1 || e.remainingCapacity() == 0) continue;
				int flow = dfs(e.to, Math.min(bottleneck, e.remainingCapacity()));
				if(flow>0) {
					e.augment(flow);
					return flow;
				}
			}
			return 0;
		}
		
		class Edge{
			int from, to;
			int cap, flow;
			Edge residual;
			public Edge(int from, int to, int cap) {
				this.from = from;
				this.to = to;
				this.cap = cap;
				this.flow = 0;
			}
			
			public void augment(int bottleneck) {
				flow += bottleneck;
				residual.flow -= bottleneck;
			}
			
			public int remainingCapacity() {
				return this.cap-this.flow;
			}
		}
	}