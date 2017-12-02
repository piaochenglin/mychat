package com.klip.android.mychat.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.klip.android.mychat.R;

import static com.klip.android.mychat.R.id.left_layout;

/**
 * Created by park
 * on 2017/11/22.
 */

public class MsgViewHolder extends RecyclerView.ViewHolder {
    public LinearLayout linearLayoutLeft;
    public LinearLayout linearLayoutRight;
    public TextView textViewLeft;
    public TextView textViewRight;

    public MsgViewHolder(View itemView) {

        super(itemView);
        linearLayoutLeft = (LinearLayout) itemView.findViewById(R.id.left_layout);
        linearLayoutRight = (LinearLayout) itemView.findViewById(R.id.right_layout);
        textViewLeft = (TextView) itemView.findViewById(R.id.left_text);
        textViewRight = (TextView) itemView.findViewById(R.id.right_text);
    }
}
