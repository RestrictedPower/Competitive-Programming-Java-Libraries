	static class SegmentTree{
		private long[] tree;
		int n;
		
		public SegmentTree(int[] a) { //Initialize by given array
			this.n = a.length;
			this.tree = new long[4*n];
			build(0, 0, n-1, a);
		}
		
		public SegmentTree(int n) { //Initialize by size
			this.n = n;
			this.tree = new long[4*n];
		}
		
		private void build(int idx, int l, int r, int[] a) {
			if(l==r) tree[idx] = a[l];
			else {
				int m = (l+r)/2;
				build(2*idx+1, l, m, a);
				build(2*idx+2,m+1,r, a);
				tree[idx] = tree[2*idx+1] + tree[2*idx+2]; //Sum
			}
		}
		
		public void update(int idx, int val) {
			updateUtil(0, 0, n-1, idx, val);
		}
		
		private void updateUtil(int idx ,int l, int r, int i, int v) {
			if(l==r) tree[idx] = v;
			else {
				int md = (l+r)/2;
				if(i<=md) updateUtil(2*idx+1, l, md, i, v);
				else updateUtil(2*idx+2, md+1, r, i, v);
				tree[idx] = tree[2*idx+1] + tree[2*idx+2]; //Sum
			}
		}
		
		public long query(int l, int r) {
			return queryUtil(0, l, r, 0, n-1);
		}
		
		private long queryUtil(int idx, int lBound, int rBound, int l, int r) {
			if(rBound < l || r < lBound) return 0; //Sum
			if(lBound <= l && r<= rBound) return tree[idx];
			int md = (l+r)/2;
			return queryUtil(2*idx+1, lBound, rBound, l, md) + queryUtil(2*idx+2, lBound, rBound, md+1, r); //Sum
		}
	}