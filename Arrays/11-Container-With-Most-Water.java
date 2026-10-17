class Solution {
    public int maxWater(int arr[]) {
        
        int left = 0;
        int right = arr.length-1;
        int max = 0;
        
        while(left < right)
        {
            int width = right - left;
            int height = Math.min(arr[left] , arr[right]);
            int area = width * height;
            
            max = Math.max(max , area);
            
        if(arr[left] < arr[right])
        {
            left++;
        }
        else
        {
            right--;
        }
        
        }
       
        
        return max;
    }
}