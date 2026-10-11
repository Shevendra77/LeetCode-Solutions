import java.util.*;

class Solution 
{
    public int[] twoSum(int[] nums, int target) 
    {
        HashMap <Integer, Integer> map =  new HashMap<>();

        for (int i = 0; i < nums.length; i++)
        {
            int first = nums[i];
            int complement = target - first;

            if (map.containsKey(complement))
            {
                return new int[] {map.get(complement) , i };
            }
            else
               {
                map.put(nums[i], i);
               }
        }
        return new int[] {};
        
    }
}