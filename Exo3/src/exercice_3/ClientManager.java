package exercice_3;

import org.hibernate.Session;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.*;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class ClientManager {


  public static void payTable(Client client, double amount){
    System.out.println("paytable");
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    session.beginTransaction();
    Criteria placCrit = session.createCriteria(Placement.class);
    placCrit.add(Restrictions.eq("client", client));
    Placement placement = (Placement) placCrit.uniqueResult();

    if (placement == null){
      System.out.println("You did not have any table");
      return;
    }

    double total = getTotalTicket(getTicket(client));
    if (amount < total){
      System.out.println("not enough !");
      return;
    }

    Table table = placement.getTable();
    table.setFree(true);
    session.save(table);
    session.delete(placement);

    System.out.println("here is your change : " + (amount - total));


    session.getTransaction().commit();
  }

  public static void orderDrinks(Client client, HashMap<Drink,Integer> drinks){
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    session.beginTransaction();

    Order order = new Order();
    Client c = (Client) session.load(Client.class, client.getId());
    order.setClient(c);
    session.save(order);
    session.getTransaction().commit();

    session = HibernateUtil.getSessionFactory().getCurrentSession();
    session.beginTransaction();
    for (Drink d : drinks.keySet()){

      OrderedDrink newOrderedDrink = new OrderedDrink(order,d,drinks.get(d));
      session.save(newOrderedDrink);
    }

    session.getTransaction().commit();
  }

  public static void issueTicket(Client client){
    HashMap<Drink,Integer> drinks = getTicket(client);

    for (Map.Entry <Drink, Integer> entry : drinks.entrySet()){
      System.out.println("name : " +  entry.getKey().getName());
      System.out.println("qty " +  entry.getValue());
      System.out.println("price " + (entry.getKey().getPrice() * entry.getValue()));
    }
    System.out.println("Total :" + getTotalTicket(drinks));
  }

  public static HashMap<Drink,Integer> getTicket(Client client){
    HashMap<Drink,Integer> drinks = new HashMap<Drink,Integer>();

    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    session.beginTransaction();
    Criteria ordCrit = session.createCriteria(Order.class);
    ordCrit.add(Restrictions.eq("client", client));
    List<Order> orders = ordCrit.list();

    List<OrderedDrink> drinkList = new ArrayList<OrderedDrink>();
    for (Order order : orders){
      Criteria drinkCrit = session.createCriteria(OrderedDrink.class);
      drinkCrit.add(Restrictions.eq("order", order));
      drinkList.addAll(drinkCrit.list());
    }


    for (OrderedDrink d : drinkList){
      Integer qty = drinks.get(d.getDrink());
      if (qty != null){
             drinks.put(d.getDrink(),qty + d.getQty());
      }else{
	drinks.put(d.getDrink(),d.getQty()); 
	}
    }
    return drinks;
  }

  public static double getTotalTicket(HashMap<Drink,Integer> list){
    double price = 0.0;
    for (Map.Entry <Drink, Integer> entry : list.entrySet()){
      price = price + entry.getKey().getPrice() * entry.getValue();
    }
    return price;
  }




}
