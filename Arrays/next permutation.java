	/*
		This algorithm generates the next permutation in-place.
		It returns true or false if there exists a next permutation (array is not sorted in decreasing order).
		
		The algorithm consists of the following steps:
		1) Find the largest index i such that a[i]<a[i+1]. We will not change anything before this index. 
		   If there exists no such pair return false.
		2) Now all numbers after i+1 are in decreasing order. We need to find the smallest number that is 
		   larger than a[i] and swap it with i, that is the first number from the end of the array, 
		   larger than a[i] since the array after i+1 is in decreasing order.
		3) Reverse the array from i+1 till the end.
	*/



	public static boolean nextPermutation(int[] a){
		int n = a.length;
		int lastIncreasing = -1;
		for(int i = n-2; i>=0 && lastIncreasing==-1; i--) if(a[i]<a[i+1]) lastIncreasing = i;
		if(lastIncreasing==-1) return false;
		int l = lastIncreasing+1, r = n-1;
		int lastLargestIdx = -1;
		for(int i = n-1; i>=0 && lastLargestIdx==-1; i--) if(a[lastIncreasing]<a[i]) lastLargestIdx = i;
		int tmp = a[lastIncreasing];
		a[lastIncreasing] = a[lastLargestIdx];
		a[lastLargestIdx] = tmp;
		while(l<=r){
			tmp = a[l];
			a[l++] = a[r];
			a[r--] = tmp;
		}
		return true;
	}