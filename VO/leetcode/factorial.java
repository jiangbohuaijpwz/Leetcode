package leetcode;

public class factorial {
    public static void main(String[] args) {
        System.out.println(factorialF(5));
    }

    public static int factorialF(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorialF(n - 1);
    }
}
