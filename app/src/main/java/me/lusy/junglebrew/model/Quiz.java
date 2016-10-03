package me.lusy.junglebrew.model;

import me.lusy.junglebrew.R;

public class Quiz {


    private Question[] mQuestions;

    public Quiz() {
        mQuestions = new Question[12];

        /*************************

         Structure of a Question:
        1st value: Question Text
        2nd value: modifies X or Y axis value (True = modifies X-value, false = modiies Y-Value
        3rd value: direction of arrow (true = positive false = negative)
        4th value: background
         X-axis measures thinking/intuitive (intuitive values are positive)
         Y-axis measures solitary/social (social values are positive)
        ************************/
        mQuestions[0] = new Question(
                "I’m not too worried about the dangers in the jungle – I should be a match for anything that comes along. ",
                true,
                true,
                R.drawable.background00
        );
        mQuestions[1] = new Question(
                "It would be best to take a guide book as I’m travelling through these jungle paths. ",
                true,
                false,
                R.drawable.background01
        );

        mQuestions[2] = new Question(
                "The worst thing that could happen in the jungle is getting lost. How could I survive without the support of all my friends?",
                false,
                true,
                R.drawable.background02
        );
        mQuestions[3] = new Question(
                "I love the solitude of the jungle – I can just enjoy the beauty without any people bugging me.",
                false,
                false,
                R.drawable.background03
        );
        mQuestions[4] = new Question(
                "I love the scents of the jungle – I can really feel that I’m getting in touch with all my senses as I wander amongst the foliage. ",
                true,
                true,
                R.drawable.background04
        );
        mQuestions[5] = new Question(
                "I’ve made sure to come prepared – I have a machete, extra food and water, and plenty of bug spray. The only issue left is how can I carry all this stuff?",
                true,
                false,
                R.drawable.background05
        );

        mQuestions[6] = new Question(
                "Wouldn’t it be great if I could bring all my friends along with me? We could have a great jungle party. ",
                false,
                true,
                R.drawable.background06
        );
        mQuestions[7] = new Question(
                "It’s important to be independent when you go exploring in the jungle – you never know when you’ll have to fend for yourself. ",
                false,
                false,
                R.drawable.background07
        );
        mQuestions[8] = new Question(
                "I really feel that this jungle trek will be a spiritually fulfilling experience. ",
                true,
                true,
                R.drawable.background08
        );
        mQuestions[9] = new Question(
                "I would love to discover a new animal in the jungle – it would be an honour to make such a big contribution to science!",
                true,
                false,
                R.drawable.background09
        );

        mQuestions[10] = new Question(
                "I will definitely take a lot of photos on this jungle trek. I can put them on Facebook so everyone can see what a fantastic time I had!",
                false,
                true,
                R.drawable.background10
        );
        mQuestions[11] = new Question(
                "I’m going into the jungle for my own reasons. I don’t really care what anyone else thinks about my experience. ",
                false,
                false,
                R.drawable.background11
        );



    }

    public Question getQuestion(int questionNumber) {
        return mQuestions[questionNumber];
    }

    public int getLength() {
        return mQuestions.length;
    }

}
