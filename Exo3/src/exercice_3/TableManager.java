package exercice_3;

import org.hibernate.Session;

import java.util.Date;
import java.util.List;

public class TableManager {

	public static void createAndStoreTable(int id) {

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		session.beginTransaction();

		Table table = new Table(id);

		session.save(table);

		session.getTransaction().commit();

		HibernateUtil.getSessionFactory().close();
	}

	public List<Table> getTables(){

                try{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();

		session.beginTransaction();

		List result = session.createQuery("from Table").list();

		session.getTransaction().commit();

		return result;
                }catch(Exception ex){
                   throw new ExceptionInInitializerError(ex);
                   //return null;
                }

	}

}
