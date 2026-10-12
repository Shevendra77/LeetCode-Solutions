public class Second-Largest2 {
    
}
class Solution {
    public int getSecondLargest(int[] arr) {
        
        int n = arr.length;
        
        int largest = -1;
        int secondLargest = -1;
        
        for(int i = 0; i < n; i++)
        {
            // If a new largest element is found, the previous largest becomes the second largest. 
            
            if(arr[i] > largest)
            {
                secondLargest = largest;
                largest = arr[i];
                
            }
            
            // Otherwise, if an element lies between the largest and second largest, update the second largest.
            
            else if (arr[i] < largest  && arr[i] > secondLargest )
            {
                secondLargest = arr[i];
                
            }
        }
        return secondLargest;
    }
}