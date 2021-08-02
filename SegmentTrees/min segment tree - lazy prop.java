	static class SegmentTree{
		private long[] tree;
		private long[] lazy;
		int n;
		public SegmentTree(int[] a) { //Initialize by given array
			this.n = a.length;
			this.tree = new long[4*n];
			this.lazy = new long[4*n];
			build(0, 0, n-1, a);
		}
		
		public SegmentTree(int n) { //Initialize by size
			this.n = n;
			this.tree = new long[4*n];
			this.lazy = new long[4*n];
		}
		
		private void build(int idx, int l, int r, int[] a) {
			if(l==r) tree[idx] = a[l];
			else {
				int m = (l+r)/2;
				build(2*idx+1, l, m, a);
				build(2*idx+2,m+1,r, a);
				tree[idx] = Math.min(tree[2*idx+1], tree[2*idx+2]); //Min
			}
		}
		
		public void prop(int idx) {
		    tree[idx*2+1] += lazy[idx];
		    lazy[idx*2+1] += lazy[idx];
		    tree[idx*2+2] += lazy[idx];
		    lazy[idx*2+2] += lazy[idx];
		    lazy[idx] = 0;
		}

		public void update(int l, int r, int val) {
			updateUtil(0, l, r, 0, n-1, val);
		}
		
		private void updateUtil(int idx, int lBound, int rBound, int l, int r , int v) {
			if(lBound<=l && r<=rBound) {
				tree[idx] += v;
				lazy[idx] += v;
				return;
			}
			if(r<lBound || rBound<l) return;
			int md = (l+r)/2;
			prop(idx);
			updateUtil(2*idx+1, lBound, rBound, l, md, v);
			updateUtil(2*idx+2, lBound, rBound, md+1, r, v);
			tree[idx] = Math.min(tree[2*idx+1], tree[2*idx+2]);
		}
		
		public long query(int l, int r) {
			return queryUtil(0, l, r, 0, n-1);
		}
		
		private long queryUtil(int idx, int lBound, int rBound, int l, int r) {
			if(rBound < l || r < lBound) return Integer.MAX_VALUE; //Min
			if(lBound <= l && r<= rBound) return tree[idx];
			prop(idx);
			int md = (l+r)/2;
			return Math.min(queryUtil(2*idx+1, lBound, rBound, l, md), queryUtil(2*idx+2, lBound, rBound, md+1, r)); //Min
		}
	}