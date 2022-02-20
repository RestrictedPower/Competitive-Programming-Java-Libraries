	public static long[][] matrixMultiplication(long[][] A, long[][] B){
		if(A[0].length!=B.length) return null; //Matrix multiplication is impossible!
		int n = A.length, m = B[0].length, X = A[0].length; 
		long[][] C = new long[n][m];
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				for(int k = 0; k<X; k++) {
					C[i][j] += A[i][k]*B[k][j];
				}
			}
		}
		return C;		
	}
	
	public long[][] matrixExponentiation(long[][] A, int pow){
		if(A.length!=A[0].length) return null; //Matrix exponentiation is impossible!
		int n = A.length;
		long[][] ans = new long[n][n];
		for(int i = 0; i<n; i++) ans[i][i] = 1;
    	while (pow > 0){
    		if ((pow & 1) != 0) ans = matrixMultiplication(ans, A);
        	pow >>= 1;
        	A = matrixMultiplication(A, A);
    	}
    	return ans;
	}
	
	//Modulo version below
	public static long[][] matrixMultiplication(long[][] A, long[][] B, long mod){
		if(A[0].length!=B.length) return null; //Matrix multiplication is impossible!
		int n = A.length, m = B[0].length, X = A[0].length; 
		long[][] C = new long[n][m];
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				for(int k = 0; k<X; k++) {
					C[i][j] = (C[i][j] + (A[i][k]*B[k][j])%mod)%mod;
				}
			}
		}
		return C;		
	}
	
	public long[][] matrixExponentiation(long[][] A, int pow, long mod){
		if(A.length!=A[0].length) return null; //Matrix exponentiation is impossible!
		int n = A.length;
		long[][] ans = new long[n][n];
		for(int i = 0; i<n; i++) ans[i][i] = 1;
    	while (pow > 0){
    		if ((pow & 1) != 0) ans = matrixMultiplication(ans, A, mod);
        	pow >>= 1;
        	A = matrixMultiplication(A, A, mod);
    	}
    	return ans;
	}