package com.example.raquelgallo.scoreboard.presenter;

import android.widget.Button;

import com.example.raquelgallo.scoreboard.ScoreBoardContract;

/**
 * Created by Raquel Gallo on 02/01/2018.
 */

public class ScoreBoardPresenter implements ScoreBoardContract.Presenter {

    ScoreBoardContract.View view;

    public ScoreBoardPresenter(ScoreBoardContract.View view) {
        this.view = view;
    }

    @Override
    public void pressScoreButton(Button scoreBtn, int scoreTeamA, int scoreTeamB) {
        String button = scoreBtn.getTag().toString();
        switch (button) {
            case "TouchdownA":
                scoreTeamA += 6;
                view.showExtraPointsAFields();
                break;
            case "TouchdownB":
                scoreTeamB += 6;
                view.showExtraPointsBFields();
                break;
            case "KickoffA":
                scoreTeamA += 1;
                view.hideExtraPointsAFields();
                break;
            case "KickoffB":
                scoreTeamB += 1;
                view.hideExtraPointsBFields();
                break;
            case "ConversionA":
                scoreTeamA += 2;
                view.hideExtraPointsAFields();
                break;
            case "ConversionB":
                scoreTeamB += 2;
                view.hideExtraPointsBFields();
                break;
            case "FieldGoalA":
                scoreTeamA += 3;
                break;
            case "FieldGoalB":
                scoreTeamB += 3;
                break;
            case "SafetyA":
                scoreTeamA += 2;
                break;
            case "SafetyB":
                scoreTeamB += 2;
                break;
            case "MissA":
                scoreTeamA += 0;
                view.hideExtraPointsAFields();
                break;
            case "MissB":
                scoreTeamB += 0;
                view.hideExtraPointsBFields();
                break;
            default:
                view.errorMessage();
                break;
        }
        view.updateScores(scoreTeamA, scoreTeamB);
    }

    @Override
    public void pressResetButton() {
        view.updateScores(0,0);
        view.hideExtraPointsAFields();
        view.hideExtraPointsBFields();
    }
}
