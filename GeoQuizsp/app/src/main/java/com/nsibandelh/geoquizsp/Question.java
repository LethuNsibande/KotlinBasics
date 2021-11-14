package com.nsibandelh.geoquizsp;

public class Question
{
    private int iQuestionId;
    private boolean bIsQuestionTrue;

    public Question(int iQuestionId, boolean bIsQuestionTrue)
    {
        this.iQuestionId = iQuestionId;
        this.bIsQuestionTrue = bIsQuestionTrue;
    }

    public int getiQuestionId()
    {
        return iQuestionId;
    }

    public void setiQuestionId(int iQuestionId)
    {
        this.iQuestionId = iQuestionId;
    }

    public boolean isbIsQuestionTrue()
    {
        return bIsQuestionTrue;
    }

    public void setbIsQuestionTrue(boolean bIsQuestionTrue)
    {
        this.bIsQuestionTrue = bIsQuestionTrue;
    }
}
