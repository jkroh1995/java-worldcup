package worldcup.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WorldResultList {

    List<WorldResult>worldResultList = new ArrayList<>();

    public WorldResultList(MatchResultList matchResultList){
        makeWorldResultList(matchResultList);
    }

    private void makeWorldResultList(MatchResultList matchResultList) {
        Set<WorldResult> worldResultSet = new HashSet<>();
        for(MatchResult matchResult : matchResultList.getMatchResultList()){
            if(worldResultList.size()==0){
                worldResultSet.add(new WorldResult(matchResult.getGroup(), matchResult.getWorldList().get(0)));
                worldResultSet.add(new WorldResult(matchResult.getGroup(), matchResult.getWorldList().get(1)));
                this.worldResultList = new ArrayList<>(worldResultSet);
            }
            for(int i=0;i< worldResultList.size();i++){
                WorldResult worldResult = worldResultList.get(i);
                if(matchResult.getWorldList().contains(worldResult.getWorld())){
                    worldResult.calculate(matchResult);
                    worldResultSet.add(worldResult);
                    continue;
                }
                worldResultSet.add(new WorldResult(matchResult.getGroup(), matchResult.getWorldList().get(0)));
                worldResultSet.add(new WorldResult(matchResult.getGroup(), matchResult.getWorldList().get(1)));
                this.worldResultList = new ArrayList<>(worldResultSet);
            }
        }
    }

    public WorldResult get(World world) {
        for(WorldResult worldResult : worldResultList){
            if(worldResult.getWorld().equals(world)){
                return worldResult;
            }
        }
        return null;
    }

    public List<WorldResult> getWordResultList() {
        return worldResultList;
    }
}
