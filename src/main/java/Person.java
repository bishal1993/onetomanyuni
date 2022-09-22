import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/**
 * .
 * A Person can not exist without passport,and also passport without person.
 *
 */
@Entity
@Table(name="person")
public class Person {


    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;



    /**
     * One to One uni direction relation from Person to Passport.
     * If person is deleted, passport will also be deleted and vice versa.
     * passport_id_number is column in Person, which contains foreign key fpr table Passport.
     */
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="person_tax_Number")
    private List<Pet> pets;

    @Id
    @Column(name="tax_number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taxNumber;


    public Person() {
    }


    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    /**
     *taxnumber is auto generated.thats why we dont give it manually.
     * @param firstName is first name of Person
     * @param lastName is last name of Passport
     */
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.taxNumber = taxNumber;
    }

    public String getName() {
        return firstName;
    }

    public void setName(String firstName) {
        this.firstName = firstName;
    }


    public  void add(Pet pet){

        if(pets==null){
            this.pets = new ArrayList<>();
        }
        pets.add(pet);


    }


    public int getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(int taxNumber) {
        this.taxNumber = taxNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", passport=" + pets +
                ", taxNumber=" + taxNumber +
                '}';
    }
}
