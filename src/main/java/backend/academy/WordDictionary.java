package backend.academy;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;

@Getter
public class WordDictionary {
    private final Map<String, List<WordWithHint>> hardWords;
    private final Map<String, List<WordWithHint>> mediumWords;
    private final Map<String, List<WordWithHint>> easyWords;
    private final String animals = "animals";
    private final String fruits = "fruits";
    private final String countries = "countries";

    public WordDictionary() {
        hardWords = new HashMap<>();
        mediumWords = new HashMap<>();
        easyWords = new HashMap<>();

        hardWords.put(animals, List.of(
            new WordWithHint("elephant", "Самое крупное наземное млекопитающее."),
            new WordWithHint("crocodile", "Рептилия с длинным хвостом и мощными челюстями."),
            new WordWithHint("hippopotamus", "Полуводное животное с толстым кожным покровом."),
            new WordWithHint("chimpanzee", "Наш ближайший родственник среди приматов."),
            new WordWithHint("rhinoceros", "Животное с одним или двумя рогами на носу.")
        ));

        hardWords.put(fruits, List.of(
            new WordWithHint("pomegranate", "Фрукт с множеством сочных семян внутри."),
            new WordWithHint("pineapple", "Тропический фрукт с жесткой кожурой и короной листьев."),
            new WordWithHint("watermelon", "Большой сочный фрукт с красной мякотью и черными семенами."),
            new WordWithHint("blackberry", "Малиновый ягода с темным окрасом и множеством семян."),
            new WordWithHint("strawberry", "Ягода с ярко-красной кожурой и мелкими семенами на поверхности.")
        ));

        hardWords.put(countries, List.of(
            new WordWithHint("kazakhstan", "Страна, самая большая по площади в Центральной Азии."),
            new WordWithHint("uzbekistan", "Страна, известная своими древними городами на Шёлковом пути."),
            new WordWithHint("afghanistan", "Страна в Южной Азии, известная своей гористой местностью."),
            new WordWithHint("turkmenistan", "Страна с одним из крупнейших газовых резервов в мире."),
            new WordWithHint("kyrgyzstan", "Страна, окруженная горами Тянь-Шань.")
        ));

        mediumWords.put(animals, List.of(
            new WordWithHint("tiger", "Хищное животное с полосатой шкурой."),
            new WordWithHint("giraffe", "Самое высокое наземное животное."),
            new WordWithHint("dolphin", "Морской млекопитающий, известный своей интеллигентностью."),
            new WordWithHint("kangaroo", "Сумчатое животное, обитающее в Австралии."),
            new WordWithHint("penguin", "Нелетающая птица, обитающая в холодных регионах.")
        ));

        mediumWords.put(fruits, List.of(
            new WordWithHint("banana", "Длинный желтый фрукт, богатый калием."),
            new WordWithHint("orange", "Цитрусовый фрукт, известный своим высоким содержанием витамина C."),
            new WordWithHint("grape", "Маленький сочный фрукт, используется для виноделия."),
            new WordWithHint("peach", "Сладкий фрукт с бархатистой кожурой и косточкой внутри."),
            new WordWithHint("cherry", "Маленький красный или черный фрукт, часто используемый в десертах.")
        ));

        mediumWords.put(countries, List.of(
            new WordWithHint("brazil", "Страна с самым большим участком тропических лесов в мире."),
            new WordWithHint("canada", "Страна, простирающаяся от Атлантического до Тихого океанов."),
            new WordWithHint("mexico", "Страна, известная своей богатой культурой и историей."),
            new WordWithHint("japan", "Островная страна, известная своими технологиями и традициями."),
            new WordWithHint("russia", "Самая большая страна в мире по площади.")
        ));

        easyWords.put(animals, List.of(
            new WordWithHint("cat", "Домашнее пушистое животное."),
            new WordWithHint("dog", "Лучший друг человека."),
            new WordWithHint("fox", "Хитрое животное с рыжей шкурой."),
            new WordWithHint("cow", "Животное, дающее молоко."),
            new WordWithHint("bat", "Летучее млекопитающее.")
        ));

        easyWords.put(fruits, List.of(
            new WordWithHint("apple", "Круглый фрукт, часто используемый в пирогах."),
            new WordWithHint("pear", "Фрукт с грушевидной формой и сладкой мякотью."),
            new WordWithHint("plum", "Маленький фрукт с гладкой кожурой и сочной мякотью."),
            new WordWithHint("kiwi", "Маленький коричневый фрукт с зеленой мякотью и черными семенами."),
            new WordWithHint("lime", "Маленький зеленый цитрусовый фрукт с кислым вкусом.")
        ));

        easyWords.put(countries, List.of(
            new WordWithHint("china", "Страна с самым большим населением в мире."),
            new WordWithHint("india", "Страна, известная своей разнообразной культурой и историей."),
            new WordWithHint("spain", "Страна на Пиренейском полуострове в Европе."),
            new WordWithHint("italy", "Страна, известная своими историческими городами и кухней."),
            new WordWithHint("egypt", "Страна, где находятся пирамиды и река Нил.")
        ));
    }

    public WordWithHint getRandomWord(DifficultyLevels difficulty, String category) {
        SecureRandom random = new SecureRandom();
        Map<String, List<WordWithHint>> chosenDictionary;
        DifficultyLevels chosenDifficulty = difficulty;

        if (difficulty.equals(DifficultyLevels.NONE)) {
            DifficultyLevels[] difficulties = {DifficultyLevels.EASY, DifficultyLevels.MEDIUM, DifficultyLevels.HARD};
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

        List<WordWithHint> wordList;
        if (category.equalsIgnoreCase("none")) {
            Object[] categories = chosenDictionary.keySet().toArray();
            String randomCategory = (String) categories[random.nextInt(categories.length)];
            wordList = chosenDictionary.get(randomCategory);
        } else {
            wordList = chosenDictionary.get(category);
            if (wordList == null || wordList.isEmpty()) { // Обработка неверной категории
                Object[] categories = chosenDictionary.keySet().toArray();
                String randomCategory = (String) categories[random.nextInt(categories.length)];
                wordList = chosenDictionary.get(randomCategory);
            }
        }

        WordWithHint selectedWord = wordList.get(random.nextInt(wordList.size()));
        return selectedWord;
    }
}
