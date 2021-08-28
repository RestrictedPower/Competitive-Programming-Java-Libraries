	static class SCC{
		int n;
		boolean[] vis;
		ArrayList<Integer> adj[];
		ArrayList<Integer> adjT[];
		
		public SCC(int n) {
			this.n = n;
			adj = new ArrayList[n];
			adjT = new ArrayList[n];
			for(int i = 0; i<n; i++) {
				adj[i] = new ArrayList<>();
				adjT[i] = new ArrayList<>();
			}
		}
		
		public void addEdge(int u, int v) {
			adj[u].add(v);
			adjT[v].add(u);
		}
		
		public void dfs1(int i, Stack<Integer> s) {
			vis[i] = true;
			for(int to : adj[i]) if(!vis[to]) dfs1(to, s);
			s.add(i);
		}
		
		public void dfs2(int i, ArrayList<Integer> a) {
			vis[i] = true;
			for(int to : adjT[i]) if(!vis[to]) dfs2(to, a);
			a.add(i);
		}
		
		public ArrayList<ArrayList<Integer>> getSCC(){
			ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
			vis = new boolean[n];
			Stack<Integer> s = new Stack<>();
			for(int i = 0; i<n; i++) if(!vis[i]) dfs1(i, s);
			vis = new boolean[n];
			while(!s.isEmpty()) {
				int v = s.pop();
				if(vis[v]) continue;
				ArrayList<Integer> cur = new ArrayList<>();
				dfs2(v, cur);
				ans.add(cur);
			}
			return ans;
		}
		
		public HashSet<Integer>[] getCompressed(){
			ArrayList<ArrayList<Integer>> scc = getSCC();
			int newN = scc.size();
			HashSet<Integer> ans[] = new HashSet[newN];
			for(int i = 0; i<newN; i++) ans[i] = new HashSet<>();
			int[] parent = new int[n];
			for(int i = 0; i<scc.size(); i++) for(int v : scc.get(i)) parent[v] = i;
			for(int i = 0; i<n; i++) {
				for(int to : adj[i]) {
					if(parent[i] == parent[to]) continue;
					ans[parent[i]].add(parent[to]);
				}
			}
			return ans;
		}
	}