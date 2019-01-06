# Competitive-Programming-Java-Libraries
My code lib for competitive programming

  #   Contents:

  # Reader.java Class:
  - Fast and efficient way to read input from System.in.
  - Supported data types are: Integers, Strings, Longs, Doubles and Integer Arrays.
  
  # Graph.java Class Contains:
  - An Edge add system.
  - Both DFS and BFS base algorithms.
  
  # Util.java Class Contains:
  - An integer primality testing algorithm.
  - A sieve function which returns an integer bitmap array with all the marked primes on it.
  - A GCD algorithm (greatest common divisor)
  - A modAdd and a modMul algorithm. They can be used instead of addition and multiplication when the problem asks the answer to be printed MOD some value
  - An upper bound utility. This takes as a parameter an array and a value and returns the largest index i where (value >= a[i])
  - A lower bound utility. This takes as a parameter an array and a value and returns the smallest index i where (value =< a[i])
  - Note: lower and higher bounds should be used on sorted arrays and they are not guaranteed to return the largest/smallest index if 
    there are duplicates of the bound value. This can be fixed by adding a loop at the end of the algorithm but it would make the time     
    complexity O(N) instead of O(logN). Worst case scenario would be if all the numbers were duplicates. Both return -1 if value gets out of range.
  
  
  
