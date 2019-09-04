package com.sar.user.notes_room;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.util.ListUpdateCallback;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecylcerrView> {

    Context context;
    List<Table> table;
    public RecyclerAdapter(Context context, List<Table>table) {
        this.context=context;
        this.table=table;

    }

    @NonNull
    @Override
    public RecylcerrView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card,viewGroup,false);

        return new RecylcerrView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecylcerrView recylcerrView, int i) {
        recylcerrView.textView1.setText(table.get(i).getId());
        recylcerrView.textView2.setText(table.get(i).getNotes());

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
