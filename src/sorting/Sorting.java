package sorting;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class Sorting {

    public void insertSort(int[] nums){
        int n = nums.length;
        for(int i=1; i<n; i++){
            int tmp = nums[i], j = i;
            while(j > 0 && tmp < nums[j-1]){
                nums[j] = nums[j-1];
                j--;
            }
            nums[j] = tmp;
        }
    }

    public void bubbleSort(int[] nums){
        int n = nums.length;
        for(int i=0; i<n-1; i++){
            for(int j=0; j<n-i-1; j++){
                if(nums[j] > nums[j+1]){
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
    }

    public void quickSort(int[] nums, int left, int right){
        int n = nums.length;
        if(left < right){
            int pos = partition(left, right, nums);
            quickSort(nums, left, pos-1);
            quickSort(nums, pos+1, right);
        }
    }

    private int partition(int left, int right, int[] nums){
        int tmp = nums[left];
        while(left < right){
            while(left < right && nums[right] > tmp)
                right--;
            nums[left] = nums[right];
            while(left < right && nums[left] < tmp)
                left++;
            nums[right] = nums[left];
        }
        nums[left] = tmp;
        return left;
    }




}


