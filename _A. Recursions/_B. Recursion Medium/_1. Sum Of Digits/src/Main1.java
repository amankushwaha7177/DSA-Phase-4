 class Main1 {
    public static void main(String[] args) {
        // code here
        int n = 567;

        int sum = 0;
        System.out.println(sumFun(n, sum));
    }

    static int sumFun(int n, int sum){
        // 567
        if(n == 0){
            return sum;
        }

        int d = n % 10;
        n = n /10;

        sum+= d;

        return sumFun(n, sum);
    }
}

// Given a positive number n. Find the sum of all the digits of n.