package com.example.inclass02_discountcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener { // From View class, implement OnClickListener Interface

    // Declare variables for the UI elements
    EditText editTextEnterTicketPrice;
    TextView discountedPercentageCalculated, discountedPriceCalculated;
    Button button5Percent, button10Percent, button15Percent, button20Percent, button50Percent, buttonClear;

    public static final String TAG = "%Calculator"; // TAG

    // Main method - onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize variables - find corresponding IDs
        editTextEnterTicketPrice = (EditText) findViewById(R.id.editTextEnterTicketPrice);
        discountedPriceCalculated = (TextView) findViewById(R.id.discountedPriceCalculated);
        discountedPercentageCalculated = (TextView) findViewById(R.id.discountedPercentageCalculated);
        button5Percent = (Button) findViewById(R.id.button5Percent);
        button5Percent.setOnClickListener(this); // calling onClick() method
        button10Percent = (Button) findViewById(R.id.button10Percent);
        button10Percent.setOnClickListener(this);
        button15Percent = (Button) findViewById(R.id.button15Percent);
        button15Percent.setOnClickListener(this);
        button20Percent = (Button) findViewById(R.id.button20Percent);
        button20Percent.setOnClickListener(this);
        button50Percent = (Button) findViewById(R.id.button50Percent);
        button50Percent.setOnClickListener(this);
        buttonClear = (Button) findViewById(R.id.buttonClear);
        buttonClear.setOnClickListener(this);
    }

    // Implement OnClickListener Interface method onClick()
    @Override
    public void onClick(View v) {
        int viewID = v.getId();
        if (viewID == R.id.button5Percent) {
            calculateAndDisplayDiscount(5.0); // Call calculateAndDisplayDiscount() method
        } else if (viewID == R.id.button10Percent) {
            calculateAndDisplayDiscount(10.0);
        }else if (viewID == R.id.button15Percent) {
            calculateAndDisplayDiscount(15.0);
        }else if (viewID == R.id.button20Percent) {
            calculateAndDisplayDiscount(20.0);
        }else if (viewID == R.id.button50Percent) {
            calculateAndDisplayDiscount(50.0);
        }else if (viewID == R.id.buttonClear) {
            Log.d(TAG, "btnClear");
            editTextEnterTicketPrice.setText("");
            discountedPercentageCalculated.setText("");
            discountedPriceCalculated.setText("");
        }
    }

    // Method to retrieve EditText value, calculate discount, show results
    @SuppressLint("SetTextI18n")
    private void calculateAndDisplayDiscount(double discountPercentage){
        String ticketPriceStr = editTextEnterTicketPrice.getText().toString(); // retrieve edit text amount as String
        try {
            double ticketPrice = (double) Double.parseDouble(ticketPriceStr); // Convert to double
            double discountPrice = ticketPrice - ((discountPercentage/100) * ticketPrice);
            discountedPercentageCalculated.setText(String.valueOf(discountPercentage) + "%");
            discountedPriceCalculated.setText(String.valueOf(discountPrice));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            Toast.makeText(MainActivity.this, "Enter a Valid Number!", Toast.LENGTH_LONG).show();
        }
    }
}