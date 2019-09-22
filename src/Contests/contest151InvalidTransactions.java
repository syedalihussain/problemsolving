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
    public static List<String> invalidTransactions(String[] transactions) {
        HashMap<String, HashMap<String, List<List<Integer>>>> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        int len = transactions.length;
        String name, city;
        Integer time, money;
        String[] values;
        for (int i = 0; i < len; i++) {
            values = transactions[i].split(",");
            name = values[0]; city = values[3];
            time = Integer.parseInt(values[1]);
            money = Integer.parseInt(values[2]);
            if (money > 1000) {
                set.add(transactions[i]);
            }
            boolean invalid = false;
            if (map.containsKey(name)) {
                HashMap<String, List<List<Integer>>> cityMap = map.get(name);
                for (HashMap.Entry<String, List<List<Integer>>> entry : cityMap.entrySet()) {
                    if (!entry.getKey().equals(city)) {
                        List<List<Integer>> arrayList = entry.getValue();
                        for (int j = 0; j < arrayList.size(); j++) {
                            Integer oldTime = arrayList.get(j).get(0);
                            Integer oldCurrency = arrayList.get(j).get(1);
                            // System.out.println(oldTime + "," + time);
                            // System.out.println(oldCurrency + "," + money);
                            if (Math.abs(oldTime-time) <= 60) {
                                invalid = true;
                                set.add(new String(name+","+oldTime+","+oldCurrency+","+entry.getKey()));
                            }
                        }
                    }
                }
                if (cityMap.containsKey(city)) {
                    List<List<Integer>> list = cityMap.get(city);
                    List<Integer> timeAndCurrency = new ArrayList<>();
                    timeAndCurrency.add(time); timeAndCurrency.add(money);
                    list.add(timeAndCurrency);
                    cityMap.put(city, list);
                    map.put(name, cityMap);
                } else {
                    List<List<Integer>> list = new ArrayList<>();
                    List<Integer> timeAndCurrency = new ArrayList<>();
                    timeAndCurrency.add(time); timeAndCurrency.add(money);
                    list.add(timeAndCurrency);
                    HashMap<String, List<List<Integer>>> newCityMap = new HashMap<>();
                    newCityMap.put(city, list);
                    map.put(name, newCityMap);
                }
            } else {
                List<List<Integer>> list = new ArrayList<>();
                List<Integer> timeAndCurrency = new ArrayList<>();
                timeAndCurrency.add(time); timeAndCurrency.add(money);
                list.add(timeAndCurrency);
                HashMap<String, List<List<Integer>>> cityMap = new HashMap<>();
                cityMap.put(city, list);
                map.put(name, cityMap);
            }


            if (invalid) {
                set.add(transactions[i]);
            }
        }

        return new ArrayList<String>(set);
    }
    public static void main(String[] args) {
        String[] transactions = new String[]{"lee,886,1785,beijing","alex,763,1157,amsterdam","lee,277,129,amsterdam",
                "bob,770,105,amsterdam","lee,603,926,amsterdam","chalicefy,476,50,budapest","lee,924,859,barcelona",
                "alex,302,590,amsterdam","alex,397,1464,barcelona","bob,412,1404,amsterdam","lee,505,849,budapest"};
        List<String> invalids = invalidTransactions(transactions);
        System.out.println(invalids);
    }
}
