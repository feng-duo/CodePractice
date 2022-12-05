package com.code.basic.io;

import org.junit.Test;

import java.io.*;

/**
 * @author FengDuo
 * @date 2022/11/18 18:09
 */
public class IOTest {

    public static void main(String[] args) {
        InputStream inputStream = IOTest.class.getResourceAsStream("etc/abc.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        LineNumberReader lineNumberReader = new LineNumberReader(bufferedReader);
        try {
            String line;
            while ((line = lineNumberReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test(){
        File file = new File("src/main/java/com/code/basic/io/etc/abc.txt");
        System.out.println("文件是否存在：" + file.exists());
        System.out.println("文件绝对路径：" + file.getAbsolutePath());
        System.out.println("文件是否为文件夹：" + file.isDirectory());
        System.out.println("文件是否为文件：" + file.isFile());
        System.out.println("文件是否为隐藏文件：" + file.isHidden());
        System.out.println("文件是否可读：" + file.canRead());
        System.out.println("文件是否可写：" + file.canWrite());
        System.out.println("文件是否可执行：" + file.canExecute());

        System.out.println("文件路径：" + file.getPath());
        System.out.println("文件名：" + file.getName());
        System.out.println("文件上一级目录：" + file.getParent());

    }

}
