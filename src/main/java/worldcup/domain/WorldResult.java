package worldcup.domain;

public class WorldResult {

    Group group;
    World world;
    int win = 0;
    int draw = 0;
    int lose = 0;
    int winPoint = 0;
    int goalDifference = 0;
    int goal = 0;

    public WorldResult(Group group, World world) {
        this.group = group;
        this.world = world;
    }

    public void calculate(MatchResult matchResult) {
        WorldList worldList = matchResult.getWorldList();
        ScoreList scoreList = matchResult.getScoreList();
        if (worldList.get(0).equals(world)) {
             Score makeScore = scoreList.get(0);
             Score loseScore = scoreList.get(1);
             goal+= makeScore.getScore();
             goalDifference+= makeScore.getScore()-loseScore.getScore();
             if(makeScore.getScore()>loseScore.getScore()){
                 win++;
                 winPoint+=3;
                 return;
             }
             if(makeScore.getScore()<loseScore.getScore()){
                 lose++;
                 return;
             }
             draw++;
             winPoint++;
             return;
        }
        Score makeScore = scoreList.get(1);
        Score loseScore = scoreList.get(0);
        goal+= makeScore.getScore();
        goalDifference+= makeScore.getScore()-loseScore.getScore();
        if(makeScore.getScore()>loseScore.getScore()){
            win++;
            winPoint+=3;
            return;
        }
        if(makeScore.getScore()<loseScore.getScore()){
            lose++;
            return;
        }
        draw++;
        winPoint++;
    }

    @Override
    public boolean equals(Object obj) {
        WorldResult worldResult = (WorldResult) obj;
        return this.world.equals(worldResult.world);
    }

    @Override
    public int hashCode() {
        if (world == null) {
            return 0;
        }
        return world.hashCode();
    }

    public World getWorld() {
        return world;
    }

    public String toString(){
        return world.getWorld() + "\n"
                +"승 : " + win
                +" 무 : " + draw
                +" 패 : " + lose
                +" 승점 : " + winPoint
                +" 골득실 : " + goalDifference
                +" 득점 : " + goal;
    }

    public Group getGroup() {
        return group;
    }

    public Integer getWinPoint() {
        return winPoint;
    }

    public Integer getGoal() {
        return goal;
    }

    public Integer getGoalDifference() {
        return goalDifference;
    }
}
