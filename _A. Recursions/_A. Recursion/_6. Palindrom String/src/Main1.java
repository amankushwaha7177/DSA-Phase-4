import java.util.Arrays;

public class Main1 {
    public static void main(String[] args) {
        String s = "naman";
        int l = 0;
        int r = s.length() -1;

        System.out.println(s);

        System.out.println(reverseArr(s, l, r));
    }

    public static boolean reverseArr(String s, int l, int r){
        if(l >= r){
            return true;
        }

        if(s.charAt(l) != s.charAt(r)){
            return false;
        }

        return reverseArr(s,l+1, r-1);

    }
}