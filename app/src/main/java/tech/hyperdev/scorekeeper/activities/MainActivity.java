package tech.hyperdev.scorekeeper.activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import tech.hyperdev.scorekeeper.R;
import tech.hyperdev.scorekeeper.fragments.ScoreFragment;

public class MainActivity extends AppCompatActivity {

    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;
    private ScoreFragment scoreFragment1;
    private ScoreFragment scoreFragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null) {
            scoreFragment1 = new ScoreFragment();
            scoreFragment2 = new ScoreFragment();

            scoreFragment1.setTeamName("Team 1");
            scoreFragment2.setTeamName("Team 2");
            mFragmentManager = getSupportFragmentManager();
            mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.fragmentScore1, scoreFragment1);
            mFragmentTransaction.replace(R.id.fragmentScore2, scoreFragment2);
            mFragmentTransaction.commit();
        }
    }
}
