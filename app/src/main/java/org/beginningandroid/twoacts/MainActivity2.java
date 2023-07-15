package org.beginningandroid.twoacts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MainActivity2 extends AppCompatActivity {
    Button button;
    TextView text3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        text3 = findViewById(R.id.text3);
        button = findViewById(R.id.btnParseHTML);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getHtmlFromWeb();
            }
        });
    }
    //Document doc = Jsoup.connect("http://www.tutorialspoint.com/").get();
        private void getHtmlFromWeb () {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    final StringBuilder stringBuilder = new StringBuilder();
                    try {
                        Document doc = Jsoup.connect("https://pelotalibre.com/agenda/").get();
                        String title = doc.title();
                        //String title = doc.selectFirst("div[class");
                        ///Elements links = doc.select("a[href]");
                        Elements links = doc.select("a[href]");
                        stringBuilder.append(links).append("");
                        for (Element link : links) {
                            stringBuilder.append("").append("Link : ").append(link.attr("href")).append(" ").append("Text : ").append(link.text());
                        }
                    } catch (IOException e) {
                        stringBuilder.append("Error : ").append(e.getMessage()).append("");
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            text3.setText(stringBuilder.toString());
                        }
                    });
                }
            }).start();
        }
    }
