package Emp;
//Creating Employee class
class EmployeeDetails {
//Creating properties of Employee class
int emp_id, salary ,experience;
String firstname, lastname, designation;
//Getter and setters for getting and setting properties
public int getEmp_id() {
return emp_id;
}
public void setEmp_id(int emp_id) {
this.emp_id = emp_id;
}
public int getSalary() {
return salary;
}
public void setSalary(int salary) {
this.salary = salary;
}
public int getExperience() {
return experience;
}
public void setExperience(int experience) {
this.experience = experience;
}
public String getfirstname() {
return firstname;
}
public void setfirstName(String firstname) {
this.firstname = firstname;
}
public String getLastname() {
return lastname;
}
public void setLastName(String lastname) {
this.lastname = lastname;
}
public String getDesignation() {
return designation;
}
public void setDesignation(String designation) {
this.designation = designation;
}
//Overriding toString() method
@Override
public String toString() {
return "Employee [emp_id= " +emp_id + ",firstname = " + firstname + ", lastname = " + lastname + ", experience =" +experience+ " , designation = " + designation+ ",salary = "+salary+"]";
}
}
//Creating main class
public class Emp{
//main() method start
public static void main(String args[]) {
//Creating object of EmployeeDetails class
EmployeeDetails emp = new EmployeeDetails();
//Setting values to the properties
emp.setEmp_id(101);
emp.setfirstName("Tom");
emp.setLastName("Deel");
emp.setExperience(4);
emp.setDesignation("Senior Software Engineer");
emp.setSalary(60000);
//Showing Employee details
System.out.println(emp);
//Getting salary using getter
int experience = emp.getExperience();
int sal=emp.getSalary();
int increment = 0;
//Incrementing salary based on condition
if ((experience>=3))
{
//incrementing salary 10%
increment += (sal * 10)/100;
sal = sal+increment;
emp.setSalary(sal);
System.out.println("\n Salary is incremented \n");
System.out.println(emp);
}else if ((experience >=5)){
//incrementing salary 20%
increment += (sal * 20/100);
sal = sal+increment;
emp.setSalary(sal);
System.out.println("\n Salary is incremented \n");
System.out.println(emp);
}else {
System.out.println("\n Salary is not incremented \n");
System.out.println(emp);
}
}
}


