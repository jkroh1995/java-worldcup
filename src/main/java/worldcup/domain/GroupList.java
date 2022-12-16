package worldcup.domain;

import java.util.Arrays;
import java.util.List;

public class GroupList {

    private final String GROUP_A = "A조";
    private final String GROUP_B = "B조";
    private final String GROUP_C = "C조";
    private final String GROUP_D = "D조";
    private final String GROUP_E = "E조";
    private final String GROUP_F = "F조";
    private final String GROUP_G = "G조";
    private final String GROUP_H = "H조";

    List<Group> groupList;

    public GroupList(){
        groupList = Arrays.asList(new Group(GROUP_A), new Group(GROUP_B), new Group(GROUP_C), new Group(GROUP_D)
        , new Group(GROUP_E), new Group(GROUP_F), new Group(GROUP_G), new Group(GROUP_H));
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public void checkGroup(String inputGroup) {
        if(!groupList.contains(new Group(inputGroup+"조"))){
            throw new IllegalArgumentException("[ERROR] 없는 그룹입니다.");
        }
    }
}
