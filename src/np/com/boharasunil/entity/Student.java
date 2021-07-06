package np.com.boharasunil.entity;

/**
 *
 * @author sunilbohara
 */
public class Student extends MasterEntity{
    private String fullName,gender,address,email;
    private Long contactNo;
    private int s_id;

    public Student() {
        
    }

    public Student(int s_id,String fullName, String gender, String address, String email, Long contactNo) {
        this.s_id = s_id;
        this.fullName = fullName;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.contactNo = contactNo;
    }

    public Student(String fullName, String gender, String address, String email, Long contactNo) {
        this.fullName = fullName;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.contactNo = contactNo;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getContactNo() {
        return contactNo;
    }

    public void setContactNo(Long contactNo) {
        this.contactNo = contactNo;
    }

    @Override
    public String toString() {
        return "Student{" + "fullName=" + fullName + ", gender=" + gender + ", address=" + address + ", email=" + email + ", contactNo=" + contactNo + ", s_id=" + s_id + '}';
    }
}
