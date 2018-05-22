package com.example.raquelgallo.scoreboard.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.raquelgallo.scoreboard.R;
import com.example.raquelgallo.scoreboard.ScoreBoardContract;
import com.example.raquelgallo.scoreboard.presenter.ScoreBoardPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Raquel Gallo on 30/12/2017.
 */

public class ScoreBoardActivity extends AppCompatActivity implements ScoreBoardContract.View {

    @BindView(R.id.kickoff_team_A)
    public Button kickoffABtn;

    @BindView(R.id.kickoff_team_B)
    public Button kickoffBBtn;

    @BindView(R.id.conversion_team_A)
    public Button conversionABtn;

    @BindView(R.id.conversion_team_B)
    public Button conversionBBtn;

    @BindView(R.id.touchdown_team_A)
    public Button touchdownABtn;

    @BindView(R.id.touchdown_team_B)
    public Button touchdownBBtn;

    @BindView(R.id.field_goal_team_A)
    public Button fieldGoalABtn;

    @BindView(R.id.field_goal_team_B)
    public Button fieldGoalBBtn;

    @BindView(R.id.safety_team_A)
    public Button safetyABtn;

    @BindView(R.id.safety_team_B)
    public Button safetyBBtn;

    @BindView(R.id.miss_team_A)
    public Button missABtn;

    @BindView(R.id.miss_team_B)
    public Button missBBtn;

    @BindView(R.id.score_team_A)
    public TextView txtScoreA;

    @BindView(R.id.score_team_B)
    public TextView txtScoreB;

    @BindView(R.id.scroll_view)
    public ScrollView scrollView;

    int scoreA;
    int scoreB;

    private ScoreBoardContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState != null) {
            scoreA = savedInstanceState.getInt("scoreA");
            scoreB = savedInstanceState.getInt("scoreB");
            updateScores(scoreA, scoreB);
        }
        presenter = new ScoreBoardPresenter(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("scoreA", scoreA);
        outState.putInt("scoreB", scoreB);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.scoreboard_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }
        if (id == R.id.reset_btn)
            presenter.pressResetButton();
        return super.onOptionsItemSelected(item);
    }

    @OnClick({R.id.safety_team_A, R.id.safety_team_B, R.id.field_goal_team_A, R.id.field_goal_team_B,
            R.id.conversion_team_A, R.id.conversion_team_B, R.id.kickoff_team_A, R.id.kickoff_team_B,
            R.id.touchdown_team_A, R.id.touchdown_team_B, R.id.miss_team_A, R.id.miss_team_B})
    public void onClickScoreButton(Button button) {
        presenter.pressScoreButton(button, scoreA, scoreB);
    }

    @Override
    public void errorMessage() {
        Snackbar snackbar = Snackbar.make(scrollView, "ERRO! Não existe esse botão.", Snackbar.LENGTH_SHORT);
        snackbar.show();
    }

    @Override
    public void updateScores(int scoreTeamA, int scoreTeamB) {
        txtScoreA.setText(String.valueOf(scoreTeamA));
        scoreA = scoreTeamA;
        txtScoreB.setText(String.valueOf(scoreTeamB));
        scoreB = scoreTeamB;
    }

    @Override
    public void showExtraPointsAFields() {
        kickoffABtn.setVisibility(View.VISIBLE);
        conversionABtn.setVisibility(View.VISIBLE);
        missABtn.setVisibility(View.VISIBLE);
        touchdownABtn.setVisibility(View.GONE);
        fieldGoalABtn.setVisibility(View.GONE);
        safetyABtn.setVisibility(View.GONE);
    }

    @Override
    public void showExtraPointsBFields() {
        kickoffBBtn.setVisibility(View.VISIBLE);
        conversionBBtn.setVisibility(View.VISIBLE);
        missBBtn.setVisibility(View.VISIBLE);
        touchdownBBtn.setVisibility(View.GONE);
        fieldGoalBBtn.setVisibility(View.GONE);
        safetyBBtn.setVisibility(View.GONE);
    }

    @Override
    public void hideExtraPointsAFields() {
        kickoffABtn.setVisibility(View.GONE);
        conversionABtn.setVisibility(View.GONE);
        missABtn.setVisibility(View.GONE);
        touchdownABtn.setVisibility(View.VISIBLE);
        fieldGoalABtn.setVisibility(View.VISIBLE);
        safetyABtn.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideExtraPointsBFields() {
        kickoffBBtn.setVisibility(View.GONE);
        conversionBBtn.setVisibility(View.GONE);
        missBBtn.setVisibility(View.GONE);
        touchdownBBtn.setVisibility(View.VISIBLE);
        fieldGoalBBtn.setVisibility(View.VISIBLE);
        safetyBBtn.setVisibility(View.VISIBLE);
    }
}
