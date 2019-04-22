package com.example.demo.Controllers;

import com.example.demo.Entities.Words;
import com.example.demo.Services.WordsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/word")
public class WordsController{

    @Autowired
    private WordsService wordsService;

    @Autowired
    ObjectMapper jacksonMapper;

    @CrossOrigin
    @GetMapping("/getMyWords")
    public ResponseEntity getWords() throws JsonProcessingException {
        List<Words> response= wordsService.getWords();
        return new ResponseEntity<>(jacksonMapper.writeValueAsString(response), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/getList")
    public ArrayList<Words> getList(){
        return wordsService.getWords();
    }

    @CrossOrigin
    @GetMapping("/getWord")
    public Words getWord(@RequestParam("id") long id){
        return wordsService.getWord(id);
    }

    @CrossOrigin
    @PostMapping("/addWord")
    public void addWord(@RequestBody String word){
        wordsService.addWord(word);
    }

    @CrossOrigin
    @GetMapping("/match")
    public ResponseEntity match(@RequestParam("wordtomatch")  String wordtomatch) throws JsonProcessingException {
//        return wordsService.match(wordToMatch);
        List<Words> response= wordsService.match(wordtomatch);
        return new ResponseEntity<>(jacksonMapper.writeValueAsString(response), HttpStatus.OK);
    }
}
