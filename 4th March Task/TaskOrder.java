package com.hmaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class Order{
	private int id;
	private String category;
	private int price;
	private String city;
	private int yearoforder;
	private String month;
	private int qty;
	
public Order() {
		
	}
	
	public Order(int id, String category, int price, String city, int yearoforder, String month, int qty) {
		super();
		this.id = id;
		this.category = category;
		this.price = price;
		this.city = city;
		this.yearoforder = yearoforder;
		this.month = month;
		this.qty=qty;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getYearoforder() {
		return yearoforder;
	}
	public void setYearoforder(int yearoforder) {
		this.yearoforder = yearoforder;
	}
	
	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}
	

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", category=" + category + ", price=" + price + ", city=" + city + ", yearoforder="
				+ yearoforder + ", month=" + month + ", qty=" + qty + "]";
	}

	
	
	
	
	
}

public class TaskOrder {
	
	//1. Highest order in year

	
	public static void getHighestOrder(List<Order> orderList) {
		
		
		Map<Integer,Order> highestorder= orderList.stream().collect(Collectors.toMap(Order:: getYearoforder,Order->Order,(o1,o2)->
		o1.getQty()>o2.getQty()?o1:o2));
		highestorder.forEach((yearoforder ,Order)->System.out.println("Year-of-Order:"+ yearoforder+ "  Category: "+Order.getCategory()+ "  "
				+ "Quantity:"+ Order.getQty()));

}
	//2. category-wise order count

	public static void getCountOfOrder(List<Order> OrderList) {
		Map<String, Long> result= OrderList.stream()
				               .collect(Collectors.groupingBy(Order::getCategory, 
				            		   Collectors.counting()));
		System.out.println(result);
		
		
	}
	
	
//3 Maximum price among all Orders
	public static void maxPrice(List<Order> OrderList) {
		Optional<Order> maxOrder= OrderList.stream()
				                .max(Comparator.comparing(Order:: getPrice));
	            
		Order orderData= maxOrder.get();
		System.out.println("Name: "+orderData.getCategory());
		System.out.println("Price: "+orderData.getPrice());
		System.out.println("Quantity: "+orderData.getQty());
		
	}
	//4 monthly  average spending
	public static void getMonthlyAverageSpending(List<Order> orderList) {
        Map<String, Double> monthlyAvgSpending = orderList.stream()
            .collect(Collectors.groupingBy(Order::getMonth, 
                Collectors.averagingDouble(order -> order.getPrice() * order.getQty())));
        
        monthlyAvgSpending.forEach((month, avgSpending) -> 
            System.out.println("Month: " + month + "  Average Spending: " + avgSpending));
    }
    
	
	//5 minimum order price among all orders
	public static void minPrice(List<Order> OrderList) {
		Optional<Order> minOrder= OrderList.stream()
				                .min(Comparator.comparing(Order:: getPrice));
	            
		Order orderData= minOrder.get();
		System.out.println("Name: "+orderData.getCategory());
		System.out.println("Price: "+orderData.getPrice());
		System.out.println("Quantity: "+orderData.getQty());
		
	}
	
	//6 First  Purchasing order 
	public static void getFirstOrder(List<Order> OrderList) {
		Optional<Order> firstorder=  
				OrderList.stream()
                         .sorted(Comparator.comparing(Order::getYearoforder)) 
                 .findFirst();
		Order orderData= firstorder.get();
		System.out.println("First Puchased Order: ");
		System.out.println("=======================");
		System.out.println("Name: "+ orderData.getCategory());
		System.out.println("Year of Order: "+ orderData.getYearoforder());


		
	}
	
	
	
	
	
		
	
	
	public static void main(String[] args) {
		List<Order> orderList= new ArrayList<>();
		orderList.add(new Order(10,"Badminton",1000,"Pune",2011,"December",10));
		orderList.add(new Order(11,"Shuttle",500,"Pune",2013,"March",20));
		orderList.add(new Order(12,"BasketBall",2500,"Mumbai",2021,"November",12));
		orderList.add(new Order(13,"FootBall",100,"Delhi",2010,"September",11));
		orderList.add(new Order(14,"BasketBall",1390,"Chennai",2023,"July",5));
		orderList.add(new Order(15,"Bat",1200,"Pune",2011,"June",3));
		orderList.add(new Order(16,"Volleyball",200,"Hyderabad",2009,"July",2));
		orderList.add(new Order(17,"Ludo",200,"Goa",2012,"April",5));
		orderList.add(new Order(18,"Badminton",500,"Pune",2011,"June",23));
		orderList.add(new Order(19,"Stick",1000,"Pune",2011,"May",15));
		
		TaskOrder.getHighestOrder(orderList); //1
		TaskOrder.getCountOfOrder(orderList); //2
		TaskOrder.maxPrice(orderList); //3
		TaskOrder.getMonthlyAverageSpending(orderList); //4
		TaskOrder.minPrice(orderList); //5
		TaskOrder.getFirstOrder(orderList); //6
		
		
		
		
	};

}
