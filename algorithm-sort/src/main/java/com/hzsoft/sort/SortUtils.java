package com.hzsoft.sort;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * 排序工具类
 *
 * @author bill
 * @date 2022/10/1 12:01
 */
public class SortUtils {
    /**
     * 冒泡排序，时间复杂度：O(n²)
     *
     * @param list       集合
     * @param comparator 比较器
     */
    public static <T> void bubbleSort(List<T> list, Comparator<T> comparator) {
        if (Objects.isNull(list) || list.isEmpty()) {
            return;
        }

        int len = list.size();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (comparator.compare(list.get(j), list.get(j + 1)) > 0) {
                    swap(list, j, j + 1);
                }
            }
        }
    }

    private static <T> void swap(List<T> list, int index1, int index2) {
        T tmp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, tmp);
    }

    public static <T> void quickSort(List<T> list, int beginIndex, int endIndex, Comparator<T> comparator) {
        if (Objects.isNull(list) || list.isEmpty()) {
            return;
        }

        if (beginIndex >= endIndex) {
            return;
        }

        int finalBeginIndex = beginIndex;
        int finalEndIndex = endIndex;
        int indexIndex = beginIndex;
        T flagVal = list.get(indexIndex);
        int compareIndex = endIndex;
        boolean end = true;

        while (beginIndex < endIndex) {
            T flagIndex = list.get(compareIndex);

            if ((end && comparator.compare(flagVal, flagIndex) > 0) ||
                    (!end && comparator.compare(flagVal, flagIndex) < 0)) {
                list.set(indexIndex, flagIndex);
                indexIndex = compareIndex;
                end = !end;
            }

            if (end) {
                endIndex--;
                compareIndex = endIndex;
            } else {
                beginIndex++;
                compareIndex = beginIndex;
            }
        }
        list.set(indexIndex, flagVal);


        System.out.print(String.format("beginIndex = %s, endIndex = %s, ", finalBeginIndex, finalEndIndex));
        System.out.println(list);

        quickSort(list, finalBeginIndex, indexIndex - 1, comparator);
        quickSort(list, indexIndex + 1, finalEndIndex, comparator);

    }
}
