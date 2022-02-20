	static class SegmentTree {
		int n;
		int[] tree;
		int dummyValue = Integer.MAX_VALUE;
		
		public int operation(int a, int b){
			return Math.min(a, b);
		}

		public SegmentTree(int[] arr) {
			n = arr.length;
			tree = new int[n * 2];
			for (int i = 0; i < n; i++) {
				tree[n + i] = arr[i];
			}
			build();
		}
		
		public SegmentTree(int n) {
			this.n = n;
			tree = new int[n * 2];
		}
		
		void build() {
			for (int i = n - 1; i > 0; i--) {
				tree[i] = operation(tree[i * 2], tree[i * 2 + 1]);
			}
		}

		void update(int i, int value) {
			tree[n + i] = value;
			for (i = (n + i) / 2; i > 0; i /= 2) {
				tree[i] = operation(tree[i * 2], tree[i * 2 + 1]);
			}
		}
		
		int query(int l, int r) {
			l += n;
			r += n;
			int ansL = dummyValue, ansR = dummyValue;
			while (l < r) {
				if ((l & 1) > 0)
					ansL = operation(ansR, tree[l++]);
				if ((r & 1) > 0)
					ansR = operation(tree[--r], ansR);
				l /= 2;
				r /= 2;
			}
			return operation(ansL, ansR);
		}
	}