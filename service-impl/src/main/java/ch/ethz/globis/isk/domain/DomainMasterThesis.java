package ch.ethz.globis.isk.domain;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "publication")
public class DomainMasterThesis extends DomainPublication implements MasterThesis {

	@DBRef(lazy = false)
	private School school;

    public DomainMasterThesis() { }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}