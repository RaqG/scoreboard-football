package com.example.raquelgallo.scoreboard;

import android.widget.Button;

/**
 * Created by Raquel Gallo on 02/01/2018.
 */

public interface ScoreBoardContract {

    interface View {

        void errorMessage();

        void updateScores(int scoreTeamA, int scoreTeamB);

        void showExtraPointsAFields();

        void showExtraPointsBFields();

        void hideExtraPointsAFields();

        void hideExtraPointsBFields();
    }

    interface Presenter {

        void pressScoreButton(Button scoreBtn, int scoreTeamA, int scoreTeamB);

        void pressResetButton();

    }
}
