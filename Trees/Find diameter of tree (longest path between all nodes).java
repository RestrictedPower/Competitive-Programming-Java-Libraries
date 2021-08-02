	/*
		The following code finds the maximum diameter in a tree graph.
		
		Note that the largest path is obviously between two leaf nodes.
		
		To solve the problem we run dfs twice.
		In the first dfs we find the furthest node from any node, this 
		will be the one edge of the path we are looking for.
		
		In the second dfs we start from the node we found in the previous dfs
		and the result of this dfs is the diameter of the tree.
	
	*/
	
	static ArrayList<Integer>[] adj;
	static int maxCount,maxIdx;
	public static int diameter() {
		maxCount = 0;
		maxIdx = 0;
		dfs(0,-1, 0);
		int A = maxIdx;
		maxCount = 0;
		maxIdx = 0;
		dfs(A, -1, 0);
		return maxCount;
	}
	public static void dfs(int i, int prev,int count) {
		if(adj[i].size()==1 && count>maxCount) {
			maxIdx = i;
			maxCount = count;
		}
		for(Integer next : adj[i]) if(next!=prev) dfs(next, i, count+1);
	}