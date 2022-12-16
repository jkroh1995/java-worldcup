package worldcup.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ResourceReader {

    public List<String> getMatchResults() {
        try {
            return Files.readAllLines(Paths.get("./src/main/resources/MatchResult.txt"));
        } catch (IOException e) {
            return null;
        }
    }
}
