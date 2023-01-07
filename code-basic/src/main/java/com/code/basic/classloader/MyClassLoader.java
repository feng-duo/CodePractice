package com.code.basic.classloader;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author FengDuo
 * @date 2022/12/17 23:36
 */
public class MyClassLoader extends ClassLoader {

    private static final String className = "com.code.basic.classloader.ClassLoaderDemo";

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        if (className.equals(name)) {
            byte[] classData = new byte[0];
            try {
                classData = getClassData(name);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return defineClass(name, classData, 0, classData.length);
        }
        return super.findClass(name);
    }

    private byte[] getClassData(String className) throws IOException {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(MyClassLoader.class.getClassLoader()
                .getResourceAsStream(className.replace(".", "/") + ".class"));
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            int data;
            while ((data = bufferedInputStream.read()) != -1) {
                byteArrayOutputStream.write(data);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
