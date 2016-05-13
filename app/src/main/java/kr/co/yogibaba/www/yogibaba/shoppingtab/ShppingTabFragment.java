package kr.co.yogibaba.www.yogibaba.shoppingtab;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kr.co.yogibaba.www.yogibaba.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ShppingTabFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShppingTabFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public ShppingTabFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ShppingTabFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ShppingTabFragment newInstance(String param1, String param2) {
        ShppingTabFragment fragment = new ShppingTabFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }
    FragmentTabHost tabHost;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_shpping_tab, container, false);
        tabHost = (FragmentTabHost)view.findViewById(R.id.tabHost);
        tabHost.setup(getContext(), getChildFragmentManager(), android.R.id.tabcontent);

        tabHost.addTab(tabHost.newTabSpec("가구").setIndicator("가구"), FurnitureTabFragment.class, null);
        tabHost.addTab(tabHost.newTabSpec("소형가전").setIndicator("소형가전"), ElectronicgoodsTabFragment.class, null);
        tabHost.addTab(tabHost.newTabSpec("소품").setIndicator("소품"), PropsTabFragment.class, null);
        tabHost.addTab(tabHost.newTabSpec("조명").setIndicator("조명"), LightingTabFragment.class, null);

        return view;
    }

}
