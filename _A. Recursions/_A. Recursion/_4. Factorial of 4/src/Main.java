public class Main {
    public static void main(String[] args) {
        int n = 4;
        // int prod = 1;
        System.out.println(findFact(n));
    }

    public static int findFact(int n){
        if(n == 1){
            return 1;
        }

        return n * findFact(n - 1);
    }
}