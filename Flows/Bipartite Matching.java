	static class BipartiteMatching{
		final int source = 0, sink = 1;
		Dinic d;
		HashSet<Integer> added;
		public BipartiteMatching() {
			added = new HashSet<>();
			this.d = new Dinic(source, sink);
		}
		public void addEdge(int u, int v) {
			u+=2; v+=2;
			d.addEdge(u, v, 1);
			if(!added.contains(u)) {
				d.addEdge(source, u, 1);
				added.add(u);
			}
			if(!added.contains(v)) {
				d.addEdge(v, sink, 1);
				added.add(v);
			}
		}
		public int getMaximumMatching() {
			return d.maxFlow();
		}
	}
	
	static class Dinic{
		int source, sink;
		int[] level,next;
		ArrayList<ArrayList<Edge>> adj;
		public Dinic(int source, int sink) {
			adj = new ArrayList<>();
			this.source = source;
			this.sink = sink;
		}
		
		void addEdge(int u, int v, int cap) {
			Edge e1 = new Edge(u, v, cap);
			Edge e2 = new Edge(v, u, 0);
			e1.residual = e2;
			e2.residual = e1;
			while(adj.size()<=u) adj.add(new ArrayList<Edge>());
			while(adj.size()<=v) adj.add(new ArrayList<Edge>());
			adj.get(u).add(e1);
			adj.get(v).add(e2);
		}
		
		int maxFlow() {
			if(adj.size()==0) return 0;
			level = new int[adj.size()];
			next = new int[adj.size()];
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
				for(Edge e : adj.get(v)) {
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
			for(; next[cur]<adj.get(cur).size(); next[cur]++) {
				Edge e = adj.get(cur).get(next[cur]);
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