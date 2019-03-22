package com.example.nguyentuan.tracnghiem1.monhoc;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.ViewFlipper;

import com.example.nguyentuan.tracnghiem1.MainActivity;
import com.example.nguyentuan.tracnghiem1.R;
import com.example.nguyentuan.tracnghiem1.Tips.TipsFragment;
import com.example.nguyentuan.tracnghiem1.question.SearchQuesFragment;
import com.example.nguyentuan.tracnghiem1.score.ScoreAdapter;
import com.example.nguyentuan.tracnghiem1.score.ScoreController;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private ViewFlipper viewFlipper;

    private Button btnA1, btnBienBao, btnLyThuyet, btnMeo, btnTraCuuLuat, btnCauHaySai;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Ôn thi giấy phép lái xe A1");
        return inflater.inflate(R.layout.fragment_home, container, false);

    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        viewFlipper=(ViewFlipper)getActivity().findViewById(R.id.viewFlipper);
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);

        btnA1 = (Button) getActivity().findViewById(R.id.btnA1);
        btnA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                A1Fragment a1Fragment = new A1Fragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.content_main, a1Fragment, a1Fragment.getTag()).commit();
            }
        });
        btnBienBao = (Button) getActivity().findViewById(R.id.btnBienBao);
        btnBienBao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                A1Fragment a1Fragment = new A1Fragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.content_main, a1Fragment, a1Fragment.getTag()).commit();
            }
        });
        btnLyThuyet = (Button) getActivity().findViewById(R.id.btnLyThuyet);
        btnLyThuyet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SearchQuesFragment searchQuesFragment = new SearchQuesFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.content_main, searchQuesFragment, searchQuesFragment.getTag()).commit();
            }
        });
        btnMeo = (Button) getActivity().findViewById(R.id.btnMeo);
        btnMeo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TipsFragment tipsFragment = new TipsFragment();
                FragmentManager manager = getFragmentManager();
                manager.beginTransaction().replace(R.id.content_main, tipsFragment, tipsFragment.getTag()).commit();
            }
        });

    }

}
