package ch.ethz.globis.isk.domain;

import java.util.HashSet;
import java.util.Set;

public class Person implements DomainObject {

    protected String id;
    protected String name;
    public Set<Publication> authoredPublications;
    public Set<Publication> editedPublications;

    public Person() {
        authoredPublications = new HashSet<>();
        editedPublications = new HashSet<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Publication> getAuthoredPublications() {
        return authoredPublications;
    }

    public void setAuthoredPublications(Set<Publication> publications) {
        this.authoredPublications = publications;
    }

    public Set<Publication> getEditedPublications() {
        return editedPublications;
    }

    public void setEditedPublications(Set<Publication> editedPublications) {
        this.editedPublications = editedPublications;
    }

    /*
        Equals and hashCode don't check references to other domain objects to avoid
        infinite loops.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person that = (Person) o;

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