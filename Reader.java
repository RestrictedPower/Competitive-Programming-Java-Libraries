public class Reader {
	static BufferedReader br;
	static StringTokenizer st;
	private int charIdx = 0;
	private String s;

	public Reader() {
		this.br = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public Reader(String f){
		try {
			this.br = new BufferedReader(new FileReader(f));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public int[] na(int n) {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = nextInt();
		return a;
	}

	public double[] nd(int n) {
		double[] a = new double[n];
		for (int i = 0; i < n; i++)
			a[i] = nextDouble();
		return a;
	}

	public char nextChar() {
		if (s == null || charIdx >= s.length()) {
			if (st == null || !st.hasMoreTokens())
				try {
					readLine();
				} catch (Exception e) {
				}
			s = st.nextToken();
			charIdx = 0;
		}
		return s.charAt(charIdx++);
	}

	public long[] nl(int n) {
		long[] a = new long[n];
		for (int i = 0; i < n; i++)
			a[i] = nextLong();
		return a;
	}

	public char[] nca() {
		return next().toCharArray();
	}

	public String[] nS(int n) {
		String[] a = new String[n];
		for (int i = 0; i < n; i++)
			a[i] = next();
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

	public static void readLine() {
		try {
			st = new StringTokenizer(br.readLine());
		} catch (Exception e) {
		}
	}
}
