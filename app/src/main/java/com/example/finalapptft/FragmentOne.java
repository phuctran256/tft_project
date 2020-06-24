package com.example.finalapptft;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RadioButton;

import androidx.fragment.app.Fragment;

import com.example.finalapptft.Adapter.AdapterFragmentItem;
import com.example.finalapptft.Constants.Constant;
import com.example.finalapptft.Object.ActivatedSkill;
import com.example.finalapptft.Object.ArratChampSinghlton;
import com.example.finalapptft.Object.Champ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FragmentOne extends Fragment {

    private ArratChampSinghlton arratChampSinghlton;
    private AdapterFragmentItem adapterFragmentItem;
    private ArrayList<Champ> arr;
    private GridView gridView;
    private RadioButton radioButton1, radioButton2;
    private int a;

    public FragmentOne() {
        // Required empty public constructor

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_one, container, false);

        gridView = (GridView) view.findViewById(R.id.grv);
        radioButton1 = (RadioButton) view.findViewById(R.id.byName);
        radioButton2 = (RadioButton) view.findViewById(R.id.byGold);
        data();
        setup();
        sortByGold();
        sortByName();
        detailChamp();
        return view;
    }

    public void setup() {
        adapterFragmentItem = new AdapterFragmentItem(getContext(), 0, arratChampSinghlton.getArr());
        gridView.setAdapter(adapterFragmentItem);

    }

    public void sortByGold() {
        radioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(arr, new Comparator<Champ>() {
                    @Override
                    public int compare(Champ o1, Champ o2) {
                        adapterFragmentItem.notifyDataSetChanged();
                        return o2.getGold() - o1.getGold();
                    }
                });
            }
        });
    }

    public void sortByName() {
        radioButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(arr, new Comparator<Champ>() {
                    @Override
                    public int compare(Champ o1, Champ o2) {

                        adapterFragmentItem.notifyDataSetChanged();
                        return o1.getNameChamp().compareTo(o2.getNameChamp());
                    }
                });
            }
        });
    }

    public void detailChamp() {
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int p, long id) {
                Intent i = new Intent(getActivity(), DetailsChamp.class);
                i.putExtra("p", p);
                startActivity(i);
            }
        });
    }

    public final void data() {
        arratChampSinghlton = new ArratChampSinghlton().getarratChampSinghlton();
        arr = new ArrayList<>();

        arr.add(new Champ("Caitlyn", Constant.ORIGIN_TK, Constant.CLASS_XT, 1, 1, "Ace in the Hole", "Kỹ năng: Caitlyn nhắm vào kẻ thù xa nhất, gây sát thương phép lên kẻ thù", new ActivatedSkill(Constant.ST + "750 / 1500 / 2250", Constant.DT + "1.1 giây")));
        arr.add(new Champ("Fiora", Constant.ORIGIN_SCN, Constant.CLASS_KK, 1, 2, "Riposte", "Kỹ năng: Fiora sẽ miễn nhiễm sát thương trước khi tung ra đòn tấn công gây sát thương theo một đường thẳng.", new ActivatedSkill(Constant.ST + "200 / 300 / 450", Constant.TGHL + "1.5 / 1.5 / 3 giây")));
        arr.add(new Champ("Graves", Constant.ORIGIN_KT, Constant.CLASS_PT, 1, 3, "Smoke Grenade", "Kỹ năng: Graves bắn một bọc khói vào kẻ thù có tốc độ tấn công cao nhất, gây sát thương phép đồng thời khiến kẻ địch trong khu vực dính bom mù", new ActivatedSkill(Constant.ST + "150 / 200 / 400 ", Constant.TGHL + "2 / 3 / 4 giây")));
        arr.add(new Champ("Illaoi", Constant.ORIGIN_CMCD, Constant.CLASS_DS, 1, 4, "Tentacle Smash", "Kỹ năng: Illaoi đập xúc tu ra phía trước, gây  sát thương và đánh cắp Giáp và Kháng Phép của những mục tiêu bị đánh trúng trong 4 giây.", new ActivatedSkill(Constant.ST + "125/200/325", Constant.DC + "20/30/50%")));
        arr.add(new Champ("Jarvan IV", Constant.ORIGIN_HT, Constant.CLASS_HV, 1, 5, "Ageless Standard", "Kỹ năng: Jarvan IV phóng đi lá cờ của Demacia ở gần nơi hắn đứng, đồng thời  Tốc độ Đánh cho tướng đồng minh ở gần.", new ActivatedSkill(Constant.TDD + "50% / 75% / 100% ")));
        arr.add(new Champ("Leona", Constant.ORIGIN_SCN, Constant.CLASS_TP, 1, 6, "Cyber Barrier", "Kỹ năng: Leona nâng cao chiếc khiên, hấp thụ sát thương từ đối thủ", new ActivatedSkill(Constant.HT + "40 / 80 / 120 ")));
        arr.add(new Champ("Malphite", Constant.ORIGIN_NL, Constant.CLASS_DS, 1, 7, "Energy Shield", "Nội tại: Malphite sẽ khởi đầu mỗi trận đấu với một chiếc khiên dựa theo máu tối đa của hắn.", new ActivatedSkill(Constant.KH+Constant.CT + "40 / 45 / 50%")));
        arr.add(new Champ("Nocturne", Constant.ORIGIN_CMCD, Constant.CLASS_MT, 1, 8, "Unspeakable Horror", "Kỹ năng: Nocturne khủng bố mục tiêu của hắn, khiến mục tiêu đó hoảng sợ trong và gây sát thương phép trong thời gian đó.", new ActivatedSkill(Constant.ST + "200/250/350", Constant.HS + "2/2.5/4 giây")));
        arr.add(new Champ("Poppy", Constant.ORIGIN_VBTT, Constant.CLASS_TP, 1, 9, "Buckler Toss", "Kỹ năng: Poppy ném khiên vào một kẻ thù, gây sát thương và nhận được một lớp khiên .", new ActivatedSkill(Constant.ST + "100 / 175 / 250", Constant.KH+Constant.CT + "200 / 350 / 600 máu")));
        arr.add(new Champ("Twisted Fate", Constant.ORIGIN_TK, Constant.CLASS_PTH, 1, 10, "Wild Cards", "Kỹ năng: Twisted Fated ném 3 lá bài về phía trước, gây sát thương phép lên mọi kẻ thù mà chúng xuyên qua.", new ActivatedSkill(Constant.ST + "200 / 300 / 500 ")));
        arr.add(new Champ("Xayah", Constant.ORIGIN_VT, Constant.CLASS_KK, 1, 11, "Deadly Plumage", "Kỹ năng: Xayah được gia tăng tốc độ đánh.", new ActivatedSkill(Constant.TDD + "75% / 100% / 150% ", Constant.TGHL + "5 / 7 / 12 giây")));
        arr.add(new Champ("Ziggs", Constant.ORIGIN_NL, Constant.CLASS_BP, 1, 12, "Bomb", "Kỹ năng: Zigg ném quả bom về phía một kẻ thù ngẫu nhiên, gây sát thương phép.", new ActivatedSkill(Constant.ST + "250 / 325 / 550 ")));
        arr.add(new Champ("Zoe", Constant.ORIGIN_VBTT, Constant.CLASS_PTH, 1, 13, "Sleepy Trouble Bubble", "Kỹ năng: Đá ra một bong bóng, kẻ thù đầu tiên trúng phải bị dính hiệu ứng ngủ và gây sát thương phép.", new ActivatedSkill(Constant.TGHL + "2 / 2,5 / 5 giây", Constant.ST + "150 / 225 / 300 ")));
        arr.add(new Champ("Ahri", Constant.ORIGIN_VBTT, Constant.CLASS_PTH, 2, 14, "Orb of Deception", "Kỹ năng: Ahri phóng ra rồi thu hồi quả cầu ma thuật của cô, gây sát thương phép trên đường bay đi và sát thương chuẩn trên đường thu về.", new ActivatedSkill(Constant.ST + "175 / 250 / 375")));
        arr.add(new Champ("Annie", Constant.ORIGIN_PC, Constant.CLASS_PTH, 2, 15, "Galaxy Shield-Blast", "Kỹ năng: Annie chưởng lửa theo hình nón, gây sát thương phép lên các kẻ địch trước mặt và nhận được một chiếc khiên .", new ActivatedSkill(Constant.ST + "150 / 200 / 350 ", Constant.KH+Constant.CT + "225 / 300 / 525 máu")));
        arr.add(new Champ("Blitzcrank", Constant.ORIGIN_TK, Constant.CLASS_DS, 2, 16, "Rocket Grab","Kỹ năng: Từ đầu trận đấu, Blitzcrank sẽ kéo kẻ thù xa nhất về phía mình, gây sát thương phép và làm choáng trong 2,5 giây. Đòn đánh tiếp theo sẽ khiến kẻ thù bị hất tung trong 1 giây. Đồng minh gần đó sẽ tấn công kẻ thù vừa bị kéo.",  new ActivatedSkill(Constant.ST + "250 / 400 / 900 ")));
        arr.add(new Champ("Darius", Constant.ORIGIN_KT, Constant.CLASS_MTA, 2, 17, "Dreadnova Guillotine", "Kỹ năng: Darius sẽ nhảy vào tấn công kẻ thù gây sát thương phép.Nếu kẻ đich còn dưới 50% máu sẽ nhân gắp đôi sát thương, nếu dùng chiêu kết liễu đối phương Darius sẽ dùng chiêu một lần nữa .", new ActivatedSkill(Constant.ST+"400 / 500 / 750 ")));
        arr.add(new Champ("KogMaw", Constant.ORIGIN_CMCD, Constant.CLASS_PT, 2, 18, "Barrage", "Kỹ năng: Trong 3 giây, Kog'Maw nhận tầm đánh tối đa và 80% tốc độ đánh, đồng thời đòn đánh gây thêm sát thương phép dựa trân máu tối đa của mục tiêu.", new ActivatedSkill(Constant.ST+Constant.CT+"2%/4%/7% máu")));
        arr.add(new Champ("Lucian", Constant.ORIGIN_SCN, Constant.CLASS_PT, 2, 19, "Relentless Pursuit", "Kỹ năng: Lucian sẽ lướt đi, sau đó tấn công 2 lần, 1 lần bằng đòn đánh thường, 1 đòn gây sát thương phép.", new ActivatedSkill(Constant.ST+"150 / 200 / 325 ")));
        arr.add(new Champ("Mordekaiser", Constant.ORIGIN_HT, Constant.CLASS_TP, 2, 20, "Indestructible", "Kỹ năng: Mordekaiser sẽ bật một chiếc khiên lên bản thân hấp thụ  sát thương. Trong thời gian tồn tại, Khiên sẽ gây sát thương phép mỗi giây.", new ActivatedSkill(Constant.KH+Constant.CT+"350 / 500 / 900", Constant.ST+"50 / 75 / 125")));
        arr.add(new Champ("Nautilus", Constant.ORIGIN_PHG, Constant.CLASS_TP, 2, 21, "Impact Crater", "Kỹ năng: Nautilus gây chấn động mặt đất bên dưới mục tiêu của hắn, hất văng mục tiêu đó lên không và làm choáng chúng , gây sát thương phép. Đối thủ đứng xung quanh mục tiêu nhận nửa hiệu ứng.", new ActivatedSkill(Constant.TGHL+"3/3.5/4 giây",Constant.ST+"100/200/400 ")));
        arr.add(new Champ("Rakan", Constant.ORIGIN_VT, Constant.CLASS_HV, 2, 22, "Grand Entrance", "Kỹ năng: Rakan sẽ lướt đến mục tiêu mà mình đang tấn công, gây sát thương phép và hất tung 1,5 giây kẻ địch ở xung quanh khi đến nơi.", new ActivatedSkill(Constant.ST+"175 / 275 / 450 ")));
        arr.add(new Champ("Shen", Constant.ORIGIN_TK, Constant.CLASS_KK, 2, 23, "Future's Refuge", "Kỹ năng: Shen sẽ được cộng kháng phép và miễn nhiễm sát thương các đòn đánh tay.", new ActivatedSkill(Constant.KP+Constant.CT+"20/40/60",Constant.TGHL+"2,5 / 3 / 4 giây")));
        arr.add(new Champ("Xin Zhao", Constant.ORIGIN_VT, Constant.CLASS_HV, 2, 24, "Three Talon Strike", "Kỹ năng: Xin Zhao tấn công đối thủ 3 lần liên tiếp, gây sát thương cơ bản kèm theo hiệu ứng đòn đánh. Đòn đánh thứ 3 sẽ gây thêm sát thương phép và hất tung kẻ thù trong 1,5 giây.", new ActivatedSkill(Constant.ST+"60 / 108 / 194", Constant.ST+Constant.CT+"175 / 250 / 400 ")));
        arr.add(new Champ("Yasuo", Constant.ORIGIN_NL, Constant.CLASS_KK, 2, 25, "Last Breath", "Kỹ năng : Dịch chuyển lập tức tới kẻ địch xa nhất trong tầm đánh, hất tung mục tiêu trong 1 giay đồng thời chém liên tiếp , gây sát thương cơ bản kèm hiệu ứng đòn đánh.", new ActivatedSkill("Chém liên tiếp: 4/5/6")));
        arr.add(new Champ("Zed", Constant.ORIGIN_NL, Constant.CLASS_MT, 2, 26, "Contempt for the Weak", "Kỹ năng: Mỗi đòn đánh thứ 3, Zed đánh cắp Sức Mạnh Công Kích của mục tiêu và gây thêm sát thương phép.", new ActivatedSkill(Constant.DC+"20/25/40%", Constant.ST+Constant.CT+"50/90/150 ")));
        arr.add(new Champ("Ashe", Constant.ORIGIN_VT, Constant.CLASS_XT, 3, 27, "Enchanted Crystal Arrow", "Kỹ năng: Ashe sẽ bắn mũi tên siêu to khổng lồ vào kẻ thù xa nhất. Kẻ địch đầu tiên dính phải sẽ bị dính sát thương phép và bị choáng trong 2 giây. Khoảng cách càng xa, sát thương và thời gian choáng càng lâu.", new ActivatedSkill(Constant.ST+"250 / 350 / 700 ")));
        arr.add(new Champ("Bard", Constant.ORIGIN_PHG, Constant.CLASS_BA, 3, 28, "Traveller's Call", "Nội Tại: Bard nhận thêm năng lượng mỗi đòn đánh, nhưng không thể nhận năng lượng nếu tấn công quái.", new ActivatedSkill(Constant.NL+Constant.CT+"8/20/90")));
        arr.add(new Champ("Cassiopeia", Constant.ORIGIN_CMCD, Constant.CLASS_BA, 3, 29, "Noxious Blast", "Kỹ năng: Cassiopeia phóng nanh độc về phía một mục tiêu chưa bị trúng độc, gây sát thương trong 12 giây, hiệu ứng lá chắn của mục tiêu trúng độc bị giảm đi 50%", new ActivatedSkill(Constant.ST+"700/1500/3000 ")));
        arr.add(new Champ("Ezreal", Constant.ORIGIN_TK, Constant.CLASS_PT, 3, 30, "E.M.P.", "Kỹ năng: Ezreal bắn ra một quả cầu dính vào kẻ thù ngẫu nhiên. gây sát thương lên kẻ thù xung quanh mục tiêu đồng thời khiến kẻ thù phải mất thêm 40% năng lượng để sử dụng kỹ năng.", new ActivatedSkill(Constant.ST+"250 / 350 / 700 ")));
        arr.add(new Champ("Jayce", Constant.ORIGIN_KT, Constant.CLASS_TP, 3, 31, "To the Skies", "Kỹ năng: Jayce nhảy lên không trung, dậm búa xuống đất, gây sát thương phép lên kẻ thù xung quanh.", new ActivatedSkill(Constant.ST+"450 / 600 / 1200 ")));
        arr.add(new Champ("Karma", Constant.ORIGIN_HT, Constant.CLASS_BA, 3, 32, "Inspire", "Kỹ năng: Karma sẽ kết nối với đồng minh gần nhất, tạo một tấm khiên , tăng tốc độ đánh cho đồng minh.", new ActivatedSkill(Constant.KH+Constant.CT+"250 / 400 / 800 máu",Constant.TDD+"35% / 50% / 100% ")));
        arr.add(new Champ("Master Yi", Constant.ORIGIN_NL, Constant.CLASS_KK, 3, 33, "Chosen One", "Kỹ năng: Trong 5 giây, Master Yi sẽ được tăng tốc độ di chuyển, được hồi máu theo 12% máu tối đa, đồng thời gây sát thương chuẩn.", new ActivatedSkill(Constant.ST+"75 / 100 / 200 (Sát thương chuẩn)")));
        arr.add(new Champ("Neeko", Constant.ORIGIN_VBTT, Constant.CLASS_HV, 3, 34, "Pop Blossom", "Kỹ năng: Sau một vài giây vận chiêu, Neeko gây sát thương và làm choáng các kẻ địch trong phạm vi 2 ô xung quanh.", new ActivatedSkill(Constant.ST + "200 / 275 / 550", Constant.TGHL+"2 /2,5 /5 giây")));
        arr.add(new Champ("Rumble", Constant.ORIGIN_PC, Constant.CLASS_BP, 3, 35, "Flamespitter", "Kỹ năng: Rumble đốt cháy các kẻ địch trước mặt hắn, gây sát thương phép theo hình nón trong 3 giây và giảm 50% hồi máu trong 5 giây.", new ActivatedSkill(Constant.ST+"250 / 400 / 800 ")));
        arr.add(new Champ("Shaco", Constant.ORIGIN_HT, Constant.CLASS_MT, 3, 36, "Deceive", "Kỹ năng: Shaco sẽ dịch chuyển tấn công sau lưng đối phương, gây sát thương chí mạng.", new ActivatedSkill(Constant.ST+"80 / 120 / 200")));
        arr.add(new Champ("Syndra", Constant.ORIGIN_VBTT, Constant.CLASS_PTH, 3, 37, "Unleashed Power", "Kỹ năng: Syndra oanh tạc tướng địch có nhiều máu nhất với tất cả những Quả Cầu Bóng Tối của cô, mỗi quả cầu gây sát thương phép.", new ActivatedSkill(Constant.ST+"250% / 325% / 450%")));
        arr.add(new Champ("Vayne", Constant.ORIGIN_SCN, Constant.CLASS_XT, 3, 38, "Final Hour", "Kỹ năng: Vayne bật chế độ tối thượng trong 10 giây, nhào lộn ra khỏi mục tiêu hiện tại ngay lập tức, và cứ sau mỗi 3 đòn đánh. Vayne được tàng hình khi nhào lộn, và đòn đánh sau khi nhào lộn gây sức mạnh công kích.", new ActivatedSkill(Constant.ST+"175/200/225% ")));
        arr.add(new Champ("Vi", Constant.ORIGIN_SCN, Constant.CLASS_DS, 3, 39, "Assault and Battery", "Kỹ năng: Vi sẽ lao vào kẻ thù xa nhất, gây sát thương đẩy và lùi những kẻ thù trên đường đi . Khi đụng phải mục tiêu, Vi sẽ gây sát thương phép lên kẻ thù này và gây choáng .", new ActivatedSkill(Constant.ST+"400 / 600 / 1200",Constant.ST+"150 / 200 / 500",Constant.TGHL+"2/ 2,5 /3 giây")));
        arr.add(new Champ("Fizz", Constant.ORIGIN_PC, Constant.CLASS_MT, 4, 40, "Chum the Waters", "Kỹ năng: Fizz quăng cá vào hướng chỉ định. Sau chốc lát, thủy quái trồi lên, hất tung và gây sát thương phép lên các Tướng xung quanh mục tiêu, đẩy lùi chúng và làm choáng trong 1,5 giây.", new ActivatedSkill(Constant.ST+"350 / 500 / 2000 ")));
        arr.add(new Champ("Gnar", Constant.ORIGIN_PHG, Constant.CLASS_DS, 4, 41, "GNAR!", "Kỹ năng: Gnar nhảy lên phía trước và biến hình thành Gnar Khổng Lồ, quét đối thủ ở xung quanh, gây sát thương phép và làm choáng chúng trong 2 giây. Khi ở dạng Gnar Khổng Lồ, Gnar nhận thêm Máu và Sức Mạnh Công Kích.", new ActivatedSkill(Constant.ST+"100/200/800", Constant.M+Constant.CT+"750/1250/2500", Constant.SMCK+"100/175/400")));
        arr.add(new Champ("Irelia", Constant.ORIGIN_SCN, Constant.CLASS_KK, 4, 42, "Bladesurge", "Kỹ năng: Irelia lao tới kẻ thù, gây sát thương vật lý và được hồi năng lượng khi hạ gục thành công kẻ địch.", new ActivatedSkill(Constant.ST+"175% / 250% / 500% ")));
        arr.add(new Champ("Jhin", Constant.ORIGIN_HT, Constant.CLASS_XT, 4, 43, "Whisper", "Kỹ năng: Jhin biến 1% tốc độ đánh cộng thêm vào 0,8 AD. Mỗi phát bắn thứ 4, Jhin sẽ gây thêm sát thương.", new ActivatedSkill(Constant.ST+"244% / 344% / 4444%")));
        arr.add(new Champ("Jinx", Constant.ORIGIN_NL, Constant.CLASS_PT, 4, 44, "Get Excited", "Kỹ năng: Sau mỗi lần hạ gục và hỗ trợ hạ gục, Jinx sẽ được hưởng thêm tốc độ đánh. Sau điểm hạ gục thứ 2, Jinx sẽ tấn công bằng Xương Cá, khẩu súng phóng lựu của cô và gây thêm sát thương phép, có đánh lan ra các ô xung quanh.", new ActivatedSkill(Constant.TDD+"60% / 75% / 100%",Constant.ST+Constant.CT+"100 / 175 / 750 ")));
        arr.add(new Champ("Riven", Constant.ORIGIN_TK, Constant.CLASS_KK, 4, 45, "Energy Slash", "Kỹ năng: Riven lướt về phía trước và tạo lá chắn cho bản thân, đồng thời tung nhát chém gây sát thương phép. Mỗi lần sử dụng kĩ năng thứ ba, Riven sẽ phóng ra một đợt sóng năng lượng gây 300/500/150 sát thương phép.", new ActivatedSkill(Constant.KH+Constant.CT+"250/400/1000", Constant.ST+"100/150/450","Nhát Chém Thứ Ba: 300/500/150")));
        arr.add(new Champ("Soraka", Constant.ORIGIN_VBTT, Constant.CLASS_BA, 4, 46, "Wish", "Kỹ năng: Soraka hồi máu cho tất cả đồng minh.", new ActivatedSkill(Constant.SMH+" 300 / 450 / 2000")));
        arr.add(new Champ("Teemo", Constant.ORIGIN_PHG, Constant.CLASS_XT, 4, 47, "Satellite Traps", "Kỹ năng: Teemo thả 3 bẫy xung quanh mục tiêu gần nhất Khi đối thủ đến gần bẫy (hoặc sau 3 giây), chiếc bẫy sẽ phát nổ, gây sát thương phép, khiến chúng choáng váng và bị làm chậm trong 4 giây.", new ActivatedSkill(Constant.ST+"125/175/600")));
        arr.add(new Champ("Viktor", Constant.ORIGIN_CMCD, Constant.CLASS_PTH, 4, 48, "Death Ray", "Kỹ năng: Viktor kẻ một tia hủy diệt giữa hai đối thủ ở xa nhau nhất, gây sát thương dựa trên máu tối đa của đối thủ thành sát thương phép, sau một 1 giây, gây thêm sát thương phép trên vết kẻ cũ.", new ActivatedSkill("Sát thương lần 1: 15/20/80%", "Sát Thương Lần 2: 250/400/1500 ")));
        arr.add(new Champ("Wukong", Constant.ORIGIN_TK, Constant.CLASS_TP, 4, 49, "Cyclone", "Kỹ năng: Ngộ Không làm cho thanh thiết bảng dài ra rồi múa nó quanh bản thân, gây sát thương phép lên những kẻ thù xung quanh trong 3 giây. Mỗi lần Lốc Xoáy chạm phải đối phương, hắn ta sẽ hất tung kẻ thù, làm choáng chúng.", new ActivatedSkill(Constant.ST+"250 / 450 / 2000 ",Constant.TGHL+"2 / 2,5/5 giây")));
        arr.add(new Champ("Aurelion Sol", Constant.ORIGIN_NL, Constant.CLASS_MH, 5, 50, "Mobilize the Fleet", "Kỹ năng: Aurelion Sol sẽ triệu hồi các phi cơ, mỗi phi cơ sẽ tấn công kẻ địch ngẫu nhiên gây sát thương phép. Khi có đủ năng lượng, Aurelion Sol sẽ phóng thêm 3 Phi cơ nữa.", new ActivatedSkill(Constant.ST+"120 / 175 / 750")));
        arr.add(new Champ("Ekko", Constant.ORIGIN_SCN, Constant.CLASS_MT, 5, 51, "Chronobreak", "Kỹ năng: Ekko phá vỡ dòng thời gian, tạo một vùng dị thường bất ổn đóng băng mọi đơn vị trong một khoản thời gian trước khi tấn công tất cả, gây sát thương phép kèm hiệu ứng đòn đánh.", new ActivatedSkill(Constant.ST+"200 / 450 / 2000")));
        arr.add(new Champ("Gangplank", Constant.ORIGIN_KT, Constant.CLASS_NB, 5, 52, "Orbital Strike", "Kỹ năng: Gangplank ra hiệu cho tàu chiến của hắn oanh tạc khu vực xung quanh hắn, gây sát thương phép cho toàn bộ kẻ thù trong khu vực trong 2 giây.", new ActivatedSkill(Constant.ST+"550 / 750 / 9001 ")));
        arr.add(new Champ("Janna", Constant.ORIGIN_VBTT, Constant.CLASS_TM, 5, 53, "Howling Gale", "Kỹ năng: Janna triệu hồi năm lốc xoáy bay ra theo hình nón. Lốc xoáy cho đồng minh chúng lướt qua tốc độ đánh trong 5 giây, trong khi hất tung đối thủ trúng phải trong 1.5 giây.", new ActivatedSkill(Constant.TDD+"100/150/500% ")));
        arr.add(new Champ("Lulu", Constant.ORIGIN_VT, Constant.CLASS_BA, 5, 54, "Mass Polymorph", "Kỹ năng: Lulu niệm phép lên kẻ thù gần nhất, khiến chúng không thể tấn công hay dùng chiêu trong 4 giây. Kẻ địch dính hiệu ứng nhận thêm sát thương.", new ActivatedSkill("Số Mục Tiêu: 2 / 4 / 12", Constant.STNT+"5% / 10% / 25%")));
        arr.add(new Champ("Thresh", Constant.ORIGIN_TK, Constant.CLASS_MTA, 5, 55, "Temporal Passage", "Kỹ năng: Thresh sẽ ném đồng minh bất kỳ trên hàng chờ xuống sàn đấu. Khi đồng minh này tấn công sẽ hồi năng lượng cho cả hắn lẫn Thresh.", new ActivatedSkill("Số Đồng Minh Ném Được: 1/1/9 ","Năng Lượng Được Hổi: 25 / 50 / 200")));
        arr.add(new Champ("Urgot", Constant.ORIGIN_CMCD, Constant.CLASS_HV, 5, 56, "Fear Beyond Death", "Kỹ năng: Urgot bắn ra một mũi khoang về phía mục tiêu xa nhất trong tầm đánh, kéo chúng về phía hắn và gây 2000 sát thương liên tục cho đến khi chúng chết. Sau lần sử dụng thành công đầu tiên, năng lượng tổng của Urgot sẽ được giảm xuống .", new ActivatedSkill("Năng Lượng Tổng Giảm Xuống: 10/20/100")));
        arr.add(new Champ("Xerath", Constant.ORIGIN_HT, Constant.CLASS_PTH, 5, 57, "Abyssal Bombardment", "Kỹ năng: Xerath thăng hoa, triệu hồi các thiên thạch rơi xuống sân đấu thay cho đòn đánh thường trong giây. Các thiên thạch gây sát thương phép và nếu nó hạ gục mục tiêu, những kẻ địch xung quanh sẽ phải nhận thêm sát thương phép và bị làm choáng trong 1.5 giây.", new ActivatedSkill(Constant.TDD+"6/8/45", Constant.ST+"300/400/2500", Constant.STNT+"150/200/1250")));
        arratChampSinghlton.setArr(arr);
    }
}