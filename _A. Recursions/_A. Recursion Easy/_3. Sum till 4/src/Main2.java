public class Main2 {
    public static void main(String[] args) {
        int cnt = 4;
        int sum = 0;
        System.out.println(findSum(cnt, sum));
    }

    public static int findSum(int cnt, int sum){
        if(cnt == 0){
            return sum;
        }

        sum += cnt;

        return findSum(cnt-1, sum);
    }
}