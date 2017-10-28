package my.edu.tarc.lab13loanapproval;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class LoanApproval extends AppCompatActivity {

    private EditText editTextSalary, editTextVP, editTextDP, editTextIR,editTextRepayment;
    private TextView textViewMonthlyPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_approval);

        editTextSalary = (EditText)findViewById(R.id.editTextSalary);
        editTextVP = (EditText)findViewById(R.id.editTextVP);
        editTextDP = (EditText)findViewById(R.id.editTextDP);
        editTextIR = (EditText)findViewById(R.id.editTextIR);
        editTextRepayment = (EditText)findViewById(R.id.editTextRepayment);
        textViewMonthlyPayment = (TextView)findViewById(R.id.textViewMonthlyPayment);

    }
    public void calculateLoan(View view)
    {
        double salary, VP, DP, IR, totalInterest, totalLoan, MonthlyPayment;
        int repayment;
        salary = Double.parseDouble(editTextSalary.getText().toString());
        VP = Double.parseDouble(editTextVP.getText().toString());
        DP = Double.parseDouble(editTextDP.getText().toString());
        IR = Double.parseDouble(editTextIR.getText().toString());
        repayment = Integer.parseInt(editTextRepayment.getText().toString());

        totalInterest = (VP - DP) * IR * (repayment/12);
        totalLoan = (VP - DP) + (totalInterest/100);
        MonthlyPayment = totalLoan/repayment;

        if(MonthlyPayment > (salary*0.30))
            textViewMonthlyPayment.setText("Sorry, your loan is not approved.");
        else
            textViewMonthlyPayment.setText("Congratulations, your loan has been approved!");


    }

    public void reset(View view)
    {
        editTextSalary.setText("");
        editTextVP.setText("");
        editTextDP.setText("");
        editTextIR.setText("");
        editTextRepayment.setText("");
        textViewMonthlyPayment.setText("");
    }
}
