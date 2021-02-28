

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sukhadapradhan
 */
public class Mainrun {
    public static void main(String[] args){


        Patient p = new Patient();
        City c = new City();
        Community com = new Community();
        House house = new House();
//        VitalSigns newVitalSign = new VitalSigns();
        List<String> types= new ArrayList();
        types.add("heart rate");
        types.add("blood pressure");
        types.add("weight in kilos");
        types.add("weight in pounds");
        types.add("respiratory rate");
        Scanner in = new Scanner(System.in);
        
        System.out.println("Enter Patient name");
        p.setPatientName(in.nextLine());
        
        System.out.println("Enter city name");
        c.setCityName(in.nextLine());
        
        System.out.println("Enter community name");
        com.setCommunityName(in.nextLine());
        
        System.out.println("Enter house number");
        house.setHouseNum(in.nextInt());
        
        p.setCity(c);
        p.setCommunity(com);
        p.setHouse(house);
        
        setVitalSigns(in, p);
        
        while(true) {

            System.out.println();
            System.out.println("Press 1: View existing Details");
            System.out.println("Press 2: Check Vitalsigns");
            System.out.println("Press 4: Display history");
            System.out.println("Press 5: Check Blood Pressure");
            System.out.println("Press 3: Exit");
            
            int input = in.nextInt();
            if (input==1) {
                print(p,p.getVitalSigns());
//                setVitalSigns(in, p);
                //newVitalSign = newVitalSign(in);
            } else if (input==2) {
                for (int i = 0; i < types.size(); i++) {
                    String s = types.get(i);
                    System.out.println(i + " " + s);
                }
                int selection = in.nextInt();
                if (isThisVitalSignNormal(types.get(selection), p.getVitalSigns())) {
                 
                    System.out.println(types.get(selection) + " is Normal");
                }
                else{
                    System.out.println(types.get(selection) + " is AbNormal");
            }
            }
            else if(input == 3){
                System.exit(0);
            }
            else if(input == 4){
                
                displayHistory(p);
            }
            else if(input == 5){
               checkBpInCommunity(p);
            }
            }
        
        
        
    }

    private static void checkBpInCommunity(Patient p) {
        int abnormalBp = 0;
        if (!isThisVitalSignNormal("blood pressure", p.getVitalSigns())){
            abnormalBp++;
        }
        System.out.println(abnormalBp + " patient with abnormal bp is  in the community");
    }

    public static void displayHistory(Patient p){
        EncounterHistory enc = p.getHistory();
        
        for(Encounter encounter:enc.AL){
            System.out.println("Patient's Name: " + encounter.getPatient().getPatientName());
            System.out.println("Patient's City: " + encounter.getCity().getCityName());
            System.out.println("Patient's Community: " + encounter.getCommunity().getCommunityName());
            System.out.println("Heart Rate : " + encounter.getVitalsigns().getHeartRate());
            System.out.println("Respiratory rate is : " + encounter.getVitalsigns().getRespiratoryRate());
            System.out.println("Weight(in kgs.): " + encounter.getVitalsigns().getWeightInKilos());
            System.out.println("Weight(in pounds.): " + encounter.getVitalsigns().getWeightInPounds());
            System.out.println("Blood Pressure: " + encounter.getVitalsigns().getSystolicBloodPressure());
            System.out.println(" ");
            
        }
    }
    
//    private static void checkBP(Scanner scanner, CityList citylist){
//        System.out.println("Please Enter City name");
//        String cityName = scanner.next();
//        
//        City city = citylist.getCity(cityName);
//        
//        System.out.println("Enter the community name");
//        String comName = scanner.next();
//        Community community = city.getCommunity(comName);
//        
//        ArrayList<House>houselist = community.getHouseList();
//        int count = 0;
//        for(House flat: houselist){
//          ArrayList<Patient> patientList = flat.getPersonList();
//          for(Patient patient: patientList){
//              EncounterHistory enhis = patient.getHistory();
//              
//              for(Encounter encounter: enhis.AL){
//              VitalSigns visgns = encounter.getVitalsigns();
//              if(!(visgns.isBloodPressureNormal()))
//              }
//          
//          
//          }
//        }
//        
//        
//    
//    
//    
//    
//    
//    
//    
//    }
//    
    
    
    
