package com.example.wuchaochao.dfx;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by zouyi on 2018/3/4.
 */

import static android.content.ContentValues.TAG;
public class school extends AppCompatActivity {
    private String[] school = {"南京邮电大学通达学院","南京林业大学"};

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.school);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(school.this,android.R.layout.simple_list_item_1,school);
        final ListView listView =  (ListView) findViewById(R.id.list_item);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                Log.e(TAG, "onItemClick: "+position);
                switch(position){
                    case 0:{
                        LoginActivity.jwUrl="http://42.247.7.170/";
                        Constant.CHECK_IMAGE_URL = "/CheckCode.aspx";
                        break;
                    }
                    case 1:{
                        LoginActivity.jwUrl="http://jwk.njfu.edu.cn/";
                        Constant.CHECK_IMAGE_URL = "/sys/ValidateCode.aspx";
                        break;
                    }
                    default:
                }

                Intent intent = new Intent(school.this,LoginActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.searcher, menu);
        return super.onCreateOptionsMenu(menu);
    }



}
