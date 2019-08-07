package com.krzysztof.SabreRecruitmentTask;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class LetterToWordIndexerTest {

     @Test
    public void checkIfAllLettersAreInKeySet() {
        String testInput = "Ala has a cat";
        LetterToWordIndexer indexer = new LetterToWordIndexer(testInput);

        Set<Character> expectedSetOfKeys = new HashSet<>();
        expectedSetOfKeys.add('a');
        expectedSetOfKeys.add('l');
        expectedSetOfKeys.add('h');
        expectedSetOfKeys.add('s');
        expectedSetOfKeys.add('c');
        expectedSetOfKeys.add('t');
        Set<Character> actualSetOfKey = indexer.getLetterWordMap().keySet();

        assertEquals(expectedSetOfKeys, actualSetOfKey);
    }

    @Test
    public void checkIfAllMatchedWordsAreAddedToParticularLetter() {
        String testInput = "word were weak worst";
        Character letter = 'w';
        LetterToWordIndexer indexer = new LetterToWordIndexer(testInput);
        Map<Character, List<String>> actualMap = indexer.getLetterWordMap();

        assertTrue(actualMap.get(letter).contains("word"));
        assertTrue(actualMap.get(letter).contains("were"));
        assertTrue(actualMap.get(letter).contains("weak"));
        assertTrue(actualMap.get(letter).contains("worst"));
    }

    @Test
    public void checkIfOnlyMatchedWordsAreAddedToParticularLetter() {
        String testInput = "word were weak worst bad";
        Character letter = 'w';

        LetterToWordIndexer indexer = new LetterToWordIndexer(testInput);

        assertTrue(indexer.getLetterWordMap().get(letter).contains("word"));
        assertTrue(indexer.getLetterWordMap().get(letter).contains("were"));
        assertTrue(indexer.getLetterWordMap().get(letter).contains("weak"));
        assertTrue(indexer.getLetterWordMap().get(letter).contains("worst"));
        assertFalse(indexer.getLetterWordMap().get(letter).contains("bad"));
    }

    @Test
    public void checkIfNotMatchedWordsAreNotAddedToParticularLetter() {
        String testInput = "word were weak worst bad farm chicken";
        Character letter = 'w';

        LetterToWordIndexer indexer = new LetterToWordIndexer(testInput);

        assertFalse(indexer.getLetterWordMap().get(letter).contains("bad"));
        assertFalse(indexer.getLetterWordMap().get(letter).contains("farm"));
        assertFalse(indexer.getLetterWordMap().get(letter).contains("chicken"));
    }

    @Test
    public void checkIfLetterDoesntContainDuplicatingWords() {
        String testInput = "ala and cat are like a cat and cat";
        Character letterToTest = 'a';
        LetterToWordIndexer indexer = new LetterToWordIndexer(testInput);
        List<String> actualListForA = indexer.getLetterWordMap().get(letterToTest);

        long actualCountOfCats = actualListForA.stream().filter(word -> word.equals("cat")).count();
        long expectedCountOfCats = 1;

        Assert.assertEquals(expectedCountOfCats, actualCountOfCats);
    }

    @Test
    public void checkIfAllMatchedWordsAreAddedToLetterInAlphabeticOrder() {
        String testInput = "ala has a cat";
        Character letterToTest = 'a';
        String[] arrayOfWordsForA = {"a", "ala", "cat", "has" };
        List<String> expectedListForA = new ArrayList<>(Arrays.asList(arrayOfWordsForA));

        LetterToWordIndexer indexer = new LetterToWordIndexer(testInput);
        List<String> actualList = indexer.getLetterWordMap().get(letterToTest);

        Assert.assertEquals(expectedListForA, actualList);
    }
}
