public class Main {
    public static void main(String[] args) {
        int cnt = 4;
        printName(cnt);
    }

    public static void printName(int cnt){
        if(cnt == 0){
            return;
        }
        System.out.println("Aman");

        cnt--;
        printName(cnt);
    }
}