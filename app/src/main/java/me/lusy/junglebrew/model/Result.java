package me.lusy.junglebrew.model;

public class Result {

    public String mAnimal;
    public String mAnimalBlurb;
    public int mBackgroundImageId;

    public Result (String animal, String blurb, int background) {
        mAnimal = animal;
        mAnimalBlurb = blurb;
        mBackgroundImageId = background;
    }

    //Getters and Setters

    public int getBackgroundImageId() {
        return mBackgroundImageId;
    }

    public void setBackgroundImageId(int backgroundImageId) {
        mBackgroundImageId = backgroundImageId;
    }

    public String getAnimalBlurb() {
        return mAnimalBlurb;

    }

    public String getAnimal() {
        return mAnimal;
    }
}
