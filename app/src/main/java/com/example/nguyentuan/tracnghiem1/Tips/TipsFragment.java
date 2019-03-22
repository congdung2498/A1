package com.example.nguyentuan.tracnghiem1.Tips;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.database.Cursor;
import android.support.annotation.Nullable;
import android.widget.ListView;
import com.example.nguyentuan.tracnghiem1.MainActivity;
import com.example.nguyentuan.tracnghiem1.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TipsFragment extends Fragment {
    ListView lvTips;
    TipsController tipsController;
    TipsAdapter tipsAdapter;

    public TipsFragment() {
        // Required empty public constructor
    }

    public void begin() {
        lvTips = (ListView) getActivity().findViewById(R.id.lvTips);
        tipsController = new TipsController(getActivity());
        listCursor(tipsController.getTips());
    }

    public void listCursor(Cursor cursor) {
        tipsAdapter = new TipsAdapter(getActivity(), cursor, true);
        lvTips.setAdapter(tipsAdapter);
        tipsAdapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Mẹo thi đạt kết quả cao");
        return inflater.inflate(R.layout.fragment_tips, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        begin();
    }
}
