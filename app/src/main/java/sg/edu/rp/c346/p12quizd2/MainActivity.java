package sg.edu.rp.c346.p12quizd2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    Spinner spnCountry;
    CheckBox cbEnglish, cbChinese, cbMalay;
    Button btnSubmit;

    ArrayList<String> alCountries;
    ArrayAdapter<String> aaCountries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Declaration Form");

        etName = findViewById(R.id.editTextName);
        spnCountry = findViewById(R.id.spinnerCountry);
        cbEnglish = findViewById(R.id.checkboxEnglish);
        cbChinese = findViewById(R.id.checkboxChinese);
        cbMalay = findViewById(R.id.checkboxMalay);
        btnSubmit = findViewById(R.id.buttonSubmit);

        // TODO: Question 3: Do the required initialization of the ArrayList and ArrayAdapter and populating the spinner with the required values
        alCountries = new ArrayList<>();
        String[] strCountries = getResources().getStringArray(R.array.country);
        alCountries.addAll(Arrays.asList(strCountries));
        aaCountries = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alCountries);
        spnCountry.setAdapter(aaCountries);




        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TODO: Question 4: Do the required form validation and show the corresponding message using AlertDialog
                int pos = spnCountry.getSelectedItemPosition();
                alCountries.clear();

                if (pos == 0){
                    AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                    myBuilder.setTitle("Error");
                    myBuilder.setMessage("Please select a country");
                    myBuilder.setCancelable(false);
                    myBuilder.setNeutralButton("OK", null);
                    AlertDialog myDialog = myBuilder.create();
                    myDialog.show();
                }

                else if (cbChinese.isChecked() == false && cbEnglish.isChecked()  == false && cbMalay.isChecked() == false ){
                    AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                    myBuilder.setTitle("Error");
                    myBuilder.setMessage("Please choose at least 1 language");
                    myBuilder.setCancelable(false);
                    myBuilder.setNeutralButton("OK", null);
                    AlertDialog myDialog = myBuilder.create();
                    myDialog.show();
                }

                else{
                    AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                    myBuilder.setTitle("From submitted");
                    myBuilder.setMessage("Thank you for your submission");
                    myBuilder.setCancelable(false);
                    myBuilder.setNeutralButton("CLOSE", null);
                    AlertDialog myDialog = myBuilder.create();
                    myDialog.show();
                }




            }
        });
    }
}