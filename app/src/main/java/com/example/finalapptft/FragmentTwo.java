package com.example.finalapptft;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.finalapptft.Adapter.AdapterFmtwo;
import com.example.finalapptft.Adapter.AdapterRv3;
import com.example.finalapptft.Constants.Constant;
import com.example.finalapptft.Object.ArratChampSinghlton;
import com.example.finalapptft.Object.CategoryChamp;
import com.example.finalapptft.Object.Champ;

import java.util.ArrayList;


public class FragmentTwo extends Fragment implements OnItemClickListener {
    private final String TAG = "Frt#";
    private ArrayList<Champ> champs;
    private androidx.recyclerview.widget.RecyclerView recyclerView1, recyclerView2;
    private AdapterRv3 adapterRv2;
    private GridLayoutManager layoutManager;
    private LinearLayoutManager linearLayout;
    private ArrayList<CategoryChamp> categoryChamps;
    private AdapterFmtwo adapterFmtwo;
    private Button remove;
    public FragmentTwo() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_two, container, false);

        champs=dataEmpty();
        anhxa(view);
        setup();
        init();
        return view;
    }

    public void anhxa(View view) {
        recyclerView1 = (androidx.recyclerview.widget.RecyclerView) view.findViewById(R.id.rcv_frmTwo);
        recyclerView2 = (androidx.recyclerview.widget.RecyclerView) view.findViewById(R.id.rcv_item_setion);
        remove = (Button) view.findViewById(R.id.btn_remove);
    }

    public void setup() {
        ArrayList<String> origin_class = new ArrayList<>();
        origin_class.add(Constant.ORIGIN_TK);
        origin_class.add(Constant.ORIGIN_CMCD);
        origin_class.add(Constant.ORIGIN_HT);
        origin_class.add(Constant.ORIGIN_KT);
        origin_class.add(Constant.ORIGIN_NL);
        origin_class.add(Constant.ORIGIN_PC);
        origin_class.add(Constant.ORIGIN_PHG);
        origin_class.add(Constant.ORIGIN_SCN);
        origin_class.add(Constant.ORIGIN_VBTT);
        origin_class.add(Constant.ORIGIN_VT);
        origin_class.add(Constant.CLASS_BA);
        origin_class.add(Constant.CLASS_BP);
        origin_class.add(Constant.CLASS_DS);
        origin_class.add(Constant.CLASS_HV);
        origin_class.add(Constant.CLASS_KK);
        origin_class.add(Constant.CLASS_MH);
        origin_class.add(Constant.CLASS_MT);
        origin_class.add(Constant.CLASS_MTA);
        origin_class.add(Constant.CLASS_NB);
        origin_class.add(Constant.CLASS_PT);
        origin_class.add(Constant.CLASS_PTH);
        origin_class.add(Constant.CLASS_TM);
        origin_class.add(Constant.CLASS_TP);
        origin_class.add(Constant.CLASS_XT);

        ArratChampSinghlton arratChampSinghlton = new ArratChampSinghlton().getarratChampSinghlton();
        categoryChamps = new ArrayList<>();
        for (int i = 0; i < origin_class.size(); i++) {
            ArrayList<Champ> champs1 = new ArrayList<>();
            for (Champ champ : arratChampSinghlton.getArr()) {
                if (origin_class.get(i).equals(champ.getClasss()) || origin_class.get(i).equals(champ.getOrigin())) {
                    champs1.add(champ);
                }
            }
            categoryChamps.add(new CategoryChamp(origin_class.get(i), champs1));
        }

    }

    public void init() {
        adapterRv2 = new AdapterRv3(getContext(), champs, this);
        layoutManager = new GridLayoutManager(getContext(), 5);
        recyclerView1.setLayoutManager(layoutManager);
        recyclerView1.setAdapter(adapterRv2);

        linearLayout = new LinearLayoutManager(getContext());

        adapterFmtwo = new AdapterFmtwo(getContext(), categoryChamps, this);
        recyclerView2.setLayoutManager(linearLayout);
        recyclerView2.setAdapter(adapterFmtwo);

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                while (champs.size()!=0){
                  champs.removeAll(champs);
                    adapterRv2.notifyDataSetChanged();
                };

                while (champs.size()!=10){
                    champs.add(new Champ(""));
                    adapterRv2.notifyDataSetChanged();
                };


            }
        });
    }


    @Override
    public void onClickListener(Champ champ) {
        if (champ.getNameChamp().equals("") == false) {
            int t = -1 ;
            int s = 0;
            for (int i = 0; i < champs.size(); i++) {
                if (champs.get(i).getNameChamp().equals("")) {
                    t=i;
                    break;
                }
            }

            for (int i = 0; i < champs.size(); i++) {
                    if(champs.get(i).getId()==champ.getId()){
                    s++;
                    break;
                }
            }
            if(s!=0||t==-1){
                return;
            }else {
                champs.remove(t);
                champs.add(t,champ);
            }
            adapterRv2.notifyDataSetChanged();
        }
    }

    @Override
    public void onClickListenerRemove(final Champ champ) {
        if (champ.getNameChamp().equals("") == false) {
                champs.remove(champ);
                champs.add(9,new Champ(""));
                adapterRv2.notifyDataSetChanged();
        }
    }

    public ArrayList<Champ> dataEmpty() {
        champs = new ArrayList<>();
        champs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            champs.add(new Champ(""));

        }
        return champs;
    }
}