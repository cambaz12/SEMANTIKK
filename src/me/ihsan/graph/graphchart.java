/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.ihsan.graph;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


/**
 *
 * @author ihsanyigitbasi
 */
public class graphchart extends javax.swing.JFrame  {
    static List<Integer> dataList = null;

    public graphchart() {
        initComponents();

    }

    public graphchart(List<Integer> dataList) {
        initComponents();
        this.dataList = dataList;
        
    }
    public void execute()
    {
        final JFreeChart chart = creatGraph();
        final ChartPanel panel = new ChartPanel(chart, true, true, true, false, true);
        panel.setPreferredSize(new java.awt.Dimension(1200, 600));
        setContentPane(panel);
        setSize(1200, 600);
        setVisible(true);
    }
    
    public static JFreeChart creatGraph() {
        XYSeries seri = new XYSeries("");

        for (int i = 0; i < dataList.size(); i++) {
            seri.add(i, dataList.get(i));
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(seri);

        JFreeChart chart = ChartFactory.createXYLineChart("Doppler Graphic", "Duration", "Heart Beat", dataset);

        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.white);

        
         
        try {
            ChartUtilities.saveChartAsJPEG(new File("C:\\chart.jpg"), chart, 1200, 600);
        } catch (IOException ex) {
            Logger.getLogger(graphchart.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chart;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.BorderLayout());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new graphchart().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    
    
}
