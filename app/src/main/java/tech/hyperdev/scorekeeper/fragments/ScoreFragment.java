package tech.hyperdev.scorekeeper.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import tech.hyperdev.scorekeeper.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScoreFragment extends Fragment {

    private String teamname;
    private int score;
    private TextView mTeamName;
    private TextView mScore;
    public ScoreFragment() {
        this.score = 0;
        this.teamname = "Team Name";
    }
    public void setTeamName(String teamname){
        this.teamname = teamname;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_score, container, false);
        mTeamName = (TextView) rootView.findViewById(R.id.tvTeamName);
        mScore = (TextView) rootView.findViewById(R.id.textView2);
        View mBtnPlus = rootView.findViewById(R.id.btnPlus);
        View mBtnMinus = rootView.findViewById(R.id.btnMinus);
        mTeamName.setText(this.teamname);
        mBtnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score++;
                mScore.setText(score+"");
            }
        });
        mBtnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(score-1 >= 0){
                    score--;
                    mScore.setText(score+"");
                }
            }
        });
        return rootView;
    }

}
