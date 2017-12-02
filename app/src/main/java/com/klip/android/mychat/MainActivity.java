package com.klip.android.mychat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.klip.android.mychat.adapter.MsgAdapter;

import java.util.ArrayList;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MsgAdapter msgAdapter;
    private ArrayList<Msg> msgs;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.chat_recycler_view);
        editText = (EditText) findViewById(R.id.edit_text);
        Button button = (Button) findViewById(R.id.send_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("".equals(editText.getText().toString())) {
                    Toast.makeText(MainActivity.this, "you can not send empty content", Toast.LENGTH_SHORT).show();
                } else {
                    Msg msg = new Msg();
                    String content = editText.getText().toString();
                    msg.setContent(content);
                    msg.setType(Msg.SEND);
                    msgs.add(msg);
                    msgAdapter.notifyItemChanged(msgs.size() - 1);
                    recyclerView.smoothScrollToPosition(msgs.size() - 1);
                    editText.setText("");

                }
            }
        });
        msgs = new ArrayList<>();
        intData();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        msgAdapter = new MsgAdapter(msgs);
        recyclerView.setAdapter(msgAdapter);
    }

    private void intData() {
        Msg msg = new Msg();
        msg.setContent("hallo");
        msg.setType(Msg.RECEIVE);
        msgs.add(msg);
        Msg msg1 = new Msg();
        msg1.setContent("how are you ");
        msg1.setType(Msg.RECEIVE);
        msgs.add(msg1);
        Msg msg2 = new Msg();
        msg2.setContent("fine thank you ,and you ? ");
        msg2.setType(Msg.SEND);
        msgs.add(msg2);
        Msg msg3 = new Msg();
        msg3.setContent("i am fine too.");
        msg3.setType(Msg.RECEIVE);
        msgs.add(msg3);
    }
}
