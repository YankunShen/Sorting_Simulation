package sorting;

import sorting.LineCharts;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Test {

    public static int[] readFromCSV(String filepath, double percentage) throws FileNotFoundException {

        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line = br.readLine();
            int length = (int) (Integer.parseInt(line) * percentage);
            int[] nums = new int[length];
            for (int i = 0; i < length; i++) {
                if ((line = br.readLine()) != null)
                    nums[i] = Integer.parseInt(line);
            }
            return nums;
        } catch (IOException e) {
            e.printStackTrace();
        }
        int[] a = new int[1];
        return a;
    }

    public static long calculateInversion(int[] array) {
        long counter = 0;
        for (int i = 0; i < array.length - 1; ++i) {
            for (int j = i + 1; j < array.length; ++j) {
                if (array[i] > array[j]) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public static void executeSorting(int[] nums, int methodIndex) {

        Sorting sorting = new Sorting();
        switch (methodIndex) {
        case 0:
            sorting.insertSort(nums);
            break;
        case 1:
            sorting.selectionSort(nums);
            break;
        case 2:
            sorting.bubbleSort(nums);
            break;
        case 3:
            sorting.mergeSort(nums);
            break;
        case 4:
            sorting.quickSort(nums);
            break;
        }
    }

    public static void helper(String filepath) throws IOException {
        int numx = 5;

        long[][][] methodData = new long[5][4][numx];

        for (int methodIndex = 0; methodIndex < 5; methodIndex++) {
            long[] sizeArray = new long[numx];
            long[] sortednessArray = new long[numx];
            long[] runtimeArray = new long[numx];
            long[] memoryArray = new long[numx];
            for (int i = 0; i < numx; i++) {
                long startMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
                int[] nums = readFromCSV(filepath, 1 / (double) numx * (i + 1));
                if (methodIndex == 0) {
                    sortednessArray[i] = calculateInversion(nums);
                    sizeArray[i] = nums.length;
                } else {
                    sizeArray = methodData[0][0];
                    sortednessArray = methodData[0][1];
                }
                long startTime = System.nanoTime();
                executeSorting(nums, methodIndex);
                long endTime = System.nanoTime();
                long endMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

                runtimeArray[i] = endTime - startTime;
                memoryArray[i] = endMemory - startMemory;
            }
            methodData[methodIndex][0] = sizeArray;
            methodData[methodIndex][1] = sortednessArray;
            methodData[methodIndex][2] = runtimeArray;
            methodData[methodIndex][3] = memoryArray;

            System.out.println(methodIndex);
            System.out.println(Arrays.toString(sizeArray));
            System.out.println(Arrays.toString(sortednessArray));
            System.out.println(Arrays.toString(runtimeArray));
            System.out.println(Arrays.toString(memoryArray));
        }
        System.out.println(Arrays.toString(methodData));

        long[][] datagroups = new long[6][numx];
        datagroups[0] = methodData[0][0];
        for (int i = 1; i < 6; i++) {
            datagroups[i] = methodData[i-1][2];
        }
        LineCharts.run("data size", "runtime", "datasize-runtime-age", datagroups);
        for (int i = 1; i < 6; i++) {
            datagroups[i] = methodData[i-1][3];
        }
        LineCharts.run("data size", "memory usage", "datasize-memusage-age", datagroups);
        datagroups[0] = methodData[0][1];
        for (int i = 1; i < 6; i++) {
            datagroups[i] = methodData[i-1][2];
        }
        LineCharts.run("sortedness", "runtime", "sortedness-runtime-age", datagroups);
        for (int i = 1; i < 6; i++) {
            datagroups[i] = methodData[i-1][3];
        }
        LineCharts.run("sortedness", "memory usage", "sortedness-memusage-age", datagroups);

    }

    public static void main(String[] args) throws IOException {

        String filepath = "data/census_income_age.csv";
        helper(filepath);
    }
}
