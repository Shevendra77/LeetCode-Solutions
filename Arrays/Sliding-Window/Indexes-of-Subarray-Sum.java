import  java.util.*;
class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
       
       int start = 0 , end = 0 , sum = 0;
       
       ArrayList <Integer> list = new ArrayList<>();
       
       for(int i = 0; i <arr.length; i++)
       {
           sum += arr[i];
           
           //sum <= target  .. so Ingore this case and move pointer Ahead
           
           if(sum >= target){
               end = i;
               while(sum > target){
                   sum -= arr[start];
                   start++;
               }
           }
           if(sum == target)
          {
           list.add(start+1);
           list.add(end+1);
           return list;
          }
       }
        list.add(-1);
        return  list;
        
    }
}
