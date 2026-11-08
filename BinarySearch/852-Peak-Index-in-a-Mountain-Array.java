class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        
        int st = 1;
        int end = arr.length - 2;

        while(st <=  end)
        {
            int mid = st + (end - st) / 2;
            
            // In a best case peak element is  a mid 
            if(arr[mid -1] < arr[mid] && arr[mid] > arr[mid + 1])
            {
                return mid;
            }
            //check mid lies in a left or right 
            //if mid is in left then search in a right side
            if(arr[mid - 1] < arr[mid])
            {
                st = mid + 1;
            }
            // if mid in right then search in left 
            else
            {
                end = mid - 1;
            }
        }
        return -1; 
    }
}