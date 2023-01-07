package com.code.basic.designpattern.decorator;

import org.junit.Test;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author FengDuo
 * @date 2022/11/10 15:17
 */
public class DecoratorTest {

    public static void main(String[] args) {
        // 点一杯咖啡
        Beverage coffee = new Coffee();
        // 加摩卡
        coffee = new MoCha(coffee);
        // 加牛奶
        coffee = new Milk(coffee);
        System.out.println(coffee.getDescription());
        System.out.println(coffee.cost());
    }

    static class DecoratorInputStream extends FilterInputStream {

        /**
         * Creates a <code>FilterInputStream</code>
         * by assigning the  argument <code>in</code>
         * to the field <code>this.in</code> so as
         * to remember it for later use.
         *
         * @param in the underlying input stream, or <code>null</code> if
         *           this instance is to be created without an underlying stream.
         */
        protected DecoratorInputStream(InputStream in) {
            super(in);
        }

        /**
         * 小写输出
         *
         * @return int
         * @throws IOException io异常
         */
        @Override
        public int read() throws IOException {
            int character = super.read();
            return character == -1 ? character : Character.toLowerCase((char) character);
        }
    }

    @Test
    public void decoratorInputStreamTest() {
        try (InputStream resourceAsStream = DecoratorTest.class.getResourceAsStream("/com/code/basic/io/etc/abc.txt");
             DecoratorInputStream decoratorInputStream = new DecoratorInputStream(resourceAsStream)) {
            int a;
            while ((a = decoratorInputStream.read()) != -1) {
                System.out.print((char) a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
