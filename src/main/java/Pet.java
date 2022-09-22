import javax.persistence.*;

@Entity
@Table(name="pet")
public class Pet {

    @Id
    @Column(name="id_number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNumber;

    /**
     * Many to One direction. deleting pet will not delete Person.
     */

    @ManyToOne
    private Person person;

    public Person getPerson() {
        return person;
    }


    public Pet() {
    }

    

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "idNumber=" + idNumber +
                '}';
    }
}
