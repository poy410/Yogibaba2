package kr.co.yogibaba.www.yogibaba.videoTab;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import kr.co.yogibaba.www.yogibaba.R;
import kr.co.yogibaba.www.yogibaba.data.VideoListData;

/**
 * Created by Tacademy on 2016-05-12.
 */
public class VideoListAdapter extends RecyclerView.Adapter<VideoListViewHolder> {
    Context context;
    List<VideoListData> items=new ArrayList<>();
    public void add(VideoListData item){
        items.add(item);
        notifyDataSetChanged();
    }
    public void addAll(List<VideoListData> items){
        this.items.addAll(items);
        notifyDataSetChanged();
    }
    public void clear(){
        items.clear();
        notifyDataSetChanged();
    }
    public VideoListAdapter() {
        super();
    }
    public VideoListAdapter(Context context) {
        super();
        this.context=context;
    }

    @Override
    public VideoListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.view_video_list,null);
        return new VideoListViewHolder(view,context);
    }

    @Override
    public void onBindViewHolder(VideoListViewHolder holder, int position) {
            holder.setVideoListData(items.get(position));
            holder.setOnItemClickListener(mListener);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    VideoListViewHolder.OnItemClickListener mListener;
    public void setOnItemClicListener(VideoListViewHolder.OnItemClickListener listener){
        mListener=listener;
    }
}
