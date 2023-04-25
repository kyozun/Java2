package Bai3.Dictionary;

public class MyDictionary {
    String englishWord;
    String vietnameseWord;

    public MyDictionary(String englishWord, String vietnameseWord) {
        this.englishWord = englishWord;
        this.vietnameseWord = vietnameseWord;
    }

    public String getEnglishWord() {
        return englishWord;
    }

    public void setEnglishWord(String englishWord) {
        this.englishWord = englishWord;
    }

    public String getVietnameseWord() {
        return vietnameseWord;
    }

    public void setVietnameseWord(String vietnameseWord) {
        this.vietnameseWord = vietnameseWord;
    }
}
