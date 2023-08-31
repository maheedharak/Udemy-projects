package org.bank.model;

public enum StopWords {
    WHERE("where"),
    AND("and");
    private String stopWord;
    StopWords(String stopWord){
        this.stopWord = stopWord;
    }

    public String getStopWord(){
        return this.stopWord;
    }
}
