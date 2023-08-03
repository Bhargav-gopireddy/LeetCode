//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            int h = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.Solve(n,a,h);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int max(int[] piles){
        int max = Integer.MIN_VALUE;
        int n = piles.length;
        for(int i=0;i<n;i++){
            if(piles[i] > max){
                max = piles[i];
            }
        }
        return max;
    }
    public static int find(int[] piles, int hourly){
        int hours = 0;
        int n = piles.length;
        for(int i=0; i < n; i++){
            hours += Math.ceil((double) piles[i] / hourly);
        }
        return hours;
        
    }
    public static int Solve(int N, int[] piles, int H) {
        // code here
        int low =1, high = max(piles);
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            
            int totalHours = find(piles, mid);
            if(totalHours <= H){
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
        
