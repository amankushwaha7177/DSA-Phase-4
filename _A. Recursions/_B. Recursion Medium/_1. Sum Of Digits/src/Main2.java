 class Main2 {
    public static void main(String[] args) {
        // code here
        int n = 567;

        // int sum = 0; // no need to pass result in params now use Functional Recursion to calculate result using calls.
        System.out.println(sumFun(n));
    }

     static int sumFun(int n){
         // 567
         if(n == 0){
             return 0;
         }


         int d = n % 10;
         n = n /10;


         return d + sumFun(n);
    }
}