class Solution {
    public String[] reorderLogFiles(String[] logs) {
        if (logs == null || logs.length == 0) {
            return null;
        }
        Arrays.sort(logs, new Comparator<String>(){
            public int compare(String a, String b) {
                String[] strA = a.split(" ", 2);
                String[] strB = b.split(" ", 2);
                boolean isDigitA = Character.isDigit(strA[1].charAt(0));
                boolean isDigitB = Character.isDigit(strB[1].charAt(0));
                if (!isDigitA && !isDigitB) {
                    int cmp = strA[1].compareTo(strB[1]);
                    if (cmp != 0) {
                        return cmp;
                    } else {
                        return strA[0].compareTo(strB[0]);
                    }
                }
                return isDigitA ? (isDigitB ? 0 : 1) : -1;
            }
        });
        return logs;
    }
}