import java.util.HashMap;

class Solution 
{
    public boolean containsNearbyDuplicate(int[] nums, int k) 
    {

       HashMap <Integer, Integer> map = new HashMap <>();

       for(int i = 0; i < nums.length; i++)
       {  
        
        // check element exit in the map 
        if(map.containsKey(nums[i]))
        {
        // if exist so find the distance 
            if(i - map.get(nums[i]) <= k)
            {
                return true;
            }
        }
        // if not true so update the index into current index
        map.put(nums[i] , i);

       }
        return false;
    }
}