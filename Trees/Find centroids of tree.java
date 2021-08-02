	static ArrayList<Integer>[] adj;
	static int[] sz;
	static ArrayList<Integer> centroids;
	public static void dfs(int i, int p) {
		sz[i] = 1;
		int maxComponent = 0;
		for(Integer v : adj[i]) if(v!=p) {
			dfs(v, i);
			sz[i]+=sz[v];
			maxComponent = Math.max(maxComponent, sz[v]);
		}
		maxComponent = Math.max(maxComponent, n-sz[i]);
		if(maxComponent<=n/2) centroids.add(i);
	}