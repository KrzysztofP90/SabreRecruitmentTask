package com.krzysztof.SabreRecruitmentTask;
import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

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
}
