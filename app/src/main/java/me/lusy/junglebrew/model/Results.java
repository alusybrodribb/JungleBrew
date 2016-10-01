package me.lusy.junglebrew.model;

import me.lusy.junglebrew.R;

public class Results {

    private Result[] mResults;

    public Results() {
        mResults = new Result[4];
        mResults[0] = new Result (
                "dolphin",
            "This is the first result",
                R.drawable.dolphin
        );
        mResults[1] = new Result (
                "monkey",
                "This is the second result",
                R.drawable.monkey
        );

        mResults[2] = new Result (
                "elephant",
                "This is the third result",
                R.drawable.elephant
        );
        mResults[3] = new Result (
                "red panda",
                "You are super cool - so cool in fact, that you don't belong in the jungle - you belong in the ocean like this dolphin! Good Luck out in the wide sea. ",
                R.drawable.redpanda
        );

    }

    public int chooseResult(int XValue, int YValue) {
        int result = 0;

        if (XValue > 0 && YValue > 0) {
            result = 0;
        } else if (XValue >0 && YValue  < 0 ){
            result = 1;
        } else if (XValue <0 && YValue >0) {
            result = 2;
        } else {
            result = 3;
        }
        //

        return result;
    }


    public Result getResult(int resultNumber) {
        return mResults[resultNumber];
    }


}
