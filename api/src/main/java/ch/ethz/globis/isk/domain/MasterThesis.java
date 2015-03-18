package ch.ethz.globis.isk.domain;

public class MasterThesis extends Publication {

    private School school;

    public MasterThesis() { }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}