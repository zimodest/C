import java.io.PrintWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
class Course{
    private String courseName;
    private String courseNo;
    private char courseGrade;
    private int courseCredits;

    //copyCourseInfo
    public void setCourseInfo(String cName, String cNo, char grade, int credits){
        courseName = cName;
        courseNo = cNo;
        courseGrade = grade;
        courseCredits = credits;
    }

    public void setCourseName(String cName){
        courseName = cName;
    }
    public void setCourseNumber(String cNo){
        courseNo = cNo;
    }
    public void setCourGrade(char grade){
        courseGrade = grade;
    }
    public void setCourseCredits(int credits){
        courseCredits = credits;
    }

    public void print(boolean isGrade){
        System.out.print(courseNo+"\t "+courseName+"\t\t"+courseCredits+"\t");
        if(isGrade){
            System.out.println(courseGrade);
        }else{
            System.out.println("***");
        }
    }

    public void print(PrintWriter outp, boolean isGrade){
        outp.print(courseNo+"\t "+courseName+"\t\t"+courseCredits+"\t");
        if(isGrade){
            outp.println(courseGrade);
        }else{
            outp.println("***");
        }
    }
    public int getCredits(){
        return courseCredits;
    }

    public String getCourseNumber(){
        return courseNo;
    }
    public char getGrade(){
        return courseGrade;
    }
    public String getCourseInfo(boolean isGrade){
        String str;
        str = courseNo+"\t "+courseName+"\t\t"+courseCredits+"\t";
        if(isGrade)
            str = str+courseGrade;
        else
            str = str+"***";
        return str;
    }
    public Course(String cName, String cNo, char grade, int credits){
        courseName = cName;
        courseNo = cNo;
        courseGrade = grade;
        courseCredits = credits;
    }
    public Course(){
        courseName = "";
        courseNo = "";
        courseGrade = '*';
        courseCredits = 0;
    }
}

class Student{
    private int sId;
    private String sName;
    private int numberOfCourses;
    private boolean isTuitionPaid;
    private Course[] courseEnrolled;

    public void setInfo(String sName, int ID, int nOfCourses, boolean isTpid, Course[] courses){
        int i;
        this.sName = sName;

        sId = ID;
        isTuitionPaid = isTpid;
        numberOfCourses = nOfCourses;
        for(i=0; i<numberOfCourses; i++){
            courseEnrolled[i].copyCourseInfo(courses[i]);
        }
    }
    public void setStudentId(int ID){
        sId = ID;
    }
    public void setsTuitionPaid(boolean isTpid){
        isTuitionPaid = isTpid;
    }
    public void setNumberOfCourses(int nOfCourses){
        numberOfCourses = nOfCourses;
    }
    public void setCoursesEnrolled(Course[] courses){
        int i;
        for(i=0;i<numberOfCourses;i++){
            courseEnrolled[i].copyCourseInfo(courses[i]);
        }
    }
    public void print(double tuitionRate){
        int i;

        DecimalFormat twoDecimal = new DecimalFormat("0.00");
        System.out.println("Student Name: "+super.toString());
        System.out.println("Student ID: "+sId);
        System.out.println("Number of courses enrolled: "+numberOfCourses);
        System.out.println("Course No Course Name"+"\t  Credits"+"\t     Grade");
        for(i=0; i<numberOfCourses; i++){
            courseEnrolled[i].print(isTuitionPaid);
        }
        System.out.println();
        System.out.println("Total number of credit hours:"+twoDecimal.format(getHoursEnrolled()));
        if(isTuitionPaid){
            System.out.println("Midsemester GPA: "+twoDecimal.format(getGpa()));
        }else{
            System.out.println("*** Grades are being held for not paying the tuition. ***");
            System.out.println("Amount Due:$"+twoDecimal.format(billingAmount(tuitionRate)));
        }
        System.out.print("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*"+"-*-*-*-*-*-*-\n");
    }
    public void print(PrintWriter outp, double tuitionRate){
         int i;

        DecimalFormat twoDecimal = new DecimalFormat("0.00");
        outp.println("Student Name: "+super.toString());
        outp.println("Student ID: "+sId);
        outp.println("Number of courses enrolled: "+numberOfCourses);
        outp.println("Course No Course Name"+"\t  Credits"+"\t     Grade");
        for(i=0; i<numberOfCourses; i++){
            courseEnrolled[i].print(isTuitionPaid);
        }
        outp.println();
        outp.println("Total number of credit hours:"+twoDecimal.format(getHoursEnrolled()));
        if(isTuitionPaid){
            outp.println("Midsemester GPA: "+twoDecimal.format(getGpa()));
        }else{
            outp.println("*** Grades are being held for not paying the tuition. ***");
            outp.println("Amount Due:$"+twoDecimal.format(billingAmount(tuitionRate)));
        }
        outp.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*"+"-*-*-*-*-*-*-\n");
    }
    public Student(){
        super();
        numberOfCourses = 0;
        sId = 0;
        isTuitionPaid = false;
        courseEnrolled = new Course[6];
        for(int i=0;i<6;i++){
            courseEnrolled[i] = new Course();
        }
    }
    public String getName(){
        return sName;
    }
    public int getStudentId(){
        return sId;
    }
    public boolean getIsTuitionPaid(){
        return isTuitionPaid;
    }
    public int getNumberOfCourse(){
        return numberOfCourses;
    }
    public Course getCOurses(int i){
        Course temp = new Course();
        temp.copyCourseInfo(courseEnrolled[i]);
        return temp;
    }
    public int getHoursEnrolled(){
        int totalCredits = 0;
        int i;

        for(i=0; i<numberOfCourses; i++){
            totalCredits += courseEnrolled[i].getCredits();
        }

        return totalCredits;
    }
    public double billingAmount(double tuitionRate){
        return tuitionRate*getHoursEnrolled();
    }
    public double getGpa(){
        int i;
        double sum = 0.0;
        for(i=0;i<numberOfCourses;i++){
            switch(courseEnrolled[i].getGrade()){
                case 'A':sum+=courseEnrolled[i].getCredits()*4;
                break;
                case 'B':sum+=courseEnrolled[i].getCredits()*3;
                break;
                 case 'C':sum+=courseEnrolled[i].getCredits()*2;
                break;
                 case 'D':sum+=courseEnrolled[i].getCredits()*1;
                break;
                 case 'F':sum+=courseEnrolled[i].getCredits()*0;
                break;
                default:System.out.println("Invalid COurse Grade");
            }
        }
        return sum/getHoursEnrolled();
    }

   
}
public class Test1{
    public static void main(String[] args){
        
    }
}