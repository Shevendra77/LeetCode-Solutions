class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
      
      int n = arr.length;
      
      int freq [] = new int [n + 1];
      
      int missing = -1;
      int repeating = -1;
      
      // find the frequency of each number
      for(int i = 0 ; i < n; i++)
      {
          freq[arr[i]]++;
      }
      
      // find the missing and repeating number
      for(int i = 1; i <= n; i++)
      {
          if(freq[i] == 2)
          {
              repeating = i;
          }
          if(freq[i] == 0)
          {
              missing = i;
          }
      }
      ArrayList <Integer> res = new ArrayList <>();
      
      res.add(repeating);
      res.add(missing);
      
      return res;
        
    }
}
