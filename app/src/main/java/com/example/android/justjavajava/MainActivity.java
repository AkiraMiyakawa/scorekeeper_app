/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjavajava;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import android.text.SpannableStringBuilder;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    public int quantity = 0;
    public int unitPrice = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        quantity = --quantity;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        quantity = ++quantity;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.checkbox_whipped_cream);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        if (hasWhippedCream = true) {
            unitPrice += 1;
        } else {
        }

        CheckBox ChocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = ChocolateCheckBox.isChecked();
        if (hasChocolate = true) {
            unitPrice += 2;
        } else {
        }

        Log.v("MainActivity", "Has whipped cream" + hasWhippedCream);

        EditText simpleEditText = (EditText) findViewById(R.id.plain_text_input);
        String editTextValue = simpleEditText.getText().toString();

        int price = calculatePrice();
        String priceMessage = createOrderSummary(editTextValue, hasWhippedCream, hasChocolate, price);
        displayMessage(priceMessage);

    }

    /**
     * Calculates the price of the order.
     *
     * */

    private int calculatePrice() {
        return quantity * unitPrice;
    }

    /**
     * get input text for the name field
     * @return
     */


    /**
     * Create the order summary as text.
     * @param addChocolate show true or false to add toppings
     * @param addWhippedCream show true or false to add toppings
     * @param price
     * */

    private String createOrderSummary(String name,boolean addWhippedCream, boolean addChocolate, int price) {
        String priceMessage = "Name: " + name;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nAdd Whipped cream? " + addWhippedCream;
        priceMessage += "\nAdd Chocolate? " + addChocolate;
        priceMessage += "\nTotal: " + price;
        priceMessage += "\nThank you!";
        return priceMessage;
    }

    /**
     * This method displays the given quantity value on the screen.
     * @param quantity
     */
    private void displayQuantity(int quantity) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + quantity);
    }

    /**
     * This method displays the total payment value on the screen.
     * @param message
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);

    }
}