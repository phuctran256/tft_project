package com.example.finalapptft;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.example.finalapptft.Adapter.AdapterRv1;
import com.example.finalapptft.Adapter.AdapterRv2;
import com.example.finalapptft.Constants.Constant;
import com.example.finalapptft.Object.Activated;
import com.example.finalapptft.Object.ArratChampSinghlton;
import com.example.finalapptft.Object.Champ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DetailsChamp extends AppCompatActivity implements OnItemClickListener{
    private Intent intent;
    private androidx.appcompat.widget.Toolbar toolbar;
    private TextView titleToolbar;
    private Champ champ;
    private ArratChampSinghlton arratChampSinghlton;
    private ImageView imgCover;
    private ImageView skill;
    private TextView nameskill;
    private TextView skillContent;
    private TextView skilactive1, skilactive2, skilactive3;
    private TextView origin;
    private androidx.recyclerview.widget.RecyclerView recyclerView1, recyclerView2, recyclerView3, recyclerView4, recyclerView5, recyclerView6;
    private AdapterRv1 adapterRv1_1, adapterRv1_2;
    private ArrayList<Activated> activatedList1, activatedList2, activateds3;
    private LinearLayoutManager layoutManager;
    private AdapterRv2 adapterRv2_1, adapterRv2_2;
    private ArrayList<Champ> originArr;
    private ArrayList<Champ> classArr, champs3;
    private GridLayoutManager gridView1, gridView2;
    private TextView name_origin;
    private TextView name_class1;
    private TextView class1;

    private LinearLayoutManager layoutManager2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        anhxa();
        setup();
        init();
        Origin();
        Class();
        if (champ.getId() == 42) {
            irelia();
        }
    }

    public void anhxa() {
        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        titleToolbar = (TextView) findViewById(R.id.title_toolbar);
        imgCover = (ImageView) findViewById(R.id.image_cover);
        skill = (ImageView) findViewById(R.id.skill);
        nameskill = (TextView) findViewById(R.id.name_skill);
        skillContent = (TextView) findViewById(R.id.skill_content);
        skilactive1 = (TextView) findViewById(R.id.skill_activated1);
        skilactive2 = (TextView) findViewById(R.id.skill_activated2);
        skilactive3 = (TextView) findViewById(R.id.skill_activated3);
        origin = (TextView) findViewById(R.id.origin);
        recyclerView1 = (androidx.recyclerview.widget.RecyclerView) findViewById(R.id.rv_item1);
        recyclerView2 = (androidx.recyclerview.widget.RecyclerView) findViewById(R.id.rv_item2);
        recyclerView3 = (androidx.recyclerview.widget.RecyclerView) findViewById(R.id.rv_item3);
        recyclerView4 = (androidx.recyclerview.widget.RecyclerView) findViewById(R.id.rv_item4);
        name_origin = (TextView) findViewById(R.id.name_origin);
        class1 = (TextView) findViewById(R.id.class1);
        name_class1 = (TextView) findViewById(R.id.name_class1);
    }

    public void setup() {
        intent = getIntent();
        arratChampSinghlton = new ArratChampSinghlton().getarratChampSinghlton();
        champ = arratChampSinghlton.getArr().get(intent.getIntExtra("p", 0));
        originArr = new ArrayList<>();
        classArr = new ArrayList<>();

        for (int i = 0; i < arratChampSinghlton.getArr().size(); i++) {
            if (arratChampSinghlton.getArr().get(i).getOrigin().equals(champ.getOrigin())) {
                originArr.add(arratChampSinghlton.getArr().get(i));
            }

            if (arratChampSinghlton.getArr().get(i).getClasss().equals(champ.getClasss())) {
                classArr.add(arratChampSinghlton.getArr().get(i));
            }
        }
        if (champ.getClasss().equals(Constant.CLASS_MTA)) {
            for (Champ champ : arratChampSinghlton.getArr()) {
                if (champ.getId() == 42) {
                    classArr.add(champ);
                }
            }
        }
        Collections.sort(originArr, new Comparator<Champ>() {
            @Override
            public int compare(Champ o1, Champ o2) {
                return o1.getGold() - o2.getGold();
            }
        });
        Collections.sort(classArr, new Comparator<Champ>() {
            @Override
            public int compare(Champ o1, Champ o2) {
                return o1.getGold() - o2.getGold();
            }
        });
    }

    public void init() {

        titleToolbar.setText(champ.getNameChamp());
        titleToolbar.setTextColor(Color.parseColor(champ.color()));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Glide.with(this).load(champ.getLinkCoverChamp()).into(imgCover);
        Glide.with(this).load(champ.getLinkSlills()).into(skill);
        nameskill.setText(champ.getSkillName());
        nameskill.setTextColor(Color.parseColor(champ.color()));
        skillContent.setText(champ.getSkillContents());
        if (champ.getActivatedSkill().getCateloty1() != null) {
            skilactive1.setText(champ.getActivatedSkill().getCateloty1());
            skilactive1.setVisibility(View.VISIBLE);
        }
        if (champ.getActivatedSkill().getCateloty2() != null) {
            skilactive2.setText(champ.getActivatedSkill().getCateloty2());
            skilactive2.setVisibility(View.VISIBLE);
        }
        if (champ.getActivatedSkill().getCateloty3() != null) {
            skilactive3.setText(champ.getActivatedSkill().getCateloty3());
            skilactive3.setVisibility(View.VISIBLE);
        }
        if (champ.getId() == 18) {
            Glide.with(this).load("https://cdn.lolchess.gg/images/lol/champion-splash-modified/KogMaw.jpg").into(imgCover);
        }
        if (champ.getId() == 49) {
            Glide.with(this).load("https://cdn.lolchess.gg/images/tft/champions/set3/splash/tft3_MonkeyKing.jpg").into(imgCover);
        }
        if (champ.getId() == 8) {
            Glide.with(this).load("https://cdn.lolchess.gg/images/lol/champion-splash-modified/Nocturne.jpg").into(imgCover);
        }
        //setOnClickListner();

        gridView1 = new GridLayoutManager(this, 7);
        gridView2 = new GridLayoutManager(this, 7);

        adapterRv2_1 = new AdapterRv2(getApplicationContext(), originArr, this,1);
        recyclerView2.setAdapter(adapterRv2_1);
        recyclerView2.setLayoutManager(gridView1);

        adapterRv2_2 = new AdapterRv2(getApplicationContext(), classArr, this,1);
        recyclerView4.setAdapter(adapterRv2_2);
        recyclerView4.setLayoutManager(gridView2);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent i = new Intent(DetailsChamp.this, MainActivity.class);
            startActivity(i);
//            finish();
        }
        return super.onOptionsItemSelected(item);
    }


    public void Origin() {
        name_origin.setText(champ.getOrigin());
        activatedList1 = new ArrayList<>();
        switch (champ.getOrigin()) {
            case Constant.ORIGIN_TK: {
                origin.setText(Constant.TKOrigin);
                activatedList1.add(new Activated(2, Constant.TK2));
                activatedList1.add(new Activated(4, Constant.TK4));
                activatedList1.add(new Activated(6, Constant.TK6));
                break;
            }
            case Constant.ORIGIN_VT: {
                origin.setText(Constant.VTOrigin);
                activatedList1.add(new Activated(2, Constant.VT2));
                activatedList1.add(new Activated(4, Constant.VT4));
                activatedList1.add(new Activated(6, Constant.VT6));
                break;
            }
            case Constant.ORIGIN_CMCD: {
                origin.setText(Constant.VTOrigin);
                activatedList1.add(new Activated(2, Constant.CMCD2));
                activatedList1.add(new Activated(4, Constant.CMCD4));
                activatedList1.add(new Activated(6, Constant.CMCD6));
                break;
            }
            case Constant.ORIGIN_PHG: {
                origin.setText(Constant.PHGOrigin);
                activatedList1.add(new Activated(3, Constant.PHG3));
                break;
            }
            case Constant.ORIGIN_SCN: {
                origin.setText(Constant.SCNOrigin);
                activatedList1.add(new Activated(3, Constant.SCN3));
                activatedList1.add(new Activated(6, Constant.SCN6));
                break;
            }
            case Constant.ORIGIN_HT: {
                origin.setText(Constant.HTOrigin);
                activatedList1.add(new Activated(2, Constant.HT2));
                activatedList1.add(new Activated(4, Constant.HT4));
                activatedList1.add(new Activated(6, Constant.HT6));
                activatedList1.add(new Activated(8, Constant.HT8));
                break;
            }
            case Constant.ORIGIN_PC: {
                origin.setVisibility(View.GONE);
                activatedList1.add(new Activated(3, Constant.PC3));
                break;
            }
            case Constant.ORIGIN_NL: {
                origin.setText(Constant.NLOrigin);
                activatedList1.add(new Activated(3, Constant.NL3));
                activatedList1.add(new Activated(6, Constant.NL6));
                activatedList1.add(new Activated(9, Constant.NL9));
                break;
            }
            case Constant.ORIGIN_KT: {
                origin.setText(Constant.KTOrigin);
                activatedList1.add(new Activated(2, Constant.KT2));
                activatedList1.add(new Activated(4, Constant.KT4));
                break;
            }
            case Constant.ORIGIN_VBTT: {
                origin.setText(Constant.VBTTOrigin);
                activatedList1.add(new Activated(3, Constant.VBTT3));
                activatedList1.add(new Activated(6, Constant.VBTT6));
                activatedList1.add(new Activated(9, Constant.VBTT9));
                break;
            }
        }
        layoutManager = new LinearLayoutManager(this);
        adapterRv1_1 = new AdapterRv1(activatedList1);
        recyclerView1.setAdapter(adapterRv1_1);
        recyclerView1.setLayoutManager(layoutManager);
    }

    public void Class() {
        activatedList2 = new ArrayList<>();
        name_class1.setText(champ.getClasss());
        switch (champ.getClasss()) {
            case Constant.CLASS_KK: {
                class1.setText(Constant.KKClass);
                activatedList2.add(new Activated(3, Constant.KK3));
                activatedList2.add(new Activated(6, Constant.KK6));
                activatedList2.add(new Activated(9, Constant.KK9));
                break;
            }
            case Constant.CLASS_PT: {
                class1.setText(Constant.PTClass);
                activatedList2.add(new Activated(2, Constant.PT2));
                activatedList2.add(new Activated(4, Constant.PT4));
                break;
            }
            case Constant.CLASS_DS: {
                class1.setText(Constant.DSClass);
                activatedList2.add(new Activated(2, Constant.DS2));
                activatedList2.add(new Activated(4, Constant.DS4));
                break;
            }
            case Constant.CLASS_BP: {
                class1.setVisibility(View.GONE);
                activatedList2.add(new Activated(2, Constant.BP2));
                break;
            }
            case Constant.CLASS_MT: {
                class1.setText(Constant.MTClass);
                activatedList2.add(new Activated(2, Constant.MT2));
                activatedList2.add(new Activated(4, Constant.MT4));
                activatedList2.add(new Activated(6, Constant.MT6));
                break;
            }
            case Constant.CLASS_MTA: {
                class1.setVisibility(View.GONE);
                activatedList2.add(new Activated(2, Constant.MTA2));
                break;
            }
            case Constant.CLASS_NB: {
                class1.setVisibility(View.GONE);
                activatedList2.add(new Activated(1, Constant.NB1));
                break;
            }
            case Constant.CLASS_BA: {
                class1.setText(Constant.BAClass);
                activatedList2.add(new Activated(2, Constant.BA2));
                activatedList2.add(new Activated(4, Constant.BA4));
                break;
            }
            case Constant.CLASS_TM: {
                class1.setVisibility(View.GONE);
                activatedList2.add(new Activated(1, Constant.TM1));
                break;
            }
            case Constant.CLASS_HV: {
                class1.setText(Constant.MTClass);
                activatedList2.add(new Activated(2, Constant.HV2));
                activatedList2.add(new Activated(4, Constant.HV4));
                activatedList2.add(new Activated(6, Constant.HV6));
                break;
            }
            case Constant.CLASS_XT: {
                class1.setText(Constant.XTClass);
                activatedList2.add(new Activated(2, Constant.XT2));
                activatedList2.add(new Activated(4, Constant.XT4));
                break;
            }
            case Constant.CLASS_PTH: {
                class1.setText(Constant.PTHClass);
                activatedList2.add(new Activated(2, Constant.PHT2));
                activatedList2.add(new Activated(4, Constant.PHT4));
                activatedList2.add(new Activated(6, Constant.PHT6));
                break;
            }
            case Constant.CLASS_MH: {
                class1.setVisibility(View.GONE);
                activatedList2.add(new Activated(1, Constant.MH1));
                break;
            }
            case Constant.CLASS_TP: {
                class1.setText(Constant.PTHClass);
                activatedList2.add(new Activated(2, Constant.TP2));
                activatedList2.add(new Activated(4, Constant.TP4));
                activatedList2.add(new Activated(6, Constant.TP6));
                break;
            }
        }
        layoutManager2 = new LinearLayoutManager(this);
        adapterRv1_2 = new AdapterRv1(activatedList2);

        recyclerView3.setAdapter(adapterRv1_2);
        recyclerView3.setLayoutManager(layoutManager2);
    }

    @Override
    public void onClickListener(Champ champ) {
        Intent intent = new Intent(DetailsChamp.this, DetailsChamp.class);
        for(int i =0;i<arratChampSinghlton.getArr().size();i++){
            if(arratChampSinghlton.getArr().get(i).getId()==champ.getId()){
                intent.putExtra("p",i);
            }
        }
        startActivity(intent);
    }

    @Override
    public void onClickListenerRemove(Champ champ) {

    }


    public void irelia() {
        androidx.cardview.widget.CardView cardView = (androidx.cardview.widget.CardView) findViewById(R.id.ire);
        cardView.setVisibility(View.VISIBLE);
        activateds3 = new ArrayList<>();
        recyclerView5 = (androidx.recyclerview.widget.RecyclerView) findViewById(R.id.rv_item5);
        activateds3.add(new Activated(3, Constant.MTA2));
        AdapterRv1 adapterRv3 = new AdapterRv1(activateds3);
        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(this);
        recyclerView5.setAdapter(adapterRv3);
        recyclerView5.setLayoutManager(linearLayoutManager3);
        champs3 = new ArrayList<>();
        champs3.add(champ);

        for (int i = 0; i < arratChampSinghlton.getArr().size(); i++) {
            if (arratChampSinghlton.getArr().get(i).getClasss().equals(Constant.CLASS_MTA)) {
                champs3.add(arratChampSinghlton.getArr().get(i));
            }
        }
        Collections.sort(champs3, new Comparator<Champ>() {
            @Override
            public int compare(Champ o1, Champ o2) {
                return o1.getGold() - o2.getGold();
            }
        });


        AdapterRv2 adapterRv21 = new AdapterRv2(getApplicationContext(), champs3, this,1);
        recyclerView6 = (androidx.recyclerview.widget.RecyclerView) findViewById(R.id.rv_item6);
        GridLayoutManager gridLayoutManager3 = new GridLayoutManager(this, 7);
        recyclerView6.setAdapter(adapterRv21);
        recyclerView6.setLayoutManager(gridLayoutManager3);
    }
}