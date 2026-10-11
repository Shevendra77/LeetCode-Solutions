public class Missing {
public static void main(String[] args) {


    int  [] arr = {1, 2, 3, 5};

    int n = arr.length + 1;
     
    int expectedSum = n * (n + 1) / 2;

    int actualSum = 0;

    for(int val : arr)
    {
        actualSum += val;
    }

    int missing = expectedSum - actualSum; 

    System.out.println(" Missing number is : " + missing);
}
    
}
