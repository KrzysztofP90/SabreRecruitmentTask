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
        sortWordsInLetterWordMap();
    }

    private void sortWordsInLetterWordMap() {
        letterWordMap.keySet().forEach(key -> Collections.sort(letterWordMap.get(key)));
    }

    private void createLetterWordMapFromText(String text) {
        String[] arrayOfWord = this.getDistinctWordList(text);
        addKeysToMapFromWordsArray(arrayOfWord);
        Arrays.stream(arrayOfWord).forEach(this::insertWordToLetterWordMap);

    }

    private void insertWordToLetterWordMap(String word) {
        word.chars().mapToObj(ch -> (char) ch).distinct().forEach(ch-> letterWordMap.get(ch).add(word));
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
