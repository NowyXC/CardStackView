package com.loopeer.test.cardstackview;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class ChildAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    int color[] = {
      0xFF00FFFF,
      0xFFFFF11F,
      0xFFFFFF00,
      0xFFFF0000,
      0xFFFF00FF
    };
    public ChildAdapter(@Nullable List<String> data) {
        super(R.layout.item_recycler_child,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.getView(R.id.recycler_child_Img).setBackgroundColor(color[helper.getAdapterPosition()%color.length]);
        helper.setText(R.id.recycler_child_Tv,String.valueOf(helper.getAdapterPosition()+1));
    }
}
