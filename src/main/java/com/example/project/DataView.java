
package com.example.project;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;

public class DataView extends JFrame {

    public DataView(String title) {
        super(title);
    }

    public static void main(String[] args) {
        
        String[] categories = new String[3];
        double[] values = new double[3];

        for (int i = 0; i < 3; i++) {
            categories[i] = JOptionPane.showInputDialog("Enter category name " + (i + 1) + ":");
            String valueInput = JOptionPane.showInputDialog("Enter value for category " + categories[i] + ":");
            values[i] = Double.parseDouble(valueInput);
        }

        // bar chart
        DefaultCategoryDataset barDataset = new DefaultCategoryDataset();
        for (int i = 0; i < 3; i++) {
            barDataset.addValue(values[i], "Category", categories[i]);
        }
        JFreeChart barChart = ChartFactory.createBarChart(
                "Bar Chart",
                "Category",
                "Value",
                barDataset
        );

        // pie chart
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        for (int i = 0; i < 3; i++) {
            pieDataset.setValue(categories[i], values[i]);
        }
        JFreeChart pieChart = ChartFactory.createPieChart(
                "Pie Chart",
                pieDataset,
                true,
                true,
                false
        );

        // line chart
        XYSeries lineSeries = new XYSeries("Line Chart Data");
        for (int i = 0; i < 3; i++) {
            lineSeries.add(i + 1, values[i]);
        }
        XYSeriesCollection lineDataset = new XYSeriesCollection(lineSeries);
        JFreeChart lineChart = ChartFactory.createXYLineChart(
                "Line Chart",
                "X",
                "Y",
                lineDataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        //all charts 
        JPanel chartPanel = new JPanel(new GridLayout(1, 3));
        chartPanel.add(new ChartPanel(barChart));
        chartPanel.add(new ChartPanel(pieChart));
        chartPanel.add(new ChartPanel(lineChart));

        // frame
        DataView project = new DataView("Data Visualization Project");
        project.setContentPane(chartPanel);
        project.setSize(1200, 600);
        project.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        project.setVisible(true);
    }
}
