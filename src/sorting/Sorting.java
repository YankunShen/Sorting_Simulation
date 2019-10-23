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
        for (int i = 0; i < n-1; i++) 
        { 
            int min_idx = i; 
            for (int j = i+1; j < n; j++) 
                if (nums[j] < nums[min_idx]) 
                    min_idx = j; 
            int temp = nums[min_idx]; 
            nums[min_idx] = nums[i]; 
            nums[i] = temp; 
        }
    }

    public void mergeSort(int[] nums) {
        mergeSortHelper(nums, 0, nums.length - 1);
    }

    void merge(int arr[], int l, int m, int r) 
    { 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
  
        int i = 0, j = 0; 
  
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
  
    void mergeSortHelper(int arr[], int l, int r) 
    { 
        if (l < r) 
        { 
            int m = (l+r)/2; 
            mergeSortHelper(arr, l, m); 
            mergeSortHelper(arr , m+1, r); 
            merge(arr, l, m, r); 
        } 
    } 
}
