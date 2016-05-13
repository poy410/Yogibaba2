package kr.co.yogibaba.www.yogibaba.shoppingtab.lighting;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import kr.co.yogibaba.www.yogibaba.R;
import kr.co.yogibaba.www.yogibaba.data.ShoppingDataByCategory;
import kr.co.yogibaba.www.yogibaba.data.ShoppingViewPageData;


/**
 * Created by OhDaeKyoung on 2016. 5. 13..
 */
public class LightingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<ShoppingDataByCategory> items = new ArrayList<>();
    List<ShoppingViewPageData> itemsOfViewpager = new ArrayList<>();

    public static final int VIEW_TYPE_VIEWPAGE = 1;
    public static final int VIEW_TYPE_RECYCLER = 2;

    public void add(ShoppingDataByCategory item) {
        items.add(item);
        notifyDataSetChanged();
    }

    public void add(ShoppingViewPageData item) {
        itemsOfViewpager.add(item);
        notifyDataSetChanged();
    }

    public void addAll(List<ShoppingDataByCategory> items) {
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    public void addAllViewPager(List<ShoppingViewPageData> itemsOfViewpager) {
        this.itemsOfViewpager.addAll(itemsOfViewpager);
        notifyDataSetChanged();
    }

    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }

    public void clearViewPager() {
        items.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return items.size() + 1;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == 0) {
            LightingViewPagerViewHolder h = (LightingViewPagerViewHolder) holder;
            h.setShoppingViewPagerData(itemsOfViewpager.get(position));
            return;
        }
        position--;
        LightingViewHolder h = (LightingViewHolder) holder;
        h.setShoppingDataByCategory(items.get(position));
        h.setOnItemClickListener(mListener);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_RECYCLER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_shopping_item_by_category, null);
            return new LightingViewHolder(view);
        }
        if (viewType == VIEW_TYPE_VIEWPAGE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_shopping_viewpager, null);
            return new LightingViewPagerViewHolder(view, LayoutInflater.from(parent.getContext()));

        }
        throw new IllegalArgumentException("invalid position");
    }
    @Override
    public int getItemViewType(int position) {
        if(position==0)
        {
            return VIEW_TYPE_VIEWPAGE;
        }
        else {
            return VIEW_TYPE_RECYCLER;
        }
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    LightingViewHolder.OnItemClickListener mListener;

    public void setOnItemClicListener(LightingViewHolder.OnItemClickListener listener) {
        mListener = listener;
    }
}