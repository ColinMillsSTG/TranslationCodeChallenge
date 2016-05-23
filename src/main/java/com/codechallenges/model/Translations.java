package com.codechallenges.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by colin.mills on 5/20/2016.
 */
public final class Translations {
    HashMap<String,String> translations = new HashMap<>();

    private void init(){
        translations.put("The","Th'");
        translations.put("the", "th'");
        translations.put("Not","Nae");
        translations.put("not","nae");
        translations.put("Isn't","Innae");
        translations.put("isn't","innae");
        translations.put("That","'at");
        translations.put("that","'at");
        translations.put("Off","aff");
        translations.put("off","aff");
        translations.put("Brown","Broon");
        translations.put("brown","broon");
        translations.put("Slippers","Baffies");
        translations.put("slippers","baffies");
        translations.put("Slipper","Baffie");
        translations.put("slipper","baffie");
        translations.put("1","yan");
        translations.put("One","Yan");
        translations.put("one","yan");
        translations.put("2","tae");
        translations.put("Two","Tae");
        translations.put("two","tae");
        translations.put("too","tae");
        translations.put("to","tae");
        translations.put("3","thee");
        translations.put("Three","thee");
        translations.put("three","thee");
        translations.put("Four","Fower");
        translations.put("four","fower");
        translations.put("5","fife");
        translations.put("Five","fife");
        translations.put("five","fife");
        translations.put("6","sex");
        translations.put("Six","sex");
        translations.put("six","sex");
        translations.put("Score","scair");
        translations.put("score","scair");
        translations.put("Fathers","faithers");
        translations.put("fathers","faithers");
        translations.put("All","Aw");
        translations.put("all","aw");
        translations.put("Are","Ur");
        translations.put("are","ur");
        translations.put("This","Thes");
        translations.put("this","thes");
        translations.put("On","Oan");
        translations.put("on","oan");
        translations.put("Brought","Brooght");
        translations.put("brought","brooght");
        translations.put("Dog","Dug");
        translations.put("dog","dug");
        translations.put("Over","Ower");
        translations.put("over","ower");
        translations.put("Star","Staurn");
        translations.put("star","staurn");
        translations.put("Eyes","Een");
        translations.put("eyes","een");
        translations.put("ave","ae");
        translations.put("ing","in'");
        translations.put("Lives","Li'es");
        translations.put("lives","li'es");
        translations.put("For","Fur");
        translations.put("for","fur");
        translations.put("Any","Onie");
        translations.put("any","onie");
        translations.put("ow","oo");
        translations.put("And","An'");
        translations.put("and","an'");
        translations.put("","");
    }

    public String getTranslation(String token){
        if(translations.size() == 0){
            init();
        }

        if(translations.get(token) == null){
            if(token.length() >= 2 && translations.get(token.substring(token.length()-2,token.length())) != null){
                token = token.replaceAll(token.substring(token.length()-2,token.length()), translations.get(token.substring(token.length()-2,token.length())));
            }else if(token.length() >= 3 && translations.get(token.substring(token.length()-3,token.length())) != null){
                token = token.replaceAll(token.substring(token.length()-3,token.length()), translations.get(token.substring(token.length()-3,token.length())));
            }else if(token.length() >= 4 && translations.get(token.substring(token.length()-4,token.length())) != null){
                token = token.replaceAll(token.substring(token.length()-4,token.length()), translations.get(token.substring(token.length()-4,token.length())));
            }
            return token;
        }else {
            return translations.get(token);
        }
    }

    public ArrayList<String> getTranslations(ArrayList<String> tokens){

        ArrayList<String> returnArray = new ArrayList<>();

        for(String token : tokens){
            returnArray.add(getTranslation(token));
        }

        return returnArray;
    }
}
