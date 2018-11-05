package com.allenxcai.tuangou;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.allenxcai.tuangou.fragment.FoodDetailFragment;
import com.allenxcai.tuangou.fragment.HomePageFragment;
import com.allenxcai.tuangou.fragment.ShoppingFragment;
import com.allenxcai.tuangou.fragment.UserFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ActionBar actionBar;

    private LinearLayout mLlHomePage;
    private LinearLayout mLlShopping;
    private LinearLayout mLlUser;


    protected HomePageFragment homePageFragment = new HomePageFragment();//HomePage
    protected ShoppingFragment shoppingFragment = new ShoppingFragment();//Shopping
    protected UserFragment userFragment = new UserFragment();//User
    protected FoodDetailFragment foodInfoFragment = FoodDetailFragment.newInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionBar = getSupportActionBar();
        actionBar.hide();

        initView();


        //获取管理类
        this.getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.main_container_content, homePageFragment, "homePageFragment")
                .add(R.id.main_container_content, shoppingFragment, "shoppingFragment")
                .hide(shoppingFragment)
                .add(R.id.main_container_content, userFragment, "userFragment")
                .hide(userFragment)
                .add(R.id.main_container_content, foodInfoFragment, "foodInfoFragment")
                .hide(foodInfoFragment)
                //添加事物 默认：显示首页 其他：隐藏
                //提交
                .commit();


    }

    private void initView() {
        mLlHomePage = findViewById(R.id.main_menu_homepage);
        mLlShopping = findViewById(R.id.main_menu_shopping);
        mLlUser = findViewById(R.id.main_menu_user);

        mLlHomePage.setOnClickListener(this);
        mLlShopping.setOnClickListener(this);
        mLlUser.setOnClickListener(this);


    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.main_menu_homepage://首页
                SwitchFragment("homePageFragment");
                break;
            case R.id.main_menu_shopping://购物
                SwitchFragment("shoppingFragment");
                break;

            case R.id.main_menu_user://用户
                SwitchFragment("userFragment");
                break;

        }


    }

    public void SwitchFragment(String tagFrag) {
        Fragment fragment = this.getSupportFragmentManager().findFragmentByTag(tagFrag);
        this.getSupportFragmentManager()
                .beginTransaction()
                .hide(homePageFragment)
                .hide(shoppingFragment)
                .hide(foodInfoFragment)
                .show(fragment)
                .commit();

    }
}
