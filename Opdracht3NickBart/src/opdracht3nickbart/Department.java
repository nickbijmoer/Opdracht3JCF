/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht3nickbart;

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
    
    public Department (String Name, String City)
    {
//        this.name = new SimpleStringProperty(Name);
//        this.city = new SimpleStringProperty(City);
        this.name = Name;
        this.city = City;
    }
    
    public String getDepartmentName()
    {
        return name;
    }
    
    public void setDepartmentName(String Name){
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
}
