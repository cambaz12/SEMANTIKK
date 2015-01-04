/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.ihsan.calculations;

import java.util.ArrayList;
import java.util.List;
import me.ihsan.*;
import me.ihsan.gui.Main;
import me.ihsan.gui.Patient;
/**
 *
 * @author ihsanyigitbasi
 */
public class CalculateAcceleration {
    
    int week;
    int firstmin;
    int secondmin;
    int onsetvalue=0;
    int peakvalue=0;
    int accelcounter=0;
    double baseline=0;
    int peakvalueInd=0;
    String accel="no";
    
    public String calculateacc() {
         Patient u = new Patient();
        week = u.week;
        CalculateBaseline b=new CalculateBaseline();
        baseline =b.getbaselinevalue();
        List<Integer> lst = Main.getList();
         List<Integer> tenminlist = new ArrayList();
         List<Integer> nexttenminlist = new ArrayList();
         List<Integer> twominlist = new ArrayList();
         
         for (int i = 0; i < 600; i++)
         {
         tenminlist.add(lst.get(i));
             
        }
         for (int i = 601; i < lst.size(); i++)
         {
         nexttenminlist.add(lst.get(i));
             
        }
         for (int i = 0; i < 8; i++) {
            firstmin=i ;
            secondmin=i+2;
             for (int j = i*60; j < secondmin*60; j++)
             {
                 twominlist.add(tenminlist.get(i));
             }
             onsetvalue=twominlist.get(0);
             for (int j = 0; j < twominlist.size(); j++) {
                 if (peakvalue<twominlist.get(i)) 
                 {
                     peakvalue=twominlist.get(i);
                 }
             }
             if (((peakvalue-onsetvalue)>=15)&(week>=32)&(baseline>15) ) {
                 accelcounter++;
             }
             else if (((peakvalue-onsetvalue)>=10)&(week<=32)&(baseline>10) ) {
                  accelcounter++;
             }
                  
            
            
        }
         for (int i = 0; i < 8; i++) {
            firstmin=i ;
            secondmin=i+2;
             for (int j = i*60; j < secondmin*60; j++)
             {
                 twominlist.add(nexttenminlist.get(i));
             }
             onsetvalue=twominlist.get(0);
             for (int j = 0; j < twominlist.size(); j++) {
                 if (peakvalue<twominlist.get(i)) 
                 {
                     peakvalue=twominlist.get(i);
                 }
             }
             if (((peakvalue-onsetvalue)>=15)&(week>=32)&(baseline>15) ) {
                 accelcounter++;
             }
             else if (((peakvalue-onsetvalue)>=10)&(week<=32)&(baseline>10) ) {
                 accelcounter++;
             }
                  
            
            
        }
         
         if (accelcounter>0) {
             accel="yes";
            
        }
       /*  onsetvalue=tenminlist.get(0);
         peakvalue=0;
        for (int i = 0; i < tenminlist.size(); i++) {
            if (peakvalue<tenminlist.get(i)) 
            {
             peakvalue=tenminlist.get(i);
             peakvalueInd=i;
            }            
            
            
        }*/
      //uzamıs akselerasyon , bazal hız değişimi bulanabilmesi için 2. bir değere ihtiyaç var.
        
         return accel;
        }

    }

