package com.example.aldemuhamad.androidquiz;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by aldemuhamad on 5/14/2017.
 */

public class ExplainAdapter extends RecyclerView.Adapter<ExplainAdapter.MyViewHolder> {

    private List<ExplainModel> explainModelList;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView answer;
        TextView explain;
        LinearLayout layoutExplain;

        public MyViewHolder(View view){
            super(view);
            answer = (TextView) view.findViewById(R.id.mTextAnswer);
            explain = (TextView) view.findViewById(R.id.mTextExplain);
            layoutExplain = (LinearLayout) view.findViewById(R.id.layout_explain);
        }
    }

    public ExplainAdapter(Context context, List<ExplainModel> explainModelList){
        this.explainModelList = explainModelList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_explaination, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position){
        final ExplainModel explain = explainModelList.get(position);
        holder.answer.setText(explain.getAnswer());
        holder.explain.setText(explain.getExplain());
    }

    @Override
    public int getItemCount(){
        return explainModelList.size();
    }

}
