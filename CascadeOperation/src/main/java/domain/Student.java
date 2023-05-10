package domain;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student
{
    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    @Column(name = "sname")
    private String sName;

    @Column(name = "email_id")
    private String emailId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_ref")
    private StudentDetails studentRef;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public StudentDetails getStudentRef() {
        return studentRef;
    }

    public void setStudentRef(StudentDetails studentRef) {
        this.studentRef = studentRef;
    }

    public Student(int studentId, String sName, String emailId, StudentDetails studentRef) {
        this.studentId = studentId;
        this.sName = sName;
        this.emailId = emailId;
        this.studentRef = studentRef;
    }

    public Student() {
    }
}
