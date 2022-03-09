package com.code.basic.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.util.ListUtils;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 使用EasyExcel完成文件导出
 *
 * @author FengDuo
 * @date 2022/3/9 14:57
 */
public class ExcelExport {

    public static void main(String[] args) {
        String fileName = "dynamicHeadWrite" + System.currentTimeMillis() + ".xlsx";
        EasyExcel.write(fileName)
                // 这里放入动态头
                .head(head()).sheet("模板")
                // 当然这里数据也可以用 List<List<String>> 去传入
                .doWrite(data());
    }

    private static List<List<String>> head() {
        List<List<String>> headList = new ArrayList<>();
        // 第 n 行 的表头
        List<String> headTitle0 = new ArrayList<>();
        List<String> headTitle1 = new ArrayList<>();
        List<String> headTitle2 = new ArrayList<>();
        headTitle0.add("最顶部-1");
        headTitle0.add("标题1");
        headTitle1.add("最顶部-1");
        headTitle1.add("标题2");
        headTitle2.add("最顶部-1");
        headTitle2.add("标题3");

        headList.add(headTitle0);
        headList.add(headTitle1);
        headList.add(headTitle2);
        return headList;


//        List<List<String>> list = new ArrayList<List<String>>();
//        List<String> head0 = new ArrayList<String>();
//        head0.add("字符串" + System.currentTimeMillis());
//        List<String> head1 = new ArrayList<String>();
//        head1.add("数字" + System.currentTimeMillis());
//        List<String> head2 = new ArrayList<String>();
//        head2.add("日期" + System.currentTimeMillis());
//        list.add(head0);
//        list.add(head1);
//        list.add(head2);
//        return list;
    }

    private static List<DemoData> data() {
        List<DemoData> list = ListUtils.newArrayList();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setString("字符串" + i);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }


    @Data
    private static class DemoData {
        @ExcelProperty("字符串标题")
        private String string;
        @ExcelProperty("日期标题")
        private Date date;
        @ExcelProperty("数字标题")
        private Double doubleData;
        /**
         * 忽略这个字段
         */
        @ExcelIgnore
        private String ignore;
    }
}
