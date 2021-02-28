

import static java.lang.System.in;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Patient extends Person {
    
    EncounterHistory history;
    List<VitalSigns> vitalSignsHistory;
    VitalSigns vitalSigns;
    House house;
    City city;
    Community community;

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }
    static Scanner in = new Scanner(System.in);
    
    public Patient(){
        history = new EncounterHistory();
        vitalSignsHistory = new ArrayList<>();
        vitalSigns = new VitalSigns();
        
    }

    public EncounterHistory getHistory() {
        return history;
    }

    public void setHistory(EncounterHistory history) {
        this.history = history;
    }
    
    
    //MOve
   
    
    public String getPatientName(){
        return super.getPersonName();
 
    }
    
    public void setPatientName(String patientName) {
        super.setPersonName(patientName);
    //this.patientName = patientName;
    }

    public VitalSigns getVitalSigns() {
        return vitalSigns;
    }

    public void setVitalSigns(VitalSigns vitalSigns) {
        this.vitalSigns = vitalSigns;
    }


    //Move
    
    
    //Move
    
    
    //Mian
    
    
    //Main
    
    


}

   
    
    

