package kr.co.yogibaba.www.yogibaba.shoppingtab.props;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import kr.co.yogibaba.www.yogibaba.R;
import kr.co.yogibaba.www.yogibaba.data.ShoppingDataByCategory;

/**
 * Created by OhDaeKyoung on 2016. 5. 13..
 */
public class PropsViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView productTitle,productPrice,productManufatoruer;
    ShoppingDataByCategory mdata;
    public PropsViewHolder(View itemView) {
        super(itemView);
        imageView=(ImageView)itemView.findViewById(R.id.img_shopping_item_by_category);
        productTitle=(TextView)itemView.findViewById(R.id.text_shopping_item_by_category_title);
        productPrice=(TextView)itemView.findViewById(R.id.text_shopping_item_by_category_price);
        productManufatoruer=(TextView)itemView.findViewById(R.id.text_shopping_item_by_category_manufactorer);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClick(v,mdata);
            }
        });
    }
    public void setShoppingDataByCategory(ShoppingDataByCategory data)
    {
        this.mdata=data;
        imageView.setImageResource(R.drawable.exampler);
        productTitle.setText(data.getProductTitle());
        productPrice.setText("가격: "+data.getProductPrice()+" won");
        productManufatoruer.setText(data.getManufactorer());
    }
    public interface OnItemClickListener {
        public void onItemClick(View view, ShoppingDataByCategory product);
    }

    OnItemClickListener mListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

}
