package com.code.basic.io;

import java.io.*;

/**
 * @author FengDuo
 * @date 2022/11/18 18:09
 */
public class IOTest {

    public static void main(String[] args) {
        InputStream inputStream = IOTest.class.getResourceAsStream("/com/code/basic/io/etc/abc.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        LineNumberReader lineNumberReader = new LineNumberReader(bufferedReader);
        try {
            while (lineNumberReader.read() > 0) {
                System.out.println(lineNumberReader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
