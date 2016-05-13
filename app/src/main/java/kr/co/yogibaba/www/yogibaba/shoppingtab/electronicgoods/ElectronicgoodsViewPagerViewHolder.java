package kr.co.yogibaba.www.yogibaba.shoppingtab.electronicgoods;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.viewpagerindicator.CirclePageIndicator;

import kr.co.yogibaba.www.yogibaba.R;
import kr.co.yogibaba.www.yogibaba.data.ShoppingViewPageData;
import kr.co.yogibaba.www.yogibaba.shoppingtab.ViewpagerShopping;

/**
 * Created by OhDaeKyoung on 2016. 5. 13..
 */
public class ElectronicgoodsViewPagerViewHolder extends RecyclerView.ViewHolder {
    ViewPager viewPager;
    CirclePageIndicator mIndicator;
    ViewpagerShopping mPagerAdapter;

    void setShoppingViewPagerData(ShoppingViewPageData data){
        mPagerAdapter.setmData(data);

    }
    public ElectronicgoodsViewPagerViewHolder(View itemView,LayoutInflater inflater) {
        super(itemView);
        mPagerAdapter=new ViewpagerShopping(inflater);   //getLayoutInflater(savedInstanceState));
        viewPager=(ViewPager)itemView.findViewById(R.id.viewpager_elec);
        viewPager.setAdapter(mPagerAdapter);
        viewPager.addOnPageChangeListener(mPageChangeListener);
        mIndicator=(CirclePageIndicator)itemView.findViewById(R.id.titles);
        //mIndicator.setOnPageChangeListener();
        mIndicator.setViewPager(viewPager);
        mIndicator.setOnPageChangeListener(mPageChangeListener);
    }

    ViewPager.OnPageChangeListener mPageChangeListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            viewPager.setCurrentItem(position);
            mIndicator.setCurrentItem(position);
        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
