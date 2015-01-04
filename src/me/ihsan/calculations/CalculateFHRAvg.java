/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.ihsan.calculations;
import java.util.List;
import me.ihsan.gui.Main;

/**
 *
 * @author ihsanyigitbasi
 */
public class CalculateFHRAvg {
    private double FHR5minAvg;
    private double FHR10minAvg;
     private double FHR20minAvg;
    private double avg=0.0 ;
     private int beat=0;
     
     public double clct5min()
    {
        List<Integer> lst = Main.getList();
        for(int i=0;i<300;i++)
     {
         
         beat=beat+lst.get(i);
         
     }
        avg=beat/300;
    setFHR5minAvg(avg);
    return getFHR5minAvg();
    
    }
     public double clct10min()
    {
        List<Integer> lst = Main.getList();
        for(int i=0;i<600;i++)
     {
         
         beat=beat+lst.get(i);
         
     }
        avg=beat/600;
    setFHR10minAvg(avg);
    return getFHR10minAvg();
    
    }
    public double clct20mins()
    {
        List<Integer> lst = Main.getList();
        for(int i=0;i<lst.size();i++)
     {
         
         beat=beat+lst.get(i);
         
     }
        avg=beat/lst.size();
    setFHR20minAvg(avg);
    return getFHR20minAvg();
    
    }
   

    /**
     * @return the FHR5minAvg
     */
    public double getFHR5minAvg() {
        return FHR5minAvg;
    }

    /**
     * @param FHR5minAvg the FHR5minAvg to set
     */
    public void setFHR5minAvg(double FHR5minAvg) {
        this.FHR5minAvg = FHR5minAvg;
    }

    /**
     * @return the FHR10minAvg
     */
    public double getFHR10minAvg() {
        return FHR10minAvg;
    }

    /**
     * @param FHR10minAvg the FHR10minAvg to set
     */
    public void setFHR10minAvg(double FHR10minAvg) {
        this.FHR10minAvg = FHR10minAvg;
    }

    /**
     * @return the FHR20minAvg
     */
    public double getFHR20minAvg() {
        return FHR20minAvg;
    }

    /**
     * @param FHR20minAvg the FHR20minAvg to set
     */
    public void setFHR20minAvg(double FHR20minAvg) {
        this.FHR20minAvg = FHR20minAvg;
    }

    /**
     * @return the avg
     */
    public double getAvg() {
        return avg;
    }

    /**
     * @param avg the avg to set
     */
    public void setAvg(double avg) {
        this.avg = avg;
    }

    /**
     * @return the beat
     */
    public int getBeat() {
        return beat;
    }

    /**
     * @param beat the beat to set
     */
    public void setBeat(int beat) {
        this.beat = beat;
    }
    
}
