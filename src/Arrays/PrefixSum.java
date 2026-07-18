package Arrays;

public class PrefixSum {
//    🔥 PREFIX SUM PATTERN ROADMAP
//🟢 Level 1 — Basic Prefix Sum Build
//1. Prefix Sum Array banao
//
//    Example:
//
//    arr = [1,2,3,4]
//
//    Prefix:
//
//            [1,3,6,10]
//
//            👉 Foundation question.
//
//            🟢 Level 2 — Range Sum Query
//2. Find sum from index L to R
//
//    Example:
//
//    arr = [2,4,1,6,3]
//    L = 1
//    R = 3
//
//    Answer:
//
//            11
//
//            👉 Formula:
//
//    prefix[r] - prefix[l-1]
//
//    MOST IMPORTANT formula.
//
//🟡 Level 3 — Subarray Sum Equals K
//3. Count subarrays whose sum = k
//
//    Example:
//
//            [1,1,1]
//    k = 2
//
//    Answer:
//
//            2
//
//            ⚠️ THIS IS THE REAL PREFIX SUM PATTERN.
//
//👉 HashMap + prefix sum.
//
//            🟡 Level 4 — Longest Subarray Sum = K
//4. Longest subarray having sum k
//
//    Example:
//
//            [1,2,3,1,1,1,1]
//    k = 3
//
//    Answer:
//
//            3
//
//            👉 Prefix + first occurrence map.
//
//🟠 Level 5 — Count Zero Sum Subarrays
//5. Count subarrays with sum = 0
//
//    Hidden prefix pattern.
//
//👉 Same logic:
//
//    prefixSum repeated
//🟠 Level 6 — Equal 0s and 1s
//6. Largest subarray with equal 0s and 1s
//
//    Trick:
//
//            0 -> -1
//
//    then prefix sum.
//
//🔴 Level 7 — Binary Array Prefix
//7. Contiguous Array (Leetcode)
//
//    Equal number of 0s and 1s.
//
//    Classic interview question.
//
//🔴 Level 8 — 2D Prefix Sum
//8. Sum of rectangle in matrix
//
//    Advanced extension.
}
