//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            int K;
            K = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.smallestDivisor(nums, K);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
    public static int sumByD(int[] arr, int div){
        int sum=0;
        int n = arr.length;
        for(int i=0;i<n;i++){
            sum += Math.ceil((double)(arr[i])/(double)(div));
        }
        return sum;
    }
    public static int smallestDivisor(int[] nums, int K) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int res = -1;
        for(int i=0;i<n;i++){
            max = Math.max(max, nums[i]);
        }
        int low = 1, high = max;
        while(low <= high){
            int mid = low + (high - low)/2;
            int ans = sumByD(nums,mid);
            if(ans <= K){
                res = mid;
                high = mid-1;
            }
            else{
                low = mid + 1;
            }
        }
        return res;
    }
}