package worldcup.domain;

import java.util.Arrays;

public class Match {

    Group group;
    WorldList worldList;
    MatchResult matchResult;

    public Match(String match) {
        String[] matchAnalysis = match.split(" ");
        group = new Group(matchAnalysis[0]);
        worldList = new WorldList(Arrays.asList(match));
        matchResult = new MatchResult(group, worldList,
                new ScoreList(Arrays.asList(new Score(matchAnalysis[4]), new Score(matchAnalysis[6]))));
    }

    public Group getGroup() {
        return group;
    }

    public String getMatch() {
        return matchResult.toString();
    }

    public MatchResult getMatchResult() {
        return matchResult;
    }

    public WorldList getWorldList() {
        return worldList;
    }
}
