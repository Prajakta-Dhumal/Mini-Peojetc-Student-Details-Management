package domain2;

import javax.persistence.*;

@Entity
@Table(name = "student_details2")
public class StudentDetails
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "s_name")
    private String sName;
    @Column(name = "email")
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "acadmic_ref")
    private AcadmicDetails acadmicRef;

    public StudentDetails() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AcadmicDetails getAcadmicRef() {
        return acadmicRef;
    }

    public void setAcadmicRef(AcadmicDetails acadmicRef) {
        this.acadmicRef = acadmicRef;
    }



}
