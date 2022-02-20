	static class Fenwick{
		private long[] tree;
		private long[] tree2;
		
		public Fenwick(int n) {
			tree = new long[n+1];
			tree2 = new long[n+1];
		}
		
		public void rangeAdd(int l, int r, long x) {
			add(tree, l, x);
			add(tree, r+1, -x);
			add(tree2, l, x*(l-1));
			add(tree2, r+1, -x*r);
		}
		
		public long prefixSum(int idx) {
			return sum(tree, idx)*idx - sum(tree2, idx);
		}
		
		public long rangeSum(int l, int r) {
			return prefixSum(r) - prefixSum(l-1);
		}

		private long sum(long[] t, int i) {
			i++;
			long ans = 0;
			while(i>0) {
				ans += t[i];
				i -= (i&-i);
			}
			return ans;
		}
		
		private void add(long[] t, int i, long x) {
			i++;
			while(i<t.length) {
				t[i] += x;
				i += (i&-i);
			}
		}
	}