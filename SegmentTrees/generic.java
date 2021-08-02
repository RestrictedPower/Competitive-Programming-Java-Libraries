	static class SegmentTree{
		int dummyValue = Integer.MAX_VALUE;
		public long operation(long a, long b){
			return Math.min(a, b);
		}
		//Modify the values above according to the required operations (i.e. for sum: operation = a+b, dummyValue = 0)
		
		private long[] tree;
		int n;
		public SegmentTree(int[] a) {
			this.n = a.length;
			this.tree = new long[4*n];
			build(0, 0, n-1, a);
		}
		
		public SegmentTree(int n) {
			this.n = n;
			this.tree = new long[4*n];
		}
		
		private void build(int idx, int l, int r, int[] a) {
			if(l==r) tree[idx] = a[l];
			else {
				int m = (l+r)/2;
				build(2*idx+1, l, m, a);
				build(2*idx+2,m+1,r, a);
				tree[idx] = operation(tree[2*idx+1], tree[2*idx+2]);
			}
		}
		
		public void update(int idx, long weight) {
			updateUtil(0, 0, n-1, idx, weight);
		}
		
		private void updateUtil(int idx ,int l, int r, int i, long weight) {
			if(l==r) tree[idx] = weight;
			else {
				int md = (l+r)/2;
				if(i<=md) updateUtil(2*idx+1, l, md, i, weight);
				else updateUtil(2*idx+2, md+1, r, i, weight);
				tree[idx] = operation(tree[2*idx+1], tree[2*idx+2]);
			}
		}
		
		public long query(int l, int r) {
			return queryUtil(0, l, r, 0, n-1);
		}
		
		private long queryUtil(int idx, int lBound, int rBound, int l, int r) {
			if(rBound < l || r < lBound) return dummyValue;
			if(lBound <= l && r<= rBound) return tree[idx];
			int md = (l+r)/2;
			return operation(queryUtil(2*idx+1, lBound, rBound, l, md), queryUtil(2*idx+2, lBound, rBound, md+1, r));
		}
	}