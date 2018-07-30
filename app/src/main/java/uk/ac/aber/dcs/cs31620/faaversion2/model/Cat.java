package uk.ac.aber.dcs.cs31620.faaversion2.model;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import uk.ac.aber.dcs.cs31620.faaversion2.model.util.DateTimeConverter;

/**
 * Defines a Cat
 * @author Chris Loftus
 * @version 1 12/06/2018.
 */

public class Cat {

    public static final int ONE_YEAR = 12;

    private String name;
    private Gender gender;
    private String breed;
    private String description;
    private Date dob;
    private int resourceId;

    public Cat(String name, Gender gender, String breed, Date dob, int resourceId, String description){
        this.name = name;
        this.gender = gender;
        this.breed = breed;
        this.dob = dob;
        this.resourceId = resourceId;
        this.description = description;
    }

    public boolean isKitten(){
        Date now = new Date();
        long daysDiff = DateTimeConverter.getDateDiff(now, dob, TimeUnit.DAYS);
        return daysDiff < 365;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public String getDescription() {
        return description;
    }

    public String getBreed() {
        return breed;
    }

    public Date getDob() {
        return dob;
    }

    public int getResourceId(){
        return resourceId;
    }

    public void setAge(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", breed='" + breed + '\'' +
                ", description='" + description + '\'' +
                ", dob=" + dob +
                ", resourceId='" + resourceId + '\'' +
                '}';
    }
}
