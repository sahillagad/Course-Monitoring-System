package Bean;

public class Faculty {

 private int facultyId;
 private String facultyName;
 private String facultyaddress;
 private String mobile;
 private String email;
 private String username;
 private  String password;


    public Faculty(int facultyId, String facultyName, String facultyaddress, String mobile, String email, String username, String password) {
        this.facultyId = facultyId;
        this.facultyName = facultyName;
        this.facultyaddress = facultyaddress;
        this.mobile = mobile;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public Faculty(String facultyName, String facultyaddress, String mobile, String email, String username, String password) {
        this.facultyName = facultyName;
        this.facultyaddress = facultyaddress;
        this.mobile = mobile;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public Faculty() {
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getFacultyaddress() {
        return facultyaddress;
    }

    public void setFacultyaddress(String facultyaddress) {
        this.facultyaddress = facultyaddress;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
