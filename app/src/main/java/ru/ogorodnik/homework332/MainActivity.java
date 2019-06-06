package ru.ogorodnik.homework332;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Spinner mLanguageSpinner;
    Button langBtn;
    Locale myLocale;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        langBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lang = mLanguageSpinner.getSelectedItem().toString();
                switch (lang) {
                    case "EN English":
                    case "EN Английский":
                        lang = "en";
                        break;
                    case "RU Русский":
                    case "RU Russian":
                        lang = "ru";
                        break;
                    default:
                        break;
                }
                changeLang(lang);
            }
        });
    }

    private void initViews() {
        mLanguageSpinner = findViewById(R.id.languageSpinner);
        textView = findViewById(R.id.textView);
        langBtn = findViewById(R.id.langBtn);
        mLanguageSpinner();
    }

    private void mLanguageSpinner() {
        ArrayAdapter<CharSequence> adapterLang = ArrayAdapter.createFromResource(this, R.array.language, android.R.layout.simple_spinner_item);
        adapterLang.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mLanguageSpinner.setAdapter(adapterLang);
    }

    public void changeLang(String lang)
    {
        if (lang.equalsIgnoreCase(""))
            return;
        Locale myLocale = new Locale(lang);
        Configuration config = new Configuration();
        config.setLocale(myLocale);
        getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        recreate();
    }

}
