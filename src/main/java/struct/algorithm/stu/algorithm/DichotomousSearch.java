package struct.algorithm.stu.algorithm;

public class DichotomousSearch {
    public static <T extends Comparable<T>> int BinarySearch(T[] numbers, T key) {//二分查找
        int low = 0;
        int high = numbers.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (numbers[mid].equals(key))return mid;
            else if (numbers[mid].compareTo(key) == 1)high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }


}
