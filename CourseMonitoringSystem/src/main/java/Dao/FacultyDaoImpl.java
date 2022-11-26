package Dao;
import Exception.*;
import Utility.DBUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FacultyDaoImpl implements FacultyDao{


    @Override
    public void viewCoursePlan(String facultyName) throws CoursePlanException {

        try(Connection conn= DBUtility.provideConnection()) {

            PreparedStatement ps = conn.prepareStatement("select * from courseplan where batchId = (select batchId from batch where facultyid = (select facultyid from faculty where facultyname = ?))");
            ps.setString(1, facultyName);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {


                System.out.println("coursePlanId = "+rs.getInt("planId"));
                System.out.println("batchId = "+rs.getInt("batchId"));
                System.out.println("daynumber = "+rs.getInt("daynumber"));
                System.out.println("topic = "+rs.getString("topic"));
                System.out.println("status = "+rs.getString("status"));

            }
        } catch (SQLException e) {
            CoursePlanException coursePlanException=new CoursePlanException(e.getMessage());
            throw  coursePlanException;
        }
    }

    @Override
    public boolean FacultyLogin(String UserName, String Password) throws AdminException {
        boolean b=false;


        try (Connection conn = DBUtility.provideConnection()) {

            PreparedStatement ps1 = conn.prepareStatement("select * from faculty where  username=? AND password=?");
            ps1.setString(1, UserName);
            ps1.setString(2, Password);


            ResultSet rs = ps1.executeQuery();

            if (rs.next()) {

                b=false;

            } else {

                AdminException adminException = new AdminException("Invaild UserName and Password");
                throw adminException;

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return b;
    }

    @Override
    public boolean updatePassword(String username, String password, String new_username) throws FacultyException {
        return false;
    }

    @Override
    public String updateStatus(int day) throws CoursePlanException {
        return null;
    }
}
