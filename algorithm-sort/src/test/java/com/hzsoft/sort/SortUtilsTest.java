package com.hzsoft.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author bill
 * @date 2022/10/1 14:02
 */
public class SortUtilsTest {
    private List<Integer> list = Arrays.asList(57, 28, 87, 15, 98, 24, 176, 32);

    @Test
    public void bubbleSort() {
    }

    @Test
    public void quickSort() {
        System.out.println("待排序数组：" + list);
        SortUtils.quickSort(list, 0, list.size() - 1, Integer::compareTo);
    }

    private void print(List<Integer> list) {
        for (Integer integer : list) {
            System.out.print(integer + ",");
        }
        System.out.println();
    }
}