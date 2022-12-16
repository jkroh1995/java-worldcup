package worldcup.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GroupRankMap {

    Map<Group, WorldList> groupRankMap = new LinkedHashMap();

    public GroupRankMap(GroupList groupList, WorldResultList worldResultList) {
        makeGroupRankList(groupList, worldResultList);
    }

    private void makeGroupRankList(GroupList groupList, WorldResultList worldResultList) {
        for (Group group : groupList.getGroupList()) {
            Map<World, Integer> worldWinPoint = new HashMap<>();
            Map<World, Integer> worldGoal = new HashMap<>();
            Map<World, Integer> worldGoalDifference = new HashMap<>();
            List<World> worlds = new ArrayList<>();
            for (WorldResult worldResult : worldResultList.getWordResultList()) {
                if (worldResult.getGroup().equals(group)) {
                    worldWinPoint.put(worldResult.getWorld(), worldResult.getWinPoint());
                    worldGoal.put(worldResult.getWorld(), worldResult.getGoal());
                    worldGoalDifference.put(worldResult.getWorld(), worldResult.getGoalDifference());
                    worlds.add(worldResult.getWorld());
                }
            }
            List<String> worldsNames = getNamesList(worldWinPoint, worldGoalDifference, worldGoal, worlds);
            groupRankMap.put(group, new WorldList(worldsNames));
        }
    }

    private List<String> getNamesList(Map<World, Integer> worldWinPoint,
                                      Map<World, Integer> worldGoalDifference,
                                      Map<World, Integer> worldGoal, List<World> worlds) {
        List<String> names = new ArrayList<>();
        List<World>tmpWorlds = new ArrayList<>();
        for(World world : worlds){
            if(tmpWorlds.size()==0){
                tmpWorlds.add(world);
            }
            for(int i=0;i<tmpWorlds.size();i++){
                if(worldWinPoint.get(world)>worldWinPoint.get(tmpWorlds.get(i))){
                    tmpWorlds.add(i, world);
                }
                if(i==tmpWorlds.size()-1&&worldWinPoint.get(world)<worldWinPoint.get(tmpWorlds.get(i))){
                    tmpWorlds.add(world);
                }
                if(worldWinPoint.get(world)==worldWinPoint.get(tmpWorlds.get(i))){
                    if(worldGoalDifference.get(world)>worldGoalDifference.get(tmpWorlds.get(i))){
                        tmpWorlds.add(i, world);
                    }
                    if(worldGoalDifference.get(world)<worldGoalDifference.get(tmpWorlds.get(i))){
                        tmpWorlds.add(i+1, world);
                    }
                    if(worldGoalDifference.get(world)==worldGoalDifference.get(tmpWorlds.get(i))){
                        if(worldGoal.get(world)>worldGoal.get(tmpWorlds.get(i))){
                            tmpWorlds.add(i, world);
                        }
                        tmpWorlds.add(world);
                    }
                }
            }
        }
        for(World tmpWorld : tmpWorlds){
            names.add(tmpWorld.getWorld());
        }
        return names;
    }
}
