package tech.hyperdev.scorekeeper.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import tech.hyperdev.scorekeeper.R;
import tech.hyperdev.scorekeeper.fragments.ScoreFragment;
import tech.hyperdev.scorekeeper.utils.Utils;

public class MainActivity extends AppCompatActivity {

    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;
    private ScoreFragment scoreFragment1;
    private ScoreFragment scoreFragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.custom_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // action with ID action_refresh was selected
            case R.id.action_night:
                Utils.changeToTheme(MainActivity.this, 1);
                break;
            // action with ID action_settings was selected
            case R.id.action_day:
                Utils.changeToTheme(MainActivity.this, 0);
                break;
            default:
                break;
        }
        return true;
    }

}
