package worldcup.domain;

import java.util.ArrayList;
import java.util.List;

public class MatchResultList {

    List<MatchResult>matchResultList;

    public MatchResultList(List<String> matchResults) {
        matchResultList = makeResultList(matchResults);
    }

    private List<MatchResult> makeResultList(List<String> matchResults) {
        List<MatchResult>resultList = new ArrayList<>();
        for(String match : matchResults){
            resultList.add(new Match(match).getMatchResult());
        }
        return resultList;
    }

    public List<MatchResult> getMatchResultList() {
        return matchResultList;
    }
}
