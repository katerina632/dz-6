import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] words = {" mama", "      ", "", null, "papa", "kaka", "dfdf_", "bla"};

        for (Character letter : getUniqueLettersFromStrings(words)) {
            System.out.printf("%s ", letter);
        }
    }

    public static Set<Character> getUniqueLettersFromStrings(String[] words) {

        List<String> wordsWithEvenLetters = new ArrayList<>();
        Set<Character> setOfUniqueLetters = new HashSet<>();


        for (String word : words) {

            if (word == null || word.replaceAll(" ", "").isEmpty()) {
                continue;
            }

            Map<Character, Integer> mapHelper = new HashMap<>();

            String wordWithoutSpace = word.replaceAll(" ", "");

            for (Character letter : wordWithoutSpace.toCharArray()) {
                if (mapHelper.containsKey(letter)) {
                    mapHelper.put(letter, mapHelper.get(letter) + 1);
                } else {
                    mapHelper.put(letter, 1);
                }
            }

            boolean isRightWord = true;
            List<Character> listOfChars = new ArrayList<>(mapHelper.keySet().stream().toList());
            int counter = 0;

            while (isRightWord && listOfChars.size() > counter) {
                isRightWord = mapHelper.get(listOfChars.get(counter++)) % 2 == 0;
            }

            if (isRightWord && wordsWithEvenLetters.size() < 2) {
                wordsWithEvenLetters.add(wordWithoutSpace);
            } else
                break;
        }

        for (int i = 0; i < wordsWithEvenLetters.size(); i++) {
            char[] letters = wordsWithEvenLetters.get(i).toCharArray();

            for (Character letter : letters) {
                setOfUniqueLetters.add(letter);
            }
        }
        return setOfUniqueLetters;
    }

}
