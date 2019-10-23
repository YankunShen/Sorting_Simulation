package sorting;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public  static int[]  readFromCSV(String filepath) throws FileNotFoundException {
        List<Integer> nums = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filepath))){
            String line;
            while((line = br.readLine()) != null){
                nums.add(Integer.parseInt(line));
            }
            int[] l = new int[nums.size()];
            for(int i=0; i<nums.size(); i++){
                l[i] = nums.get(i);
            }
            return l;
        } catch (IOException e) {
            e.printStackTrace();
        }
        int[] a = new int[1];
        return a;
    }
    public static void main(String[] args) throws FileNotFoundException {

        String filepath = "Beijing_PM2.5_data_2010.1.1-2014.12.31.csv";
        Sorting sorting = new Sorting();
        int[] nums = readFromCSV(filepath);
        sorting.insertSort(nums);
        
        System.out.println(Arrays.toString(nums));
    }
}
