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