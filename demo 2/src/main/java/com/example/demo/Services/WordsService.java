package com.example.demo.Services;

import com.example.demo.Entities.Words;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

import static java.lang.Math.abs;

@Service
public class WordsService {
//    List<Words> wordsList = Arrays.asList(
//            new Words(1, "tal"),
//            new Words(2, "yahel"),
//            new Words(3, "ofer"),
//            new Words(4, "ilana"),
//            new Words(5, "geva"),
//            new Words(6, "winboim"),
//            new Words(7, "naruto"),
//            new Words(8, "bleach"),
//            new Words(9, "black clover"),
//            new Words(10, "fairy tail")
//    );

    public ArrayList<Words> wordsList = new ArrayList<>();

    public ArrayList<Words> getWords() {
        Collections.sort(wordsList , new Comparator<Words>() {
            @Override
            public int compare(Words o1, Words o2) {
                return Integer.valueOf((int) o1.id).compareTo((int) o2.id);
            }
        });

        return wordsList;
    }

    public void addWord(String word) {
        wordsList.add(new Words(wordsList.size()+1,word));
    }

    public Words getWord(long id) {
        for (int i = 0; i < wordsList.size(); i++) {
            if (Objects.equals(wordsList.get(i).id, id)) {
                return wordsList.get(i);
            }
        }
        return null;
    }

    public ArrayList<Words> match(String wordToMatch) {
        for (int i = 0; i < wordsList.size(); i++) {
            wordsList.get(i).difference= abs((wordsList.get(i).asciiValue)-Words.asciiValue(wordToMatch));
        }

        Collections.sort(wordsList , new Comparator<Words>() {
            @Override
            public int compare(Words o1, Words o2) {
                return Integer.valueOf(o1.difference).compareTo(o2.difference);
            }
        });

        if (wordsList.size()<3){
            return null;
        }else{
            ArrayList<Words> wordsListMatch = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                wordsListMatch.add(wordsList.get(i));
            }

            return wordsListMatch ;
        }
    }
}
