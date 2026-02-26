package com.example.benlistener;

import java.util.ArrayList;

public class GameRoom {
private ArrayList<Message> messages;
private ArrayList<String> correctWords;
private String player1Uid;
private String player2Uid;
private String player1Name;
private String player2Name;
private int currentPlayer;
private int diffLevel;

private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getDiffLevel() {
        return diffLevel;
    }

    public void setDiffLevel(int diffLevel) {
        this.diffLevel = diffLevel;
    }

    public GameRoom() {
        messages= new ArrayList<>();
        correctWords= new ArrayList<>();
    }
    // when creating gane room - we know:
    //  level, player1 name and uid, category,
    public GameRoom(int diffLevel, String player1Name, String player1Uid, String category){
        this();
        this.diffLevel = diffLevel;
        this.player1Name= player1Name;
        this.player1Uid=player1Uid;
        this.category=category;
    }

    public GameRoom(ArrayList<Message> messages, ArrayList<String> correctWords, String player1Uid, String player2Uid, String player1Name, String player2Name, int currentPlayer) {
        this.messages = messages;
        this.correctWords = correctWords;
        this.player1Uid = player1Uid;
        this.player2Uid = player2Uid;
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.currentPlayer = currentPlayer;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    public ArrayList<String> getCorrectWords() {
        return correctWords;
    }

    public void setCorrectWords(ArrayList<String> correctWords) {
        this.correctWords = correctWords;
    }

    public String getPlayer1Uid() {
        return player1Uid;
    }

    public void setPlayer1Uid(String player1Uid) {
        this.player1Uid = player1Uid;
    }

    public String getPlayer2Uid() {
        return player2Uid;
    }

    public void setPlayer2Uid(String player2Uid) {
        this.player2Uid = player2Uid;
    }

    public String getPlayer1Name() {
        return player1Name;
    }

    public void setPlayer1Name(String player1Name) {
        this.player1Name = player1Name;
    }

    public String getPlayer2Name() {
        return player2Name;
    }

    public void setPlayer2Name(String player2Name) {
        this.player2Name = player2Name;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}
