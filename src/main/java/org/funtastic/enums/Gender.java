package org.funtastic.enums;

public enum Gender {
	
	MALE("M"), FEMALE("F"), OTHER("O");
    private String gender;

    private Gender(String value) {
        this.gender = value;
    }

    public String getGender() {
        return this.gender;
    }

    @Override
    public String toString() {
        return this.gender;
    }

}
