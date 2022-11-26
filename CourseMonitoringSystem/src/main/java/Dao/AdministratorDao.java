package Dao;

import Bean.*;
import  Exception.*;


public interface AdministratorDao {


    public boolean adminLogin(String UserName,String Password) throws  AdminException;
    public String createAdmin(Admin admin) throws AdminException;
    public  String createCourse(Course course) throws  CourseException;
    public  String createBatch(Batch batch) throws  BatchException;
    public  String createFaculty(Faculty faculty)throws  FacultyException;
    public  String updateCourse(int CourseId)throws  CourseException;
    public  String updateBatch(int BatchId) throws  BatchException;
    public  String updateFaculty(int FacultyId) throws  FacultyException;
    public  void  viewCourse(int CourseId) throws  CourseException;
    public  void  viewBatch(int BatchId) throws  BatchException;
    public void  viewFaculty(int FacultyId) throws  FacultyException;
    public  String AllocateFacultyToBatch(int BatchId,int FacultyId) throws  FacultyException,BatchException;
    public  String createCoursePlan(CoursePlan coursePlan) throws  CoursePlanException;
    public  String UpdateCoursePlan(int planId) throws  CoursePlanException;
    public  void viewCoursePlan(int planId) throws  CoursePlanException;








}
