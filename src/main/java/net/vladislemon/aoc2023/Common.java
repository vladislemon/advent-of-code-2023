package net.vladislemon.aoc2023;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Common {
    @SuppressWarnings("DataFlowIssue")
    public static Stream<String> lines(String inputFile) {
        try {
            Path path = Paths.get(Common.class.getResource(inputFile).toURI());
            return Files.lines(path);
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
