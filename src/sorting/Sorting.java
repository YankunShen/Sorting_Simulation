package sorting;

public class Sorting {

    public void insertSort(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int tmp = nums[i], j = i;
            while (j > 0 && tmp < nums[j - 1]) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = tmp;
        }
    }

    public void bubbleSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
    }

    public void quickSort(int[] nums) {
        quickSortHelper(nums, 0, nums.length - 1);
    }

    public void quickSortHelper(int[] nums, int left, int right) {
        if (left < right) {
            int pos = partition(left, right, nums);
            quickSortHelper(nums, left, pos - 1);
            quickSortHelper(nums, pos + 1, right);
        }
    }

    private int partition(int left, int right, int[] nums) {
        int tmp = nums[left];
        while (left < right) {
            while (left < right && nums[right] > tmp)
                right--;
            nums[left] = nums[right];
            while (left < right && nums[left] <= tmp)
                left++;
            nums[right] = nums[left];
        }
        nums[left] = tmp;
        return left;
    }

    public void selectionSort(int[] nums) {

        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int idx = i;
            for (int j = i + 1; j < n; j++)
                if (nums[j] < nums[idx])
                    idx = j;
            int temp = nums[idx];
            nums[idx] = nums[i];
            nums[i] = temp;
        }
    }

    public void mergeSort(int[] nums) {
        mergeSortHelper(nums, 0, nums.length - 1);
    }

    private void merge(int arr[], int l, int m, int r) {
        int len1 = m - l + 1;
        int len2 = r - m;

        int left[] = new int[len1];
        int right[] = new int[len2];

        for (int i = 0; i < len1; ++i)
            left[i] = arr[l + i];
        for (int j = 0; j < len2; ++j)
            right[j] = arr[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        while (i < len1 && j < len2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < len1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < len2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    private void mergeSortHelper(int arr[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSortHelper(arr, l, m);
            mergeSortHelper(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }
}
