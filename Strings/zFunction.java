	/*
	 * Z function returns an int[] z where z[i] contains the size of the maximum 
	 * substring starting at i that matches the prefix of the string.
	 * 
	 * 	Examples:
	 * 	"aaaaa" - [0,4,3,2,1]
	 *	"aaabaab" - [0,2,1,0,2,1,0]
	 *	"abacaba" -  [0,0,1,0,3,0,1]
	 * 
	 * Source: https://cp-algorithms.com/string/z-function.html
	 */
	static int[] z_function(String s) {
		int n = s.length();
		int[] z = new int[n];
	    for (int i = 1, l = 0, r = 0; i < n; ++i) {
	        if (i <= r) z[i] = Math.min(r - i + 1, z[i - l]);
	        while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) ++z[i];
	        if (i + z[i] - 1 > r) {
	        	l = i;
	        	r = i + z[i] - 1;
	        }
	    }
	    return z;
	}