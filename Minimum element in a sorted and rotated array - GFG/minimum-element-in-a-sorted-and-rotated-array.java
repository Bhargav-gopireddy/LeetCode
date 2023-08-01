//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0)
        {
            int n = sc.nextInt();
            int A[] = new int[n];
            
            for (int i = 0;i < n;i++)
            {
                A[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            System.out.println(sol.findMin(A, n));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    int findMin(int arr[], int n)
    {
        //complete the function here

        int low = 0, high = n-1;
        int res = Integer.MAX_VALUE;
        while(low <= high){
            int mid = low + (high - low)/2;
            // [4 5 6 0 1 2]
            if(arr[low] <= arr[high]){
                res = Math.min(arr[low], res);
                break;
            }
            if(arr[low] <= arr[mid]){
                res = Math.min(arr[low], res);
                low = low + 1;
            }
            else{
                res = Math.min(arr[mid], res);
                high = mid - 1;
            }
        }
        return res;
    }
}
