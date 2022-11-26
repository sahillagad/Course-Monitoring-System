package Dao;

import  Exception.*;
public interface FacultyDao {


    public  void viewCoursePlan(String facultyName) throws CoursePlanException;
    public boolean  FacultyLogin(String UserName,String Password) throws  AdminException;
    public boolean updatePassword(String username,String password,String new_username) throws FacultyException;
    public String updateStatus(int day) throws CoursePlanException;
}
