package SlidingWindow;

/**
 * Invariant - Prefix sum with hashmap/array - We contain remainder found in previous prefix sum and compute accordingly using below theorem.
 *
 * Theorem (Important) - If prefix sum S1 and S2, both have same remainder, means S1 % K == S2 % K. Then (S1 - S2) % k ==0
 * remainder of S1 - S2 is 0.
 * Proof-> We can write a number like this -> S = k * x + r (for eg: 11 = 2*5 + 1) where k is modulo, x is quotient and r is remainder.
 * so, using above logic S1 = k * x + r and S2 = k * y + r; (Ps: there remainder are same)
 * S1-S2 = (K * x + r) - (k * y + r)
 * s1-s2 = k(x-y);
 * S3 = KN -> Where s3 = s1-s2 and N is x-y;
 * If you observe, S3/K = N and S3/N = K. So, both remainder are 0;
 * Hence proved.
 */
public class LC974 {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int prefixSum = 0, result = 0;

        // There are k mod groups 0...k-1.
        int[] modGroups = new int[k];
        modGroups[0] = 1;

        for (int num: nums) {
            prefixSum+=num;
            /**
             * If Y%k = -X , so -X + k = Positive(K-X) Which is simple maths of denoting -ve value on +ve end.
             */
            int mod = (prefixSum%k+k)%k; // Edge case - If remainder is -ve, so modgroups[-ve] -> exception.
            result += modGroups[mod];
            modGroups[mod]++;
        }

        return result;
    }
}
