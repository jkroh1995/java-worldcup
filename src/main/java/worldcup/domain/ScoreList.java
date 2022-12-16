package worldcup.domain;

import java.util.ArrayList;
import java.util.List;

public class ScoreList {

    List<Score>scoreList;

    public ScoreList(List<Score>scoreList){
        this.scoreList = scoreList;
    }

    public String toString(){
        List<String>scores = new ArrayList<>();
        for(Score score : scoreList){
            scores.add(String.valueOf(score.getScore()));
        }
        return String.join(" : ", scores);
    }

    public Score get(int i) {
        return scoreList.get(i);
    }
}
