public class Main {
    public static void main(String[] args) {
        // code here
        StringBuilder s = new StringBuilder("banana");
        System.out.println(s);

        char c = 'a';
        int i = 0;
        clean(s, c, i);

        System.out.println(s);
    }

    public static void clean(StringBuilder s, char c, int i){
        if(i >= s.length()){
            return;
        }

        if(s.charAt(i) == c){
            s.deleteCharAt(i);
        }
        else{
            i++;
        }

        clean(s, c, i);
    }
}