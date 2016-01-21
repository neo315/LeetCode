// # 204 Count Primes 
//Description:
//
//Count the number of prime numbers less than a non-negative number, n
//
//click to show more hints.
//
//Tags: Math

public class Solution { 
    public int countPrimes(int n) { 
        int result = 0; 
        boolean[] notPrime = new boolean[n + 2]; 
        notPrime[0] = notPrime[1] = true; 
         
        for (int i = 2; i*i < n; i++) 
        { 
            if (!notPrime[i])  
            { 
                int c = i * i; 
                while (c < n) 
                { 
                    notPrime[c] = true; 
                    c += i; 
                } 
            } 
        } 
         
        for (int i = 0; i < n; i ++) 
            if (!notPrime[i]) result++; 
        return result; 
    } 
}