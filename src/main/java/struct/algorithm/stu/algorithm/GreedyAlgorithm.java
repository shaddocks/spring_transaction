package struct.algorithm.stu.algorithm;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GreedyAlgorithm {
    public static void main(String[] args) {
        Integer[] nums = {1, 3, 0, 2, 5, 6, 3};
        Arrays.sort(nums, (a, b) -> a > b?1:-1);
        for (Integer num: nums) {
            System.out.println(num);
        }
        System.out.println(Integer.valueOf(String.valueOf(12).substring(0, 1)));
    }

    public static void test01(){
        HashMap<String, HashSet<String>> broadCasts = new HashMap<>();
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<>();
        hashSet2.add("成都");
        hashSet2.add("上海");
        hashSet2.add("杭州");

        HashSet<String> hashSet4 = new HashSet<>();
        hashSet2.add("上海");
        hashSet2.add("天津");

        HashSet<String> hashSet5 = new HashSet<>();
        hashSet2.add("大连");
        hashSet2.add("杭州");

        broadCasts.put("k1", hashSet1);
        broadCasts.put("k2", hashSet2);
        broadCasts.put("k3", hashSet3);
        broadCasts.put("k4", hashSet4);
        broadCasts.put("k5", hashSet5);

        HashSet<String> allAreas = new HashSet<>();
        allAreas.add("大连");
        allAreas.add("杭州");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("成都");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("北京");

        ArrayList<String> selects = new ArrayList<>();
        HashSet<String> tempSet = new HashSet<>();
        String maxKey = null;

        while (allAreas.size() != 0) {
            for (String key: broadCasts.keySet()) {
                HashSet<String> ares = broadCasts.get(key);
                tempSet.addAll(ares);
                tempSet.retainAll(allAreas);
                if (tempSet.size() > 0 && (maxKey == null || tempSet.size() > broadCasts.get(maxKey).size())) {
                    maxKey = key;
                }
            }
            if (maxKey != null) {
                selects.add(maxKey);
                allAreas.removeAll(broadCasts.get(maxKey));
            }
            maxKey = null;
            tempSet.clear();
        }
        System.out.println(selects);
    }

    public static void test02(int[] nums) {
        IntStream stream = Arrays.stream(nums);
        Stream<Integer> integerStream = stream.boxed();
        String[] integers = integerStream.toArray(String[]::new);

    }

}
