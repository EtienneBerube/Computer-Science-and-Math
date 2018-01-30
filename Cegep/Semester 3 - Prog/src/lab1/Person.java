/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

/**
 *
 * @author Étienne Bérubé
 */
public class Person {

    
    private String name;
    private String address;
    private long phoneNumber;
    private String email;
    
    public Person(String name, String address, long phoneNumber, String email){
      this.name = name;
      this.address = address;
      this.email = email;
      this.phoneNumber = phoneNumber;
    }
    
    @Override
    public String toString(){
        return "Person: " + this.getName()+ "\nAddress: " + this.getAddress() + "\nPhone :" + this.getPhoneNumber() + "\nEmail: "+ this.getEmail();
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof Person){
           Person x = (Person)o;
            if(this.name.equals(x.getName()) && this.address.equals(x.getAddress()) && this.phoneNumber == x.getPhoneNumber() && this.email.equals(x.getEmail())){
                return true;
            }else
                return false;
        }else
            return false;
    }
    
    public String getName(){
        return name;
    }
    
    public String getAddress() {
        return address;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    
}
