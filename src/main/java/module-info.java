module com.example.javalabs.javaclientserverrandomarray {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javalabs.javaclientserverrandomarray to javafx.fxml;
    exports com.example.javalabs.javaclientserverrandomarray;
}