/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.ihsan.protege;

import me.ihsan.*;
import me.ihsan.calculations.CalculateAcceleration;
import me.ihsan.calculations.CalculateBasalVariability;
import me.ihsan.calculations.CalculateBaseline;
import me.ihsan.calculations.CalculateFHRAvg;
/**
 *
 * @author ihsanyigitbasi
 */
public class SavePropertiesToOwl {
    
   
    
    public SavePropertiesToOwl()
    {
    CalculateBaseline cb = new CalculateBaseline();
        Double baseline = cb.getbaselinevalue();
        
        DataPropertyMethods dp = new DataPropertyMethods();
        dp.SaveDTPDouble("FH0001", "hasBazalRate", baseline);
        
        //
                
       CalculateBasalVariability bv = new CalculateBasalVariability();
       String Basalvar= bv.CalcBasalVar();
       DataPropertyMethods dp1 = new DataPropertyMethods();
        dp1.SaveDTPString("FH0001", "hasBazalVariability", Basalvar);
        
        CalculateFHRAvg fhr = new CalculateFHRAvg();
        double fhr5min = fhr.clct5min();
        double fhr10min = fhr.clct10min();
        double fhr20min = fhr.clct20mins();
             dp1.SaveDTPDouble("FH0001", "hasAverageHeartBeatper5Min", fhr5min);
            dp1.SaveDTPDouble("FH0001", "hasAverageHeartBeatper10Min", fhr10min);
            dp1.SaveDTPDouble("FH0001", "hasAverageHeartBeat", fhr20min);
    
            CalculateAcceleration ac = new CalculateAcceleration();
        String accel = ac.calculateacc();
        
        if (accel.equals("yes")) {
              
                    dp1.SaveDTPString("FH0001", "hasAcceleration", "Yes");
        }
}
    
}
