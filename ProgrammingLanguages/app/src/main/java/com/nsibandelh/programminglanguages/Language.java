package com.nsibandelh.programminglanguages;

//This is a data carrier class
public class Language
{
    private String sLanguageName;
    private String sReleaseDate;

    public Language(String sLanguageName, String sReleaseDate)
    {
        this.sLanguageName = sLanguageName;
        this.sReleaseDate = sReleaseDate;
    }

    public String getsLanguageName()
    {
        return sLanguageName;
    }

    public void setsLanguageName(String sLanguageName)
    {
        this.sLanguageName = sLanguageName;
    }

    public String getsReleaseDate()
    {
        return sReleaseDate;
    }

    public void setsReleaseDate(String sReleaseDate)
    {
        this.sReleaseDate = sReleaseDate;
    }
}
