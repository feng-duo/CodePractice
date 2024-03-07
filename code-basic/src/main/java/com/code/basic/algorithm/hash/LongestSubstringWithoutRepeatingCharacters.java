package com.code.basic.algorithm.hash;

import java.util.HashMap;

/**
 * 无重复字符的最长子串（滑动窗口）
 * <p>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
 * <p>
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * @author FengDuo
 * @date 2024/03/07 10:38
 */
public class LongestSubstringWithoutRepeatingCharacters {


    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty() || s.length() == 1) {
            return s.length();
        }
        HashMap<Character, Integer> map = new HashMap<>();
        char[] charArray = s.toCharArray();
        int maxLength = 0, temp = 0;
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            Integer existIndex = map.get(c);
            if (null != existIndex) {
                // 滑动窗口至下一个位置，确保子串无重复字符
                temp = Math.max(existIndex + 1, temp);
            }
            maxLength = Math.max(maxLength, i - temp + 1);
            // 记录字符最新的位置下标
            map.put(c, i);
        }
        return maxLength;

    }
}
