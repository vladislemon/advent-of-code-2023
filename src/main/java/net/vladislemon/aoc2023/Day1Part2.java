package net.vladislemon.aoc2023;

import java.util.Arrays;

public class Day1Part2 {
    public static void main(String[] args) {
        char[][] words = {
                "one".toCharArray(),
                "two".toCharArray(),
                "three".toCharArray(),
                "four".toCharArray(),
                "five".toCharArray(),
                "six".toCharArray(),
                "seven".toCharArray(),
                "eight".toCharArray(),
                "nine".toCharArray(),
        };
        int[] match = new int[words.length];
        int sum = Common.lines("/day1/input.txt")
                .mapToInt(line -> {
                    int first = 0, last = 0;
                    char[] chars = line.toCharArray();
                    for (int i = 0; i < chars.length; i++) {
                        int digit = 0;
                        if (Character.isDigit(chars[i])) {
                            digit = Character.digit(chars[i], 10);
                        } else {
                            Arrays.fill(match, 0);
                            searchword:
                            for (int j = i; j < chars.length; j++) {
                                int matches = 0;
                                for (int word = 0; word < words.length; word++) {
                                    if (words[word].length > j - i && chars[j] == words[word][j - i]) {
                                        matches++;
                                        match[word]++;
                                        if (match[word] == words[word].length) {
                                            digit = word + 1;
                                            break searchword;
                                        }
                                    }
                                }
                                if (matches == 0) {
                                    break;
                                }
                            }
                            if (digit == 0) {
                                continue;
                            }
                        }
                        if (first == 0) {
                            first = digit;
                        }
                        last = digit;
                    }
                    return first * 10 + last;
                })
                .sum();
        System.out.println(sum);
    }
}
