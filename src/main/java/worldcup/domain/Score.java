package worldcup.domain;

public class Score {

    int score;

    public Score(String score){
        this.score = Integer.parseInt(score);
    }

    public int getScore() {
        return score;
    }
}
