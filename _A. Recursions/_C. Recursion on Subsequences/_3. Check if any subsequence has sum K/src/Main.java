public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        int k = 2;    // true
        // int k = 5; // false
        System.out.println(check(0, arr,  k, 0));
    }

    public static boolean check(int i, int[] arr, int k, int sum){
        if(i == arr.length){
            // all slots complted +
            if(sum == k){
                return true;
            }
            else{
                return false;
            }
        }

        sum += arr[i];
        boolean left = check(i+1, arr, k, sum);                    // result of left hand
        if(left == true){
            // we got our ans no need to check right :
            return true;
        }


        sum-= arr[i];
        boolean right = check(i+1, arr, k, sum);                  // result of right hand
        if(right == true){
            return true;
        }

        // Coming here means both sides are not correct
        return false;

    }
}