package com.collectioncls;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//use of comparable
class Students implements Comparable<Students>{
	private int id;
	private String name;
	private int age;
	private String gender;
	private int yearofjoin;

	//constructor
	public Students() {
		
	}
	//parameterized constructor
	public Students(int id, String name,  int age, String gender, int yearofjoin) {
		this.id=id;
		this.name=name;
		this.age=age;
		this.gender=gender;
		this.yearofjoin=yearofjoin;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public int getYearofjoin() {
		return yearofjoin;
	}
	public void setYearofjoin(int yearofjoin) {
		this.yearofjoin = yearofjoin;
	}
	//setters and getters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	//toString method
	@Override
	public String toString() {
		return "Student [id="+ id+",name=" + name+ ", age="+ age+ ",gender=" +gender+", date="+yearofjoin+"]";
	}
	
//	@Override
//	public int compareTo(Students o) {
//		
//		return (this.date.getDate()-o.date.getDate());
//	
//	}
	
	
}

public class Work {
public static void main(String[] args) {
	List<Students> stdList= new ArrayList<>();
	
	stdList.add(new Students(4,"Alice",33,"Fem",2020));
	stdList.add(new Students(3,"Bob",35,"Male",2019));
	stdList.add(new Students(2,"Eve",30,"Male",2021));
	stdList.add(new Students(1,"Kavya",12,"Female",2012));
	System.out.println("before sorting data");
	stdList.forEach(emp-> System.out.println("ID:"+emp.getId()+"   Name:"+ emp.getName()+  "   Age:"+ emp.getAge()+ "   Gender:"+ emp.getGender()+ "   Date:"+ emp.getYearofjoin()));
	
	//sorting
	List<Students> frmtData= stdList.parallelStream()
			.sorted(Comparator.comparing(Students:: getId))
			.collect(Collectors.toList());
	System.out.println("After Sorting data");
	frmtData.forEach(emp-> System.out.println("ID:"+emp.getId()+"   Name:"+ emp.getName()+  "  Age:"+ emp.getAge()+"   Gender:"+ emp.getGender()+ "   Date:"+ emp.getYearofjoin()
	));
	//Students whose name start with A
	System.out.println("Employee whose name start with A");
	stdList.stream().filter(emp->emp.getName().startsWith("A")).forEach(emp->System.out.println("ID:"+emp.getId()+"   Name:"+ emp.getName()+  "  Age:"+ emp.getAge()+"   Gender:"+ emp.getGender()+ "   Date:"+ emp.getYearofjoin()));
	
	//to show who joined after 2020
	List<Students> joinedafter2020= stdList.stream().filter(emp->emp.getYearofjoin()>2020).collect(Collectors.toList());
	List<Students> sortedStudents= joinedafter2020.stream().sorted(Comparator.comparing(Students::getName)).collect(Collectors.toList());
	//printing the student values
System.out.println("Students join after 2020");
sortedStudents.forEach(System.out::println);
	
	

}
}

