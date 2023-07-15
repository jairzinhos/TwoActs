package org.beginningandroid.twoacts;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    // These are the global variables

    public static EditText editNumber;
    TextView result;
    Button buttonSubmit, buttonReset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        editNumber = findViewById(R.id.editNumber);
        result = (TextView) findViewById(R.id.textView2);
        buttonSubmit = (Button) findViewById(R.id.button2);
        buttonReset = (Button) findViewById(R.id.button3);


        // Attaching OnClick listener to the submit button
        //Submit Button
        /*
        buttonSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Get the Data and Use it
                // get text from EditText name view
                String number = editNumber.getText().toString();

                // get text from EditText password view
                ///String password = editPassword.getText().toString();

                result.setText("Name:\t" + number + "\nPassword:\t" + number);


            }
        });
        */
        // Attaching OnClick listener to the submit button
        //Submit Button


        buttonSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String number = editNumber.getText().toString();
                if (number == null || number.length() == 0 || Integer.parseInt(number) > 1300 || Integer.parseInt(number) < 1000) {
                    // If name or password is not entered
                    Toast.makeText(getApplicationContext(), "Proper Channel Number is required (1000-1300)", Toast.LENGTH_LONG).show();
                } else {
                    sendMessage();
                    //result.setText("Name:\t" + number + "\nPassword:\t" + number );
                }

                //sendMessage();


                //goToVideoActivity();

            }
        });
        ///}
        ;

        /*
            Reset Button
        */

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ///sendMessage();
                editNumber.setText("");
                ///editPassword.setText("");
                ////result.setText("");
                editNumber.requestFocus();
                showSoftKeyboard(editNumber);






            }
        });

        /*
            Validation
        /*


        buttonSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String number = editNumber.getText().toString();
                ///String password = editPassword.getText().toString();
                ///if(name == '' || password == '') {
                if(number == null || number.length() == 0 || Integer.parseInt(number) > 1300 || Integer.parseInt(number) <1000) {
                    // If name or password is not entered
                    Toast.makeText(getApplicationContext(), "Proper Channel Number is required (1000-1300)", Toast.LENGTH_LONG).show();
                }
                else{
                    result.setText("Name:\t" + number + "\nPassword:\t" + number );
                }
            }
        });


    }
    /*
    /*

         */
    }

    private void goToVideoActivity() {

        Intent intent = new Intent(this, VideoActivity.class);

        startActivity(intent);

    }
    /**
         */
    public void sendMessage() {
        String url = "https://arenacdmexico.com/canales/dtv2b.html?id=" + editNumber.getText().toString() +"&id=1251&" + editNumber.getText().toString();
        Intent senderIntent =  new Intent(this, VideoActivity.class);
        senderIntent.putExtra("KEY_SENDER", url);
        startActivity(senderIntent);
    }
    public void showSoftKeyboard(View view) {
        if(view.requestFocus()){
            InputMethodManager imm =(InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(view,InputMethodManager.SHOW_IMPLICIT);
        }
    }
///*/
}