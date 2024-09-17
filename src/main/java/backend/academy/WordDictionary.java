package backend.academy;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;

@Getter
public class WordDictionary {
    private final Map<String, List<String>> hardWords;
    private final Map<String, List<String>> mediumWords;
    private final Map<String, List<String>> easyWords;
    private final String animals = "animals";
    private final String fruits = "fruits";
    private final String countries = "countries";

    public WordDictionary() {
        hardWords = new HashMap<>();
        mediumWords = new HashMap<>();
        easyWords = new HashMap<>();

        hardWords.put(animals, List.of("elephant", "crocodile", "hippopotamus", "chimpanzee", "rhinoceros"));
        hardWords.put(fruits, List.of("pomegranate", "pineapple", "watermelon", "blackberry", "strawberry"));
        hardWords.put(countries, List.of("kazakhstan", "uzbekistan", "afghanistan", "turkmenistan", "kyrgyzstan"));

        mediumWords.put(animals, List.of("tiger", "giraffe", "dolphin", "kangaroo", "penguin"));
        mediumWords.put(fruits, List.of("banana", "orange", "grape", "peach", "cherry"));
        mediumWords.put(countries, List.of("brazil", "canada", "mexico", "japan", "russia"));

        easyWords.put(animals, List.of("cat", "dog", "fox", "cow", "bat"));
        easyWords.put(fruits, List.of("apple", "pear", "plum", "kiwi", "lime"));
        easyWords.put(countries, List.of("china", "india", "spain", "italy", "egypt"));
    }

    public String getRandomWord(DifficultyLevels difficulty, String category) {
        SecureRandom random = new SecureRandom();
        Map<String, List<String>> chosenDictionary;
        DifficultyLevels chosenDifficulty = difficulty;

        if (difficulty.equals(DifficultyLevels.NONE)) {
            DifficultyLevels[] difficulties = DifficultyLevels.values();
            chosenDifficulty = difficulties[random.nextInt(difficulties.length)];
        }

        switch (chosenDifficulty) {
            case HARD:
                chosenDictionary = hardWords;
                break;
            case MEDIUM:
                chosenDictionary = mediumWords;
                break;
            case EASY:
            default:
                chosenDictionary = easyWords;
                break;
        }

        List<String> wordList;
        if (category.equalsIgnoreCase("none")) {
            Object[] categories = chosenDictionary.keySet().toArray();
            String randomCategory = (String) categories[random.nextInt(categories.length)];
            wordList = chosenDictionary.get(randomCategory);
        } else {
            wordList = chosenDictionary.get(category);
        }

        return wordList.get(random.nextInt(wordList.size()));
    }
}
