package com.sar.user.notes_room;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class RecylcerrView extends RecyclerView.ViewHolder {
    TextView textView1,textView2;
    public RecylcerrView(@NonNull View itemView) {
        super(itemView);
        textView1=itemView.findViewById(R.id.textView);
         textView2=itemView.findViewById(R.id.textView2);

    }
}
