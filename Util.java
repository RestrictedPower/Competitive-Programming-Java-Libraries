import java.util.Arrays;

public class Util{
		static long[] fact;
		public static void initFactorial(int n, long mod) {
			fact = new long[n+1];
			fact[0] = 1;
			for (int i = 1; i < n+1; i++) fact[i] = (fact[i - 1] * i) % mod;
		}
		
		public static long modInverse(long a, long MOD) {
			long[] gcdE = gcdExtended(a, MOD);
			if (gcdE[0] != 1) return -1; // Inverted doesn't exist
			long x = gcdE[1];
			return (x % MOD + MOD) % MOD;
		}

		public static long[] gcdExtended(long p, long q) {
			if (q == 0) return new long[] { p, 1, 0 };
			long[] vals = gcdExtended(q, p % q);
			long tmp = vals[2];
			vals[2] = vals[1] - (p / q) * vals[2];
			vals[1] = tmp;
			return vals;
		}
		
		public static long nCr(int n, int r, long MOD) {
			if (r == 0) return 1;
			return (fact[n] * modInverse(fact[r], MOD) % MOD * modInverse(fact[n - r], MOD) % MOD) % MOD;
		}
		
		public static long nCr(int n, int r) {
			return (fact[n]/fact[r])/fact[n-r];
		}
		
		public static long nPr(int n, int r, long MOD) {
			if (r == 0) return 1;
			return (fact[n] * modInverse(fact[n - r], MOD) % MOD) % MOD;
		}
		
		public static long nPr(int n, int r) {
			return fact[n]/fact[n-r];
		}
		
		public static boolean isPrime(int n) { 
	        if (n <= 1) return false; 
	        if (n <= 3) return true; 
	        if (n % 2 == 0 || n % 3 == 0) return false; 
	        for (int i = 5; i * i <= n; i = i + 6) 
	            if (n % i == 0 || n % (i + 2) == 0) 
	            return false; 
	        return true; 
	    }
		
		public static int upperBound(long[] a, long v) {
			int l=0, h=a.length-1, ans = -1;
			while(l<h) {
				int mid = (l+h)/2;
				if(a[mid]<=v) {
					ans = mid;
					l = mid+1;
				}else h = mid-1;
			}
			return ans;
		}
		
		public static int lowerBound(long[] a, long v) {
			int l=0, h=a.length-1, ans = -1;
			while(l<h) {
				int mid = (l+h)/2;
				if(v<=a[mid]) {
					ans = mid;
					h = mid-1;
				}else l = mid-1;
			}
			return ans;
		}
		
	    public static boolean[] getSieve(int n) {
	        boolean[] isPrime = new boolean[n+1];
	        for (int i = 2; i <= n; i++) isPrime[i] = true;
	        for (int i = 2; i*i <= n; i++) if (isPrime[i]) 
	                for (int j = i; i*j <= n; j++) isPrime[i*j] = false;
	        return isPrime;
	    }
	    
	    public static int gcd(int a, int b) { 
	        if (a == 0)  return b; 
	        return gcd(b%a, a); 
	    }
	    
		public static void dbg(Object... o) { 
			System.out.println(Arrays.deepToString(o)); 
		}
	}
