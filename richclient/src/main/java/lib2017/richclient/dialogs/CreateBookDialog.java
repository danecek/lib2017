package lib2017.richclient.dialogs;

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
import lib2017.richclient.LibStateObservable;
import lib2017.richclient.MainWindow;
import lib2017.utils.LibException;
import lib2017.utils.Messages;

public final class CreateBookDialog extends LibAbstractDialog {

    private TextField title;
    private TextField author;

    public CreateBookDialog() {
        setTitle(Messages.CREATE_BOOK.getMessage());
        getDialogPane().setContent(createContent());
        getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL, ButtonType.OK);
        validate();
    }

    protected Node createContent() {
        GridPane gb = new GridPane();
        gb.setPadding(new Insets(5));
        gb.setHgap(5);
        gb.setVgap(5);
        gb.add(new Label(Messages.AUTHOR.getMessage() + ":"), 0, 0);
        gb.add(author = createTF(), 1, 0);
        gb.add(new Label(Messages.TITLE.getMessage() + ":"), 0, 1);
        gb.add(title = createTF(), 1, 1);
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
            FacadeService.service().createBook(author.getText(), title.getText());
            LibStateObservable.instance.notif();
        } catch (LibException ex) {
            MainWindow.error(ex);
        }
    }

    @Override
    protected void validate() {
        StringBuilder sb = new StringBuilder();
        if (author.getText().isEmpty()) {
            sb.append(Messages.EMPTY_AUTHOR.getMessage());
        }
        if (title.getText().isEmpty()) {
            sb.append('\n' + Messages.EMPTY_TITLE.getMessage());
        }
        errorPane.setText(sb.toString());

    }

}
