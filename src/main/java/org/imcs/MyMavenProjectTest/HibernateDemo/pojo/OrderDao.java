package org.imcs.MyMavenProjectTest.HibernateDemo.pojo;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.imcs.MyMavenProjectTest.HibernateDemo.Util.CustomerUtil;

public class OrderDao {

	SessionFactory sf;
	List<Order> list = null;
	private LocalDate startDate;
	private LocalDate endDate;

	public OrderDao() {
		sf = CustomerUtil.getSessionFactory();
	}

	public boolean addOrder(Order order) {
		Session session = sf.openSession();
		session.getTransaction().begin();
		session.save(order);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	public boolean deleteOrder(int order_Number) {
		sf = CustomerUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		Order order = (Order) session.load(Order.class, order_Number);
		session.delete(order);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	public boolean updateOrder(Order order) {
		sf = CustomerUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.update(order);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	public boolean loadOrder(int order_Number) {
		sf = CustomerUtil.getSessionFactory();
		Session session = sf.openSession();
		session.getTransaction().begin();
		Order ss = (Order) session.get(Order.class, order_Number);
		return true;
	}

	public void orderByRangeDates() {
		sf = CustomerUtil.getSessionFactory();
		Session session = sf.openSession();
		int pageNumber = 1;
		int pageSize = 2;
		try {
			session.beginTransaction();
			Criteria criteria = session.createCriteria(Order.class)
					.add(Restrictions.between("orderDate", getStartDate(), getEndDate()));
			criteria.setFirstResult((pageNumber - 1) * pageSize);
			criteria.setMaxResults(pageSize);

			List<Order> listOfOrders = criteria.list();
			if (listOfOrders != null) {
				System.out.println("Total Results:" + listOfOrders.size());
				for (Order od : listOfOrders) {
					System.out.println(od.getOrderNumber() + " " + od.getStatus());
				}
			}else {
				System.out.println("No entries found between the given dates");
			}
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void orderByMonth() {
		sf = CustomerUtil.getSessionFactory();
		Session session = sf.openSession();
		LocalDate myDate = LocalDate.of(1993, 01, 1);
		
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Product.class);
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.sum("priceEach"));
		projectionList.add(Projections.groupProperty("month"));
		
		criteria.setProjection(projectionList);
		List listOfOrders = criteria.list();
		if (listOfOrders != null) {
			System.out.println("Total Results:" + listOfOrders.size());
			for (Object od : listOfOrders) {
				System.out.println(((Order) od).getOrderNumber() + " " + ((Order) od).getStatus());
			}
		}else {
			System.out.println("No entries found between the given dates");
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		
		
		

		
	}
}
