package org.imcs.MyMavenProjectTest.HibernateDemo.pojo;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {
	public static void main(String[] args) throws ParseException {

		

		/*
		 * SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); java.util.Date
		 * myDate1 = sdf.parse("1993-03-10"); java.util.Date myDate2 =
		 * sdf.parse("1992-12-03");
		 */
		LocalDate myDate = LocalDate.of(1993, 03, 10);
		LocalDate shippingDate = myDate.plusDays(10);
		LocalDate deliveryDate = shippingDate.plusDays(3);

		Product product = new Product("engineOil", "AutoZone", "used for engine", 30);
		List<Product> productDetails = new ArrayList<>();
		productDetails.add(product);

		List<Order> orderDetails = new ArrayList<>();
		
		Order order = new Order(myDate, "got your order", shippingDate, deliveryDate);
		orderDetails.add(order);
		order.setProductDetails(productDetails);
		OrderDao orderDao = new OrderDao();
		Address address = new Address("dayton", "ohio", "peppertree", "US");
		Customer customer = new Customer("sandeep", 250000);
		customer.setAddress(address);
		customer.setOrder(orderDetails);
		order.setCustomer(customer);
		order.setMonth(12);
		order.setMonth(3);
		
		
		CustomerDao customerDao = new CustomerDao();
		
		customerDao.addCustomer(customer);
		orderDao.addOrder(order);
		customerDao.loadCustomer(customer.getPersonId());
		customerDao.updateCustomer(customer);
		
		orderDao.loadOrder(order.getOrderNumber());
		orderDao.updateOrder(order);
		/* orderDao.deleteOrder(order.getOrderNumber()); */
		// customerDao.deleteCustomer(customer.getPersonId());
		
		//getting results between particular dates
		orderDao.setStartDate(myDate);
		orderDao.setEndDate(deliveryDate);
		orderDao.orderByRangeDates();
		//orderDao.orderByMonth();

	}
}
