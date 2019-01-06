	static class Reader {
		static BufferedReader br;
		static StringTokenizer st;
		public Reader() {
			this.br = new BufferedReader(new InputStreamReader(System.in));
		}
		public int[] na(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) a[i] = nextInt();
			return a;
		}
		public int nextInt() {
			if (st == null || !st.hasMoreTokens())
				try {
					readLine();
				} catch (Exception e) {
				}
			return Integer.parseInt(st.nextToken());
		}
		public double nextDouble() {
			if (st == null || !st.hasMoreTokens())
				try {
					readLine();
				} catch (Exception e) {
				}
			return Double.parseDouble(st.nextToken());
		}
		public Long nextLong() {
			if (st == null || !st.hasMoreTokens())
				try {
					readLine();
				} catch (Exception e) {
				}
			return Long.parseLong(st.nextToken());
		}
		public String next() {
			if (st == null || !st.hasMoreTokens())
				try {
					readLine();
				} catch (Exception e) {
				}
			return st.nextToken();
		}
		private static void readLine() {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (Exception e) {
			}
		}
	}