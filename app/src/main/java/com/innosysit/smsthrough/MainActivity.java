package com.innosysit.smsthrough;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.ClipData;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemSettingAdapter.ButtonClickListener {

    Dialog settingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 메인화면의 FloatingActionButton
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.newItem);

        // 메인화면의 리스트뷰
        ListView listview = findViewById(R.id.listView);

        ArrayList<ListData> mainItems = new ArrayList<>();
        String myPhoneNum = "01012345678";

        mainItems.add(new ListData(myPhoneNum, myPhoneNum, "2022/1/4", "Hello World"));
        mainItems.add(new ListData("01011112222", "01033334444", "2022/1/4", "Bye World"));

        ListViewAdapter adapter = new ListViewAdapter(mainItems, getApplicationContext());
        listview.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "Hello World", Toast.LENGTH_SHORT).show();
                showSettingDialog();
            }
        });

    }

    public void showSettingDialog() {

        // 설정 다이얼로그
        settingDialog = new Dialog(MainActivity.this);
        settingDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        settingDialog.setContentView(R.layout.item_setting);

        settingDialog.show();

        // 설정 다이얼로그 크기 조절
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(settingDialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        Window window = settingDialog.getWindow();
        window.setAttributes(lp);

        TextView addButton = settingDialog.findViewById(R.id.addSelectButton);
        TextView cancelButton = settingDialog.findViewById(R.id.setting_cancel);
        TextView saveButton = settingDialog.findViewById(R.id.setting_save);
        RecyclerView recyclerView = settingDialog.findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        List<ItemSettingData> dataList = new ArrayList<>();
        for(int i = 1; i <= 1; i++) {
            if(i == 1) dataList.add(new ItemSettingData("1st"));
            else if(i == 2) dataList.add(new ItemSettingData("2nd"));
            else dataList.add(new ItemSettingData(i + "th"));
        }

        ItemSettingAdapter recyclerAdapter = new ItemSettingAdapter(dataList);
        recyclerView.setAdapter(recyclerAdapter);

        recyclerAdapter.setOnClickListener(this);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataList.add(new ItemSettingData("new"));
                recyclerAdapter.notifyItemInserted(recyclerAdapter.getItemCount());
                //recyclerAdapter.notifyDataSetChanged();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                settingDialog.dismiss();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO : 저장 기능 추가
            }
        });

    }

    @Override
    public void onItemClicked(int position) {
        Toast.makeText(this, position + 1 + "번째 아이템", Toast.LENGTH_SHORT).show();
    }

    public void addSelectButton(View view) {
        Toast.makeText(this, "Button Clicked!", Toast.LENGTH_SHORT).show();
    }
}