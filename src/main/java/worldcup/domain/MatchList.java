package worldcup.domain;

import java.util.ArrayList;
import java.util.List;

public class MatchList {

    List<Match> matchList;

    public MatchList(List<String>matchList){
        this.matchList = makeMatchList(matchList);
    }

    private List<Match> makeMatchList(List<String> matchList) {
        List<Match>matches = new ArrayList<>();
        for(String match : matchList){
            matches.add(new Match(match));
        }
        return matches;
    }

    public List<Match> getMatchList() {
        return matchList;
    }
}
