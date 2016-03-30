/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht3nickbart;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Bart
 */
public class Department {
    
//    private final SimpleStringProperty name;
//    private final SimpleStringProperty city;
    private  String name;
    private  String city;
    private List<Employee> employees;
    
    public Department (String Name, String City, List<Employee> Employees)
    {
//        this.name = new SimpleStringProperty(Name);
//        this.city = new SimpleStringProperty(City);
        this.name = Name;
        this.city = City;
        employees = Employees;
    }
    
    public Department()
    {
        
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String Name){
        this.name = Name;
    }
    
    public String getCity()
    {
        return city;
    }
    
    public void setCity(String City)
    {
        this.city = City;
    }
    
     public void setEmployees(List<Employee> employees)
    {
        this.employees = employees;
    }
     
     public List<Employee> getEmployees()
     {
         return employees;
     }
     
     public void addEmployee(Employee employee)
     {
         employees.add(employee);
     }

    @Override
    public String toString() {
        return name;
    }
    
}
