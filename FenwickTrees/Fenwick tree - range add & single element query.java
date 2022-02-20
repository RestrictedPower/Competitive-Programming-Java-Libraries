	static class Fenwick{
		private long[] tree;
		
		public Fenwick(int n) {
			tree = new long[n+1];
		}
		
		public void rangeAdd(int l, int r, long x) {
			add(l, x);
			add(r+1, -x);
		}
		
		public long get(int i) {
			i++;
			long ans = 0;
			while(i>0) {
				ans += tree[i];
				i -= (i&-i);
			}
			return ans;
		}
		
		public void add(int i, long x) {
			i++;
			while(i<tree.length) {
				tree[i] += x;
				i += (i&-i);
			}
		}
	}