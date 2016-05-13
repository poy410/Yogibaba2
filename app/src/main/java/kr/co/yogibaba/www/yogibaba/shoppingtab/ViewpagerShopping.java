package kr.co.yogibaba.www.yogibaba.shoppingtab;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import kr.co.yogibaba.www.yogibaba.R;
import kr.co.yogibaba.www.yogibaba.data.ShoppingViewPageData;

/**
 * Created by OhDaeKyoung on 2016. 5. 13..
 */
public class ViewpagerShopping extends PagerAdapter {
    LayoutInflater inflater;
    ShoppingViewPageData mData;
    public void setmData(ShoppingViewPageData data)
    {
        mData=data;
    }
    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((View)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view=null;
        view=inflater.inflate(R.layout.view_viewpager_shoppingtab,null);

        ImageView imageView=(ImageView)view.findViewById(R.id.img_viewpager_childimage);
        imageView.setImageResource(R.drawable.gametitle_01+position);
        container.addView(view);
        return view;
    }

    public ViewpagerShopping(LayoutInflater inflater) {
        this.inflater=inflater;

    }
}
