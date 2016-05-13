package kr.co.yogibaba.www.yogibaba.shoppingtab;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.viewpagerindicator.CirclePageIndicator;
import com.viewpagerindicator.PageIndicator;

import kr.co.yogibaba.www.yogibaba.MainActivity;
import kr.co.yogibaba.www.yogibaba.R;
import kr.co.yogibaba.www.yogibaba.data.ShoppingDataByCategory;
import kr.co.yogibaba.www.yogibaba.data.ShoppingViewPageData;
import kr.co.yogibaba.www.yogibaba.shoppingtab.electronicgoods.ElectronicgoodsAdapter;
import kr.co.yogibaba.www.yogibaba.shoppingtab.electronicgoods.ElectronicgoodsViewHolder;
import kr.co.yogibaba.www.yogibaba.shoppingtab.shoppingdetail.ShoppingDetailActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ElectronicgoodsTabFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ElectronicgoodsTabFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public ElectronicgoodsTabFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ElectronicgoodsTabFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ElectronicgoodsTabFragment newInstance(String param1, String param2) {
        ElectronicgoodsTabFragment fragment = new ElectronicgoodsTabFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    ElectronicgoodsAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        mAdapter=new ElectronicgoodsAdapter();
        mAdapter.setOnItemClicListener(new ElectronicgoodsViewHolder.OnItemClickListener() {
            @Override
            public void onItemClick(View view, ShoppingDataByCategory product) {
                Intent intent=new Intent(getContext(), ShoppingDetailActivity.class);
                startActivity(intent);
            }
        });


        setData();

    }
    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_electronicgoods_tab, container, false);
        recyclerView=(RecyclerView)view.findViewById(R.id.rv_shopping_elec);
        recyclerView.setAdapter(mAdapter);
        gridLayoutManager=new GridLayoutManager(getContext(),2);

        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) { //포지션에 따라 한칸을 차지할거냐 두칸을 차지할거냐
                int type = mAdapter.getItemViewType(position);
                if (type == ElectronicgoodsAdapter.VIEW_TYPE_RECYCLER) {
                    return 1;
                } else {
                    return 2;
                }
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);

        return  view;
    }
    private void setData(){
        for(int i=0; i<20; i++ ){
            ShoppingDataByCategory d=new ShoppingDataByCategory();
            d.setImagUrl("ss");
            d.setManufactorer("전기");
            d.setProductTitle("전기");
            d.setProductPrice(20000);
            mAdapter.add(d);
        }
        ShoppingViewPageData d=new ShoppingViewPageData();
        String[] temp={"Asdsad","asdads"};
        d.setImageUrl(temp);
        mAdapter.add(d);

    }

}
