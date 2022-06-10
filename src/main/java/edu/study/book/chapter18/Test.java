package edu.study.book.chapter18;

import java.util.*;

public class Test {
    public static void main(String[] args) {
    }

    public static String minWindow(String s, String t) {
        int left = 0;
        int count = Integer.MAX_VALUE;
        int resultLeft = 0;

        int[] alphabetList = new int[128]; //只用52个有点繁琐
        for (int i = 0; i < t.length(); ++i) alphabetList[t.charAt(i)]++;
        // if (c >= 65 && c <= 90) alphabetList[c - 65]++;
        // if (c >= 97 && c <= 122) alphabetList[c - 97 + 26]++;

        for (int right = 0; right < s.length(); ++right) {
            alphabetList[s.charAt(right)]--;
            if (isALLNegative(alphabetList)) {
                while (left < right && ++alphabetList[s.charAt(left++)] <= 0) ;
                if (count > right - left + 2) {
                    count = right - left + 2;
                    resultLeft = left - 1;
                }
            }
        }
        return count == Integer.MAX_VALUE? "":s.substring(resultLeft, resultLeft + count);
    }

    public static boolean isALLNegative(int[] alphabetList) {
        for (int i: alphabetList) if (i > 0) return false;
        return true;
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)return -1;
        int low = 0;
        int high = nums.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target)return mid;
            else if (nums[mid] > target) high = mid;
            else low = mid + 1;
        }
        return -1;
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int slowIndex = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); ++i) {
            //if (!map.containsKey(p.charAt(i))) map.put(p.charAt(i), 0);
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }
        for (int i = 0; i < p.length() - 1; ++i) {
            if (map.containsKey(s.charAt(i))) map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
        }

        for (int fastIndex = p.length() - 1; fastIndex < s.length(); ++fastIndex) {
            if (map.containsKey(s.charAt(fastIndex))) map.put(s.charAt(fastIndex), map.get(s.charAt(fastIndex)) - 1);
            if (isZero(map)) list.add(slowIndex);
            if (map.containsKey(s.charAt(slowIndex))) map.put(s.charAt(slowIndex), map.get(s.charAt(slowIndex)) + 1);
            slowIndex++;
        }
        return list;
    }

    public static boolean isZero(Map<Character, Integer> map) {
        int result = 0;
        for (Integer num: map.values()) {
            if (num < 0) return false;
            result += num;
        }
        return result == 0;
    }

    public static String reverseWords(String s) {
        char[] words = s.toCharArray();
        List<Integer> index = new ArrayList<>();
        for (int low = 0, high = words.length - 1; low < high; ++low, --high) {
            if (words[high] == ' ') index.add(low);
            if (words[low] == ' ') index.add(high);
            words[low] ^= words[high];
            words[high] ^= words[low];
            words[low] ^= words[high];
        }
        if (words.length % 2 == 1 && words[words.length / 2] == ' ') index.add(words.length / 2);

        index.sort(Comparator.comparingInt(a -> a));
        int start = 0;
        for (int i = 0; i <= index.size(); ++i) {
            while (start < words.length && words[start] == ' ') ++start;
            int end = i == index.size()? words.length - 1:index.get(i) - 1;
            while (start < end) {
                words[start] ^= words[end];
                words[end] ^= words[start];
                words[start] ^= words[end];
                start++;
                end--;
            }
            start = i == index.size()? words.length - 1:index.get(i);
        }
        return new String(words);
    }
}
