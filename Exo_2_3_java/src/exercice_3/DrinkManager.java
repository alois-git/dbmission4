package exercice_3;

import org.hibernate.Session;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class DrinkManager {

  public static Drink getDrinkById(long id){
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    session.beginTransaction();
    Drink d = (Drink) session.load(Drink.class, id);
    session.getTransaction().commit();
    return d;
  }

}
