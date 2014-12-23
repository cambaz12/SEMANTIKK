package me.ihsan.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ihsanyigitbasi
 */
import java.io.*;
import java.util.List;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.ChartUtilities; 

public class graphtry {
    
    public static void main(String [] args)
	{
	
     

}
    public void graphs(List<Integer> list)
    {
       try {
           DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
           
           for(int i=0;i<list.size();i++)
            {
                int second =1;
                String sst = "";
                sst=String.valueOf(second);
                System.out.println(" -->"+list.get(i));
                line_chart_dataset.addValue(list.get(i), "heartbeats", sst);
               second++;
                
                }
                
           
                /* Step -2:Define the JFreeChart object to create line chart */
                JFreeChart lineChartObject=ChartFactory.createLineChart("Doppler","Heartbeats","Time (Seconds)",line_chart_dataset,PlotOrientation.VERTICAL,true,true,false);                
                          
                /* Step -3 : Write line chart to a file */               
                 int width=1280; /* Width of the image */
                 int height=480; /* Height of the image */                
                 File lineChart=new File("line_Chart_example.png");              
                 ChartUtilities.saveChartAsPNG(lineChart,lineChartObject,width,height); 
         }
         catch (Exception i)
         {
             System.out.println(i);
         }      
         }}
