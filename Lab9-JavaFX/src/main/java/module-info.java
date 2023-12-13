module com.example.lab9javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab9javafx to javafx.fxml;
    exports com.example.lab9javafx;
}