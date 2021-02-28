
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sukhadapradhan
 */
public class House {
    
    ArrayList<Patient>personList;
    int HouseNum;

    
    public House(){
        
      personList = new ArrayList<>();
    
    }
    
    public ArrayList<Patient>getPersonList(){
       return personList;
    }
    
    public void setPersonList(ArrayList<Patient>personList){
      this.personList = personList;
    }
    
    public int getHouseNum() {
        return HouseNum;
    }

    public void setHouseNum(int HouseNum) {
        this.HouseNum = HouseNum;
    }
    
    
    
}
