import java.io.Serializable;

public class Contract implements Serializable {
    private String phoneNumber;
    private String groupName;
    private String name;
    private String gender;
    private String address;
    private String dateOfBirth;
    private String emailAdress;

    public Contract() {};

    public Contract(String phoneNumber, String groupName, String name, String gender, String address, String dateOfBirth, String emailAdress) {
        this.phoneNumber = phoneNumber;
        this.groupName = groupName;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.emailAdress = emailAdress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    @Override
    public String toString() {
        return "Phone: " + getPhoneNumber() + "\nGroup: " + getGroupName() + "\nName: " + getName() + "\nGender: " + getGender() + "\nAddress: " + getAddress() + "\n";
    }
}
