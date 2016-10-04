package me.lusy.junglebrew.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import me.lusy.junglebrew.R;
import me.lusy.junglebrew.model.Question;
import me.lusy.junglebrew.model.Quiz;
import me.lusy.junglebrew.model.ResultsParser;

public class QuizActivity extends AppCompatActivity {
    private Quiz mQuiz = new Quiz();
    private ImageView mBackgroundImage;
    private TextView mQuizTextView;
    private Button mSubmitButton;
    private Spinner mAnswerSpinner;
    private Question mCurrentQuestion;
    private int mQuestionNumber;
    private ResultsParser mResultsParser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        mBackgroundImage = (ImageView) findViewById(R.id.backgroundImageView);
        mQuizTextView = (TextView) findViewById(R.id.questionTextView);
        mSubmitButton = (Button) findViewById(R.id.submitButton);
        mAnswerSpinner = (Spinner) findViewById(R.id.quizSpinner);
        mQuestionNumber = 0;
        loadQuestion(mQuestionNumber);
        mResultsParser = new ResultsParser();

    }

    private void loadQuestion(int question) {
        mCurrentQuestion = mQuiz.getQuestion(question);
        Drawable drawable;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            drawable = getDrawable(mCurrentQuestion.getBackgroundImageId());
        } else {
            drawable = getResources().getDrawable(mCurrentQuestion.getBackgroundImageId());
        }
        mBackgroundImage.setImageDrawable(drawable);
        mQuizTextView.setText(mCurrentQuestion.getQuestion());

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //parse result
                String choice = String.valueOf(mAnswerSpinner.getSelectedItem());
                mResultsParser.parseQuestion(mCurrentQuestion, choice);
               //Toast.makeText(QuizActivity.this, mResultsParser.showCoordinates() , Toast.LENGTH_SHORT).show();
                mQuestionNumber++;
                if (mQuestionNumber < mQuiz.getLength()) {
                    loadQuestion(mQuestionNumber);
                } else {
                    showResult();
                }
            }
        });
    }

    private void showResult() {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("xValue", mResultsParser.getXAxis());
        intent.putExtra("yValue", mResultsParser.getYAxis());
        startActivity(intent);
    }


}