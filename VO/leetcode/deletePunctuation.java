package leetcode;

public class deletePunctuation {
    public static String delete(String s) {
//        s = s.replaceAll("[^a-zA-Z ]","");
        s = s.replaceAll("\\W"," ");
        return s;
    }


    public static void main(String[] args) {
        String s = "I like you, but I like bella more.";
        System.out.println(delete(s));
    }
}
