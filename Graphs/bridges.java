	/*
		Reference: https://cp-algorithms.com/graph/bridge-searching.html
		
		Algorithm used to find bridges in undirected graph (bridges are edges that if removed they split the graph i.e. edges that are not in any cycles).
		- Etime[i] denotes the 'time' node i was first visited by the dfs - the order it was visited. This is useful to find out if a node is ancestor of another.
		- low[i] If node i is part of a cycle in the graph (as far as the dfs has proceeded), it contains the min Etime 
		  of all the cycle's nodes, otherwise it contains its own Etime.
		  
		Basic idea:
		A bridge from i to j is formed if and only if the low[j] > etime[i]. (Here we suppose that dfs was already run from i to j)
		If low[j] <= etime[i] it means that node j or a node after it (in the dfs order) has already found i or one of its ancestors, thus this edge creates a cycle.
	
	*/
	
	static ArrayList<Integer> adj[];
	static int time;
	static int[] low, etime;
	
	
	public static void bridgeFound(int u, int v) {
		//Do stuff
	}
	public static void dfs(int i, int p) {
		low[i] = etime[i] = time++; 
		for(int to : adj[i]) {
			if(to==p) continue;
			if(low[to]==-1) { //if j is not visited
				dfs(to, i);
				low[i] = Math.min(low[i], low[to]);
				if (low[to] > etime[i])  bridgeFound(i, to);
			}else low[i] = Math.min(low[i], etime[to]);
		}
	}
	
	public static void findBridges() {
		int n = in.nextInt(), m = in.nextInt();
		adj = new ArrayList[n];
		for(int i = 0; i<n; i++) adj[i] = new ArrayList<Integer>();
		for(int i = 0; i<m; i++) {
			int u = in.nextInt()-1, v = in.nextInt()-1;
			adj[u].add(v);
			adj[v].add(u);
		}
		low = new int[n];
		etime = new int[n];
		Arrays.fill(low, -1);
		Arrays.fill(etime, -1);
		time = 0;
		for(int i = 0; i<n; i++) if(etime[i]==-1) dfs(i, -1);
	}