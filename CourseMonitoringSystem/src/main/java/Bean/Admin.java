package Bean;

public class Admin {

    private int adminId;
    private  String adminName;
    private  String adminEmail;
    private  String adminPhoneNumber;
    private  String adminPassword;
    private  String adminUsername;


    public Admin(int adminId, String adminName, String adminEmail, String adminPhoneNumber, String adminPassword, String adminUsername) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminEmail = adminEmail;
        this.adminPhoneNumber = adminPhoneNumber;
        this.adminPassword = adminPassword;
        this.adminUsername = adminUsername;
    }

    public Admin(String adminName, String adminEmail, String adminPhoneNumber, String adminPassword, String adminUsername) {
        this.adminName = adminName;
        this.adminEmail = adminEmail;
        this.adminPhoneNumber = adminPhoneNumber;
        this.adminPassword = adminPassword;
        this.adminUsername = adminUsername;
    }

    public Admin() {
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminPhoneNumber() {
        return adminPhoneNumber;
    }

    public void setAdminPhoneNumber(String adminPhoneNumber) {
        this.adminPhoneNumber = adminPhoneNumber;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", adminName='" + adminName + '\'' +
                ", adminEmail='" + adminEmail + '\'' +
                ", adminPhoneNumber='" + adminPhoneNumber + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                ", adminUsername='" + adminUsername + '\'' +
                '}';
    }
}
