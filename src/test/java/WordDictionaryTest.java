import backend.academy.WordDictionary;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WordDictionaryTest {

    private WordDictionary wordDictionary;

    @Before
    public void setUp() {
        wordDictionary = new WordDictionary();
    }

    @Test
    public void testGetRandomWordEasyAndAnimals() {
        String word = wordDictionary.getRandomWord("easy", "animals");
        assertNotNull(word, "Слово не должно быть null");
        assertTrue(
            wordDictionary.easyWords().get("animals").contains(word),
            "Слово должно быть из категории 'animals' и легкого уровня");
    }

    @Test
    public void testGetRandomWordMediumAndFruits() {
        String word = wordDictionary.getRandomWord("medium", "fruits");
        assertNotNull(word, "Слово не должно быть null");
        assertTrue(
            wordDictionary.mediumWords().get("fruits").contains(word),
            "Слово должно быть из категории 'fruits' и среднего уровня");
    }

    @Test
    public void testGetRandomWordHardAndCountries() {
        String word = wordDictionary.getRandomWord("hard", "countries");
        assertNotNull(word, "Слово не должно быть null");
        assertTrue(
            wordDictionary.hardWords().get("countries").contains(word),
            "Слово должно быть из категории 'countries' и сложного уровня");
    }

}
