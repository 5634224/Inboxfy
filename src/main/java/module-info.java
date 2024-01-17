module com.santiago.di03.inboxfy {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires javax.mail.api;
    requires javafx.web;

    opens com.santiago.di03.inboxfy to javafx.fxml;
    exports com.santiago.di03.inboxfy;
    exports com.santiago.di03.inboxfy.controlador;
    opens com.santiago.di03.inboxfy.controlador to javafx.fxml;
}