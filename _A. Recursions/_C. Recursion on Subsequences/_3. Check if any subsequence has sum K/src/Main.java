public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        // int k = 2; // true
        int k = 5; // false
        System.out.println(check(0, arr, 0, k));
    }

    public static boolean check(int i, int[] arr, int s, int k){
        if(i == arr.length){
            if(s == k){
                return true;
            }
            return false;
        }

        s = s + arr[i];
        if(check(i+1, arr, s, k) == true){
            return true;
        }
        // if left gave true  return true cause 1 true is enough. no need to check further
        // for right


        // if left is giving false check right
        s = s - arr[i];
        if(check(i+1, arr,  s, k) == true){
            return true;
        }

        // if both gave false. now main call will return false
        return false;

    }
}