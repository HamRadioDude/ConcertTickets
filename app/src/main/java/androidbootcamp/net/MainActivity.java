package androidbootcamp.net;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    // DECLARE DEM' VARIABLES
    double costPerTicket = 79.99;
    int numberOfTickets;
    double totalCost;
    String groupChoice;

    // SET LISTENERS AND DEM BUTTONS
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText tickets = (EditText)findViewById(R.id.txtTickets);
        final Spinner group = (Spinner)findViewById(R.id.txtGroup);
        final TextView result = ((TextView)findViewById(R.id.txtResult));

        Button cost = (Button)findViewById(R.id.btnCost);
        cost.setOnClickListener(new View.OnClickListener() {
            final TextView result = ((TextView)findViewById(R.id.txtResult));

            @Override
            public void onClick(View v) {

                numberOfTickets = Integer.parseInt(tickets.getText().toString());



                totalCost = costPerTicket * numberOfTickets;
                DecimalFormat currency = new DecimalFormat("$###,###.##");
                // ABOVE WE CONVERTED THE NUM OF TICKETS TO STRINGS, WE THEN MULTIPLIED THE COST PER TICKET AND NUM OF TIKCETS.  FINALLY SET THE DECIMAL FORMAT

                // NOW, LET US convert the selected group item (from spinner) to a string
                groupChoice = group.getSelectedItem().toString();

                result.setText("Cost for " + groupChoice + " is " + currency.format(totalCost));

            }
        });
    }
}
