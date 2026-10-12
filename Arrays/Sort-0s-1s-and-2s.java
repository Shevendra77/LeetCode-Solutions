class Solution {
    public void sort012(int[] arr) {
        // code here
        
     int n = arr.length;
     
     int c0 = 0;
     int c1 = 0;
     int c2 = 0;
     
     for(int val : arr)
     {
         if(val == 0)
         {
             c0++;
         }
         else if (val == 1)
         {
             c1++;
         }
         else
         {
             c2++;
         }
     }
     int index = 0;
     
     for(int i = 0; i < c0; i++)
     {
         arr[index++] = 0;
     }
      for(int i = 0; i < c1; i++)
     {
         arr[index++] = 1;
     }
      for(int i = 0; i < c2; i++)
     {
         arr[index++] = 2;
     }
     
    
        
    }
}