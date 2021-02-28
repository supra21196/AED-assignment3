
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
public class City {
    private ArrayList<Community>communityDirec;
    private String comname;
    
    public City(){
        communityDirec = new ArrayList();
    }
    
    public String getCityName(){
        return comname;
    }
    
    public void setCityName(String name){
        this.comname = name;
    }
    
    public ArrayList<Community>getCommunityList(){
        
        return communityDirec;
    }    
        
    public void setCommunityList(ArrayList<Community>communitylist){
        this.communityDirec = communitylist;
    }    
        
    public Community getCommunity(String name){
        for(Community community:communityDirec){
            if(community.getCommunityName().equalsIgnoreCase(name)){
                return community;
            }
        }
        Community latest = new Community();
        latest.setCommunityName(name);
        communityDirec.add(latest);
        return latest;
    }

    Community getCommunity(Community community) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

