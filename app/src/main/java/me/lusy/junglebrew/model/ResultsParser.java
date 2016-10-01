package me.lusy.junglebrew.model;

public class ResultsParser {

    private int mXAxis = 0;
    private int mYAxis = 0;

    public void parseQuestion(Question question, String spinnerSelection) {
        boolean axis = question.isAxis();
        boolean direction = question.isDirection();
        int answer = parseAnswer(spinnerSelection);
        if (axis && direction) {
            mXAxis += answer;
        } else if (axis && !direction) {
            mXAxis -= answer;
        } else if (!axis && direction) {
            mYAxis += answer;
        } else if (!axis && !direction) {
            mYAxis -= answer;
        }
    }

    private int parseAnswer(String answer) {
        int answerAsInt = 0;
        switch(answer) {
            case "Strongly Agree":
                answerAsInt = 3;
                break;
            case "Agree":
                answerAsInt = 2;
                break;
            case "Somewhat Agree":
                answerAsInt = 1;
                break;
            case "Neither Agree nor Disagree":
                answerAsInt = 0;
                break;
            case "Somewhat Disagree":
                answerAsInt = -1;
                break;
            case "Disagree":
                answerAsInt = -2;
                break;
            case "Strongly Disagree":
                answerAsInt = -3;
                break;
        }
        return answerAsInt;
    }

   public String showCoordinates() {
       return "X = " + mXAxis + ", Y = " + mYAxis;
   }

    public int getXAxis() {
        return mXAxis;
    }

    public int getYAxis() {
        return mYAxis;
    }


}
