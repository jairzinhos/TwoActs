package org.beginningandroid.twoacts;

import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.beginningandroid.twoacts.databinding.ActivityScrollingBinding;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class ScrollingActivity extends AppCompatActivity {

    private ActivityScrollingBinding binding;

    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.btnParseHTML);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getHtmlFromWeb();
            }
        });


    }
    private void getHtmlFromWeb() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                final StringBuilder stringBuilder = new StringBuilder();
                try {
                    Document doc = Jsoup.connect("http://www.tutorialspoint.com/").get();
                    String title = doc.title();
                    Elements links = doc.select("a[href]");
                    stringBuilder.append(title).append("");
                    for (Element link : links) {
                        stringBuilder.append("").append("Link : ").append(link.attr("href")).append(" ").append("Text : ").append(link.text());
                    }
                } catch (IOException e) {
                    stringBuilder.append("Error : ").append(e.getMessage()).append("");
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(stringBuilder.toString());
                    }
                });
            }
        }).start();
    }
    public class UrlConnectionReader
    {
        /*
        public void main(String[] args)
        {
            String output  = getUrlContents("https://www.javatpoint.com/java-tutorial");
            text = setContentView(R.layout.id.text3);
            text.setText(output);
            System.out.println(output);
        }
        */
        private  String getUrlContents(String theUrl)
        {
            StringBuilder content = new StringBuilder();
            // Use try and catch to avoid the exceptions
            try
            {
                URL url = new URL(theUrl); // creating a url object
                URLConnection urlConnection = url.openConnection(); // creating a urlconnection object

                // wrapping the urlconnection in a bufferedreader
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                String line;
                // reading from the urlconnection using the bufferedreader
                while ((line = bufferedReader.readLine()) != null)
                {
                    content.append(line + "\n");
                }
                bufferedReader.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            return content.toString();
        }
    }
}