package teamtriplej.com.lipidlator21;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WaxEsters_Result_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wax_esters_result);
        TextView tvMolarMassResult = (TextView) findViewById(R.id.tvMolarMassResult);
        TextView tvFormulaResult = (TextView) findViewById(R.id.tvFormulaResult);
        TextView tvAlcoholResult = (TextView) findViewById(R.id.tvAlcoholResult);
        TextView tvAcidResult = (TextView) findViewById(R.id.tvAcidResult);
        TextView tvIonSelected = (TextView) findViewById(R.id.tvIonResult);
        TextView tvAbbreviation = (TextView) findViewById(R.id.tvAbbreviationResult);
        Button btnBack = (Button) findViewById(R.id.btnBack);
        Button btnHome = (Button) findViewById(R.id.btnHome);
        //Bring over the data from previous screen
        int ion = getIntent().getExtras().getInt("ion");
        int alcoholIndex = getIntent().getExtras().getInt("alcoholIndex");
        int acidIndex = getIntent().getExtras().getInt("acidIndex");
        String ionSelected = getIntent().getExtras().getString("ionSelected");
        String alcoholSelected = getIntent().getExtras().getString("alcoholSelected");
        String acidSelected = getIntent().getExtras().getString("acidSelected");
        Calculations calc = new Calculations();
        double mass = calc.calculateWEBasicMass(alcoholIndex,acidIndex);
        double molarMass = Math.round(calc.calculateFinalMass(ion, mass)*10000d)/10000d;
        String formula = calc.calculateFormula(calc.getNumC(), calc.getNumH(), calc.getNumO(), calc.getNumN(),
                calc.getNumAg(), calc.getNumLi(), calc.getNumNa(), calc.getNumK(), calc.getNumCl(),
                calc.getNumP(), calc.getNumS(), calc.getNumF());
        tvMolarMassResult.setText(Double.toString(molarMass));
        tvFormulaResult.setText(formula);
        tvIonSelected.setText(ionSelected);
        tvAlcoholResult.setText(alcoholSelected);
        tvAcidResult.setText(acidSelected);

        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WaxEsters_Result_Activity.this, WaxEstersActivity.class);
                startActivity(intent);
            }
        });
        btnHome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WaxEsters_Result_Activity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}