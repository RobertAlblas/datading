package nl.robertalblas.datading;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class GroupService {

    private Set<Group> groups;

    public GroupService() {
        this.groups = new HashSet<>();
    }

    public Group addGroup(Group group) {
        this.groups.add(group);
        return group;
    }

    public Set<Group> getGroups() {
        return new HashSet<>(groups);
    }
}
