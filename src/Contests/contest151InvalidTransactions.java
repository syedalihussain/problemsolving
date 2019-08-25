package Contests;

import java.util.*;

public class contest151InvalidTransactions {
    /*
    ["alex,741,1507,barcelona","xnova,683,1149,amsterdam","bob,52,1152,beijing","bob,137,1261,beijing",
    "bob,607,14,amsterdam","bob,307,645,barcelona","bob,220,105,beijing","xnova,914,715,beijing","alex,279,632,beijing"]

    ["chalicefy,639,1283,beijing","maybe,324,192,frankfurt","bob,627,974,amsterdam","alex,962,125,chicago",
    "iris,849,36,beijing","chalicefy,70,415,bangkok","chalicefy,112,467,frankfurt","xnova,358,82,barcelona",
    "chalicefy,180,543,beijing","xnova,624,572,budapest","lee,651,1761,chicago","alex,991,1698,budapest",
    "bob,531,700,amsterdam","chalicefy,926,478,budapest","iris,235,1993,frankfurt","alex,107,812,beijing",
    "maybe,199,1313,barcelona"]
     */
    public static void main(String[] args) {
        List<HashSet<Integer>> rowSets = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        rowSets.add(set);
        HashSet<Integer> newset = rowSets.get(0);
        newset.add(2);
        HashSet<Integer> latest = rowSets.get(0);
        String[] transactions = new String[]{"alice,50,100,beijing", "alice,20,800,mtv"};
        Comparator<String> cmp = new Comparator<String>() {
            public int compare(String o1, String o2) {
                Integer time1 = Integer.valueOf(o1.split(",")[1]);
                Integer time2 = Integer.valueOf(o2.split(",")[1]);
                return time1.compareTo(time2);
            }
        };
        Arrays.sort(transactions, cmp);
    }
}
