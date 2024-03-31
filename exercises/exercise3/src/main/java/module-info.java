module org.example.exercise3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.exercise3 to javafx.fxml;
    exports org.example.exercise3;
}