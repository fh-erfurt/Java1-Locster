import java.sql.Timestamp;

public class PersonalInfo
{
    private String firstName;
    private String lastName;
    private String region;
    private Timestamp birthdate;
    private String relationshipStatus;
    private String occupation;
    private String profilePicture;

    public PersonalInfo(String firstName, String lastName, String region,
                        Timestamp birthdate, String relationshipStatus,
                        String occupation, String profilePicture) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.region = region;
        this.birthdate = birthdate;
        this.relationshipStatus = relationshipStatus;
        this.occupation = occupation;
        this.profilePicture = profilePicture;
    }

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

    public Timestamp getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Timestamp birthdate) {
        this.birthdate = birthdate;
    }

    public String getRelationshipStatus() {
        return relationshipStatus;
    }

    public void setRelationshipStatus(String relationshipStatus) {
        this.relationshipStatus = relationshipStatus;
    }

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
}
