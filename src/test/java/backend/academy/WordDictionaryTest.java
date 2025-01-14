package backend.academy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WordDictionaryTest {

    private WordDictionary wordDictionary;

    @BeforeEach
    public void setUp() {
        wordDictionary = new WordDictionary();
    }

    @Test
    public void testGetRandomWordEasyAndAnimals() {
        WordWithHint word = wordDictionary.getRandomWord(DifficultyLevels.EASY, "animals");
        assertNotNull(word, "Слово не должно быть null");
        assertTrue(
            wordDictionary.easyWords().get("animals").contains(word),
            "Слово должно быть из категории 'animals' и легкого уровня");
    }

    @Test
    public void testGetRandomWordMediumAndFruits() {
       WordWithHint word = wordDictionary.getRandomWord(DifficultyLevels.MEDIUM, "fruits");
        assertNotNull(word, "Слово не должно быть null");
        assertTrue(
            wordDictionary.mediumWords().get("fruits").contains(word),
            "Слово должно быть из категории 'fruits' и среднего уровня");
    }

    @Test
    public void testGetRandomWordHardAndCountries() {
        WordWithHint word = wordDictionary.getRandomWord(DifficultyLevels.HARD, "countries");
        assertNotNull(word, "Слово не должно быть null");
        assertTrue(
            wordDictionary.hardWords().get("countries").contains(word),
            "Слово должно быть из категории 'countries' и сложного уровня");
    }

    @Test
    public void testGetRandomWordRandomDifficultyAndRandomCategory() {
        WordWithHint word = wordDictionary.getRandomWord(DifficultyLevels.NONE, "none");
        assertNotNull(word, "Слово не должно быть null");
        assertTrue(
            wordDictionary.hardWords().get("countries").contains(word) ||
                wordDictionary.hardWords().get("animals").contains(word) ||
                wordDictionary.hardWords().get("fruits").contains(word) ||
                wordDictionary.easyWords().get("countries").contains(word) ||
                wordDictionary.easyWords().get("animals").contains(word) ||
                wordDictionary.easyWords().get("fruits").contains(word) ||
                wordDictionary.mediumWords().get("countries").contains(word) ||
                wordDictionary.mediumWords().get("animals").contains(word) ||
                wordDictionary.mediumWords().get("fruits").contains(word));
    }

}
