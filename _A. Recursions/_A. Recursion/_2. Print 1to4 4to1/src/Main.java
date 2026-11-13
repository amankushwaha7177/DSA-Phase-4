public class Main {
    public static void main(String[] args) {
        int cnt = 1;
        printName(cnt);
    }

    public static void printName(int cnt){
        if(cnt == 5){
            return;
        }
        System.out.println(cnt);


        printName(cnt+1);


        System.out.println(cnt);
    }
}