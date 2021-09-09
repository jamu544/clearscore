package android.com.jumpco.io.clearscore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.net.NetworkInterface;

public class MainActivity extends AppCompatActivity {

   private int score;
   private int maxScoreValue;

    private ProgressBar progressBar;
    private TextView results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        Bundle bundle = getIntent().getExtras();

        score = bundle.getInt("score");
        maxScoreValue = bundle.getInt("maxScore");


        results.setText(score+"/"+maxScoreValue);
        progressBar.setProgress(calculateCreditScore( score, maxScoreValue));

    }

    //initialisation method
    public void init(){
        progressBar = findViewById(R.id.stats_progressbar);
        results = findViewById(R.id.calculation);
    }

    //calculate the percentage of the users's progress
    public int calculateCreditScore(int score,int maxScoreValue){
        double d = (double) score/(double) maxScoreValue;
        int progress = (int) (d*100);

        return progress;
    }


}