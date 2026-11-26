class Solution
{
    public int getSecondLargest(int[] arr) 
    {
        
     int n = arr.length;
     
     int largest = -1;
     int secondLargest = -1;
     
     // find the largest element
     for(int i = 0; i < n; i++)
     {
         
         if(arr[i] > largest)
         {
            
            largest = arr[i];
            
         }
     }
     // find second largest
     
     for(int i = 0; i < n; i++)
     {
         if(arr[i] < largest && arr[i] > secondLargest)
         {
             secondLargest = arr[i];
         }
     }
     
       return secondLargest; 
    }
}