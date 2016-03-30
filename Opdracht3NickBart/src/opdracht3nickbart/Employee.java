package opdracht3nickbart;

import javafx.beans.property.SimpleStringProperty;

 public class Employee {
 
        private final SimpleStringProperty firstName;
        private final SimpleStringProperty lastName;
        private final SimpleStringProperty email;
        private final SimpleStringProperty fullName;
//        private final SimpleStringProperty department;
 
        public Employee(String fName, String lName, String email) {
            this.firstName = new SimpleStringProperty(fName);
            this.lastName = new SimpleStringProperty(lName);
            this.email = new SimpleStringProperty(email);
          this.fullName = new SimpleStringProperty(fName + " " + lName);
        }
        
//        public Employee(String Name, String Department)
//        {
//            this.firstName = new SimpleStringProperty(Name);
//            this.department = new SimpleStringProperty(Department);
//            
//            this.lastName = new SimpleStringProperty("");
//            this.email = new SimpleStringProperty("");
//        }
 
        public String getFirstName() {
            return firstName.get();
        }
 
        public void setFirstName(String fName) {
            firstName.set(fName);
        }
        
//        public String getDepartment() {
//            return department.get();
//        }
// 
//        public void setDepartment(String Department) {
//            department.set(Department);
//        }
 
        public String getLastName() {
            return lastName.get();
        }
 
        public void setLastName(String fName) {
            lastName.set(fName);
        }
 
        public String getEmail() {
            return email.get();
        }
 
        public void setEmail(String fName) {
            email.set(fName);
        }
        
        public String getName()
    {
        return fullName.get();
    }
    
    public void setName(String Name){
        this.fullName.set(Name);
    }

    @Override
    public String toString() {
        return fullName.getValue();
    }
        
        
    
}