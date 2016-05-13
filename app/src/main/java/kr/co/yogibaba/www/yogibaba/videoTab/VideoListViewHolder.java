package kr.co.yogibaba.www.yogibaba.videoTab;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import kr.co.yogibaba.www.yogibaba.MyApplication;
import kr.co.yogibaba.www.yogibaba.R;
import kr.co.yogibaba.www.yogibaba.Splash;
import kr.co.yogibaba.www.yogibaba.TempActivity;
import kr.co.yogibaba.www.yogibaba.data.VideoListData;

/**
 * Created by Tacademy on 2016-05-12.
 */
public class VideoListViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView videoTitle,videoViewCount;
    Button videoShow;
    VideoListData mData;

    public interface OnItemClickListener {
        public void onItemClick(View view, VideoListData product);
    }

    OnItemClickListener mListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }
    /*static Context context= MyApplication.getContext();
    public interface OnButtonClickListener{
         public void onButtonClick(Context context);
    }
    OnButtonClickListener mListener;
    public void setOnButtonClickListener(OnButtonClickListener listener){
        mListener=listener;
    }*/
    public VideoListViewHolder(View itemView, final Context context) {
        super(itemView);
        imageView=(ImageView)itemView.findViewById(R.id.imgview_video_list);
        videoTitle=(TextView)itemView.findViewById(R.id.text_video_list_title);
        videoViewCount=(TextView)itemView.findViewById(R.id.text_video_list_view_count);
        videoShow=(Button)itemView.findViewById(R.id.btn_video_list_vrbtn);
        videoShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Intent intent=new Intent(context,TempActivity.class);
                context.startActivity(intent);
            }
        });
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener!=null) {
                    mListener.onItemClick(v, mData);
                }
            }
        });
    }
    public void setVideoListData(VideoListData data){
        mData=data;
        imageView.setImageResource(R.drawable.exampler);
        videoTitle.setText(data.getVideoTitle());
        videoViewCount.setText(data.getVideoTitle());

    }

}
