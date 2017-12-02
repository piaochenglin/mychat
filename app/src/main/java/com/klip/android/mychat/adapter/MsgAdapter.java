package com.klip.android.mychat.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.klip.android.mychat.Msg;
import com.klip.android.mychat.R;

import java.util.ArrayList;


/**
 * Created by park
 * on 2017/11/22.
 */

public class MsgAdapter extends RecyclerView.Adapter<MsgViewHolder> {
    private ArrayList<Msg> msgs;
    public View view;

    public MsgAdapter(ArrayList<Msg> msgs) {
        this.msgs = msgs;
    }

    @Override
    public MsgViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item, parent, false);
        return new MsgViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MsgViewHolder holder, int position) {
        Msg msg = msgs.get(position);
        if (Msg.RECEIVE.equals(msg.getType())) {
            holder.linearLayoutRight.setVisibility(View.GONE);
            holder.linearLayoutLeft.setVisibility(View.VISIBLE);
            holder.textViewLeft.setText(msg.getContent());
        } else if (Msg.SEND.equals(msg.getType())) {
            holder.linearLayoutLeft.setVisibility(View.GONE);
            holder.linearLayoutRight.setVisibility(View.VISIBLE);
            holder.textViewRight.setText(msg.getContent());
        }

    }

    @Override
    public int getItemCount() {
        return msgs.size();
    }
}
