package com.example.mytreeview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.unnamed.b.atv.model.TreeNode;

/**
 * Created by dell on 2017/3/14.
 */

public class MyHolder extends TreeNode.BaseNodeViewHolder<IconTreeItem> {

    private ViewHolder holder;

    public MyHolder(Context context) {
        super(context);
    }

    @Override
    public View createNodeView(TreeNode node, IconTreeItem value) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View inflate = inflater.inflate(R.layout.layout_item, null);
        holder = new ViewHolder(inflate);
        holder.mTvTitle.setText(value.getName());
        holder.mImgHead.setImageResource(value.getIcon());
        return inflate;
    }

    public static class ViewHolder {
        public View rootView;
        public ImageView mImgHead;
        public TextView mTvTitle;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.mImgHead = (ImageView) rootView.findViewById(R.id.img_head);
            this.mTvTitle = (TextView) rootView.findViewById(R.id.tv_title);
        }

    }
}
