package com.easyquiz.controller;

/**
 * Created by felleuch on 01/02/2018.
 */
import javax.annotation.PostConstruct;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.*;

@ManagedBean
public class ChartController implements Serializable {

    private PieChartModel pieModel1;
    private PieChartModel pieModel2;
    private PieChartModel pieModel3;
    private PieChartModel pieModel4;

    private LineChartModel lineModel1;

    public LineChartModel getLineModel1() {
        return lineModel1;
    }

    public void setLineModel1(LineChartModel lineModel1) {
        this.lineModel1 = lineModel1;
    }

    public PieChartModel getPieModel1() {
        return pieModel1;
    }

    public void setPieModel1(PieChartModel pieModel1) {
        this.pieModel1 = pieModel1;
    }

    public PieChartModel getPieModel2() {
        return pieModel2;
    }

    public void setPieModel2(PieChartModel pieModel2) {
        this.pieModel2 = pieModel2;
    }

    public PieChartModel getPieModel3() {
        return pieModel3;
    }

    public void setPieModel3(PieChartModel pieModel3) {
        this.pieModel3 = pieModel3;
    }

    public PieChartModel getPieModel4() {
        return pieModel4;
    }

    public void setPieModel4(PieChartModel pieModel4) {
        this.pieModel4 = pieModel4;
    }

    @PostConstruct
    public void init() {
        createPieModels();
    }



    private void createPieModels() {
        createPieModel1();
        createPieModel2();
        createPieModel3();
        createPieModel4();


        lineModel1 = initLinearModel();
        lineModel1.setTitle("Statistique");
        lineModel1.setLegendPosition("e");
        lineModel1.getAxes().put(AxisType.X, new CategoryAxis("Tests"));
        Axis yAxis = lineModel1.getAxis(AxisType.Y);
        yAxis.setLabel("Résultat");
        yAxis.setMin(0);
        yAxis.setMax(10);


    }

    private LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();

        ChartSeries  series1 = new ChartSeries ();
        series1.setLabel("Informatique");

        series1.set("Test 1", 2);
        series1.set("Test 2", 1);
        series1.set("Test 3", 3);
        series1.set("Test 4", 6);
        series1.set("Test 5", 8);

        model.addSeries(series1);

        return model;
    }

    private void createPieModel1() {
        pieModel1 = new PieChartModel();

        pieModel1.set("JAVA", 540);
        pieModel1.set("SQL", 325);
        pieModel1.set("HTML/JavaScript", 702);
        pieModel1.set("Spring", 421);
        pieModel1.setShowDataLabels(true);

        pieModel1.setTitle("MOURAD");
        pieModel1.setLegendPosition("w");
    }


    private void createPieModel2() {
        pieModel2 = new PieChartModel();

        pieModel2.set("JAVA", 540);
        pieModel2.set("SQL", 325);
        pieModel2.set("HTML/JavaScript", 702);
        pieModel2.set("Spring", 421);
        pieModel2.setShowDataLabels(true);

        pieModel2.setTitle("Christophe");
        pieModel2.setLegendPosition("w");
    }



    private void createPieModel3() {
        pieModel3 = new PieChartModel();

        pieModel3.set("JAVA", 540);
        pieModel3.set("SQL", 325);
        pieModel3.set("HTML/JavaScript", 702);
        pieModel3.set("Spring", 421);
        pieModel3.setShowDataLabels(true);

        pieModel3.setTitle("Eric");
        pieModel3.setLegendPosition("w");
    }


    private void createPieModel4() {
        pieModel4 = new PieChartModel();

        pieModel4.set("JAVA", 540);
        pieModel4.set("SQL", 325);
        pieModel4.set("HTML/JavaScript", 702);
        pieModel4.set("Spring", 421);
        pieModel4.setShowDataLabels(true);

        pieModel4.setTitle("Florent");
        pieModel4.setLegendPosition("w");
    }




}