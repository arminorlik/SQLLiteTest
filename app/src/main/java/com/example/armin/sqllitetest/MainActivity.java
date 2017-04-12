package com.example.armin.sqllitetest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    DatabaseHelper databaseHelper;
    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.btnAdd)
    Button btnAdd;
    @BindView(R.id.btnView)
    Button btnView;
    private DatabaseHelper mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mDatabaseHelper = new DatabaseHelper(this);
    }

    @OnClick(R.id.btnAdd)
    public void btnAdd() {
        String newEntry = editText.getText().toString();
        if (editText.length() != 0) {
            AddData(newEntry);
            editText.setText("");
        } else {
            toastMessage("Musisz wpisać jakiś tekst");
        }
    }

    @OnClick(R.id.btnView)
    public void setBtnView(){
        Intent intent = new Intent(MainActivity.this, ListDataActivity.class);
        startActivity(intent);

    }

    public void AddData(String entry) {
        boolean insertData = mDatabaseHelper.addData(entry);

        if (insertData) {
            toastMessage("Dane wstawione do bazy");
        } else {
            toastMessage("Coś poszło nie tak");
        }
    }

    public void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }




}
