package leetcode;

import java.util.*;

public class customerRecord {
    static class buyingRecord{
        int customID;
        char itemId;
        int timeStamp;
        buyingRecord(int customID, char itemId, int timeStamp) {
            this.customID = customID;
            this.itemId = itemId;
            this.timeStamp = timeStamp;
        }
    }

    public static String record(buyingRecord[] arr) {
        if (arr == null || arr.length == 0) {
            return "";
        }
        Arrays.sort(arr, new Comparator<buyingRecord>() {
            @Override
            public int compare(buyingRecord o1, buyingRecord o2) {
                if (o1.customID != o2.customID) {
                    return o1.customID - o2.customID;
                } else {
                    return o1.timeStamp - o2.timeStamp;
                }
            }
        });
        HashMap<Integer, String> map = new HashMap<>();
        for (buyingRecord record : arr) {
            if (!map.containsKey(record.customID)) {
                map.put(record.customID, "");
            }
            String cur = map.get(record.customID) + String.valueOf(record.itemId);
            map.put(record.customID, cur);
        }
//        System.out.println(map);
        HashMap<String, Integer> map2 = new HashMap<>();
        for (Integer num : map.keySet()) {
            String cur = map.get(num);
            for (int i = 0; i < cur.length() - 2; i++) {
                String sub = cur.substring(i, i + 3);
                map2.put(sub, map2.getOrDefault(sub, 0) + 1);
            }
        }
        String res = "";
        int max = Integer.MIN_VALUE;
        for (String str : map2.keySet()) {
            if (map2.get(str) >= max) {
                max = map2.get(str);
                res = str;
            }
        }
        return res;
    }



    public static void main(String[] args) {
        buyingRecord[] arr = new buyingRecord[7];
        arr[1] = new buyingRecord(1,'A', 0);
        arr[5] = new buyingRecord(1, 'B', 2);
        arr[3] = new buyingRecord(1,'C', 4);
        arr[6] = new buyingRecord(1,'D',5);
        arr[4] = new buyingRecord(2,'A', 0);
        arr[2] = new buyingRecord(2, 'B', 2);
        arr[0] = new buyingRecord(2, 'C', 4);
        System.out.println(record(arr));
    }
}