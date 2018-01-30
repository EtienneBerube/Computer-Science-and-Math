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
public class Staff extends Employee{
    private String title;
  
    
    public Staff(String name, String address, long phoneNumber, String email, String title, int salary, String office){
        
        super( name, address,phoneNumber,email, salary, office);
        
        this.title = title;
    }
    
    @Override
    public String toString(){
        return "Staff: " + this.getName() +"\nTitle: "+ title +"\nAddress: " + this.getAddress() + "\nPhone :" + this.getPhoneNumber() + "\nEmail: "+ this.getEmail()+ "\nDate hired"+this.getDateHired() +"\nOffice: " + this.getOffice() + "\nSalary: " + this.getSalary() + "$";
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof Staff){
            Staff x = (Staff)o;
            
            if(super.equals(x) && this.title.equals(x.getTitle())){
                return true;
            }else
                return false;
        }else{
            return false;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    
}
