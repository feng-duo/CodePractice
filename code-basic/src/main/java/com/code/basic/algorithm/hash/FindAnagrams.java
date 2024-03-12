package com.code.basic.algorithm.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找到字符串中所有字母异位词
 * <p>
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * <p>
 * 示例 1:
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * <p>
 * 示例 2:
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 *
 * @author FengDuo
 * @date 2024/03/08 13:37
 */
public class FindAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<Integer>();
        }
        int[] sArr = new int[26];
        int[] pArr = new int[26];
        for (int i = 0; i < p.length(); i++) {
            sArr[s.charAt(i) - 'a']++;
            pArr[p.charAt(i) - 'a']++;
        }
        ArrayList<Integer> resultList = new ArrayList<>();
        if (Arrays.equals(sArr, pArr)) {
            resultList.add(0);
        }
        for (int i = p.length(); i < s.length(); i++) {
            // 移除最左的元素
            sArr[s.charAt(i - p.length()) - 'a']--;
            // 添加最右的元素
            sArr[s.charAt(i) - 'a']++;
            // 以上两步操作为向右滑动一格窗口
            if (Arrays.equals(sArr, pArr)) {
                resultList.add(i - p.length() + 1);
            }
        }
        return resultList;
    }
}
