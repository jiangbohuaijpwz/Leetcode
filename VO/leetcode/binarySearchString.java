package leetcode;

public class binarySearchString {

    public static int search(String[] strs, String target) {
        int start = 0;
        int end = strs.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (strs[mid].equals(target)) {
                return mid;
            } else if (strs[mid].compareTo(target) < 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        String[] strs = new String[]{"abc", "bcd", "bhg", "cjd", "cjde"};
        System.out.print(search(strs, "cjd"));
    }
}
