package com.example.java_app;

import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private TextView textViewStatus, textViewName, textViewWinner, textViewPlayerPlayed, textViewComputerPlayed;
    private RadioButton radioButtonScissors, radioButtonRock, radioButtonPaper;
    private Button buttonPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect XML views to Java objects
        editTextName = findViewById(R.id.editTextName);
        textViewStatus = findViewById(R.id.TextViewStatus);
        textViewName = findViewById(R.id.textViewName);
        textViewWinner = findViewById(R.id.textViewWinner);
        textViewPlayerPlayed = findViewById(R.id.textViewPlayerPlayed);
        textViewComputerPlayed = findViewById(R.id.textViewComputerPlayed);
        radioButtonScissors = findViewById(R.id.radioButtonScissors);
        radioButtonRock = findViewById(R.id.radioButtonRock);
        radioButtonPaper = findViewById(R.id.radioButtonPaper);
        buttonPlay = findViewById(R.id.buttonPlay);

        buttonPlay.setOnClickListener(view -> {
            // Check if the name input is empty
            if (editTextName.length() < 1) {
                textViewStatus.setText("請輸入玩家姓名");
            } else {
                // Display player's name
                textViewName.setText(String.format("名字\n%s", editTextName.getText().toString()));

                // Determine player's choice
                if (radioButtonScissors.isChecked()) {
                    textViewPlayerPlayed.setText("我出拳\n剪刀");
                } else if (radioButtonRock.isChecked()) {
                    textViewPlayerPlayed.setText("我出拳\n石頭");
                } else {
                    textViewPlayerPlayed.setText("我出拳\n布");
                }

                // Generate computer's choice using random number (0 = Scissors, 1 = Rock, 2 = Paper)
                int computerChoice = (int) (Math.random() * 3);
                if (computerChoice == 0) {
                    textViewComputerPlayed.setText("電腦出拳\n剪刀");
                } else if (computerChoice == 1) {
                    textViewComputerPlayed.setText("電腦出拳\n石頭");
                } else {
                    textViewComputerPlayed.setText("電腦出拳\n布");
                }

                // Determine the winner
                if ((radioButtonScissors.isChecked() && computerChoice == 2) ||
                        (radioButtonRock.isChecked() && computerChoice == 0) ||
                        (radioButtonPaper.isChecked() && computerChoice == 1)) {
                    textViewWinner.setText("勝利者\n" + editTextName.getText().toString());
                    textViewStatus.setText("恭喜您獲勝了！！！");
                } else if ((radioButtonScissors.isChecked() && computerChoice == 1) ||
                        (radioButtonRock.isChecked() && computerChoice == 2) ||
                        (radioButtonPaper.isChecked() && computerChoice == 0)) {
                    textViewWinner.setText("勝利者\n電腦");
                    textViewStatus.setText("可惜，電腦獲勝了！");
                } else {
                    textViewWinner.setText("勝利者\n平手");
                    textViewStatus.setText("平局，請再試一場！");
                }
            }
        });
    }
}
