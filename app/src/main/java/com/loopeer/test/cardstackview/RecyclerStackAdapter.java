package com.loopeer.test.cardstackview;

import android.content.Context;
import android.graphics.PorterDuff;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.loopeer.cardstack.CardStackView;
import com.loopeer.cardstack.StackAdapter;

import java.util.ArrayList;
import java.util.List;

public class RecyclerStackAdapter extends StackAdapter<String> {

    public RecyclerStackAdapter(Context context) {
        super(context);
    }

    @Override
    public void bindView(String data, int position, CardStackView.ViewHolder holder) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder h = (ItemViewHolder) holder;
            h.onBind(data, position);
        }

    }

    @Override
    protected CardStackView.ViewHolder onCreateView(ViewGroup parent, int viewType) {
        View view = getLayoutInflater().inflate(R.layout.item_recycler, parent, false);
        return new ItemViewHolder(view);
    }


    static class ItemViewHolder extends CardStackView.ViewHolder {
        RecyclerView mRecycler;
        TextView mTextTitle;

        public ItemViewHolder(View view) {
            super(view);
            mRecycler = view.findViewById(R.id.recycler);
        }

        @Override
        public void onItemExpand(boolean b) {
        }

        public void onBind(String data, int position) {
            mRecycler.setAdapter(new ChildAdapter(getData(5)));
            mRecycler.setHasFixedSize(true);
            mRecycler.setNestedScrollingEnabled(false);
        }

        private List<String> getData(int count){
            List<String> data = new ArrayList<>(count);
            for(int i = 0 ;i< count;i++){
                data.add("模拟数据"+i);
            }
            return data;
        }

    }




}
