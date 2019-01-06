public static class Util{
	    static boolean isPrime(int n) { 
	        if (n <= 1) return false; 
	        if (n <= 3) return true; 
	        if (n % 2 == 0 || n % 3 == 0) return false; 
	        for (int i = 5; i * i <= n; i = i + 6) 
	            if (n % i == 0 || n % (i + 2) == 0) 
	            return false; 
	        return true; 
	    }
		public static int upperBound(int[] a, int v) {
			if(a[0]>v) return -1;
			int l=0,h=a.length-1;
			while(l<h) {
				int mid = (l+h)/2;
				if(v>=a[mid]) l = mid+1;
				else h = mid-1;
			}
			if(v<a[l]) return l-1;
			return l;
		}
		public static int lowerBound(int[] a, int v) {
			if(a[a.length-1]<v) return -1;
			int l=0,h=a.length-1;
			while(l<h) {
				int mid = (l+h)/2;
				if(v<=a[mid]) h = mid-1;
				else l = mid+1;
			}
			if(v>a[l]) return l+1;
			return l;
		}
	    public static boolean[] getSieve(int n) {
	        boolean[] isPrime = new boolean[n+1];
	        for (int i = 2; i <= n; i++) isPrime[i] = true;
	        for (int i = 2; i*i <= n; i++) if (isPrime[i]) 
	                for (int j = i; i*j <= n; j++) isPrime[i*j] = false;
	        return isPrime;
	    }
	    public static int gcd(int a, int b) { 
	        if (a == 0) 
	            return b; 
	        return gcd(b%a, a); 
	    }
		public static long modAdd(long a, long b, long mod) {
			return (a%mod+b%mod)%mod;
		}
		public static long modMul(long a, long b, long mod) {
			return ((a%mod)*(b%mod))%mod;
		}
	}
