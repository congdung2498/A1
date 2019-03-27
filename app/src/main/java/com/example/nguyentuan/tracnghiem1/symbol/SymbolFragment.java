package com.example.nguyentuan.tracnghiem1.symbol;


import android.content.Context;
import android.database.Cursor;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.nguyentuan.tracnghiem1.MainActivity;
import com.example.nguyentuan.tracnghiem1.R;
import com.example.nguyentuan.tracnghiem1.Tips.TipsAdapter;
import com.example.nguyentuan.tracnghiem1.Tips.TipsController;
import com.example.nguyentuan.tracnghiem1.question.Question;
import com.example.nguyentuan.tracnghiem1.slide.ScreenSlideActivity;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SymbolFragment extends Fragment {

    ListView lvSymbols;
    SymbolController  symbolsController;
    SymbolsAdapter symbolsAdapter;


    public SymbolFragment() {
        // Required empty public constructor
    }

    public void begin() {
        lvSymbols = (ListView) getActivity().findViewById(R.id.lvSymbols);
        symbolsController = new SymbolController(getActivity());
        listCursor(symbolsController.getSymbols());
    }

    public void listCursor(Cursor cursor) {
        symbolsAdapter = new SymbolsAdapter(getActivity(), cursor, true);
        lvSymbols.setAdapter(symbolsAdapter);
        symbolsAdapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Biển báo giao thông đường bộ");

        return inflater.inflate(R.layout.fragment_symbols, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        begin();
    }

}
