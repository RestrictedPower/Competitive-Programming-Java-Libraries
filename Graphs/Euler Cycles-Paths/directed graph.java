	static int n,m;
	static HashSet<Integer> adj[];
	static ArrayList<Integer> ans = new ArrayList<Integer>();
	public static void solve() {
		n = in.nextInt(); m = in.nextInt();
		adj = new HashSet[n];
		for(int i = 0; i<n; i++) adj[i] = new HashSet<Integer>();
		int[] deg = new int[n];
		for(int i = 0; i<m; i++) {
			int u = in.nextInt()-1, v = in.nextInt()-1;
			adj[u].add(v);
			adj[v].add(u);
			deg[u]++;
			deg[v]++;
		}
		boolean can = true;
		//If we want to check for euler path, there can be at most 2 nodes with degree % 2 = 1,
		//and our answer will start from one of those.
		for(int i : deg) if(i % 2 != 0) can = false;
		dfs(0);
		can &= m+1 == ans.size();
		if(!can) {
			out.println("No euler cycle");
			return;
		}
		for(int i : ans) out.print((i+1)+" ");
		out.println();
	}
	public static void dfs(int i) {
		while(!adj[i].isEmpty()) {
			int j = adj[i].iterator().next();
			adj[i].remove(j);
			adj[j].remove(i);
			dfs(j);
		}
		ans.add(i);
	}