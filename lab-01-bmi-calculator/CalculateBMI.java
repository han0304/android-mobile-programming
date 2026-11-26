package han1624.homework2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        TextView tv_result = (TextView)findViewById(R.id.tv_result);

        Button btn_send = (Button) findViewById(R.id.btn_send);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText et_height = (EditText) findViewById(R.id.et_height);
                EditText et_weight = (EditText) findViewById(R.id.et_weight);

                String et_heightTextValue = et_height.getText().toString();
                String et_weightTextValue = et_weight.getText().toString();

                double et_heightValue = Double.parseDouble(et_heightTextValue);
                double et_weightValue = Double.parseDouble(et_weightTextValue);

                double heightInMeter = et_heightValue / 100;
                double bmi = et_weightValue / (heightInMeter * heightInMeter);

                String result = String.format("%.2f",bmi);

                String status = "";
                if (bmi < 18.5){
                    status = "體重過輕";
                } else if (bmi < 24) {
                    status = "正常範圍";
                }else {
                    status = "異常範圍";
                }

                tv_result.setText("您的BMI是:" + result);
                TextView tv_result2 = (TextView)findViewById(R.id.tv_result2);
                tv_result2.setText("診斷結果: " + status);
                Toast.makeText(MainActivity.this, "計算完成!" , Toast.LENGTH_LONG).show();

            }
        });

        Button btn_clear = (Button) findViewById(R.id.btn_clear);
        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Clear", Toast.LENGTH_LONG).show();
            }
        });
    }
}