
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
public class Community {

    private ArrayList<House>houseList;
    private String name;
    
    public Community(){
        houseList = new ArrayList<House>();
    }
    
    public ArrayList<House> getHouseList(){
      return houseList;

    }
    
    public void setCityList(ArrayList<House> cityList){
       this.houseList = cityList;
    }
    
    public String getCommunityName(){
        return name;
    
    }
    public void setCommunityName(String name){
        this.name = name;
    }
    
    public House getHouse(int number){
        for(House house: houseList){
          if(house.getHouseNum() == number){
            return house;
        
        }
        
        }
        House newHouse = new House();
        newHouse.setHouseNum(number);
        houseList.add(newHouse);
        
        return newHouse;
    }
            
    
    
    
}
    