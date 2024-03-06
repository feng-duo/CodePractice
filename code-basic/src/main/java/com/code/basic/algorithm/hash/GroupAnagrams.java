package com.code.basic.algorithm.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 字母异位词分组
 *
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 * 示例 1:
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 *
 * @author FengDuo
 * @date 2024/03/01 18:45
 */
public class GroupAnagrams {

        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                char[] charArray = str.toCharArray();
                Arrays.sort(charArray);
                String strKey = Arrays.toString(charArray);
                List<String> list = map.getOrDefault(strKey, new ArrayList<>());
                list.add(str);
                map.put(strKey, list);
            }
            return new ArrayList<>(map.values());
        }
}
