package ch.ethz.globis.isk.domain;

import java.util.HashSet;
import java.util.Set;

public class Conference implements DomainObject {

    private String id;
    private String name;
    private Set<ConferenceEdition> editions;

    public Conference() {
        editions = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ConferenceEdition> getEditions() {
        return editions;
    }

    public void setEditions(Set<ConferenceEdition> editions) {
        this.editions = editions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /*
        Equals and hashCode don't check references to other domain objects to avoid
        infinite loops.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Conference)) return false;

        Conference that = (Conference) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        return result;
    }
}