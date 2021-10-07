import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TemperatureConverterGUI extends Application {

    public void start(Stage stage) {

        Button convertButton = new Button();
        convertButton.setText("Convert");

        ComboBox<String> pickScaleFrom = new ComboBox();
        ComboBox<String> pickScaleTo = new ComboBox();

        pickScaleFrom.getItems().addAll("Fahrenheit", "Celcius");
        pickScaleTo.getItems().addAll("Fahrenheit", "Celcius");

        pickScaleFrom.getSelectionModel().selectFirst();
        pickScaleTo.getSelectionModel().selectLast();

        Label from = new Label("From:");
        Label to = new Label("To:");

        TextField userInput = new TextField();
        Label inputValue = new Label("Input value: ");
        Label result = new Label();

        convertButton.setOnAction(event -> {
            String temperatureString = userInput.getCharacters().toString();
            try {
                double temperature = Double.parseDouble(temperatureString);
                String scaleFrom = pickScaleFrom.getValue();
                String scaleTo = pickScaleTo.getValue();
                double conversionResult = convert(scaleFrom, scaleTo, temperature);
                result.setText(String.format("%.2f", conversionResult));
            } catch (NumberFormatException e) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("Error");
                a.setHeaderText("Invalid Temperature");
                a.setContentText("That is not a valid temperature.");
                a.showAndWait();
            }
        });

        HBox input = new HBox();
        input.setAlignment(Pos.CENTER);
        input.getChildren().addAll(inputValue, userInput);

        HBox scales = new HBox();
        scales.setAlignment(Pos.CENTER);
        scales.getChildren().addAll(from, pickScaleFrom, to, pickScaleTo);

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        root.getChildren().addAll(input, scales, convertButton, result);

        Scene scene = new Scene(root, 400, 400);
        stage.setTitle("Temperature Converter");
        stage.setScene(scene);
        stage.show();
    }

    private double convert(String from, String to, double value) {
        double converted = 0;
        if (from.equals(to)) {
            converted = value;
        } else if (from.charAt(0) == 'F') {
            converted = (value - 32) * (5D / 9);
        } else {
            converted = value * (9D / 5) + 32;
        }
        return converted;
    }
}
