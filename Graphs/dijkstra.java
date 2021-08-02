	public static int[] dijkstra(int source) {
		int[] dist = new int[n];
		Arrays.fill(dist, inf);
		PriorityQueue<Pair> pq = new PriorityQueue<Main.Pair>();
		dist[source] = 0;
		pq.add(new Pair(source, 0));
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			int cur = p.f;
			if(p.s>dist[cur]) continue;
			for(Pair i : adj[cur]) {
				if(dist[i.f]>dist[cur]+i.s) {
					dist[i.f] = dist[cur]+i.s;
					pq.add(new Pair(i.f,dist[cur]+i.s));
				}
			}
		}
		return dist;
	}
	
	static class Pair implements Comparable<Pair>{
		int f,s;
		public Pair(int f, int s) {
			this.f = f;
			this.s = s;
		}
		@Override
		public int compareTo(Pair o) {
			return this.s - o.s;
		}
	}
	
	static final int inf = Integer.MAX_VALUE/2;
	static int n,m;
	static ArrayList<Pair> adj[];
	public static void solve() {
		n = in.nextInt();
		m = in.nextInt();
		int source = in.nextInt()-1;
		adj = new ArrayList[n];
		for(int i = 0; i<n; i++) adj[i] = new ArrayList<Pair>();
		for(int i = 0; i<m; i++) {
			int u = in.nextInt()-1, v = in.nextInt()-1, w = in.nextInt();
			adj[u].add(new Pair(v, w));
			adj[v].add(new Pair(u, w));
		}
		int[] d = dijkstra(source);
	}