/*
===================================
== Matthias Gabel
===================================
*/
package de.teamLocster.User;


import java.util.Date;


public class PersonalInfo
{
    /*
    ===================================
    == ENUM
    ===================================
    */
    public enum Sex
    {
        male,
        female,
        uni
    }

    public enum RelationshipStatus
    {
        taken,
        single,
        married,
        no_information
    }

    /*
    ===================================
    == Variable
    ===================================
    */
    private String firstName;
    private String lastName;
    private String region;
    private Date   birthdate;
    private RelationshipStatus relationshipStatus;
    private String occupation;
    private String profilePicture;
    private Sex sex;


    /*
    ===================================
    == Constructor
    ===================================
    */
    public PersonalInfo(String firstName, String lastName, Date birthdate, Sex sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.region = "";
        this.birthdate = birthdate;
        this.relationshipStatus = RelationshipStatus.no_information;
        this.occupation = "";
        this.profilePicture = "";
        this.sex = sex;
    }

    /*
    ===================================
    == Getter & Setter
    ===================================
    */
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public RelationshipStatus getRelationshipStatus() { return relationshipStatus; }

    public void setRelationshipStatus(RelationshipStatus relationshipStatus) { this.relationshipStatus = relationshipStatus; }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
}
