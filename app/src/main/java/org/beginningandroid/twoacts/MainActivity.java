package org.beginningandroid.twoacts;

//import static org.beginningandroid.twoacts.SecondActivity.number;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        Button button4 = (Button) findViewById(R.id.button4);
        //System.out.println(number);

        button.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                goToSecondActivity();

            }

        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMainActivity2();

            }
        });
    }
    private void goToMainActivity2() {

        Intent intent = new Intent(this, MainActivity2.class);

        startActivity(intent);
    }
    private void goToSecondActivity() {

        Intent intent = new Intent(this, SecondActivity.class);

        startActivity(intent);

    }

}