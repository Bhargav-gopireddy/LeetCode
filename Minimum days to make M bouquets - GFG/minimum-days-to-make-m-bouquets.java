//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
       
        int t = sc.nextInt();
        while(t-- > 0){
            
            
           int M = sc.nextInt();
           int K = sc.nextInt();
            
            
            //int n = sc.nextInt();
            sc.nextLine();
            String s[]=sc.nextLine().split(" ");
            int n=s.length;
            int[] bloomDay = new int[n];
            for(int i=0;i<n;i++) bloomDay[i]=Integer.parseInt(s[i]);
            
            Solution obj = new Solution();
            int res = obj.solve(M, K, bloomDay);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public static boolean possible(int[] bloomDay, int mid, int M, int K){
        int n = bloomDay.length;
        int number_bouquets = 0;
        int count = 0;
        for(int i=0;i<n;i++){
            if(bloomDay[i] <= mid){
                count++;
            }
            else{
                number_bouquets += (count/K);
                count = 0;
            }
        }
        number_bouquets += count/K;
        return number_bouquets >= M;
    }
    public static int solve(int M, int K, int[] bloomDay) {
       int n = bloomDay.length;
       int ans = -1;
       if(M*K > n){
           return -1;
       }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            max = Math.max(bloomDay[i], max);
            min = Math.min(bloomDay[i], min);
        }
        int low = min, high = max;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(possible(bloomDay, mid, M, K)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
}