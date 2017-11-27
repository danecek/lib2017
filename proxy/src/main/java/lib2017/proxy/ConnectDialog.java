package lib2017.proxy;

import lib2017.richclient.LibAbstractDialog;
import java.util.Optional;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import lib2017.business.FacadeService;
import lib2017.connection.Connection;
import lib2017.richclient.LibStateObservable;
import lib2017.richclient.MainWindow;
import lib2017.utils.LibException;
import lib2017.utils.Messages;

public final class ConnectDialog extends LibAbstractDialog {

    private TextField host;
    private TextField portTf;
    int port;

    public ConnectDialog() {
        setTitle(Messages.CONNECT.getMessage());
        getDialogPane().setContent(createContent());
        getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL, ButtonType.OK);
        validate();
    }

    protected Node createContent() {
        GridPane gb = new GridPane();
        gb.setPadding(new Insets(5));
        gb.setHgap(5);
        gb.setVgap(5);
        gb.add(new Label(Messages.HOST.getMessage() + ":"), 0, 0);
        gb.add(portTf = createTF(), 1, 0);
        portTf.setText("3333");
        gb.add(new Label(Messages.PORT.getMessage() + ":"), 0, 1);
        gb.add(host = createTF(), 1, 1);
        host.setText("host");
        return new VBox(gb, errorPane);
    }

    public void execute() {
        try {
            Optional<ButtonType> bt = showAndWait();
            if (!bt.isPresent()) {
                return;
            }
            if (bt.get() == ButtonType.CANCEL) {
                return;
            }
            Connection.instance.connect(portTf.getText(), port);
            LibStateObservable.instance.notif();
        } catch (LibException ex) {
            MainWindow.error(ex);
        }
    }

    @Override
    protected void validate() {
        StringBuilder sb = new StringBuilder();
        try {
            port = Integer.valueOf(portTf.getText());
        } catch (NumberFormatException ex) {

            sb.append(Messages.EMPTY_AUTHOR.getMessage());
        }
        if (host.getText().isEmpty()) {
            sb.append('\n' + Messages.EMPTY_TITLE.getMessage());
        }
        errorPane.setText(sb.toString());

    }

}
