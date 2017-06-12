package summerProject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class StatisticsWindow extends BaseWindow{

    private WaterBarrel waterBarrel = new WaterBarrel();
    private TextField textField = new TextField("Percentage");
    private Button button = new Button("Set");

    public StatisticsWindow(double width, double height){
        super(width, height);

        //Barrel
        waterBarrel.setScaleX(0.5);
        waterBarrel.setScaleY(0.5);
        waterBarrel.setTranslateX(160);

        //TextField
        textField.setTranslateX(-100);
        textField.setMaxWidth(100);

        textField.setOnMouseClicked(e -> {
            textField.setText("");
        });

        //Button
        button.setOnMousePressed(e -> {
            int percentage = Integer.parseInt(textField.getText());
            if(percentage < 0 || percentage > 100){
                textField.setText("Invalid input!");
            }
            else{
                waterBarrel.setWaterLevel(Integer.parseInt(textField.getText()));
            }
        });

        this.getChildren().addAll(waterBarrel, textField, button);
    }
}
