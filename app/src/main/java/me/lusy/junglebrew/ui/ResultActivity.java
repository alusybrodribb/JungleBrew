package me.lusy.junglebrew.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import me.lusy.junglebrew.R;
import me.lusy.junglebrew.model.Result;
import me.lusy.junglebrew.model.Results;

public class ResultActivity extends AppCompatActivity {
    private ImageView mBackgroundImage;
    private TextView mResultTextView;
    private ImageView mSpeechChevron;
    private EditText mCaption;
    private Button mSubmitButton;
    private int mXAxis;
    private int mYAxis;
    private Results mResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        mXAxis = intent.getIntExtra("xValue",0);
        mYAxis = intent.getIntExtra("yValue",0);

        mBackgroundImage = (ImageView) findViewById(R.id.backgroundImageView);
        mResultTextView = (TextView) findViewById(R.id.resultTextView);
        mSubmitButton = (Button) findViewById(R.id.submitButton);
        mCaption = (EditText) findViewById(R.id.captionEditText);
        mSpeechChevron = (ImageView) findViewById(R.id.speechChevron);
        mResults = new Results();
        loadResult();
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String caption = mCaption.getText().toString();
                mSubmitButton.setText(R.string.playAgain);
                mSpeechChevron.setVisibility(View.VISIBLE);
                mCaption.setVisibility(View.INVISIBLE);
                if (caption.equals("")) {
                    mResultTextView.setText(R.string.defaultCaption);
                } else {
                    mResultTextView.setText(caption);
                }
                mSubmitButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        restartQuiz();
                    }
                });
            }
        });
    }

    public void loadResult() {
        int resultId = mResults.chooseResult(mXAxis, mYAxis);
        Result result = mResults.getResult(resultId);
        Drawable drawable;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            drawable = getDrawable(result.getBackgroundImageId());
        } else {
            drawable = getResources().getDrawable(result.getBackgroundImageId());
        }
        Toast.makeText(this, "You are " + result.getAnimal() + "!", Toast.LENGTH_LONG).show();
        mBackgroundImage.setImageDrawable(drawable);
        mResultTextView.setText(result.getAnimalBlurb());
    }

    private void restartQuiz() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
