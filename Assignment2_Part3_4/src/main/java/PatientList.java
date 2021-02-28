
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
public class PatientList {
    private ArrayList<Patient>patientList;
    
    public PatientList(){
       patientList = new ArrayList<>();
    }
    
    public Patient getPatient(String name){
      for(Patient patient: patientList){
        if(patient.getPatientName().equalsIgnoreCase(name)){
           return patient;
        
        
        }
      }
      Patient newPatient = new Patient();
      newPatient.setPatientName(name);
      patientList.add(newPatient);
      return newPatient;
    }

    public void addPatient(Patient patient){
        patientList.add(patient);
    }
    
}
