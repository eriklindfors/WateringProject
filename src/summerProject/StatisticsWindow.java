package summerProject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

public class StatisticsWindow extends BaseWindow{

    private PieChart pieChart;
    private ObservableList<PieChart.Data> pieChartData;

    public StatisticsWindow(double width, double height){
        super(width, height);
        pieChartData = FXCollections.observableArrayList();
        pieChart = new PieChart(pieChartData);
        pieChart.setPrefWidth(width / 2);
        pieChart.setPrefHeight(height / 2);

        this.getChildren().add(pieChart);
    }

    public void addPieChartData(String name, double data){
        pieChartData.add(new PieChart.Data(name, data));
    }
}
