package domain;

import javax.persistence.*;

@Entity
@Table(name = "student_details")

public class StudentDetails
{
    @Id
    @Column(name = "details_id")
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int detailsId;

    @Column(name = "10_per")
    private double teenthPer;
    @Column(name = "12_per")
    private double twelevePer;
    @Column(name = "degree_per")
    private double degreePer;
    @Column(name = "stream")
    private String stream;

    public int getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(int detailsId) {
        this.detailsId = detailsId;
    }

    public double getTeenthPer() {
        return teenthPer;
    }

    public void setTeenthPer(double teenthPer) {
        this.teenthPer = teenthPer;
    }

    public double getTwelevePer() {
        return twelevePer;
    }

    public void setTwelevePer(double twelevePer) {
        this.twelevePer = twelevePer;
    }

    public double getDegreePer() {
        return degreePer;
    }

    public void setDegreePer(double degreePer) {
        this.degreePer = degreePer;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public StudentDetails(int detailsId, double teenthPer, double twelevePer, double degreePer, String stream) {
        this.detailsId = detailsId;
        this.teenthPer = teenthPer;
        this.twelevePer = twelevePer;
        this.degreePer = degreePer;
        this.stream = stream;
    }

    public StudentDetails() {
    }

    @Override
    public String toString() {
        return "StudentDetails{" +
                "detailsId=" + detailsId +
                ", teenthPer=" + teenthPer +
                ", twelevePer=" + twelevePer +
                ", degreePer=" + degreePer +
                ", stream='" + stream + '\'' +
                '}';
    }
}
