package cpe200;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {

    public Student() {
        this("","",1990,false);
    }

    public Student(String n) {
        this.name = n;
    }

    public Student(String n, String id) {
        this.name = n;
        this.student_id = id;
    }

    public Student(String n, String id, int yob) {
        this.name = n;
        this.student_id = id;
        this.year_of_birth = yob;
    }

    public Student(String n, String id, int yob, boolean a) {
        this.name = !n.equalsIgnoreCase("")?n:"John Doe";
        this.student_id = isValidStudent_id(id)?id:"560610000";
        this.year_of_birth = isValidYOB(yob)?yob:1990;
        this.active = a;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = !name.equalsIgnoreCase("")?name:this.name;
    }

    public String getStudent_id() {
        return this.student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = isValidStudent_id(student_id)?student_id:this.student_id;
    }

    public int getYearOfBirth() {
        return this.year_of_birth;
    }

    public void setYearOfBirth(int year_of_birth) {
        this.year_of_birth = isValidYOB(year_of_birth)?year_of_birth:this.year_of_birth;
    }

    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        String o = this.name + " ("
                + this.student_id + ") was born in "
                + this.year_of_birth + " is an ";

        if(this.active)
        {
            o += "ACTIVE student.";
        }
        else
        {
            o += "INACTIVE student.";
        }

        return o;
    }

    private boolean isValidStudent_id(String id) {
        Pattern p = Pattern.compile(idREGEX);
        Matcher m = p.matcher(id);

        return m.matches();
    }

    private boolean isValidYOB(int yob) {
        return (yob>1989);
    }

    //Regular expression for the student id
    private static final String idREGEX = "5+[6-9]+061+[0-2]+\\d{3}";

    // all private attributes
    private String name;
    private String student_id;
    private int year_of_birth;
    private boolean active;

}
