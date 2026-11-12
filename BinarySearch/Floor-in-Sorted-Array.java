class Solution {
    static int findFloor(int[] arr, int x) {
        
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;
        
        while(low <= high)
        {
            int mid = low + (high - low) / 2;
            if(arr[mid] > x)
            {
                high = mid - 1;
            }
            // <= because next index will be our answer
            else if(arr[mid] <= x)
            {
                ans = mid;
                low = mid + 1;
            }
        }
        return ans;
    }
}
