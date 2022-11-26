package Dao;

import Bean.*;
import  Exception.*;
import Utility.DBUtility;

import java.sql.*;
import java.util.Scanner;


public class AdministratorDaoImpl implements  AdministratorDao{



    @Override
    public boolean adminLogin(String username, String password) throws AdminException {
        boolean b=false;


        try (Connection conn = DBUtility.provideConnection()) {

            PreparedStatement ps1 = conn.prepareStatement("select * from admin where  admin_username=? AND admin_password=?");
            ps1.setString(1, username);
            ps1.setString(2, password);


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
    public String createAdmin(Admin admin) throws AdminException {
      String result="Admin is Created Process Failed...";

      try(Connection conn= DBUtility.provideConnection()) {


          PreparedStatement ps1 = conn.prepareStatement("select * from admin where adminName=? AND admin_email=? AND admin_phone_number=? AND admin_username=?");
          ps1.setString(1, admin.getAdminName());
          ps1.setString(2, admin.getAdminEmail());
          ps1.setString(3, admin.getAdminPhoneNumber());
          ps1.setString(4, admin.getAdminUsername());

          ResultSet rs = ps1.executeQuery();


          if (rs.next() == false) {

              PreparedStatement ps = conn.prepareStatement("insert into admin(adminName,admin_email,admin_phone_number,admin_password,admin_username) values(?,?,?,?,?)");
              ps.setString(1, admin.getAdminName());
              ps.setString(2, admin.getAdminEmail());
              ps.setString(3, admin.getAdminPhoneNumber());
              ps.setString(4, admin.getAdminPassword());
              ps.setString(5, admin.getAdminUsername());


              int x = ps.executeUpdate();
              if (x > 0) {
                  result = "Admin created successfully...";

              } else {

                  AdminException adminException = new AdminException("Admin Creation Process failed Due To Some Error...");
                  throw adminException;
              }

          }
          else{

              AdminException adminException1=new AdminException("Admin Is Already Presented....");
              throw   adminException1;


          }

      }
      catch (SQLException e) {
          throw new RuntimeException(e);
      }
        return result;
    }


    @Override
    public String createCourse(Course course) throws CourseException {

        String result="Course is Created Process Failed...";

        try(Connection conn= DBUtility.provideConnection()) {


            PreparedStatement ps1 = conn.prepareStatement("select * from Course where courseName=?");
            ps1.setString(1,course.getCourseName());

            ResultSet rs = ps1.executeQuery();


            if (rs.next() == false) {

                PreparedStatement ps = conn.prepareStatement("insert into course(courseName,fee,courseDescription) values(?,?,?)");
                ps.setString(1,course.getCourseName());
                ps.setInt(2,course.getFee());
                ps.setString(3,course.getCourseDescription());


                int x = ps.executeUpdate();
                if (x > 0) {
                    result = "Course created successfully...";

                } else {

                    CourseException  courseException= new CourseException("Course Creation Process failed Due To Some Error...");
                    throw courseException;
                }

            }
            else{

                CourseException courseException1=new CourseException("Course Is Already Presented....");
                throw   courseException1;


            }

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;



    }

    @Override
    public String createBatch(Batch batch) throws BatchException {

        String result="Batch is Created Process Failed...";

        try(Connection conn= DBUtility.provideConnection()) {


            PreparedStatement ps1 = conn.prepareStatement("select * from batch where courseId=? AND  facultyId=? AND batchstartDate=? AND duration=?");
            ps1.setInt(1,batch.getCourseId());
            ps1.setInt(2,batch.getFacultyId());
            ps1.setDate(3, Date.valueOf(batch.getBatchstartDate()));
            ps1.setString(4 ,batch.getDuration());

            ResultSet rs = ps1.executeQuery();


            if (rs.next() == false) {

                PreparedStatement ps = conn.prepareStatement("insert into batch(courseId,facultyId,numberofStudents,batchstartDate,duration) values(?,?,?,?,?)");
                ps.setInt(1,batch.getCourseId());
                ps.setInt(2,batch.getFacultyId());
                ps.setInt(3,batch.getNumberofStudents());
                ps.setDate(4, Date.valueOf(batch.getBatchstartDate()));
                ps.setString(5,batch.getDuration());


                int x = ps.executeUpdate();
                if (x > 0) {
                    result = "Batch created successfully...";

                } else {

                    BatchException  batchException= new BatchException("Batch Creation Process failed Due To Some Error...");
                    throw batchException;
                }

            }
            else{

                BatchException batchException1=new BatchException("Batch Is Already Presented....");
                throw   batchException1;


            }

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;

    }



    @Override
    public String createFaculty(Faculty faculty) throws FacultyException {
        String result="Faculty is Created Process Failed...";

        try(Connection conn= DBUtility.provideConnection()) {


            PreparedStatement ps1 = conn.prepareStatement("select * from faculty where  facultyname=? AND facultyaddress=? AND mobile=? AND email=? AND username=?");
            ps1.setString(1,faculty.getFacultyName());
            ps1.setString(2,faculty.getFacultyaddress());
            ps1.setString(3,faculty.getMobile());
            ps1.setString(4,faculty.getEmail());
            ps1.setString(5,faculty.getUsername());



            ResultSet rs = ps1.executeQuery();



            if (rs.next() == false) {

                PreparedStatement ps = conn.prepareStatement("insert into faculty(facultyname,facultyaddress,mobile,email,username,password) values(?,?,?,?,?,?)");
                ps.setString(1,faculty.getFacultyName());
                ps.setString(2,faculty.getFacultyaddress());
                ps.setString(3,faculty.getMobile());
                ps.setString(4,faculty.getEmail());
                ps.setString(5,faculty.getUsername());
                ps.setString(6,faculty.getPassword());


                int x = ps.executeUpdate();
                if (x > 0) {
                    result = "Faculty created successfully...";

                } else {

                    FacultyException  facultyException= new FacultyException("Faculty Creation Process failed Due To Some Error...");
                    throw facultyException;
                }

            }
            else{

                FacultyException facultyException1=new FacultyException("Faculty Is Already Presented....");
                throw   facultyException1;


            }

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }


    @Override
    public String createCoursePlan(CoursePlan coursePlan) throws CoursePlanException {
        String result="Course Plan is Created Process Failed...";

        try(Connection conn= DBUtility.provideConnection()) {


            PreparedStatement ps1 = conn.prepareStatement("select * from courseplan where batchId=? AND  daynumber=? AND topic=? AND status=?");
             ps1.setInt(1,coursePlan.getBatchId());
             ps1.setInt(2,coursePlan.getDaynumber());
             ps1.setString(3,coursePlan.getTopic());
             ps1.setString(4,coursePlan.getStatus());




            ResultSet rs = ps1.executeQuery();



            if (rs.next() == false) {

                PreparedStatement ps = conn.prepareStatement("insert into courseplan(batchId,daynumber,topic,topic,status) values(?,?,?,?,?)");

                ps.setInt(1,coursePlan.getBatchId());
                ps.setInt(2,coursePlan.getDaynumber());
                ps.setString(3,coursePlan.getTopic());
                ps.setString(4,coursePlan.getStatus());


                int x = ps.executeUpdate();
                if (x > 0) {
                    result = "Course Plan created successfully...";

                } else {

                    CoursePlanException  coursePlanException= new CoursePlanException("Course Plan Creation Process failed Due To Some Error...");
                    throw coursePlanException;
                }

            }
            else{

                CoursePlanException CoursePlanException1=new CoursePlanException("Course Plan Is Already Presented....");
                throw   CoursePlanException1;


            }

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }


    @Override
    public String updateCourse(int CourseId) throws CourseException {
        String result="Course Update successfully....";

        try(Connection conn=DBUtility.provideConnection()) {

            PreparedStatement ps=conn.prepareStatement("select * from course where courseid=?");
            ps.setInt(1,CourseId);

            ResultSet rs= ps.executeQuery();

            if(rs.next()){

                 int courseid=rs.getInt("courseid");
                 String courseName=rs.getString("courseName");
                 int fee=rs.getInt("fee");
                 String courseDescription=rs.getString("courseDescription");

                Scanner sc=new Scanner(System.in);

                 Course course=new Course(courseid,courseName,fee,courseDescription);


                System.out.println("Enter 1 For Update Course Name");
                System.out.println("Enter 2 For Update Fee");
                System.out.println("Enter 3 For Update Course Description");

                int i=sc.nextInt();

                if(i==1){
                    System.out.println("Enter Update Course Name");
                    String cName=sc.next();
                    course.setCourseName(cName);
                }
                if (i==2){
                    System.out.println("Enter Update Course Fee");
                    int cFee=sc.nextInt();
                    course.setFee(cFee);
                }
               if(i==3){
                   System.out.println("Enter Update Course Description");
                    String  cDescription=sc.next();
                    course.setCourseDescription(cDescription);
               }
               if (i>=4 || i<=0){
                   CourseException courseException1=new CourseException("Please Enter Proper Input");
                     throw courseException1;
               }


               PreparedStatement ps5=conn.prepareStatement("update course set courseName=?,fee=?,courseDescription=? where  courseid=?");
               ps5.setString(1,course.getCourseName());
               ps5.setInt(2,course.getFee());
               ps5.setString(3,course.getCourseDescription());

                int x= ps5.executeUpdate();


            if (x>0){

             result="Course Is Updated  successfully...";

            }
            else{
                CourseException courseException=new CourseException("Course Not Updated Due TO Some Error...");
                throw  courseException;
            }


            }
            else{

                CourseException courseException=new CourseException("Course is not Avaliable by Given Course ID");
                throw  courseException;

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  result;
    }

    @Override
    public String updateBatch(int BatchId) throws BatchException {

        String result="Batch Update successfully....";

        try(Connection conn=DBUtility.provideConnection()) {

            PreparedStatement ps=conn.prepareStatement("select * from batch where batchId=?");
            ps.setInt(1,BatchId);

            ResultSet rs= ps.executeQuery();

            if(rs.next()){

                int batchId=rs.getInt("batchId");
                int courseId=rs.getInt("courseId");
                int facultyId=rs.getInt("facultyId");
                int numberofStudents=rs.getInt("numberofStudents");
                String  batchstartDate=rs.getString("batchstartDate");
                String duration=rs.getString("duration");


                Batch batch=new Batch(BatchId,courseId,facultyId,numberofStudents,batchstartDate,duration);

                Scanner sc=new Scanner(System.in);

                System.out.println("Enter 1 For Update Course Id");
                System.out.println("Enter 2 For Update Faculty Id");
                System.out.println("Enter 3 For Update Number Of Student");
                System.out.println("Enter 4 For Update Batch Start Date");
                System.out.println("Enter 5 For Update Duration");

                int output=sc.nextInt();

                if (output==1){

                    System.out.println("Enter update Course Id");
                    int cId=sc.nextInt();
                    batch.setCourseId(cId);

                }
                if (output==2){
                    System.out.println("Enter Update faculty Id");
                    int fId=sc.nextInt();
                    batch.setFacultyId(fId);

                }
                if (output==3){
                    System.out.println("Enter Update Number Of Students");
                     int nStudents=sc.nextInt();
                     batch.setNumberofStudents(nStudents);

                }
                if(output==4){
                    System.out.println("Enter Update batch start Date (Enter Formatte DD/MM/YYYY)");
                    String bDate= sc.next();
                    batch.setBatchstartDate(bDate);
                }
               if (output==5){
                   System.out.println("Enter Update Course Duration");
                   String cDuration= sc.next();
                   batch.setDuration(cDuration);
               }

               if (output<=0 || output>=6){

                   BatchException batchException1=new BatchException("Please Provide Proper Input");
                   throw  batchException1;

               }

                PreparedStatement ps5=conn.prepareStatement("update batch set courseId=?,facultyId=?,numberofStudents=?,batchstartDate=? ,duration=? where  batchId=?");

               ps5.setInt(1,batch.getCourseId());
               ps5.setInt(2,batch.getFacultyId());
               ps5.setString(3,batch.getBatchstartDate());
               ps5.setString(4,batch.getDuration());


                int x= ps5.executeUpdate();


                if (x>0){

                    result="Batch Is Updated  successfully...";

                }
                else{
                    BatchException  batchException3=new BatchException("Batch Not Updated Due TO Some Error...");
                    throw  batchException3;
                }


            }
            else{

                BatchException batchException=new BatchException("Batch is not Available by Given Course ID");
                throw  batchException;

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  result;


    }


    @Override
    public String updateFaculty(int FacultyId) throws FacultyException {



        String result="Faculty Update successfully....";

        try(Connection conn=DBUtility.provideConnection()) {

            PreparedStatement ps=conn.prepareStatement("select * from faculty where facultyid=?");
            ps.setInt(1,FacultyId);

            ResultSet rs= ps.executeQuery();

            if(rs.next()){

                int facultyid=rs.getInt("facultyid");
                String facultyname=rs.getString("facultyname");
                String facultyaddress=rs.getString("facultyaddress");
                String mobile=rs.getString("mobile");
                String email=rs.getString("email");
                String username=rs.getString("username");
                String password=rs.getString("password");


                Faculty faculty=new Faculty(FacultyId,facultyname,facultyaddress,mobile,email,username,password);




                Scanner sc=new Scanner(System.in);


                System.out.println("Enter 1 For Update faculty name");
                System.out.println("Enter 2 For Update faculty address");
                System.out.println("Enter 3 For Update mobile");
                System.out.println("Enter 4 For Update email");
                System.out.println("Enter 5 For Update username");
                System.out.println("Enter 6 For Update password");

                int i=sc.nextInt();

                if(i==1){

                    System.out.println("Enter Update Faculty Name");
                     String Fname=sc.next();
                     faculty.setFacultyName(Fname);

                }

                if (i==2){
                    System.out.println("Enter Update Faculty Address");
                    String Faddress=sc.next();
                    faculty.setFacultyaddress(Faddress);

                }

                if(i==3){

                    System.out.println("Enter Update Faculty mobile");
                    String Fmobile =sc.next();
                     faculty.setMobile(Fmobile);

                }

                if(i==4){
                    System.out.println("Enter Update Faculty email");
                    String Femail=sc.next();
                    faculty.setEmail(Femail);
                }
                if (i==5){

                    System.out.println("Enter Update Faculty username");
                    String Fusername=sc.next();
                    faculty.setUsername(Fusername);
                }

                if(i==6){
                    System.out.println("Enter Update faculty password");
                     String Fpassword=sc.next();
                     faculty.setPassword(Fpassword);

                }
                if (i<=0 || i>=7){

                    FacultyException facultyException2=new FacultyException("Please Provide Proper Input");
                    throw  facultyException2;

                }

                PreparedStatement ps5=conn.prepareStatement("update  faculty set facultyname=?,facultyaddress=?,mobile=?,email=? ,duration=? username  username=?  where  facultyid=?");
                   ps5.setString(1,faculty.getFacultyName());
                   ps5.setString(2,faculty.getFacultyaddress());
                   ps5.setString(3,faculty.getMobile());
                   ps5.setString(4,faculty.getEmail());
                   ps5.setString(5,faculty.getUsername());
                   ps5.setString(6,faculty.getPassword());
                   ps5.setInt(7,faculty.getFacultyId());




                int x= ps5.executeUpdate();


                if (x>0){

                    result="Faculty Is Updated  successfully...";

                }
                else{
                    FacultyException facultyException=new FacultyException("Faculty Not Updated Due TO Some Error...");
                    throw  facultyException;
                }


            }
            else{

                FacultyException facultyException1=new FacultyException("Faculty is not Available by Given Course ID");
                throw  facultyException1;

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  result;




    }




    @Override
    public String UpdateCoursePlan(int planId) throws CoursePlanException {

        String result="Course Plan Update successfully....";

        try(Connection conn=DBUtility.provideConnection()) {

            PreparedStatement ps=conn.prepareStatement("select * from courseplan where planId=?");
            ps.setInt(1,planId);
            ResultSet rs= ps.executeQuery();

            if(rs.next()){


                int coursePlanId=rs.getInt("planId");
                int batchId=rs.getInt("batchId");
                int daynumber=rs.getInt("daynumber");
                String topic=rs.getString("topic");
                String status=rs.getString("status");




                CoursePlan coursePlan=new CoursePlan(coursePlanId,batchId,daynumber,topic,status);

                Scanner sc=new Scanner(System.in);

                System.out.println("Enter 1 For Update Batch Id");
                System.out.println("Enter 2 For Update day number");
                System.out.println("Enter 3 For Update topic");
                System.out.println("Enter 4 For Update status");


                int output=sc.nextInt();

                if(output==1){

                    System.out.println("Enter Update Batch Id");
                    int batch_Id=sc.nextInt();
                    coursePlan.setBatchId(batch_Id);

                }
                if (output==2){

                    System.out.println("Enter Update  day number");
                    int day_number=sc.nextInt();
                    coursePlan.setDaynumber(day_number);
                }

                if (output==3){
                    System.out.println("Enter Update topic");
                    String topic1=sc.next();
                    coursePlan.setTopic(topic1);
                }

                if (output==4){
                    System.out.println("Enter Update status");
                    String status1=sc.next();
                    coursePlan.setStatus(status1);
                }

                if (output<=0 || output>=5){

                    CoursePlanException coursePlanException=new CoursePlanException("Please Provide Proper Input");
                    throw  coursePlanException;

                }

                PreparedStatement ps5=conn.prepareStatement("update courseplan set batchId=?,daynumber=?,topic=?,status=? where  planId=?");
                     ps5.setInt(1,coursePlan.getBatchId());
                     ps5.setInt(2,coursePlan.getDaynumber());
                     ps5.setString(3,coursePlan.getTopic());
                     ps5.setString(4,coursePlan.getStatus());
                     ps5.setInt(5,coursePlan.getPlanId());



                int x= ps5.executeUpdate();
                if (x>0){

                    result="Course Plan Is Updated  successfully...";

                }
                else{
                    CoursePlanException  coursePlanException3=new CoursePlanException("Course Plan Not Updated Due TO Some Error...");
                    throw  coursePlanException3;
                }


            }
            else{

                 CoursePlanException coursePlanException=new CoursePlanException("Course Plan is not Available by Given Course ID");
                throw  coursePlanException;

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  result;
    }


    @Override
    public void viewCoursePlan(int planId) throws CoursePlanException {

        try(Connection conn=DBUtility.provideConnection()) {

            PreparedStatement ps = conn.prepareStatement("select * from courseplan where planId=?");
            ps.setInt(1, planId);
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
    public void viewFaculty(int FacultyId) throws FacultyException {
        try(Connection conn=DBUtility.provideConnection()) {

            PreparedStatement ps = conn.prepareStatement("select * from faculty where facultyid=?");
            ps.setInt(1, FacultyId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("facultyid = "+rs.getInt("facultyid"));
                System.out.println("facultyname = "+rs.getString("facultyname"));
                System.out.println("facultyaddress = "+rs.getString("facultyaddress"));
                System.out.println("mobile = "+rs.getString("mobile"));
                System.out.println("email = "+rs.getString("email"));
                System.out.println("username = "+rs.getString("username"));
                System.out.println("password = "+rs.getString("password"));

            }
        } catch (SQLException e) {
            FacultyException facultyException1=new FacultyException(e.getMessage());
            throw  facultyException1;
        }

    }


    @Override
    public void viewBatch(int BatchId) throws BatchException {


        try (Connection conn = DBUtility.provideConnection()) {

            PreparedStatement ps = conn.prepareStatement("select * from batch where batchId=?");
            ps.setInt(1, BatchId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("batchId = "+rs.getInt("batchId"));
                System.out.println("courseId = "+rs.getInt("courseId"));
                System.out.println("facultyId = "+rs.getInt("facultyId"));
                System.out.println("numberofStudents = "+rs.getInt("numberofStudents"));
                System.out.println("batchstartDate = "+rs.getString("batchstartDate"));
                System.out.println("duration = "+rs.getString("duration"));


            }

        } catch (SQLException e) {
            BatchException batchException=new BatchException(e.getMessage());
            throw  batchException;
        }



    }

    @Override
    public void viewCourse(int CourseId) throws CourseException {
        try (Connection conn = DBUtility.provideConnection()) {

            PreparedStatement ps = conn.prepareStatement("select * from course where courseid=?");
            ps.setInt(1, CourseId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("courseid = "+rs.getInt("courseid"));
                System.out.println("courseName = "+rs.getString("courseName"));
                System.out.println("fee = "+rs.getInt("fee"));
                System.out.println("courseDescription = "+rs.getString("courseDescription"));

            }
        } catch(SQLException e){
            CourseException courseException=new CourseException(e.getMessage());
            throw  courseException;

        }


    }





    @Override
    public String AllocateFacultyToBatch(int BatchId, int FacultyId) throws FacultyException, BatchException {

        String result="Allocate Faculty To Batch Process is failed...";


        try (Connection conn = DBUtility.provideConnection()) {

            PreparedStatement ps = conn.prepareStatement("select * from batch where batchId=?");
            ps.setInt(1, BatchId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                PreparedStatement ps5=conn.prepareStatement("update batch set facultyId=? where  batchId=?");

                ps5.setInt(1,FacultyId);
                ps5.setInt(2,BatchId);

                int x= ps5.executeUpdate();

                if(x>0){

                    result="Allocate Faculty To Batch Process is successfully....";

                }
                else{

                    BatchException batchException=new BatchException("Allocate Faculty To Batch Process is failed Due to some Error...");
                    throw batchException;

                }

            }
            else {
                BatchException batchException=new BatchException("Batch is not Available by give Batch id");
                throw batchException;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return  result;
    }


}
