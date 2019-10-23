package sorting;

import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;

public class DataGenerator {
    public static void main(String args[]) {
        try {
            /* 写入Txt文件 */
            Random random = new Random();
            File writename = new File("output.txt"); // 相对路径，如果没有则要建立一个新的output。txt文件
            writename.createNewFile(); // 创建新文件
            BufferedWriter out = new BufferedWriter(new FileWriter(writename));
            for (int i = 0; i < 150000; i++) {
                out.write(String.valueOf((int)(random.nextGaussian() * Math.sqrt(10000))));
                out.write("\r\n"); // \r\n即为换行
            }
            out.flush(); // 把缓存区内容压入文件
            out.close(); // 最后记得关闭文件

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}