//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int count(int[] arr, int n, int x) {
        // code here
        int res1 = firstoccurance(arr, n, x);
        if(res1 == -1){
            return 0;
        }
        int res2 = lastoccurance(arr, n , x);
        return (res2 - res1 + 1);
    }
    public int firstoccurance(int arr[], int n, int x){
        int res = -1;
        int low = 0;
        int high = n-1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == x){
                res = mid;
                high = mid - 1;
            }
            else if(arr[mid] > x){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return res;
    }
    
    public int lastoccurance(int arr[], int n, int x){
        int res = -1;
        int low = 0;
        int high = n-1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == x){
                res = mid;
                low = mid + 1;
            }
            else if(arr[mid] > x){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return res;
    }
}