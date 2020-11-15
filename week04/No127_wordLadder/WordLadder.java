package com.wsj.algorithm.week4.No127_wordLadder;

import java.util.*;

/**
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 *
 */
public class WordLadder {
    /**
     * 两个定点之间最短路径长度 --> 广度优先遍历
     * 构建图
     */
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }

        // bfs
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> visitedSet = new HashSet<>();
        visitedSet.add(beginWord);

        // beginWord本身算一个边
        int length = 1;
        // 代码模板
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                String currentWord = queue.poll();

                if (visitWord(currentWord, endWord, queue, visitedSet, wordSet)) {
                    return length + 1;
                }
            }

            length++;
        }

        return 0;
    }

    private static boolean visitWord(String currentWord, String endWord, Queue<String> queue, Set<String> visitedWord, Set<String> wordSet) {
        char[] chars = currentWord.toCharArray();

        for (int i = 0; i < currentWord.length(); i++) {
            // 先保存原位置上的字母
            char originChar = chars[i];

            // 在该位置上遍历26个字母替换当前位
            for (char c = 'a'; c < 'z'; c++) {
                if (c == originChar) {
                    continue;
                }
                chars[i] = c;
                String nextWord = String.valueOf(chars);

                // 字典里必须包含替换后这个单词
                if (wordSet.contains(nextWord)) {
                    if (nextWord.equals(endWord)) {
                        return true;
                    }
                    // 如果包含且未被访问
                    if (!visitedWord.contains(nextWord)) {
                        queue.add(nextWord);
                        visitedWord.add(nextWord);
                    }
                }
            }

            chars[i] = originChar;
        }
        return false;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        int length = ladderLength(beginWord, endWord, wordList);
        System.out.println(length);
    }
}
