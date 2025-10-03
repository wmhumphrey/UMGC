module com.example.project3test {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.project3test to javafx.fxml;
    exports com.example.project3test;
}