     public static void setVitalSigns(Scanner in, Patient patient){
        System.out.println("Enter patient details");
        VitalSigns vitalSigns  = new VitalSigns();
        
        System.out.println("Age:");
        vitalSigns.setAge(in.nextFloat());
        
        System.out.println("Respiratory Rate:");
        vitalSigns.setRespiratoryRate(in.nextInt());
        
        System.out.println("Heart Rate:");
        vitalSigns.setHeartRate(in.nextInt());
        
        System.out.println("Blood Pressure:");
        vitalSigns.setSystolicBloodPressure(in.nextInt());
        
        System.out.println("Weight (in Kgs):");
        vitalSigns.setWeightInKilos(in.nextFloat());
        
        System.out.println("Weight (in Pounds):");
        vitalSigns.setWeightInPounds(in.nextFloat());
        

        if (isPatientNormal(vitalSigns))
        {
            System.out.println("Patient is Normal");
        }
        
        else {
            System.out.println("Patient is Abnormal");
           
        }
        System.out.println();
        
        Encounter enc = new Encounter();
        enc.setPatient(patient);
        enc.setVitalsigns(vitalSigns);
        enc.setCity(patient.city);
        enc.setCommunity(patient.community);
        enc.setHouse(patient.house);

        patient.getHistory().AL.add(enc);
        patient.setVitalSigns(vitalSigns);
        //vitalSignsHistory.add(vitalSigns);
        
         
    }
     
     public static void print(Patient p,VitalSigns newVitalSign)
    {
        System.out.println("");
        System.out.println("Patient Name" + " " + p.getPatientName());
        System.out.println("Heart Rate" + " " + newVitalSign.getHeartRate() );
        System.out.println("Age" + " " + newVitalSign.getAge());
        System.out.println("Respiratory Rate" + " " + newVitalSign.getRespiratoryRate());
        System.out.println("Blood Pressure" + " " + newVitalSign.getSystolicBloodPressure());
        System.out.println("Weight in kgs." + " " + newVitalSign. getWeightInKilos());
        System.out.println("Weight in pounds" + " " + newVitalSign.getWeightInPounds());
//         for (VitalSigns v:vitalSignsHistory){
//            System.out.println(+v.getHeartRate()+"           " + v.getAge()+ "       " + v.getRespiratoryRate()+ "      " +
//                    v.getSystolicBloodPressure() + "       " + v.getWeightInKilos() + "       " + v.getWeightInPounds());
//            
//        }
    }
     
     public static boolean isPatientNormal(VitalSigns vitalSigns)
    {
        if((vitalSigns.getAge()>=0 && vitalSigns.getAge()<0.83) &&
            (vitalSigns.getRespiratoryRate()>=30 && vitalSigns.getRespiratoryRate()<=50 ) &&
             (vitalSigns.getHeartRate()>=120 && vitalSigns.getHeartRate()<=160) &&
                (vitalSigns.getSystolicBloodPressure()>=50 && vitalSigns.getSystolicBloodPressure()<=70)&&
                (vitalSigns.getWeightInKilos()>=2 && vitalSigns.getWeightInKilos()<=3)&&
                (vitalSigns.getWeightInPounds()>=4.5 && vitalSigns.getWeightInPounds()<=7))
        
           
        {
            return true;
            
        }
       
        
       else if((vitalSigns.getAge()>=0.83 && vitalSigns.getAge()<1) &&
            (vitalSigns.getRespiratoryRate()>=20 && vitalSigns.getRespiratoryRate()<=30 ) &&
             (vitalSigns.getHeartRate()>=80 && vitalSigns.getHeartRate()<=140) &&
                (vitalSigns.getSystolicBloodPressure()>=70 && vitalSigns.getSystolicBloodPressure()<=100)&&
                (vitalSigns.getWeightInKilos()>=4 && vitalSigns.getWeightInKilos()<=10)&&
                (vitalSigns.getWeightInPounds()>=9 && vitalSigns.getWeightInPounds()<=22))
        {
            return true;
        }
        
        
       else if((vitalSigns.getAge()>=1 && vitalSigns.getAge()<3) &&
            (vitalSigns.getRespiratoryRate()>=20 && vitalSigns.getRespiratoryRate()<=30 ) &&
             (vitalSigns.getHeartRate()>=80 && vitalSigns.getHeartRate()<=130) &&
                (vitalSigns.getSystolicBloodPressure()>=80 && vitalSigns.getSystolicBloodPressure()<=110)&&
                (vitalSigns.getWeightInKilos()>=10 && vitalSigns.getWeightInKilos()<=14)&&
                (vitalSigns.getWeightInPounds()>=22 && vitalSigns.getWeightInPounds()<=31))
        {
            return true;
        }
        
       else if((vitalSigns.getAge()>=3 && vitalSigns.getAge()<6) &&
            (vitalSigns.getRespiratoryRate()>=20 && vitalSigns.getRespiratoryRate()<=30 ) &&
             (vitalSigns.getHeartRate()>=80 && vitalSigns.getHeartRate()<=120) &&
                (vitalSigns.getSystolicBloodPressure()>=80 && vitalSigns.getSystolicBloodPressure()<=110)&&
                (vitalSigns.getWeightInKilos()>=14 && vitalSigns.getWeightInKilos()<=18)&&
                (vitalSigns.getWeightInPounds()>=31 && vitalSigns.getWeightInPounds()<=40))
        {
            return true;
        }
        
       else if((vitalSigns.getAge()>=6 && vitalSigns.getAge()<12) &&
            (vitalSigns.getRespiratoryRate()>=20 && vitalSigns.getRespiratoryRate()<=30 ) &&
             (vitalSigns.getHeartRate()>=70 && vitalSigns.getHeartRate()<=110) &&
                (vitalSigns.getSystolicBloodPressure()>=80 && vitalSigns.getSystolicBloodPressure()<=120)&&
                (vitalSigns.getWeightInKilos()>=20 && vitalSigns.getWeightInKilos()<=42)&&
                (vitalSigns.getWeightInPounds()>=41 && vitalSigns.getWeightInPounds()<=92))
        {
            return true;
        }
        
       else if((vitalSigns.getAge()>=13 && vitalSigns.getAge()<1000) &&
            (vitalSigns.getRespiratoryRate()>=12 && vitalSigns.getRespiratoryRate()<=20 ) &&
             (vitalSigns.getHeartRate()>=55 && vitalSigns.getHeartRate()<=105) &&
                (vitalSigns.getSystolicBloodPressure()>=110 && vitalSigns.getSystolicBloodPressure()<=120)&&
                (vitalSigns.getWeightInKilos()>=50 && vitalSigns.getWeightInKilos()<=1000)&&
                (vitalSigns.getWeightInPounds()>=110 && vitalSigns.getWeightInPounds()<=2000))
        {
            return true;
        }
        
       else{
        return false;
       }
        
    }
    
