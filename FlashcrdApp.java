package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.*;

public class FlashcardApp extends Application {

    private FlashcardSet flashcardSet;
    private Flashcard currentCard;
    private Label questionLabel;
    private Label answerLabel;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        CardLoader loader = new HardcodedCardLoader();
        flashcardSet = loader.loadCards();
        currentCard = flashcardSet.getNextCard();

        questionLabel = new Label(currentCard.getQuestion());
        answerLabel = new Label();
        Button showAnswerButton = new Button("Show Answer");
        Button nextButton = new Button("Next");

        showAnswerButton.setOnAction(e -> answerLabel.setText(currentCard.getAnswer()));
        nextButton.setOnAction(e -> {
            currentCard = flashcardSet.getNextCard();
            questionLabel.setText(currentCard.getQuestion());
            answerLabel.setText("");
        });

        VBox layout = new VBox(10, questionLabel, answerLabel, showAnswerButton, nextButton);
        Scene scene = new Scene(layout, 400, 200);

        primaryStage.setTitle("Flashcard Quiz App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
