package me.lusy.junglebrew.model;

import android.content.Context;

import me.lusy.junglebrew.R;

public class Results {

    private Result[] mResults;

    public Results() {
        mResults = new Result[13];
        mResults[0] = new Result (
             "a dolphin",
                "You are super cool - so cool in fact, that you don't belong in the jungle - you belong in the ocean like this dolphin! Good Luck out in the wide sea. ",
                R.drawable.dolphin
        );
        mResults[1] = new Result (
                "a zebra",
                "You’re a part of the crowd, and that’s the way you like it. You may not be the showiest joker, or the biggest organiser, but you’re still happiest with people around. You’re happy being you, and why shouldn’t you be? There's no need for you to change your stripes.",
                R.drawable.zebra
        );

        mResults[2] = new Result (
                "a red panda",
                "You don’t mind having few people around, but more than that is too much for you to bear. In general, you trust your instincts, though you always try to be careful in case something bamboozles you. ",
                R.drawable.redpanda
        );
        mResults[3] = new Result (
                "an eagle",
                "You like to keep your distance from everything. You don’t get too emotionally invested, but you don’t overthink things either. This makes your vision on most things perfectly clear. ",
                R.drawable.eagle
        );

        mResults[4] = new Result (
                "an orangutan",
                "You’re keen on learning, and even if you don’t quite get there, you’re happy to ape those who are better than you. As long as you get there in the end, that’s what counts, right? No point in hanging around doing nothing – that’s just bananas!",
                R.drawable.orangutan
        );
        mResults[5] = new Result (
                "a hyena",
                "You’re always up for a laugh. If there’s a joke going on, you’ll usually get it, because you’re just as comfortable with wit as you are with goofballery. That doesn’t mean you don’t take some things seriously – your pack is the most important thing to you.",
                R.drawable.hyena
        );
        mResults[6] = new Result (
                "a monkey",
                "You’re the life of the party – always ready to get into some monkey business. Your friends never want to go out without you, and why would they? You’re always up for some fun.",
                R.drawable.monkey
        );

        mResults[7] = new Result (
                "a lion",
                "Those close to you are your pride and joy, however you don’t care much about anyone else. It’s a matter of emotion to you – when you care about something, you’re a king in your domain. Anything else is just not relevant to you. ",
                R.drawable.lion
        );
        mResults[8] = new Result (
                "a rhino",
                "You like to charge into things, and when you do, you’re usually alone. This doesn’t really bother you though. Usually you just nose around a bit, and then things always end up alright.",
                R.drawable.rhino
        );

        mResults[9] = new Result (
                "a crocodile",
                "You don’t shed tears about anyone else’s problems – at least, not genuine tears. You might not care much for intellectual pursuits, but you’re not one for emotion either. You take care of yourself, and that’s enough.",
                R.drawable.crocodile
        );
        mResults[10] = new Result (
                "a tiger",
                "In the night of the jungle, you burn bright with your passion for study. You aren’t much for people, instead you would much prefer to be curled up with a good book on science, or history – or, perchance, some poetry. ",
                R.drawable.tiger
        );
        mResults[11] = new Result (
                "a parrot",
                "You have answers to everything, and you’re not afraid to share. Sometimes people think you’re crackers, but who cares? You have enough friends that you don’t need to worry about what everyone else thinks. ",
                R.drawable.parrot
        );

        mResults[12] = new Result (
                "an elephant",
                "You are definitely not one who will ever forget their friends. You’re always the go to person any time a friend needs a helping hand, and because of this, your friends won’t forget you either.  ",
                R.drawable.elephant
        );
    }

    public int chooseResult(int XValue, int YValue) {
        int result = 0;
        if (Math.abs(XValue) <= 1 &&  Math.abs(YValue) <= 1) {
            //inner circle - dolphin
            result = 0;
        } else if (Math.abs(XValue) <= 4 && Math.abs(YValue) <= 4){
            //middle circle - zebra, red panda, eagle, crocodile
            if (YValue > 0 && Math.abs(YValue) >= Math.abs(XValue)) {
                result = 1; //zebra
            } else if (XValue > 0 && Math.abs(XValue) >= Math.abs(YValue)) {
                result = 2; //red panda
            } else if (YValue < 0 && Math.abs(YValue) >= Math.abs(XValue)) {
                result = 3; //eagle
            } else if (XValue < 0 && Math.abs(XValue) >= Math.abs(YValue)) {
                result = 4; //orangutan
            }
        } else if (Math.abs(XValue) > 4 || Math.abs(YValue) > 4) {
            //above logic not strictly necessary, but included for clarity
            //outer circle  - hyena, monkey, lion, rhino, crocodile, tiger, parrot, elephant
            if (YValue > 0 && -3 < XValue && XValue <=3 ){
                result = 5; //hyena
            } else if (XValue > 3 && YValue >= 3) {
                result = 6; //monkey
            } else if (XValue > 0 && 3 > YValue && YValue >= -3 ){
                result = 7; //lion
            } else if (XValue >= 3 && YValue < -3) {
                result = 8; //rhino
            } else if (YValue < 0 && -3 <= XValue && XValue < 3 ) {
                result = 9; //crocodile
            }else if (XValue < -3 && YValue <= -3) {
                result = 10; //tiger
            } else if (XValue < 0 && 3 >= YValue && YValue > -3 ){
                result = 11; //parrot
            } else if (XValue <= -3 && YValue > 3) {
                result =12; //elephant
            }
        } else {
            //default result - if all else fails, you are a dolphin squeak squeak
            //everybody likes dolphins
            result = 0;
        }
        return result;
    }


    public Result getResult(int resultNumber) {
        return mResults[resultNumber];
    }


}
