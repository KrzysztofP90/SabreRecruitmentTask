package com.krzysztof.SabreRecruitmentTask;

import java.util.*;
import java.util.stream.Stream;

public class LetterToWordIndexer {

    private Map<Character, List<String>> letterWordMap;

    public LetterToWordIndexer(String text) {
        this.letterWordMap = new TreeMap<>();
        initialMap(text);
    }

    public Map<Character, List<String>> getLetterWordMap() {
        return this.letterWordMap;
    }

    private void initialMap(String text) {
        createLetterWordMapFromText(text);
    }

    private void createLetterWordMapFromText(String text) {
        String[] arrayOfWord = this.getDistinctWordList(text);
        addKeysToMapFromWordsArray(arrayOfWord);

    }

    private String[] getDistinctWordList(String text) {
        return Arrays.stream(text.split(" ")).distinct().map(String::toLowerCase)
                .toArray(String[]::new);
    }

    private void addKeysToMapFromWordsArray(String[] arrayOfWord) {
        Arrays.stream(arrayOfWord).forEach(this::addKeysFromWord);
    }

    private void addKeysFromWord(String word) {
        Stream<Character> charStream =  word.chars().distinct().mapToObj(ch -> (char) ch);
        charStream.forEach(c -> {if (!letterWordMap.containsKey(c)) {
            letterWordMap.put(c, new ArrayList<>());
        }});
    }
}
