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
public class Employee extends Person{
    private MyDate dateHired = new MyDate();
    private int salary = 0;
    private String office = "";
    
    public Employee(String name, String address, long phoneNumber, String email, int salary, String Office){
        super( name, address, phoneNumber,email);
        this.salary = salary;
        this.office = office;
    }
    
    public String getDateHired(){
        return dateHired.getDate();
    }

    public void setDateHired(MyDate dateHired) {
        this.dateHired = dateHired;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }
   
    
    @Override
    public String toString(){
        return "Employee: " + this.getName()+ "\nAddress: " + this.getAddress() + "\nPhone :" + this.getPhoneNumber() + "\nEmail: "+ this.getEmail() +"\nOffice: " + this.getOffice() + "\nSalary: " + this.getSalary() + "$";
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof Employee){
            Employee x = (Employee)o;
            
            if(super.equals(x) && this.getDateHired().equals(x.getDateHired()) && (this.getSalary() == ((Employee) o).getSalary()) && (this.getOffice().equals(((Employee) o).getOffice()))){
                return true;
            }else
                return false;
        }else{
            return false;
        }
    }
}
