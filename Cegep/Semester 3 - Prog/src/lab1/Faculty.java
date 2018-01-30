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
public class Faculty extends Employee{
    
    private String rank;
    private String officeHours;
    
    public Faculty(String name, String address, long phoneNumber, String email, String Rank, String officeHours, int salary, String office){
        
        super( name, address,phoneNumber,email, salary, office);
        
        this.officeHours = officeHours;
        this.rank = rank;
    }
    
    @Override
    public String toString(){
        return "Faculty: " + this.getName() +"\nRank: "+ rank +"\nAddress: " + this.getAddress() + "\nPhone :" + this.getPhoneNumber() + "\nEmail: "+ this.getEmail() + "\nOffice hours: "+officeHours + "\nDate hired"+this.getDateHired() +"\nOffice: " + this.getOffice() + "\nSalary: " + this.getSalary() + "$";
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof Faculty){
            Faculty x = (Faculty)o;
            
            if(super.equals(x) && this.officeHours.equals(x.getOfficeHours()) && this.rank.equals(x.getRank())){
                return true;
            }else
                return false;
        }else{
            return false;
        }
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }
    
    
}
