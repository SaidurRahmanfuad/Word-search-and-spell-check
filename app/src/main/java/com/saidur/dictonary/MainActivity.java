package com.saidur.dictonary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView listView;
SearchView searchView;
EditText inputText;

ArrayList<WordItem> wordList;
ArrayAdapter<String> adapter;
WordAdapter filterAdapter;
RecyclerView recyclerView;
private RecyclerView.LayoutManager mLayoutManager;
private AutoCompleteTextView autoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listView);
        searchView=findViewById(R.id.seearchview);
        recyclerView=findViewById(R.id.recyclerWord);
        inputText=findViewById(R.id.searchtext);
        autoCompleteTextView=findViewById(R.id.actv);
        //search
        Sysyem1();
        //filter
        System2();
        //Autocomplete tv
        autoCompleteTextView.setAdapter(adapter);





    }

    public void Sysyem1()
    { ArrayList<String> word= new ArrayList<>();
        word.add("name"); word.add("watch"); word.add("dream");
        word.add("apple"); word.add("apeal");  word.add("apple"); word.add("apple");
        word.add("ball");

        adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,word);
        listView.setAdapter(adapter);
        searchView.setQueryHint("Search here");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return true;
            }
        });

    }

    private void System2(){
        createWordList();

        inputText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                recyclerView.setVisibility(View.GONE);
            }

            @Override
            public void afterTextChanged(Editable editable) {

                filter(editable.toString());
                recyclerView.setVisibility(View.VISIBLE);
            }
        });

        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        filterAdapter = new WordAdapter(wordList,MainActivity.this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(filterAdapter);
    }
    private void filter(String word) {
         ArrayList<WordItem> filterwordlist=new ArrayList<>();
         for (WordItem words : wordList)
         {
             if (words.getItem().toLowerCase().contains(word.toLowerCase()))
             {
                 filterwordlist.add(words);
             }
         }

         filterAdapter.filterListFun(filterwordlist);
         filterAdapter.notifyDataSetChanged();


    }

    private void createWordList()
    {
        wordList=new ArrayList<>();
        wordList.add(new WordItem("One"));
        wordList.add(new WordItem("Two"));
        wordList.add(new WordItem("Three"));
        wordList.add(new WordItem("Four"));
        wordList.add(new WordItem("Five"));
        wordList.add(new WordItem("Six"));
        wordList.add(new WordItem("Seven"));
        wordList.add(new WordItem("Office"));
        wordList.add(new WordItem("Maven"));
        wordList.add(new WordItem("Axe"));
    }
 /*   public void filterList(ArrayList<ExampleItem> filteredList) {
        mExampleList = filteredList;
        notifyDataSetChanged();
    }*/
}