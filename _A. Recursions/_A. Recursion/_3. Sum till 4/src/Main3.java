public class Main3 {
    public static void main(String[] args) {
        int n = 4;
        int sum = 0;
        System.out.println(findSum(n));
    }

    public static int findSum(int n){
        if(n == 0){
            return 0;
        }

        return n + findSum(n - 1);
    }
}