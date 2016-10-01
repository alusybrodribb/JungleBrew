package me.lusy.junglebrew.model;

import me.lusy.junglebrew.R;

public class Quiz {


    private Question[] mQuestions;

    public Quiz() {
        mQuestions = new Question[4];


        //Question Text
        //modifies X or Y axis value
        //direction of arrow
        //background

        mQuestions[0] = new Question(
                "This is question 1",
                true,
                true,
                R.drawable.background01
        );
        mQuestions[1] = new Question(
                "This is question 2",
                true,
                false,
                R.drawable.background02
        );

        mQuestions[2] = new Question(
                "This is question 3",
                false,
                true,
                R.drawable.background01
        );
        mQuestions[3] = new Question(
                "This is question 4",
                false,
                false,
                R.drawable.background02
        );

    }

    public Question getQuestion(int questionNumber) {
        return mQuestions[questionNumber];
    }

    public int getLength() {
        return mQuestions.length;
    }

}
