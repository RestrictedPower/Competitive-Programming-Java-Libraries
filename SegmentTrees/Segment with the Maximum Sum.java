	static class Segment{
		long prefix, mid, suffix, sum;
		public Segment(long v) {
			this.sum = v;
			v = Math.max(0, v);
			this.prefix = v;
			this.mid = v;
			this.suffix = v;
		}
		public void changeAll(long v) {
			this.sum = v;
			v = Math.max(0, v);
			this.prefix = v;
			this.mid = v;
			this.suffix = v;
		}
		public void updateSegment(Segment l, Segment r) {
			this.sum = l.sum + r.sum;
			this.mid = Math.max(l.suffix + r.prefix, Math.max(l.mid, r.mid));
			this.prefix = Math.max(l.prefix,l.sum + r.prefix);
			this.suffix = Math.max(r.suffix, l.suffix + r.sum);
		}
	}
	
	
	static class SegmentTree{
		private Segment[] tree;
		int n;
		
		public SegmentTree(long[] a) {
			this.n = a.length;
			this.tree = new Segment[4*n];
			for(int i = 0; i<4*n; i++) tree[i] = new Segment(0);
			build(0, 0, n-1, a);
 		}
		
		public SegmentTree(int n) {
			this.n = n;
			this.tree = new Segment[4*n];
			for(int i = 0; i<4*n; i++) tree[i] = new Segment(0);
		}
		
		private void build(int idx, int l, int r, long[] a) {
			if(l==r) {
				tree[idx].changeAll(a[l]);
			} else {
				int m = (l+r)/2;
				build(2*idx+1, l, m, a);
				build(2*idx+2,m+1,r, a);
				tree[idx].updateSegment(tree[2*idx+1], tree[2*idx+2]);
			}
		}
		
		public void update(int idx, long val) {
			updateUtil(0, 0, n-1, idx, val);
		}
		
		private void updateUtil(int idx ,int l, int r, int i, long v) {
			if(l==r) tree[idx].changeAll(v);
			else {
				int md = (l+r)/2;
				if(i<=md) updateUtil(2*idx+1, l, md, i, v);
				else updateUtil(2*idx+2, md+1, r, i, v);
				tree[idx].updateSegment(tree[2*idx+1], tree[2*idx+2]);
			}
		}
		
		public long query(int l, int r) {
			return queryUtil(0, l, r, 0, n-1).mid;
		}
		
		private Segment queryUtil(int idx, int lBound, int rBound, int l, int r) {
			if(rBound < l || r < lBound) return new Segment(0);
			if(lBound <= l && r<= rBound) return tree[idx];
			int md = (l+r)/2;
			Segment merge = new Segment(0);
			merge.updateSegment(queryUtil(2*idx+1, lBound, rBound, l, md), queryUtil(2*idx+2, lBound, rBound, md+1, r));
			return merge;
		}
	}