     public static VitalSigns newVitalSign(Scanner in){
        VitalSigns vitalSigns = new VitalSigns();
        //setVitalSigns(vitalSigns, in, );
        return vitalSigns;
        
    }
     
     public static boolean isThisVitalSignNormal(String vsign, VitalSigns vitalSigns){
        switch (vsign) {
            case "respiratory rate":
                if((vitalSigns.getAge()>=6 && vitalSigns.getAge()<12) &&
            (vitalSigns.getRespiratoryRate()>=20 && vitalSigns.getRespiratoryRate()<=30 ))
                    return true;
                else  if((vitalSigns.getAge()>=0 && vitalSigns.getAge()<0.83) &&
            (vitalSigns.getRespiratoryRate()>=30 && vitalSigns.getRespiratoryRate()<=50 ))
                        return true;
                else if((vitalSigns.getAge()>=1 && vitalSigns.getAge()<3) &&
            (vitalSigns.getRespiratoryRate()>=20 && vitalSigns.getRespiratoryRate()<=30 ))
                    return true;
                 else if((vitalSigns.getAge()>=3 && vitalSigns.getAge()<5) &&
            (vitalSigns.getRespiratoryRate()>=20 && vitalSigns.getRespiratoryRate()<=30 ))
                     return true;
                 else if((vitalSigns.getAge()>=13 && vitalSigns.getAge()<1000) &&
            (vitalSigns.getRespiratoryRate()>=12 && vitalSigns.getRespiratoryRate()<=20 ))
                     return true;
                
                
                
                
                
                break;
            case "heart rate":
                 if((vitalSigns.getAge()>=0 && vitalSigns.getAge()<0.83) &&
           
             (vitalSigns.getHeartRate()>=120 && vitalSigns.getHeartRate()<=160))
                     return true;
                  else if((vitalSigns.getAge()>=0.83 && vitalSigns.getAge()<1) &&
                          (vitalSigns.getHeartRate()>=80 && vitalSigns.getHeartRate()<=140))
                      return true;
                  else if((vitalSigns.getAge()>=1 && vitalSigns.getAge()<3) &&
                           (vitalSigns.getHeartRate()>=80 && vitalSigns.getHeartRate()<=130))
                      return true;
                  else if((vitalSigns.getAge()>=3 && vitalSigns.getAge()<5) &&
                          (vitalSigns.getHeartRate()>=70 && vitalSigns.getHeartRate()<=110))
                      return true;
                  else if((vitalSigns.getAge()>=6 && vitalSigns.getAge()<12) &&
                      (vitalSigns.getHeartRate()>=70 && vitalSigns.getHeartRate()<=110))
                      return true;
                  else if((vitalSigns.getAge()>=13 && vitalSigns.getAge()<1000) &&
                          (vitalSigns.getHeartRate()>=55 && vitalSigns.getHeartRate()<=105))
                      return true;
                 
                     break;
            case "blood pressure":
                if((vitalSigns.getAge()>=0 && vitalSigns.getAge()<0.83) &&
                         (vitalSigns.getSystolicBloodPressure()>=50 && vitalSigns.getSystolicBloodPressure()<=70))
                 
                 return true;
                 else if((vitalSigns.getAge()>=0.83 && vitalSigns.getAge()<1) &&
                (vitalSigns.getSystolicBloodPressure()>=70 && vitalSigns.getSystolicBloodPressure()<=100))
                 
                 return true;
                  else if((vitalSigns.getAge()>=1 && vitalSigns.getAge()<3) &&
                          (vitalSigns.getSystolicBloodPressure()>=80 && vitalSigns.getSystolicBloodPressure()<=110))
                      return true;
                  else if((vitalSigns.getAge()>=3 && vitalSigns.getAge()<5) &&
                          (vitalSigns.getSystolicBloodPressure()>=80 && vitalSigns.getSystolicBloodPressure()<=110))
                      return true;
                 else if((vitalSigns.getAge()>=6 && vitalSigns.getAge()<12) &&
                 (vitalSigns.getSystolicBloodPressure()>=80 && vitalSigns.getSystolicBloodPressure()<=120))
                     return true;
                else if((vitalSigns.getAge()>=13 && vitalSigns.getAge()<1000) &&
                        (vitalSigns.getSystolicBloodPressure()>=110 && vitalSigns.getSystolicBloodPressure()<=120))
                    return true;
                
               
                 break;
            case "weight in kilos":
                if((vitalSigns.getAge()>=0 && vitalSigns.getAge()<0.83) &&
                         (vitalSigns.getWeightInKilos()>=2 && vitalSigns.getWeightInKilos()<=3))
                    return true;
                
                 else if((vitalSigns.getAge()>=0.83 && vitalSigns.getAge()<1) &&
             
                (vitalSigns.getWeightInKilos()>=4 && vitalSigns.getWeightInKilos()<=10))
                return true;
                 
                 else if((vitalSigns.getAge()>=1 && vitalSigns.getAge()<3) &&
           
             
                (vitalSigns.getWeightInKilos()>=10 && vitalSigns.getWeightInKilos()<=14))
                     return true;
                 
                 else if((vitalSigns.getAge()>=3 && vitalSigns.getAge()<6) &&
           
                (vitalSigns.getWeightInKilos()>=14 && vitalSigns.getWeightInKilos()<=18))
                     return true;
                else if((vitalSigns.getAge()>=6 && vitalSigns.getAge()<12) &&
          
                (vitalSigns.getWeightInKilos()>=20 && vitalSigns.getWeightInKilos()<=42))
                    return true;
                 else if((vitalSigns.getAge()>=13 && vitalSigns.getAge()<1000) &&
           
                (vitalSigns.getWeightInKilos()>=50 && vitalSigns.getWeightInKilos()<=1000))
                     return true;
                
                                 break;
            case "weight in pounds":

                 if((vitalSigns.getAge()>=0 && vitalSigns.getAge()<0.83) &&

                (vitalSigns.getWeightInPounds()>=4.5 && vitalSigns.getWeightInPounds()<=7))

           
        
            return true;
            
        
       
        
       else if((vitalSigns.getAge()>=0.83 && vitalSigns.getAge()<1) &&
            
                (vitalSigns.getWeightInPounds()>=9 && vitalSigns.getWeightInPounds()<=22))
        
            return true;
        
        
        
       else if((vitalSigns.getAge()>=1 && vitalSigns.getAge()<3) &&
           
                (vitalSigns.getWeightInPounds()>=22 && vitalSigns.getWeightInPounds()<=31))
        
            return true;
        
        
       else if((vitalSigns.getAge()>=3 && vitalSigns.getAge()<6) &&
           
                (vitalSigns.getWeightInPounds()>=31 && vitalSigns.getWeightInPounds()<=40))
        
            return true;
        
        
       else if((vitalSigns.getAge()>=6 && vitalSigns.getAge()<12) &&
            
                (vitalSigns.getWeightInPounds()>=41 && vitalSigns.getWeightInPounds()<=92))
        
            return true;
        
        
       else if((vitalSigns.getAge()>=13 && vitalSigns.getAge()<1000) &&
           
                (vitalSigns.getWeightInPounds()>=110 && vitalSigns.getWeightInPounds()<=2000))
        
            return true;
        
                
                
            default:
                return false;
        }
        return false;
    }
}
