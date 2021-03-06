package Program;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.*;

/**
 * ConfirmBox alert class.
 * @author Mika Kaur
 * @version 12_16_2015
 */
public class ConfirmBox {

    /**
     * User's answer
     */
    static boolean answer;

    /**
     * Displays the confirm box prompt.
     *
     * @param title title of the prompt
     * @param message message to the user
     * @return the user's choice yes/no
     */
    public static boolean display(String title, String message) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        Label label = new Label(message);
        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");

        yesButton.setOnAction(e -> {
            answer = true;
            window.close();
        });

        noButton.setOnAction(e -> {
            answer = false;
            window.close();
        });

        HBox layout1 = new HBox(10);
        layout1.getChildren().addAll(yesButton, noButton);
        layout1.setAlignment(Pos.CENTER);

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, layout1);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);

        // Set minimum size and don't allow resizing
        window.setMinHeight(100);
        window.setMinWidth(300);
        window.setResizable(false);

        window.showAndWait();

        return answer;

    }

}
