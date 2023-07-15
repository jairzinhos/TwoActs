package org.beginningandroid.twoacts;

//import static org.beginningandroid.twoacts.SecondActivity.number;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ProofText extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proof_text);
        textView = (TextView) findViewById(R.id.textView);

        Intent receiverIntent = getIntent();
        String receivedValue = receiverIntent.getStringExtra("KEY_SENDER");
        textView.setText(receivedValue);
        //System.out.println(number);
    }
}