package com.codechallenges.service;

import com.codechallenges.model.Translations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by colin.mills on 5/20/2016.
 */
@Service
public class TranslatorServiceImpl implements TranslatorService {

    Translations translations = new Translations();

    public String getTranslation(String originalText){
        ArrayList<String> tokens;
        ArrayList<String> translatedTokens;

        tokens = tokenizeText(originalText);

        translatedTokens = translations.getTranslations(tokens);

        return assembleTokens(translatedTokens);

    }

    public ArrayList<String> tokenizeText(String text){

        text = text.replaceAll("[^a-zA-Z ]", "");
        StringTokenizer stringTokenizer = new StringTokenizer(text, " ");
        ArrayList<String> tokens = new ArrayList<>();

        while(stringTokenizer.hasMoreTokens()){
            tokens.add(stringTokenizer.nextToken());
        }

        return tokens;
    }

    public String assembleTokens(List<String> tokenList){
        String fullText = "";

        for(String token : tokenList){
            fullText += token + " ";
        }

        return fullText.trim();
    }

}
