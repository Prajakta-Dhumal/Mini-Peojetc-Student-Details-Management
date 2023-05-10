package domain2;

import javax.persistence.*;

@Entity
@Table(name = "acadmic_details")
public class AcadmicDetails
{
   @Id
   @Column(name = "acadmic_id")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int acdId;
   @Column(name = "teenth_per")
    private double teenthPer;
   @Column(name = "twelve_per")
    private double twelevePer;
   @Column(name = "degree_per")
    private double degreePer;
   @Column(name = "stream")
    private String stream;
   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "address_ref")
   private AddressDetails addressRef;

    public int getAcdId() {
        return acdId;
    }

    public void setAcdId(int acdId) {
        this.acdId = acdId;
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

    public AddressDetails getAddressRef()
    {
        return addressRef;
    }

    public void setAddressRef(AddressDetails addressRef) {
        this.addressRef = addressRef;
    }
}
