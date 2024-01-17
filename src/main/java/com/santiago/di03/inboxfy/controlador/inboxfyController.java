package com.santiago.di03.inboxfy.controlador;

import com.santiago.di03.inboxfy.Escenario;
import com.santiago.di03.inboxfy.JavaFXUtil;
import com.santiago.di03.inboxfy.modelo.Email;
import com.santiago.di03.inboxfy.modelo.EmailRecibido;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.web.HTMLEditor;
import java.net.URL;
import java.util.ResourceBundle;

public class inboxfyController implements Initializable {

    /*===================== CAMPOS MIOS =====================*/
    private Escenario stage;

    /*===================== CAMPOS SCENEBUILDER =====================*/
    @javafx.fxml.FXML
    private MenuItem menuItemAbrir;
    @javafx.fxml.FXML
    private MenuItem menuItemGuardar;
    @javafx.fxml.FXML
    private MenuItem menuItemGuardarComo;
    @javafx.fxml.FXML
    private MenuItem menuItemImprimir;
    @javafx.fxml.FXML
    private MenuItem menuItemCerrar;
    @javafx.fxml.FXML
    private MenuItem menuItemSeleccionarTodo;
    @javafx.fxml.FXML
    private MenuItem menuItemCopiar;
    @javafx.fxml.FXML
    private MenuItem menuItemCortar;
    @javafx.fxml.FXML
    private MenuItem menuItemPegar;
    @javafx.fxml.FXML
    private MenuItem menuItemAcercaDe;
    @javafx.fxml.FXML
    private Button btnBuscar;
    @javafx.fxml.FXML
    private Button btnZoomAcercar;
    @javafx.fxml.FXML
    private Button btnZoomAlejar;
    @javafx.fxml.FXML
    private Button btnZoom100x100;
    @javafx.fxml.FXML
    private CheckBox checkBoxRegla;
    @javafx.fxml.FXML
    private CheckBox checkBoxBarraEstado;
    @javafx.fxml.FXML
    private ListView inboxListView;
    @javafx.fxml.FXML
    private Button btnNuevoEmail;
    @javafx.fxml.FXML
    private Button btnResponderEmail;
    @javafx.fxml.FXML
    private Button btnSincronizarEmails;
    @javafx.fxml.FXML
    private Button btnSincronizarSoloFavoritos;
    @javafx.fxml.FXML
    private HTMLEditor htmlEmailEditor;
    @javafx.fxml.FXML
    private Button btnBorrarEmail;
    @javafx.fxml.FXML
    private Button btnEnviar;
    @javafx.fxml.FXML
    private TextField txtRemitente;
    @javafx.fxml.FXML
    private TextField txtDestinatario;
    @javafx.fxml.FXML
    private TextField txtAsunto;
    @javafx.fxml.FXML
    private Button btnAdjuntarArchivos;

    /*===================== METODOS =====================*/
    public void setStage(Escenario stage) {
        this.stage = stage;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Carga elementos en la lista de emails y los asocia con un objeto EmailRecibido
        inboxListView.setItems(FXCollections.observableArrayList(
                new EmailRecibido("Asunto 1", "Contenido 1", "Destinatario 1", "Remitente 1", false, false),
                new EmailRecibido("Asunto 2", "Contenido 2", "Destinatario 2", "Remitente 2", false, false),
                new EmailRecibido("Asunto 3", "Contenido 3", "Destinatario 3", "Remitente 3", false, false),
                new EmailRecibido("Asunto 4", "Contenido 4", "Destinatario 4", "Remitente 4", false, false),
                new EmailRecibido("Asunto 5", "Contenido 5", "Destinatario 5", "Remitente 5", false, false)));


        // Configura la lista para permitir la selección de un solo elemento
        inboxListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        // Agrega un listener para manejar la selección de elementos en la lista
        inboxListView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        mostrarContenidoCorreo((EmailRecibido) newValue);
                    }
                }
        );
    }

    private void mostrarContenidoCorreo(EmailRecibido emailSeleccionado) {
    if (emailSeleccionado != null) {
        txtAsunto.setText(emailSeleccionado.getAsunto());
        txtRemitente.setText(emailSeleccionado.getRemitente());
        txtDestinatario.setText(emailSeleccionado.getDestinatario());
        htmlEmailEditor.setHtmlText(emailSeleccionado.getContenido());
    } else {
        // Si no hay correo seleccionado, borramos el contenido del área de visualización
        htmlEmailEditor.setHtmlText("");
        txtAsunto.setText("");
        txtRemitente.setText("");
        txtDestinatario.setText("");
    }
}

    @Deprecated
    public void btnNuevoEmail_onClicked(ActionEvent actionEvent) {

    }

    @javafx.fxml.FXML
    public void notImplemented_onClicked(ActionEvent actionEvent) {
        JavaFXUtil.alerta(Alert.AlertType.INFORMATION, "Funcionalidad no implementada", "Funcionalidad no implementada", "Esta funcionalidad no está implementada aún, pero se implementará en un futuro próximo", ButtonType.OK);
    }
}