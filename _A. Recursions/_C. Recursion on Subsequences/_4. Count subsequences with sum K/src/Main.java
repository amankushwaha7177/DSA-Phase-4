public class Main {
    public static void main(String[] args) {

        // List<Integer> current = new ArrayList<>();
        // List<List<Integer>> result = new ArrayList<>();
        int result = 0;

        int[] arr = {1, 2, 1, 1};
        int k = 2;    // 2
        // int k = 5; // 0

        System.out.println(check(0, arr, result, 0, k));
    }

    public static int check(int i, int[] arr, int result, int s, int k){
        if(i == arr.length){
            if(s == k){
                return 1;
            }
            return 0;
        }

        // current.add(arr[i]);
        s = s + arr[i];
        int l = check(i+1, arr, result, s, k);

        // current.remove(current.size()-1);
        s = s - arr[i];
        int r = check(i+1, arr, result, s, k);

        return l + r;
    }
}