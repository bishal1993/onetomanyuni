import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainClass {
public static void main(String [] args){

System.out.println("Project started.....");
   SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Person.class).addAnnotatedClass(Pet.class).buildSessionFactory();
      Session session = sessionFactory.openSession();


    Person bishal = new Person("bishal","maharjan");


    Person bikram = new Person("Bikram","Maharjan");

    Pet pet1 = new Pet();
    Pet pet2 = new Pet();
    Pet pet3 = new Pet();
    Pet pet4 = new Pet();
    Pet pet5 = new Pet();

    Pet pet6 = new Pet();
    Pet pet7 = new Pet();
    Pet pet8 = new Pet();
    Pet pet9 = new Pet();
    Pet pet10 = new Pet();


    bikram.add(pet6);
    bikram.add(pet7);
    bikram.add(pet8);
    bikram.add(pet9);
    bikram.add(pet10);



    bishal.add(pet1);
    bishal.add(pet2);
    bishal.add(pet3);
    bishal.add(pet4);
    bishal.add(pet5);
    System.out.println("list is "+bishal.getPets().size());
   try{




       session.beginTransaction();

      // Person deletePerson = session.get(Person.class,2);
       //session.delete(deletePerson);


      Pet deletePet = session.get(Pet.class,12);
       session.delete(deletePet);

       //session.save(bishal);



       session.getTransaction().commit();
       System.out.println(" ...Done!.....");

   } catch (Exception ex){
    System.out.println("Error...."+ex.getLocalizedMessage());

   } finally {
    sessionFactory.close();
    session.close();
   }



    System.out.println("deleted....");

}

}
