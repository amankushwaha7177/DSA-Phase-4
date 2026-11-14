public class Main {
    public static void main(String[] args) {
        int n =4;
        System.out.println(fibonacci(n));
    }

    public static int fibonacci(int n){
        if(n == 1){
            return 1;
        }
        if(n == 0){
            return 0;
        }

        int last = fibonacci(n-1);
        int slast = fibonacci(n-2);

        return last + slast;
    }
}