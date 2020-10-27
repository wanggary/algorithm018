package com.wsj.algorithm.week2.HashMap.No242_validAnagram;

import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 */
public class ValidAnagram {

    /**
     * 构建Hash表方法
     * s和t都只包含a-z字母，所以只需要定义一个26位大小的数组
     * 遍历字符串s中的字符，当前位的字符出现一次，arr中对应位置数值++
     * t中字符出现一次，arr中对应位置数值--
     * 如果最后arr中所有位都是0，则s和t中的字母相同
     */
    public boolean validAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }

        for (int i : arr) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * 可先将s中出现的字母统计好
     */
    public boolean validAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;

        }

        for (int j = 0; j < t.length(); j++) {
            arr[t.charAt(j) - 'a']--;

            if (arr[t.charAt(j) - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * 通过对字符串中字符排序判断字符串是否相等
     */
    public boolean validAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] charss = s.toCharArray();
        char[] charst = t.toCharArray();
        Arrays.sort(charss);
        Arrays.sort(charst);

        return Arrays.equals(charss, charst);
    }
}
