/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.ihsan.gui;

/**
 *
 * @author ihsanyigitbasi
 */
public class patientmodel {
    private String name ; 
    private int numberofbirth;
    private int cesarean;
    private String gender;
    private int week;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the numberofbirth
     */
    public int getNumberofbirth() {
        return numberofbirth;
    }

    /**
     * @param numberofbirth the numberofbirth to set
     */
    public void setNumberofbirth(int numberofbirth) {
        this.numberofbirth = numberofbirth;
    }

    /**
     * @return the cesarean
     */
    public int getCesarean() {
        return cesarean;
    }

    /**
     * @param cesarean the cesarean to set
     */
    public void setCesarean(int cesarean) {
        this.cesarean = cesarean;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the week
     */
    public int getWeek() {
        return week;
    }

    /**
     * @param week the week to set
     */
    public void setWeek(int week) {
        this.week = week;
    }
    
    
    
}
