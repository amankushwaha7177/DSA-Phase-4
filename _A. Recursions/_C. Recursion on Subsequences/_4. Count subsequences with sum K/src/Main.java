public class Main {
    public static void main(String[] args) {

        int[] arr = {1, 2, 1, 1};
        int k = 2;    // 2
        // int k = 5; // 0

        System.out.println(check(0, arr,  k, 0));
    }

    public static int check(int i, int[] arr, int k, int sum){
        if(i == arr.length){
            // all slots complted +
            if(sum == k){
                return 1; // 1 subsequence is formed.
            }
            else{
                return 0; // No Subsequence is formed.
            }
        }

        sum += arr[i];
        int left = check(i+1, arr, k, sum);                    // result of left hand


        sum-= arr[i];
        int right = check(i+1, arr, k, sum);                  // result of right hand


        // Count both left and right subsequence.
        return left + right;

    }
}