package edu.sdsu.cs160l.algorithm.sort;

import java.util.Comparator;

/**
 * TODO assignment (4 points)
 *  implement mergesort in a similar way as quick sort and bubble sort structurally
 *
 *  hint to create a generic array use T[] t = (T[])(new Object[])
 */
public class MergeSort implements Sorter {
    @Override
    @SuppressWarnings("unchecked")
    public <T> void sort(T[] c) {
        Comparable[] comparable = (Comparable[]) c;
        sort(comparable, Comparator.naturalOrder());
    }

    @Override
    public <T> void sort(T[] c, Comparator<? super T> comparisonStrategy) {
        if (c == null || c.length == 0) {
            return;
        }
        T[] temp = (T[]) (new Object[c.length]);
        mergeSort(c, temp, 0, c.length - 1, comparisonStrategy);
    }

    private <T> void mergeSort(T[] arr, T[] temp, int left, int right, Comparator<? super T> comparisonStrategy) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, temp, left, mid, comparisonStrategy);
            mergeSort(arr, temp, mid + 1, right, comparisonStrategy);
            merge(arr, temp, left, mid, right, comparisonStrategy);
        }
    }

    private <T> void merge(T[] arr, T[] temp, int left, int mid, int right, Comparator<? super T> comparisonStrategy) {
        System.arraycopy(arr, left, temp, left, right - left + 1);

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (comparisonStrategy.compare(temp[i], temp[j]) <= 0) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }

        while (i <= mid) {
            arr[k++] = temp[i++];
        }

        while (j <= right) {
            arr[k++] = temp[j++];
        }
    }
}
