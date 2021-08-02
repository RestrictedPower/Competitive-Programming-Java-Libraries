	//lps[i] = the longest prefix of pat[0..i] which is also a suffix of pat[0..i].
	public static int[] lps(char[] a) {
		int n = a.length;
		int[] lps = new int[n];
		for(int i = 1; i<n; i++) {
			int idx = lps[i-1];
			while(idx>0&&a[i]!=a[idx]) idx = lps[idx-1];
			lps[i] = idx + (a[i]==a[idx]?1:0);
		}
		return lps;
	}