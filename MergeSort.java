package services;

public class MergeSort {

    public static void merge(int[] notes, int left, int right, int mid) {
        int len1 = mid - left + 1;
        int len2 = right - mid;

        int i, j, k;
        int[] leftArr  = new int[len1];
        int[] rightArr = new int[len2];

        for (i = 0; i < len1; i++)
            leftArr[i] = notes[left + i];

        for (j = 0; j < len2; j++)
            rightArr[j] = notes[mid + 1 + j];

        i = 0; j = 0; k = left;

        while (i < len1 && j < len2) {
            if (leftArr[i] > rightArr[j]) {
                notes[k] = leftArr[i];
                i++;
            }
            else {
                notes[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < len1) {
            notes[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < len2) {
            notes[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void mergesort(int[] notes, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;

        mergesort(notes, left, mid);
        mergesort(notes, mid+1, right);

        merge(notes, left, right, mid);
    }

    public static void sort(int[] notes) {
        mergesort(notes, 0 , notes.length-1);
    }

}
