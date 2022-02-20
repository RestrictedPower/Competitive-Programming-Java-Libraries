	static class BipartiteColoring{
		private boolean possible, run;
		private int n;
		private int[] col;
		private ArrayList<Integer> adj[];
		
		public BipartiteColoring(ArrayList<Integer> adj[]) {
			run = possible = false;
			col = new int[n = adj.length];
			this.adj = adj;
		}
		
		public boolean possible() {
			if(!run) throw new RuntimeException("Call run first!");
			return possible;
		}
		
		public int[] getColoring() {
			if(!run) throw new RuntimeException("Call run first!");
			if(!possible) throw new RuntimeException("Graph is not bipartite!");
			return col;
		}
		
		public void run() {
			Arrays.fill(col, -1);
			for(int i = 0; i<n; i++) dfs(i, 0);
			possible = true;
			for(int i = 0; i<n; i++) for(int j : adj[i]) if(col[i] == col[j]) possible = false;
			run = true;
		}
		
		private void dfs(int i, int color) {
			if(col[i] != -1) return;
			col[i] = color;
			for(int j : adj[i]) dfs(j,color^1);
		}
	}