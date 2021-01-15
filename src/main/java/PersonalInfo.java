/*
===================================
Matthias Gabel
===================================
*/

import java.sql.Timestamp;
import java.util.Date;

public class PersonalInfo
{
    /*
    ===================================
    ENUM
    ===================================
    */
    enum sex {
        male,
        female,
        uni
    }

    enum relationshipStatus {
        taken,
        single,
        married,
        no_information
    }

    private String firstName;
    private String lastName;
    private String region;
    private Date   birthdate;
    private relationshipStatus relationshipStatus;
    private String occupation;
    private String profilePicture;
    private sex    sex;


    /*
    ===================================
    Constructor
    ===================================
    */
    public PersonalInfo(String firstName, String lastName, Date birthdate, sex sex, relationshipStatus relationshipStatus) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.region = "";
        this.birthdate = birthdate;
        this.relationshipStatus = relationshipStatus;
        this.occupation = "";
        this.profilePicture = "";
        this.sex = sex;
    }

    public void changeRegion(String newregion)
    {
        this.region = newregion;
    }

    public void changeRelationshipStatus(PersonalInfo.relationshipStatus newrelationshipStatus) { this.relationshipStatus = newrelationshipStatus; }

    public void changeOccupation( String newoccupation) { this.occupation= newoccupation; }

    public void changeprofilePicture( String newprofilepicture) { this.profilePicture= newprofilepicture; }

    /*
    ===================================
    Getter & Setter
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

    public PersonalInfo.relationshipStatus getRelationshipStatus() { return relationshipStatus; }

    public void setRelationshipStatus(PersonalInfo.relationshipStatus relationshipStatus) { this.relationshipStatus = relationshipStatus; }

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

    public PersonalInfo.sex getSex() {
        return sex;
    }

    public void setSex(PersonalInfo.sex sex) {
        this.sex = sex;
    }
}
