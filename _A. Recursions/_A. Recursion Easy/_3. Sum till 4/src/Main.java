public class Main {
    public static void main(String[] args) {
        int cnt = 1;
        int sum = 0;
        System.out.println(findSum(cnt, sum));
    }

    public static int findSum(int cnt, int sum){
        if(cnt == 5){
            return sum;
        }

        sum += cnt;

        return findSum(cnt+1, sum);
    }
}