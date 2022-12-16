package worldcup.domain;

public class MatchResult {

    Group group;
    WorldList worldList;
    ScoreList scoreList;

    public MatchResult(Group group, WorldList worldList, ScoreList scoreList) {
        this.group = group;
        this.worldList = worldList;
        this.scoreList = scoreList;
    }

    public String toString() {
        return worldList.toString()
                + " "
                + scoreList.toString();
    }

    public WorldList getWorldList() {
        return worldList;
    }

    public ScoreList getScoreList() {
        return scoreList;
    }

    public Group getGroup() {
        return group;
    }
}
