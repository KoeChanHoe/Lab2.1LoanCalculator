package my.edu.tarc.lab21loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editTextPrice;
    private EditText editTextPayment;
    private EditText editTextPeriod;
    private EditText editTextInterest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPrice = (EditText)findViewById(R.id.editTextPrice);
        editTextPayment = (EditText)findViewById(R.id.editTextPayment);
        editTextPeriod = (EditText)findViewById(R.id.editTextPeriod);
        editTextInterest = (EditText)findViewById(R.id.editTextInterest);

    }

    public void calculatePayment(View view){
        Intent intent = new Intent(this, ResultActivity.class);

        double loan,price,payment,interestRate,interest,monthPay;
        int period;

        price = Double.parseDouble(editTextPrice.getText().toString());
        payment = Double.parseDouble(editTextPayment.getText().toString());
        period = Integer.parseInt(editTextPeriod.getText().toString());
        interestRate = Double.parseDouble(editTextInterest.getText().toString());

        intent.putExtra("DOWN",payment);
        intent.putExtra("PERIOD",period);
        intent.putExtra("INTEREST",interestRate);

        loan = price - payment;
        interest = loan * interestRate * period;
        monthPay = (loan + interest) / loan / 12;

        intent.putExtra("MONTHPAY",monthPay);
        startActivity(intent);
    }
}
