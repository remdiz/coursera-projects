package com.example.vital.udemy_course;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private class Task {

        String title;
        List<Integer> answers;
        int correct;

        Task(String title, List<Integer> answers, int correct) {
            this.title = title;
            this.answers = answers;
            this.correct = correct;
        }

        public String getTitle() {
            return title;
        }

        public List<Integer> getAnswers() {
            return answers;
        }

        public int getCorrect() {
            return correct;
        }
    }

    List<Task> tasks = new ArrayList<>();

    TextView timerView,
             startButton,
             progressView;

    CountDownTimer timer;
    Boolean isStarted = false;
    int currentTask = 0,
        correctAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        timerView = findViewById(R.id.timerView);
        startButton = findViewById(R.id.startButton);
        progressView = findViewById(R.id.resultText);

        tasks.add(new Task("0 + 1", Arrays.asList(15,2,34,1), 1));
        tasks.add(new Task("13 - 7", Arrays.asList(22,6,2,19), 6));
        tasks.add(new Task("5 + 4", Arrays.asList(9,28,6,44), 9));
        tasks.add(new Task("7 x 8", Arrays.asList(56,34,9,12), 56));
        tasks.add(new Task("3 + 15", Arrays.asList(45,1,34,18), 18));
        tasks.add(new Task("35 / 7", Arrays.asList(15,5,28,81), 5));
        initGame();

    }

    public void startGame(View view) {

        startButton.setVisibility(View.INVISIBLE);
        progressView.setText("");
        progressView.setVisibility(View.VISIBLE);
        isStarted = true;

        timer = new CountDownTimer(30000 + 100, 1000) {
            public void onTick(long msUntilDone) {
                timerView.setText(msUntilDone / 1000 + "s");
//                        Log.i("Seconds left", String.valueOf(msUntilDone / 1000));
            }
            public void onFinish() {
                finishGame();
            }
        }.start();

    }

    private void finishGame() {

        timerView.setText("30s");
        startButton.setVisibility(View.VISIBLE);
        isStarted = false;
        progressView.setText("Your score is: " + correctAnswers + " / 6");
        currentTask = 0;
        correctAnswers = 0;
        timer.cancel();
        initGame();

    }

    public void checkAnswer(View view) {

        if (!isStarted)
            return;
        int answer = Integer.parseInt((String) ((TextView) view).getText());
        Task task = tasks.get(currentTask);
        TextView progress = findViewById(R.id.resultText);
        if (task.getCorrect() == answer) {
            correctAnswers++;
            progress.setText("Correct!");
        } else {
            progress.setText("Incorrect!");
        }
        currentTask++;
        if (currentTask > 5) {
            finishGame();
        }
        initGame();

    }

    private void initGame() {
        Task task = tasks.get(currentTask);
        List<Integer> answers = task.getAnswers();
        TextView title = findViewById(R.id.taskView);
        title.setText(task.getTitle());

        TextView answersScore = findViewById(R.id.scoreView);
        answersScore.setText(correctAnswers + " / " + currentTask);

        ((TextView)findViewById(R.id.answer1)).setText(String.valueOf(answers.get(0)));
        ((TextView)findViewById(R.id.answer2)).setText(String.valueOf(answers.get(1)));
        ((TextView)findViewById(R.id.answer3)).setText(String.valueOf(answers.get(2)));
        ((TextView)findViewById(R.id.answer4)).setText(String.valueOf(answers.get(3)));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
