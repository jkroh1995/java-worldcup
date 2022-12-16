package worldcup.controller.domain;

import java.util.List;
import worldcup.domain.GroupList;
import worldcup.domain.GroupRankMap;
import worldcup.domain.MatchList;
import worldcup.domain.MatchResultList;
import worldcup.domain.World;
import worldcup.domain.WorldList;
import worldcup.domain.WorldResult;
import worldcup.domain.WorldResultList;
import worldcup.util.ResourceReader;

public class MatchController {

    List<String> allMatchResults = new ResourceReader().getMatchResults();
    GroupList groupList = new GroupList();
    WorldList worldList = new WorldList(allMatchResults);
    MatchList matchList = new MatchList(allMatchResults);
    MatchResultList matchResultList = new MatchResultList(allMatchResults);
    WorldResultList worldResultList = new WorldResultList(matchResultList);
    GroupRankMap groupRankList = new GroupRankMap(groupList, worldResultList);

    public MatchList getAllMatches() {
        return matchList;
    }

    public GroupList getGroupList() {
        return groupList;
    }

    public WorldList getWorldList() {
        return worldList;
    }

    public WorldResult getWorldResult(World world) {
        return worldResultList.get(world);
    }
}
