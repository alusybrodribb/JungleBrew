package me.lusy.junglebrew.model;

public class Question {


    public String mQuestion;
    public boolean mAxis;
    public boolean mDirection;
    public int mBackgroundImageId;

    public Question(String question, boolean axis, boolean direction, int background) {
        mQuestion = question;
        mAxis = axis;
        mDirection = direction;
        mBackgroundImageId = background;
    }

//Getters and setters

    public String getQuestion() {
        return mQuestion;
    }

    public void setQuestion(String question) {
        mQuestion = question;
    }

    public int getBackgroundImageId() {
        return mBackgroundImageId;
    }

    public void setBackgroundImageId(int backgroundImageId) {
        mBackgroundImageId = backgroundImageId;
    }

    public boolean isDirection() {

        return mDirection;
    }

    public void setDirection(boolean direction) {
        mDirection = direction;
    }

    public boolean isAxis() {

        return mAxis;
    }

    public void setAxis(boolean axis) {
        mAxis = axis;
    }
}
