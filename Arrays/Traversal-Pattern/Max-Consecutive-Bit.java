class Solution {
    public int maxConsecBits(int[] arr) {
        
        int count = 1;
        int maxCount = 1;
        
        for(int i = 1; i < arr.length; i++)
        {
            if(arr[i] == arr[i - 1])
            {
                count++;
            }
            else
            {
                count = 1;
            }
        maxCount = Math.max(count, maxCount);
        }
    return maxCount;
    }
}
