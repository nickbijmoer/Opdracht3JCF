/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht3nickbart;

import java.util.ArrayList;

/**
 *
 * @author Bart
 */
public class School {
    
    private final String name;
    private final String city;
    private final ArrayList<Person> persons;
    
    public School(String Name, String City)
    {
        this.name = Name;
        this.city = City;
        persons = new ArrayList<Person>();
    }
    
    public void AddPerson(Person person)
    {
        persons.add(person);
    }
    
}
