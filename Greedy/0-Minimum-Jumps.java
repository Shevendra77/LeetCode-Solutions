class Solution {
    public int minJumps(int[] arr) {
        
        int n = arr.length;
        
        if(n == 1)
        {
            return 0;
        }
        if(arr[0] == 0)
        {
            return -1;
        }
        
        int max = 0;
        int choice = 0;
        int jumps = 0;
        
        for(int i = 0; i < n -1; i++)
        {
            max = Math.max(max , arr[i] + i);
            if(i == choice)
            {
                choice = max;
                jumps++;
            }
           
        }
        if(choice >= n - 1)
        {
            return jumps;
        }
        return -1;
        
    }
}