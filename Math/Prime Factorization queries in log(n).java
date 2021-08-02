	int maxN = 1000000;
	public static int[] getMinPrimeFactorSieve(int n) {
        int[] minFactor = new int[n+1];
        for(int i = 0; i<=n; i++) minFactor[i] = i;
        for (int i = 2; i*i <= n; i++) if (minFactor[i]==i) 
            for (int j = i*i; j <= n; j+=i) minFactor[j] = i;
        return minFactor;
    }
	public static ArrayList<Integer> getFactorization(int v){
		ArrayList<Integer> ans = new ArrayList<Integer>();
		int[] factor = getMinPrimeFactorSieve(maxN); //factor[i] is the smallest prime factor for i.
		while(v>1) {
			int largestFactor = factor[v];
			ans.add(largestFactor);
			v/=largestFactor;
		}
		return ans;
	}