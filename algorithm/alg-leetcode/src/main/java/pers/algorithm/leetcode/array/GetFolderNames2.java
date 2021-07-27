package pers.algorithm.leetcode.array;

import java.util.HashMap;
import java.util.Map;

class GetFolderNames2 extends GetFolderNames {

    public String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>();
        String[] ans = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            if (!map.containsKey(names[i])) {
                ans[i] = names[i];
                map.put(names[i], 0);
            } else {
                int k = map.get(names[i]) + 1;
                while (map.containsKey(names[i] + "(" + k + ")")) {
                    k++;
                }
                map.put(names[i], k);
                map.put(names[i] + "(" + k + ")", 0);
                ans[i] = names[i] + "(" + k + ")";
            }
        }
        return ans;
    }
}
