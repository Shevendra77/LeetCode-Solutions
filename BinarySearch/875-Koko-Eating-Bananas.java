class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = 0;

        //calculate the max piles
        for(int pile : piles)
        {
           high = Math.max(pile, high);
        }

        //It will take max or max hours 
        int ans = high;

        while(low <= high)
        {
            int mid = low + (high - low) / 2;
            
            long hours = 0;
            
            //calculate toatal hours
            for(int pile : piles)
            {
                hours += (pile -1) / mid + 1;
            }
            // check minimum time 
            if(hours <= h)
            {
                ans = mid;
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return ans;
    }
}