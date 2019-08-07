package com.krzysztof.SabreRecruitmentTask;

public class App 
{
    public static void main( String[] args )
    {
        String inputDemo = "ala ma kota, kot koduje w Javie kota";
        LetterToWordIndexer indexer = new LetterToWordIndexer(inputDemo);
        indexer.printIndexingText();
    }
}
