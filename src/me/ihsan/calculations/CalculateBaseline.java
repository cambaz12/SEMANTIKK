/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.ihsan.calculations;
import java.util.ArrayList;
import java.util.List;
import me.ihsan.gui.Main;

/**
 *
 * @author ihsanyigitbasi
 */
public class CalculateBaseline {
    
    List<Integer> lst = Main.getList();
    List<Integer> dopplerlst = new ArrayList();
    double avg=0.0;
    int bigvalues=0;        
    
   private double getbaselinevalue()
   {
       for(int i=0;i<600;i++)
       {
           if(1<=i && lst.get(i)-lst.get(i-1)==5)
           {
               dopplerlst.add(lst.get(i));
               bigvalues=bigvalues+lst.get(i);
               
            }
       }
       avg=bigvalues/dopplerlst.size();
       return avg;
       
   }
}
