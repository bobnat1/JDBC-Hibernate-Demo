package jpa.entitymodels;

import javax.persistence.*;

@Entity
//@Table(name = "Course Table")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int dbid;
    @Column(name = "id")
    private int cId;
    @Column(name = "name")
    private String cName;
    @Column(name ="Instructor")
    private String cInstructorName;

    public Course() {
    }

    public Course(int cId, String cName, String cInstructorName) {
        this.cId = cId;
        this.cName = cName;
        this.cInstructorName = cInstructorName;
    }

    public int getcId() {

        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcInstructorName() {
        return cInstructorName;
    }

    public void setcInstructorName(String cInstructorName) {
        this.cInstructorName = cInstructorName;
    }

    public int getDbid() {
        return dbid;
    }
}
