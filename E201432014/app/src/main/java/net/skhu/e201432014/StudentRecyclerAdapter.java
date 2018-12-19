package net.skhu.e201432014;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class StudentRecyclerAdapter extends RecyclerView.Adapter<StudentRecyclerAdapter.ViewHolder>{

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView studentNumber;
        TextView name;

        public ViewHolder(View view) {
            super(view);
            studentNumber = view.findViewById(R.id.textView_studentNumber);
            name = view.findViewById(R.id.textView_name);
            view.setOnClickListener(this);
        }

        public void setData() {
            StudentData data = arrayList.get(getAdapterPosition());
            studentNumber.setText(data.getNumber());
            name.setText(data.getName());
        }

        @Override
        public void onClick(View view){
            int index = super.getAdapterPosition();
            arrayList.remove(index);
            adapter.notifyDataSetChanged();
        }

    }

    final StudentRecyclerAdapter adapter = this;
    LayoutInflater layoutInflater;
    ArrayList<StudentData> arrayList;

    public StudentRecyclerAdapter(Context context, ArrayList<StudentData> arrayList) {
        this.layoutInflater = LayoutInflater.from(context);
        this.arrayList = arrayList;
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = layoutInflater.inflate(R.layout.item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int index) {
        viewHolder.setData();
    }
}
