package net.vladislemon.aoc2023;

public class Day1Part1 {
    public static void main(String[] args) {
        int sum = Common.lines("/day1/input.txt")
                .mapToInt(line -> {
                    char first = 0, last = 0;
                    for (char c : line.toCharArray()) {
                        if (Character.isDigit(c)) {
                            if (first == 0) {
                                first = c;
                            }
                            last = c;
                        }
                    }
                    return Character.digit(first, 10) * 10 + Character.digit(last, 10);
                })
                .sum();
        System.out.println(sum);
    }
}