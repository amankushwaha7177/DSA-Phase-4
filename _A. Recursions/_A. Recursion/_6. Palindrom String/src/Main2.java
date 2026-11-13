public class Main2 {
    public static void main(String[] args) {
        String s = "naman";
        int i = 0;

        System.out.println(s);

        System.out.println(reverseArr(s, i));
    }

    public static boolean reverseArr(String s, int i){
        int n = s.length();
        if(i >= n/2){
            return true;
        }

        if(s.charAt(i) != s.charAt(n - i - 1)){
            return false;
        }

        return reverseArr(s,i + 1);

    }
}