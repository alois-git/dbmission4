package exercice_3;

import org.hibernate.Session;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class TableManager {

	public static Client sitAtTable(long tablebarcode){
		try {

			// get the table from the database
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Table table = (Table) session.load(Table.class, tablebarcode);

			// check if the table we want is free
			if (!table.isFree()){
				System.out.println("sorry table already taken");
				return null;
			}

			// if the table is free , create a new client and set the table to taken

			Client client = new Client();
			session.save(client);
			session.getTransaction().commit();

			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			table.setFree(false);
			session.update(table);
			Placement placement = new Placement(table,client);
			session.save(placement);
			session.getTransaction().commit();
			return client;

		}catch (Exception ex){
			throw new ExceptionInInitializerError(ex);
		}
	}

}
