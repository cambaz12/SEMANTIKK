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
public class CalculateBasalVariability {
    
    List<Integer> lst = Main.getList();
    List<Integer> min10List=new ArrayList();
    List<Integer> next10List=new ArrayList();
    int max=0; 
    int maxIndex=0;
    int Nmax=0; 
    int NmaxIndex=0;
    private String CalcBasalVar()
    { 
        
        String BasalVar="";
        
       for(int i=0;i<600;i++)
     {
         
         min10List.add(lst.get(i));
        
     }
       
       for(int i=600;i<lst.size();i++)
     {
         
         next10List.add(lst.get(i));
        
     }
        for(int i=0;i<min10List.size();i++)
     {
         
         if(min10List.get(i)>max)
         {
             max=min10List.get(i);
                     maxIndex=i;
         }
        
     }
    
        for(int i=0;i<next10List.size();i++)
     {
         
         if(next10List.get(i)>Nmax)
         {
             Nmax=next10List.get(i);
                     NmaxIndex=i;
         }
        
     }
    
    
    return BasalVar;
    }
    
}
