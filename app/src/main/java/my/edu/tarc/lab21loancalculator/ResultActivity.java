package my.edu.tarc.lab21loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView textViewPayment, textViewPeriod, textViewInterest, textViewMonthPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textViewPayment = (TextView)findViewById(R.id.textViewPayment);
        textViewPeriod = (TextView)findViewById(R.id.textViewPeriod);
        textViewInterest = (TextView)findViewById(R.id.textViewInterest);
        textViewMonthPay = (TextView)findViewById(R.id.textViewMonthPay);

        Intent intent = getIntent();
        double payment = intent.getDoubleExtra("DOWN", 0);
        int period = intent.getIntExtra("PERIOD", 0);
        double interestRate = intent.getDoubleExtra("INTEREST", 0);
        double monthPay = intent.getDoubleExtra("MONTHPAY", 0);

        textViewPayment.setText(Double.toString(payment));
        textViewPeriod.setText(Integer.toString(period));
        textViewInterest.setText(Double.toString(interestRate));
        textViewPayment.setText(Double.toString(monthPay));

    }

    public void closeActivity(View view){
        finish();//to terminate an activity

    }

}
