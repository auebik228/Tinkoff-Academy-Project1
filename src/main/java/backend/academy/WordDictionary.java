package backend.academy;

import lombok.Getter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Getter public class WordDictionary {
    private final Map<String, List<String>> hardWords;
    private final Map<String, List<String>> mediumWords;
    private final Map<String, List<String>> easyWords;

    public WordDictionary() {
        hardWords = new HashMap<>();
        mediumWords = new HashMap<>();
        easyWords = new HashMap<>();

        // Заполняем словарь для сложных слов (Hard)
        hardWords.put("animals", List.of("elephant", "crocodile", "hippopotamus", "chimpanzee", "rhinoceros"));
        hardWords.put("fruits", List.of("pomegranate", "pineapple", "watermelon", "blackberry", "strawberry"));
        hardWords.put("countries", List.of("kazakhstan", "uzbekistan", "afghanistan", "turkmenistan", "kyrgyzstan"));

        // Заполняем словарь для средних слов (Medium)
        mediumWords.put("animals", List.of("tiger", "giraffe", "dolphin", "kangaroo", "penguin"));
        mediumWords.put("fruits", List.of("banana", "orange", "grape", "peach", "cherry"));
        mediumWords.put("countries", List.of("brazil", "canada", "mexico", "japan", "russia"));

        // Заполняем словарь для легких слов (Easy)
        easyWords.put("animals", List.of("cat", "dog", "fox", "cow", "bat"));
        easyWords.put("fruits", List.of("apple", "pear", "plum", "kiwi", "lime"));
        easyWords.put("countries", List.of("china", "india", "spain", "italy", "egypt"));
    }

    public String getRandomWord(String difficulty, String category) {
        Random random = new Random();
        Map<String, List<String>> chosenDictionary;

        if (difficulty.isEmpty()) {
            String[] difficulties = new String[] {"eazy", "medium", "hard"};
            difficulty = difficulties[random.nextInt(difficulties.length)];
        }
        switch (difficulty.toLowerCase()) {
            case "hard":
                chosenDictionary = hardWords;
                break;
            case "medium":
                chosenDictionary = mediumWords;
                break;
            case "easy":
                chosenDictionary = easyWords;
            default:
                chosenDictionary = easyWords;
                break;
        }

        List<String> wordList;
        if (category.isEmpty()) {
            Object[] categories = chosenDictionary.keySet().toArray();
            String categoryRandom = (String) categories[random.nextInt(categories.length)];
            wordList = chosenDictionary.get(categoryRandom);
        } else {
            wordList = chosenDictionary.get(category);
        }
        String word = wordList.get(random.nextInt(wordList.size()));
        return word;
    }

}