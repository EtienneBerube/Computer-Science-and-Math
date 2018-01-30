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
public class Student extends Person{
    private int status;
    public final static int FRESHMAN = 1;
    public final static int SOPHOMORE = 2;
    public final static int JUNIOR = 3;
    public final static int SENIOR = 4;
    
    public Student(String name, String address, long phoneNumber, String email, int status){
        super(name, address, phoneNumber, email);
        this.status = status;
    }
    public String getStatus(){
        switch(status){
            case 1: return "Freshman";
            case 2: return "Sophomore";
            case 3: return "Junior";
            case 4: return "Senior";
            default: return "Default";
        }
    }

    public void setStatus(int status) {
        this.status = status;
    }
    

    @Override
    public String toString(){
        return "Student: " + this.getName() +"\nStatus: " + this.getStatus() + "\nAddress: " + this.getAddress() + "\nPhone :" + this.getPhoneNumber() + "\nEmail: "+ this.getEmail();
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof Student){
            Student x = (Student)o;
            if(super.equals(x) && this.getStatus().equals(x.getStatus())){
                return true;
            }else
                return false;
        }else{
            return false;
        }
    }
    
}
