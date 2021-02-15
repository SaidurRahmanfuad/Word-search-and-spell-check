package com.saidur.dictonary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView listView;
SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listView);
        searchView=findViewById(R.id.seearchview);
        ArrayList<String> word= new ArrayList<>();
        word.add("name"); word.add("watch"); word.add("dream");
        word.add("apple"); word.add("apeal");  word.add("apple"); word.add("apple");
        word.add("ball");

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,word);
        listView.setAdapter(adapter);

        //search
searchView.setQueryHint("Search here");
 searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
     @Override
     public boolean onQueryTextSubmit(String query) {
         return false;
     }

     @Override
     public boolean onQueryTextChange(String newText) {
         adapter.getFilter().filter(newText);
         return true;
     }
 });   }

}