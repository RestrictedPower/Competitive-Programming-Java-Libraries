    static int[][] up;
    static int[] depth;
    static final int LOG = 20;
    static ArrayList<Integer> adj[];
	
	public static void dfs(int i, int p) {
		for(int nxt : adj[i]) if(nxt!=p) {
			depth[nxt] = depth[i] + 1;
			up[nxt][0] = i;
			for(int j = 1; j<LOG; j++) up[nxt][j] = up[up[nxt][j-1]][j-1];
			dfs(nxt, i);
		}
	}
	
    public static int getKthAncestor(int node, int k) {
        for (int i = 0; i < LOG; i++) {
            if ((k & (1 << i)) != 0) {
                node = up[node][i];
                if (node == -1) break;
            }
        }
        return node;
    }
    
	public static int lca(int a, int b){
		if(depth[a]<depth[b]) {
			int tmp = b;
			b = a;
			a = tmp;
		}
		a = getKthAncestor(a, depth[a]-depth[b]);
		if(a==b) return a;
		for(int i = LOG-1; i>=0; i--) {
			if(up[a][i]!=up[b][i]) {
				a = up[a][i];
				b = up[b][i];
			}
		}
		return up[a][0];
	}
	
	public static void solve() {
		int n = in.nextInt();
        up = new int[n][LOG];
        depth = new int[n];
        adj = new ArrayList[n];
        for(int i = 0; i<n; i++) adj[i] = new ArrayList<Integer>();
        //init adj list...
        int root = 0;
        dfs(root,-1);
        int q = in.nextInt();
        for(int i = 0; i<q; i++) out.println(lca(in.nextInt(), in.nextInt()));
	}
	