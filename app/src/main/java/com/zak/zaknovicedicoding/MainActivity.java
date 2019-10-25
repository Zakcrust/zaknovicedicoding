package com.zak.zaknovicedicoding;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvHelloWorld;
    private ArrayList<HelloWorld> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rvHelloWorld = findViewById(R.id.rv_hello_worlds);
        rvHelloWorld.setHasFixedSize(true);

        list.addAll(HelloWorldData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList(){
        rvHelloWorld.setLayoutManager(new LinearLayoutManager(this));
        ListHelloWorldAdapter listhwAdapter = new ListHelloWorldAdapter(list);
        rvHelloWorld.setAdapter(listhwAdapter);

        listhwAdapter.setOnItemClickCallback(new ListHelloWorldAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(HelloWorld data) {
                showSelectedLanguage(data);
            }
        });
    }

    private void showSelectedLanguage(HelloWorld hw) {
        Toast.makeText(this, "Kamu memilih " + hw.getName(), Toast.LENGTH_SHORT).show();
    }
}
