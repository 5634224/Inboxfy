module com.santiago.di03.inboxfy {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.santiago.di03.inboxfy to javafx.fxml;
    exports com.santiago.di03.inboxfy;
}