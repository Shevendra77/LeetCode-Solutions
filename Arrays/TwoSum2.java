import java.util.HashMap;

public class TwoSum2 {
    public static void main(String[] args) {
        
        int [] arr = {2, 7, 11, 15};
        int target = 9;

        HashMap <Integer ,Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++)
        {
            int complement = target - arr[i];

            if (map.containsKey(complement)) {
                    System.out.println("Indeces :" + map.get(complement) + " " + i);
                    return ;
            }
            else{
                map.put(arr[i] , i);
            }
            System.out.println("No solution found");
        }

        
    }
}
