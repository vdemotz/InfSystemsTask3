package ch.ethz.globis.isk.domain;

public class ConferenceEdition implements DomainObject {

    private String id;
    private Integer year;
    private Conference conference;
    private Proceedings proceedings;

    public ConferenceEdition() {
    }

    public Conference getConference() {
        return conference;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
    }

    public Proceedings getProceedings() {
        return proceedings;
    }

    public void setProceedings(Proceedings proceedings) {
        this.proceedings = proceedings;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "ConferenceEdition{" +
                "id='" + getId() + '\'' +
                ", year=" + getYear() +
                '}';
    }

    /*
        Equals and hashCode don't check references to other domain objects to avoid
        infinite loops.
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConferenceEdition)) return false;

        ConferenceEdition that = (ConferenceEdition) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getYear() != null ? !getYear().equals(that.getYear()) : that.getYear() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getYear() != null ? getYear().hashCode() : 0);
        return result;
    }
}