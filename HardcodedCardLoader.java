package finalproject;

public class HardcodedCardLoader implements CardLoader {
    @Override
    public FlashcardSet loadCards() {
        FlashcardSet set = new FlashcardSet();
        set.addCard(new Flashcard("What is the capital of France?", "Paris"));
        set.addCard(new Flashcard("What is 2 + 2?", "4"));
        set.addCard(new Flashcard("Who wrote 'Hamlet'?", "William Shakespeare"));
        return set;
    }
}
