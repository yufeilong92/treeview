package com.example.mytreeview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.unnamed.b.atv.model.TreeNode;
import com.unnamed.b.atv.view.AndroidTreeView;

public class MainActivity extends AppCompatActivity implements TreeNode.TreeNodeClickListener {

    private RelativeLayout mContinonal;
    public static final String TAG = "查询结果";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initContent();
        inittree();

    }

    private void inittree() {
        IconTreeItem iconTreeItem = new IconTreeItem();
        iconTreeItem.setIcon(R.mipmap.ic_launcher);
        iconTreeItem.setName("机器人");
        TreeNode child = new TreeNode(iconTreeItem).setViewHolder(new MyHolder(this));


    }

    private void initContent() {
        TreeNode root = TreeNode.root();

        IconTreeItem iconTreeItem1 = new IconTreeItem();
        iconTreeItem1.setIcon(R.mipmap.ic_launcher);
        iconTreeItem1.setName("MyParentNode");
        TreeNode parent1 = new TreeNode(iconTreeItem1).setViewHolder(new MyHolder(this));


        IconTreeItem iconTreeItem = new IconTreeItem();
        iconTreeItem.setIcon(R.mipmap.ic_launcher);
        iconTreeItem.setName("机器人");
        TreeNode child = new TreeNode(iconTreeItem).setViewHolder(new MyHolder(this));

//        TreeNode parent = new TreeNode("MyParentNode");

        IconTreeItem iconTreeItem2 = new IconTreeItem();
        iconTreeItem2.setName("ChildNode01");
        iconTreeItem2.setIcon(R.mipmap.ic_launcher);
        TreeNode childNocde1 = new TreeNode(iconTreeItem2).setViewHolder(new MyHolder(this));

        IconTreeItem iconTreeItem3 = new IconTreeItem();
        iconTreeItem2.setName("ChildNode02");
        iconTreeItem2.setIcon(R.mipmap.ic_launcher);
        TreeNode childNocde2 = new TreeNode(iconTreeItem2).setViewHolder(new MyHolder(this));

/*        TreeNode childNode01 = new TreeNode("ChildNode01");
        TreeNode childNode02 = new TreeNode("ChildNode02");*/
//        parent.addChildren(childNode01, childNode02);
        parent1.addChildren(childNocde1, childNocde2);//添加第二层元素
//        TreeNode child = new TreeNode("child");
//        TreeNode childs = new TreeNode("childs");
        IconTreeItem iconTreeItem4 = new IconTreeItem();
        iconTreeItem4.setName("childs");
        iconTreeItem4.setIcon(R.mipmap.ic_launcher);
        TreeNode childe = new TreeNode(iconTreeItem4).setViewHolder(new MyHolder(this));//添加布局数据
/*
        childNode01.addChildren(child);
        childNode02.addChildren(childs);
*/

        childNocde1.addChildren(child);//添加第三层元素
        childNocde2.addChildren(childe);
//        root.addChild(parent);
        root.addChild(parent1);//添加第一层元素

        AndroidTreeView treeView = new AndroidTreeView(getApplicationContext(), root);//把布局添加到root
    treeView.setDefaultAnimation(true);
        treeView.setUse2dScroll(true);
        treeView.setDefaultContainerStyle(R.style.TreeNodeStyle);//设置展示布局样式
        treeView.setDefaultNodeClickListener(this);//设置监听
        //设置view添加
        mContinonal.addView(treeView.getView());

    }

    private void initView() {
        /**
         * 布局界面
         */
        mContinonal = (RelativeLayout) findViewById(R.id.continonal);
    }

    /**
     * 设置监听
     * @param node
     * @param value
     */
    @Override
    public void onClick(TreeNode node, Object value) {
        String name = ((IconTreeItem) value).getName();
        Toast.makeText(MainActivity.this, "" + name, Toast.LENGTH_SHORT).show();
    }
}
