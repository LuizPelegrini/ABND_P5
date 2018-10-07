package com.example.android.abnd_p5;

public class Phrase {

    private String _chinesePhrase;
    private String _englishTranslation;
    private int _audioResource;

    public Phrase(String chinesePhrase, String englishTranslation, int audioResource)
    {
        this._chinesePhrase = chinesePhrase;
        this._englishTranslation = englishTranslation;
        this._audioResource = audioResource;
    }

    public String getChinesePhrase() {
        return _chinesePhrase;
    }

    public String getEnglishTranslation() {
        return _englishTranslation;
    }

    public int getAudioResource(){
        return _audioResource;
    }
}
