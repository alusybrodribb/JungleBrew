package me.lusy.junglebrew.ui;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import me.lusy.junglebrew.R;
import me.lusy.junglebrew.model.Question;
import me.lusy.junglebrew.model.Quiz;
import me.lusy.junglebrew.model.Result;
import me.lusy.junglebrew.model.Results;

public class QuizActivity extends AppCompatActivity {
    private Quiz mQuiz = new Quiz();
    private ImageView mBackgroundImage;
    private TextView mQuizTextView;
    private Button mSubmitButton;
    private Spinner mAnswerSpinner;
    private Question mCurrentQuestion;
    private int mQuestionNumber;
    private Result mResult;
    private Results mResults = new Results();

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

    }

    private void loadQuestion(int question) {
        mCurrentQuestion = mQuiz.getQuestion(question);
        Drawable drawable = null;
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
                mQuestionNumber++;
                if (mQuestionNumber < mQuiz.getLength()) {
                    loadQuestion(mQuestionNumber);
                } else {
                    loadResult(0);//load result
                }
            }
        });
    }

    public void loadResult(int result) {
        mResult = mResults.getResult(result);
        Drawable drawable = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            drawable = getDrawable(mResult.getBackgroundImageId());
        } else {
            drawable = getResources().getDrawable(mResult.getBackgroundImageId());
        }
        mBackgroundImage.setImageDrawable(drawable);
        mQuizTextView.setText(mResult.getAnimalBlurb());
    }
}