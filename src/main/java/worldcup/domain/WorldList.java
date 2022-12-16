package worldcup.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class WorldList {

    List<World> worldList;

    public WorldList(List<String> matchList) {
        this.worldList = makeWorldList(matchList);
    }

    private List<World> makeWorldList(List<String> matchList) {
        Set<String> worldSet = makeWorldSet(matchList);
        List<World>worldList = new ArrayList<>();
        for(String world : worldSet){
            worldList.add(new World(world));
        }
        return worldList;
    }

    private Set<String> makeWorldSet(List<String> matchList) {
        Set<String> worldSet = new LinkedHashSet<>();
        for (String match : matchList) {
            String[] worlds = match.split(" ");
            worldSet.add(worlds[1]);
            worldSet.add(worlds[3]);
        }
        return worldSet;
    }

    public String toString() {
        List<String> worlds = new ArrayList<>();
        for (World world : worldList) {
            worlds.add(world.getWorld());
        }
        return String.join(" vs ", worlds);
    }

    public void checkWorldList(String inputWorld) {
        if(!worldList.contains(new World(inputWorld))){
            throw new IllegalArgumentException("[ERROR] 없는 국가입니다.");
        }
    }

    public World get(int number) {
        return worldList.get(number);
    }

    public boolean contains(World world) {
        return worldList.contains(world);
    }
}
