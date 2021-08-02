	static class DSU{
		int n;
		int[] parent;
		public DSU(int n){
			this.n = n;
			parent = new int[n];
			for(int i = 0; i<n; i++) parent[i] = i;
		}
		public int find(int i){
			if(parent[i]==i) return i;
			return parent[i] = find(parent[i]);
		}
		public boolean union(int i, int j){
			int pI = find(i), pJ = find(j);
			if(pI==pJ) return false; //Already united
			parent[pI] = pJ;
			return true;
		}
	}