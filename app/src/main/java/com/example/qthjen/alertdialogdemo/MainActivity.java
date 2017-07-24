package com.example.qthjen.alertdialogdemo;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<String> arrayList;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv  = (ListView) findViewById(R.id.lv);
        arrayList = new ArrayList<>();

        arrayList.add("Java");
        arrayList.add("Kotlin");
        arrayList.add("Swift");
        arrayList.add("CShape");
        arrayList.add("Python");
        arrayList.add("Golang");
        arrayList.add("React Native");
        arrayList.add("PHP");

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        lv.setAdapter(arrayAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                deleteConfirm(i);
            }
        });

    }

    private void deleteConfirm(final int position) {
        /** alert dialog giống jOptionPane.showConfirmDialog **/
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Message");
        alertDialog.setIcon(R.mipmap.ic_launcher);
        alertDialog.setMessage("Are you delete this subject");

        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {    // yes
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                arrayList.remove(position);
                arrayAdapter.notifyDataSetChanged();
            }
        });

        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {     // no
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertDialog.show();

    }

}
