package han1624.homework3;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random; // 導入隨機數工具

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        String[] choices = {"剪刀", "石頭", "布"};
        ArrayAdapter<String> choices_adapter = new ArrayAdapter<>(
                MainActivity.this, android.R.layout.simple_spinner_item, choices);
        choices_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner sp_choices = (Spinner) findViewById(R.id.sp_choices);
        sp_choices.setAdapter(choices_adapter);

        Button btn_decide = (Button) findViewById(R.id.btn_decide);
        Button btn_restart = (Button) findViewById(R.id.btn_restart);

        TextView tv_computer = (TextView) findViewById(R.id.tv_computer);
        TextView tv_result = (TextView) findViewById(R.id.tv_result);

        btn_decide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int playerChoice = sp_choices.getSelectedItemPosition();

                int computerChoice = new Random().nextInt(3);
                tv_computer.setText("電腦出拳: " + choices[computerChoice]);

                if (playerChoice == computerChoice) {
                    tv_result.setText("遊戲結果: 平手！");
                } else if ((playerChoice == 0 && computerChoice == 2) ||
                        (playerChoice == 1 && computerChoice == 0) ||
                        (playerChoice == 2 && computerChoice == 1)) {

                    tv_result.setText("遊戲結果: 你贏了！");
                } else {
                    tv_result.setText("遊戲結果: 你輸了！");
                }
            }
        });

        btn_restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "遊戲重置", Toast.LENGTH_SHORT).show();
                sp_choices.setSelection(0);
                tv_computer.setText("電腦出拳:");
                tv_result.setText("遊戲結果:");
            }
        });
    }
}