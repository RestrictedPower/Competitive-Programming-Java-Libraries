	static class TopologicalSort{
		private boolean possible, run;
		private int n;
		private int[] inDeg, topSort;
		private ArrayList<Integer> adj[];
		
		public TopologicalSort(ArrayList<Integer> adj[]) {
			run = possible = false;
			inDeg = new int[n = adj.length];
			topSort = new int[n];
			this.adj = adj;
		}
		
		public boolean possible() {
			if(!run) throw new RuntimeException("Call run first!");
			return possible;
		}
		
		public int[] getTopSort() {
			if(!run) throw new RuntimeException("Call run first!");
			if(!possible) throw new RuntimeException("Graph is not bipartite!");
			return topSort;
		}
		
		public void run() {
			Arrays.fill(topSort, -1);
			Queue<Integer> q = new LinkedList<>();
			for(int i = 0; i<n; i++) {
				for(int j : adj[i]) inDeg[j]++;
			}
			for(int i = 0; i<n; i++) if(inDeg[i] == 0) q.add(i);
			int idx = 0;
			while(!q.isEmpty()) {
				int i = q.poll();
				topSort[i] = idx++;
				for(int j : adj[i]) {
					if(--inDeg[j] == 0) q.add(j);
				}
			}
			possible = idx==n;
			run = true;
		}
	}