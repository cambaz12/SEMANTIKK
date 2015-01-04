/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.ihsan.protege;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ihsanyigitbasi
 */
public class cCc {
    public static void main(String[] args)
    {
        List<String> list = new ArrayList<String>();
    DataPropertyMethods dp =new DataPropertyMethods();
    dp.SaveDTPDouble("B0001", "FETALDEGERI", 1.3);
    
    ObjectTypePropertyMethods op = new ObjectTypePropertyMethods();
    list = op.getAnObjectProperty("F0001", "hasPatern");
   
    /*List<String> newstring = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++)
        {
          str= list.get(i).split("#");
            
        }
        for (int i = 0; i <str.length; i++) {
            System.out.println(str[i]);
            if (str[i].length() >0  ) {
                
                newstring.add(str[i].substring(0,str[i].length()-1));
            }
            
        }
        for (int i = 0; i < newstring.size(); i++) {
                System.out.println(newstring.get(i));
            }
        */
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
