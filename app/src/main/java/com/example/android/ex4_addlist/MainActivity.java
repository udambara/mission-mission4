package com.example.android.ex4_addlist;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TextView.OnEditorActionListener, AdapterView.OnItemClickListener {

    ListViewAdapter adapter;
    ArrayList<Player> items;
    ListView lvout;
    EditText etname;
    EditText etteam;
    Button btnadd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    void init(){
        //키보드 위로 edittext올리기
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        items = new ArrayList<Player>();
        adapter = new ListViewAdapter();

        lvout = (ListView)findViewById(R.id.lv);
        lvout.setOnItemClickListener(this);
        lvout.setAdapter(adapter);

        etname = (EditText)findViewById(R.id.et_name);
        etteam = (EditText)findViewById(R.id.et_team);
        btnadd = (Button)findViewById(R.id.btn_add);

        etname.setOnEditorActionListener(this);
        etteam.setOnEditorActionListener(this);
    }
    public void onClickAdd(View view){
        String inputname = etname.getText().toString();
        String inputteam = etteam.getText().toString();
        if (inputname != null && inputteam !=null) {
            adapter.addItem(inputname, inputteam);
            adapter.notifyDataSetChanged();
            etname.setText("");
            etteam.setText("");

            }
        //키보드 내리기
        view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if(textView.getId()==R.id.et_name && i== EditorInfo.IME_ACTION_NEXT){ // 뷰의 id를 식별, 키보드의 완료 키 입력 검출
           View view = this.getCurrentFocus();


        }
        if(textView.getId()==R.id.et_team && i== EditorInfo.IME_ACTION_SEND){
            View view = this.getCurrentFocus();
            onClickAdd(view);

        }
        return false;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
