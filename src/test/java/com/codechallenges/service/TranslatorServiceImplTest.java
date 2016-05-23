package com.codechallenges.service;

import com.codechallenges.TranslatorApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.StringTokenizer;

import static org.junit.Assert.*;

/**
 * Created by colin.mills on 5/20/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TranslatorApplication.class)
public class TranslatorServiceImplTest {

    @Autowired
    TranslatorServiceImpl translatorService;

    @Test
    public void testTranslationEmptyStrings(){
        String expectedString = "";
        String testString = "";

        assertEquals(expectedString, translatorService.getTranslation(testString));
    }

    @Test
    public void testTranslation(){
        String expectedString = "The quick brown fox jumped over the lazy dog";
        String testString = "Th' quick broon fox jumped ower th' lazy dug";

        assertEquals(testString, translatorService.getTranslation(expectedString));
    }

    @Test
    public void testTokenizer(){
        String testString = "The quick brown fox jumped over the lazy dog";
        ArrayList<String> tokens = new ArrayList<>();
        tokens.add("The");
        tokens.add("quick");
        tokens.add("brown");
        tokens.add("fox");
        tokens.add("jumped");
        tokens.add("over");
        tokens.add("the");
        tokens.add("lazy");
        tokens.add("dog");

        ArrayList<String> tokenList = translatorService.tokenizeText(testString);

        assertEquals(9, tokenList.size());
        assertEquals(tokens, tokenList);
    }

    @Test
    public void testAssembler(){
        String testString = "The quick brown fox jumped over the lazy dog.";
        ArrayList<String> tokens = new ArrayList<>();
        tokens.add("The");
        tokens.add("quick");
        tokens.add("brown");
        tokens.add("fox");
        tokens.add("jumped");
        tokens.add("over");
        tokens.add("the");
        tokens.add("lazy");
        tokens.add("dog.");

        assertEquals(testString, translatorService.assembleTokens(tokens));
    }
}
