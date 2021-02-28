
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
public class CityList {
    private ArrayList<City> cityList;
    
    public CityList(){
     cityList = new ArrayList<>();
    
    }
    
    public City getCity(String name){
      
       for(City city: cityList){
         if(city.getCityName().equalsIgnoreCase(name)){
             return city;
         }
       }
       City newCity = new City();
       newCity.setCityName(name);
       cityList.add(newCity);
       return newCity;
    }
}
