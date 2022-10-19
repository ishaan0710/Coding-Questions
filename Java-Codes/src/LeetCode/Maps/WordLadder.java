package LeetCode.Maps;

import java.util.*;

/**
 * https://leetcode.com/problems/word-ladder/
 *
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
 *
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * sk == endWord
 * Given two words, beginWord and endWord, and a dictionary wordList,
 * return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 *
 *
 * beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
 */

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(beginWord)) {
            wordList.add(beginWord);
        }
        Map<String, List<String>> adjacentNodesMap = new HashMap<>();
        calculateAdjacentNodes(adjacentNodesMap, wordList);

        Set<String> visitedNodes = new HashSet<>();
        Queue<String> currVisits = new LinkedList<>();
        currVisits.add(beginWord);
        visitedNodes.add(beginWord);
        int dist = 1;
        while (!currVisits.contains(endWord) && !currVisits.isEmpty()) {
            Queue<String> nextVisits = new LinkedList<>();
            for (String words : currVisits) {
                List<String> adjacentNodes = adjacentNodesMap.get(words);
                if (adjacentNodes == null || adjacentNodes.isEmpty()) {
                    continue;
                }
                for (String adjacent : adjacentNodes) {
                    if (!visitedNodes.contains(adjacent)) {
                        visitedNodes.add(adjacent);
                        nextVisits.add(adjacent);
                    }
                }
            }
            dist++;
            currVisits = nextVisits;
        }
        return currVisits.contains(endWord) ? dist : 0;
    }

    private void calculateAdjacentNodes(Map<String, List<String>> adjacentNodesMap, List<String> wordList) {

        for (int i=0; i<wordList.size(); i++) {
            for (int j=i+1; j<wordList.size(); j++) {
                if (differByOne(wordList.get(i), wordList.get(j))) {
                    if (adjacentNodesMap.containsKey(wordList.get(i))) {
                        List<String> adjacentNodes = adjacentNodesMap.get(wordList.get(i));
                        adjacentNodes.add(wordList.get(j));
                    } else {
                        List<String> adjacentNodes = new ArrayList<>();
                        adjacentNodes.add(wordList.get(j));
                        adjacentNodesMap.put(wordList.get(i), adjacentNodes);
                    }

                    if (adjacentNodesMap.containsKey(wordList.get(j))) {
                        List<String> adjacentNodes = adjacentNodesMap.get(wordList.get(j));
                        adjacentNodes.add(wordList.get(i));
                    } else {
                        List<String> adjacentNodes = new ArrayList<>();
                        adjacentNodes.add(wordList.get(i));
                        adjacentNodesMap.put(wordList.get(j), adjacentNodes);
                    }
                }
            }
        }
    }

    private boolean differByOne(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        int diffCount = 0;
        for (int i=0; i<s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffCount++;
            }
        }
        return diffCount == 1;
    }

    public static void main(String[] args) {
        List<String> words = new ArrayList<>(Arrays.asList("hot","dot"));
        WordLadder wordLadder = new WordLadder();
        int x = wordLadder.ladderLength("hot","dog", words);
        System.out.println(x);
    }

}
