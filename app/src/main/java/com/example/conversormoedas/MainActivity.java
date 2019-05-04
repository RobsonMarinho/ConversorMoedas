package com.example.conversormoedas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.editValue = (EditText) findViewById(R.id.edit_value);
        this.mViewHolder.textDollar = (TextView) findViewById(R.id.text_dollar);
        this.mViewHolder.textEuro = (TextView) findViewById(R.id.text_euro);
        this.mViewHolder.buttonCalculate = (Button) findViewById(R.id.button_calculate);

        this.mViewHolder.buttonCalculate.setOnClickListener(this);

        this.clearValues();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_calculate) {
            String value = this.mViewHolder.editValue.getText().toString();
            if ("",equals(value)) {
                Toast.makeText( this, this.getString(R.string.informe_valor), Toast.LENGTH_LONG).show();
            }else {

            }mViewHolder.textDollar.setText(String.format("%.2f" , value * 3));
            this.mViewHolder.textEuro.setText(String.format("%.2f" , value * 4));
        }
    }

//Método de tratamento
    private void clearValues(){
        this.mViewHolder.textDollar.setText(" ");
        this.mViewHolder.textEuro.setText(" ");
    }

    private static class ViewHolder {
        EditText editValue;
        TextView textDollar;
        TextView textEuro;
        Button buttonCalculate;
    }
}
