package worldcup.domain;

import java.util.Objects;

public class Group {

    private final String group;

    public Group(String group) {
        this.group = group;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public boolean equals(Object obj) {
        Group group = (Group) obj;
        return this.group.equals(group.group);
    }

    @Override
    public int hashCode() {
        if (group == null) {
            return 0;
        }
        return group.hashCode();
    }

}
