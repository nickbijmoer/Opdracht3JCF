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
    
    private final SimpleStringProperty name;
    private final SimpleStringProperty city;
    
    public Department (String Name, String City)
    {
        this.name = new SimpleStringProperty(Name);
        this.city = new SimpleStringProperty(City);
    }
    
    public String getDepartmentName()
    {
        return name.get();
    }
    
    public void setDepartmentName(String Name){
        this.name.set(Name);
    }
    
    public String getCity()
    {
        return name.get();
    }
    
    public void setCity(String City)
    {
        this.city.set(City);
    }
    
    
}
