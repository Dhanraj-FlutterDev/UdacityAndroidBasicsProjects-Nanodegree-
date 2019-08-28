package com.example.coffeeorderapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int numberOfCoffee = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        EditText editText = (EditText) findViewById(R.id.editText);
        String name = editText.getText().toString();
        CheckBox checkBox = (CheckBox)findViewById(R.id.cream);
        CheckBox checkBox2 = (CheckBox)findViewById(R.id.chocolate);
        boolean  haswhippedCream = checkBox.isChecked();
        boolean  hasChocolate = checkBox2.isChecked();

        int msg = calculatePrice(haswhippedCream,hasChocolate);

        String priceMessage = createOrderSummery(name, msg, haswhippedCream, hasChocolate);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Coffee Order for "+ name);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        displayMessage(priceMessage);
        /*display(numberOfCoffee);
        displayPrice(numberOfCoffee * 2);*/
    }

    public void incrementt(View view) {
        if(numberOfCoffee == 10){

            Toast.makeText(this,"Not more than 10",Toast.LENGTH_SHORT ).show();
            return;
        }
        numberOfCoffee = numberOfCoffee + 1;
        display(numberOfCoffee);
    }

    public void decrementt(View view) {
        if(numberOfCoffee == 1){
            Toast.makeText(this,"Not less than 1",Toast.LENGTH_SHORT ).show();
         return;
        }
        numberOfCoffee = numberOfCoffee - 1;
        display(numberOfCoffee);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.number);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView ordeSummeryText = (TextView) findViewById(R.id.orderSummery);
        ordeSummeryText.setText(message);
    }

    /**
     * Calculates the price of the order based on the current quantity.
     *
     * @return the price
     */
    private int calculatePrice(boolean addWhippedCream, boolean addChocolate) {

        int basePrice = 5;
        if(addWhippedCream){
          basePrice += 1;
        }
        if (addChocolate){
            basePrice += 2;
        }

        return numberOfCoffee * basePrice;

    }


    private String createOrderSummery(String name, int msg, boolean  haswhippedCream, boolean hasChocolate) {


        String priceMessage;
        priceMessage = "Name: "+ name;
        priceMessage += "\nAdd Whipped cream? " + haswhippedCream;
        priceMessage += "\nAdd Chocolate? " + hasChocolate;
        priceMessage += "\nQuantity "+ numberOfCoffee;
        priceMessage += "\nTotal $" + msg;
        priceMessage = priceMessage + "\nThank you!";
        return priceMessage;

    }

}