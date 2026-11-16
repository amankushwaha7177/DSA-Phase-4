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

        s = s - arr[i];
        if(check(i+1, arr,  s, k) == true){
            return true;
        }
        else{
            return false;
        }

    }
}