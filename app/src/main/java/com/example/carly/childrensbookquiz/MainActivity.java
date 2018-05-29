package com.example.carly.childrensbookquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Game Score Variable
    int score = 0;

    // Radio Groups
    RadioButton q1Answer, q2Answer, q3Answer, q5Answer, q7Answer, q10Answer;
    RadioGroup q1Group, q2Group, q3Group, q5Group, q7Group, q10Group;
    RadioGroup[] RadioGroups;

    // Quiz Check Boxes
    CheckBox q6CheckBoxA, q6CheckBoxB,q6CheckBoxC, q6CheckBoxD, q9CheckBoxA, q9CheckBoxB, q9CheckBoxC, q9CheckBoxD;
    CheckBox[] CheckBoxes;

    // Write-in
    EditText q4Answer, q8Answer;
    EditText[] WriteIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Radio Button ID's (Answers and Groups)
        q1Answer = findViewById(R.id.Q1Correct);
        q2Answer = findViewById(R.id.Q2Correct);
        q3Answer = findViewById(R.id.Q3Correct);
        q5Answer = findViewById(R.id.Q5Correct);
        q7Answer = findViewById(R.id.Q7Correct);
        q10Answer = findViewById(R.id.Q10Correct);
        q1Group = findViewById(R.id.Q1Group);
        q2Group = findViewById(R.id.Q2Group);
        q3Group = findViewById(R.id.Q3Group);
        q5Group = findViewById(R.id.Q5Group);
        q7Group = findViewById(R.id.Q7Group);
        q10Group = findViewById(R.id.Q10Group);
        RadioGroups = new RadioGroup[]{q1Group, q2Group, q3Group, q5Group, q7Group, q10Group};

        // Check Box ID's
        q6CheckBoxA = findViewById(R.id.Q6CheckBoxA);
        q6CheckBoxB = findViewById(R.id.Q6CheckBoxB);
        q6CheckBoxC = findViewById(R.id.Q6CheckBoxC);
        q6CheckBoxD = findViewById(R.id.Q6CheckBoxD);
        q9CheckBoxA = findViewById(R.id.Q9CheckBoxA);
        q9CheckBoxB = findViewById(R.id.Q9CheckBoxB);
        q9CheckBoxC = findViewById(R.id.Q9CheckBoxC);
        q9CheckBoxD = findViewById(R.id.Q9CheckBoxD);
        CheckBoxes = new CheckBox[]{q6CheckBoxA, q6CheckBoxB, q6CheckBoxC, q6CheckBoxD,
                                    q9CheckBoxA, q9CheckBoxB, q9CheckBoxC, q9CheckBoxD};

        // Write-in ID's
        q4Answer = findViewById(R.id.Q4Answer);
        q8Answer = findViewById(R.id.Q8Answer);
        WriteIn = new EditText[]{q4Answer, q8Answer};
    }

    public void submitQuiz(View view) {

        // Grade Quiz
        if (q1Answer.isChecked()) { // Question 1
            score += 1;
        }
        if (q2Answer.isChecked()) { // Question 2
            score += 1;
        }
        if (q3Answer.isChecked()) { // Question 3
            score += 1;
        }
        if (q4Answer.getText().toString().equals("Hungry")) { // Question 4
            score += 1;
        }
        if (q5Answer.isChecked()) { // Question 5
            score += 1;
        }
        if (q6CheckBoxA.isChecked() && q6CheckBoxB.isChecked() && q6CheckBoxD.isChecked()) { // Question 6
            score += 1;
        }
        if (q7Answer.isChecked()) { // Question 7
            score += 1;
        }
        if (q8Answer.getText().toString().equals("Express")) { // Question 8
            score += 1;
        }
        if (q9CheckBoxA.isChecked() && q9CheckBoxC.isChecked()) { // Question 9
            score += 1;
        }
        if (q10Answer.isChecked()) { // Question 10
            score += 1;
        }
        // Score Quiz
        if (score == 10) {
            Toast.makeText(this, "10 out of 10! You have a perfect score! You're a great reader!", Toast.LENGTH_LONG).show();
        } else if (score == 9) {
            Toast.makeText(this, "9 out of 10! You missed 1! You're practically a great reader!", Toast.LENGTH_LONG).show();
        } else if (score == 8) {
            Toast.makeText(this, "8 out of 10! Mom is okay with this score.", Toast.LENGTH_LONG).show();
        } else if (score == 7) {
            Toast.makeText(this, "7 out of 10! Mom is not okay with this score.", Toast.LENGTH_LONG).show();
        } else if (score == 6) {
            Toast.makeText(this, "6 out of 10! Um, maybe find a Elementary student to help you study up.", Toast.LENGTH_LONG).show();
        } else if (score == 5) {
            Toast.makeText(this, "5 out of 10! Try reading Cat in the Hat, that's an easy one.", Toast.LENGTH_LONG).show();
        } else if (score == 4) {
            Toast.makeText(this, "4 out of 10! Mom is worried.", Toast.LENGTH_LONG).show();
        } else if (score == 3) {
            Toast.makeText(this, "3 out of 10! Mom says you can't move back home, she turned your old room into a craft room.", Toast.LENGTH_LONG).show();
        } else if (score == 2) {
            Toast.makeText(this, "2 out of 10! *face palm*.", Toast.LENGTH_LONG).show();
        } else if (score == 1) {
            Toast.makeText(this, "1 out of 10! Time to go back to Kindergarten.", Toast.LENGTH_LONG).show();
        } else if (score == 0) {
            Toast.makeText(this, "0 out of 10! Mom has disowned you.", Toast.LENGTH_LONG).show();
        }
    }

    public void restartQuiz(View view) {
        // Reset Score to 0
        score = 0;

        // Clear Radio Groups
        for (RadioGroup radioGroup : RadioGroups) {
            radioGroup.clearCheck();
        }

        // Set Check Boxes to false
        for (CheckBox checkBox : CheckBoxes) {
            checkBox.setChecked(false);
        }

        // Set Write-In to empty string
        for (EditText editText : WriteIn) {
            editText.setText("");
        }

        // Scroll to top of screen
        ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView);
            scrollView.scrollTo(0,0);
    }
}
