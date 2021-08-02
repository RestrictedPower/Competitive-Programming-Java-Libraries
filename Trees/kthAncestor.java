    static int[][] up;
    static final int LOG = 20;
    static ArrayList<Integer> adj[];
    
    static void init(int n) {
        up = new int[n][LOG];
        adj = new ArrayList[n];
        for(int i = 0; i<n; i++) adj[i] = new ArrayList<Integer>();
        //init adj list...
        int root = 0;
        dfs(root,-1);
    }
	
	public static void dfs(int i, int p) {
		up[i][0] = p;
		for(int j = 1; j<LOG; j++) up[i][j] = (p==-1||up[i][j-1]==-1)?-1:up[up[i][j-1]][j-1];
		for(int nxt : adj[i]) if(nxt!=p) dfs(nxt, i);
	}
	
    public int getKthAncestor(int node, int k) {
        for (int i = 0; i < LOG; i++) {
            if ((k & (1 << i)) != 0) {
                node = up[node][i];
                if (node == -1) break;
            }
        }
        return node;
    }