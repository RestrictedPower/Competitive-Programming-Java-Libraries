	static class SegmentTree{
		int dummyValue = Integer.MAX_VALUE;
		
		public int operation(int a, int b){
			return Math.min(a,b);
		}

		private int[] tree;
		private int[] lazy;
		int n;
		
		public SegmentTree(int[] a) {
			this.n = a.length;
			this.tree = new int[4*n];
			this.lazy = new int[4*n];
			build(0, 0, n-1, a);
		}
		
		private void prop(int i, int l, int r) {
			tree[i] += lazy[i];
			if(l!=r) {
				lazy[2*i+1] += lazy[i];
				lazy[2*i+2] += lazy[i];
			}
			lazy[i] = 0;
		}
		
		public SegmentTree(int n) {
			this.n = n;
			this.tree = new int[4*n];
			this.lazy = new int[4*n];
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
		
		public void addRange(int l, int r, int delta) {
			addRangeUtil(0, l, r, 0, n-1, delta);
		}
		
		private void addRangeUtil(int idx, int lBound, int rBound, int l, int r, int delta) {
			prop(idx,l,r);
			if(rBound < l || r < lBound) return;
			if(lBound <= l && r <= rBound) {
				lazy[idx] += delta;
				prop(idx, l, r);
				return;
			}
			int md = (l+r)/2;
			addRangeUtil(2*idx+1, lBound, rBound, l, md, delta);
			addRangeUtil(2*idx+2, lBound, rBound, md+1, r, delta);
			tree[idx] = operation(tree[2*idx+1], tree[2*idx+2]);
		}
		public int query(int l, int r) {
			return queryUtil(0, l, r, 0, n-1);
		}
		
		private int queryUtil(int idx, int lBound, int rBound, int l, int r) {
			if(rBound < l || r < lBound) return dummyValue;
			prop(idx,l,r);
			if(lBound <= l && r <= rBound) return tree[idx];
			int md = (l+r)/2;
			return operation(queryUtil(2*idx+1, lBound, rBound, l, md), queryUtil(2*idx+2, lBound, rBound, md+1, r));
		}
	}