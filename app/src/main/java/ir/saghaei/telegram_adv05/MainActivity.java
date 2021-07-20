package ir.saghaei.telegram_adv05;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import ir.saghaei.telegram_adv05.adapter.MainViewPagerAdapter;
import ir.saghaei.telegram_adv05.databinding.ActivityMainBinding;
import ir.saghaei.telegram_adv05.fragment.AllCahtFragment;
import ir.saghaei.telegram_adv05.fragment.ChannelsCahtFragment;
import ir.saghaei.telegram_adv05.fragment.ContactFragment;
import ir.saghaei.telegram_adv05.fragment.GroupsCahtFragment;
import ir.saghaei.telegram_adv05.fragment.PrivateCahtFragment;
import ir.saghaei.telegram_adv05.fragment.SearchChatFragment;
import ir.saghaei.telegram_adv05.fragment.UnreadCahtFragment;
import ir.saghaei.telegram_adv05.room.Appdatabase;
import ir.saghaei.telegram_adv05.room.entity.en_chat;

public class MainActivity extends AppCompatActivity {

    String s;


    ActivityMainBinding binding;
    MainViewPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();
        makeviewpager();


        binding.navMainMenu.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Toast.makeText(MainActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                if(binding.drawerlayout.isDrawerOpen(GravityCompat.START))
                {
                    binding.drawerlayout.closeDrawer(GravityCompat.START);
                }
                return false;
            }
        });



    }

    private void makeviewpager() {

        Map<String, Fragment> map = new LinkedHashMap<>();

        map.put("All", new AllCahtFragment());
        map.put("Private", new PrivateCahtFragment());
        map.put("Groups", new GroupsCahtFragment());
        map.put("Channels", new ChannelsCahtFragment());
        map.put("Unread", new UnreadCahtFragment());

        adapter = new MainViewPagerAdapter(getSupportFragmentManager(),map);
        binding.viewpagerMain.setAdapter(adapter);
        binding.tabMain.setupWithViewPager(binding.viewpagerMain);



    }

    public void init(){

        binding.includeMainmenu.tvMainsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragmentsearch,new SearchChatFragment(),"SerachFragment")
                        .addToBackStack("SerachFragment")
                        .commit();
            }
        });

        binding.includeMainmenu.tvMainmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.drawerlayout.openDrawer(GravityCompat.START);
            }
        });

        binding.fabAddchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragmentcontact,new ContactFragment(),"ContactFragment")
                        .commit();

            }
        });

        List<en_chat> list = Appdatabase.getInstance(this).getChatDAO().getall();
        if (list.size()==0) {
            List<en_chat> result = import_data();
            for (int i = 0; i < result.size(); i++) {

                en_chat new_record = result.get(i);
                try {
                    long ok = Appdatabase.getInstance(MainActivity.this).getChatDAO().insert(new_record);
                } catch (Exception ex) {
                    Log.e("TAG", "init: " + ex.getMessage() );

                }
            }
        }
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0 ){
            getFragmentManager().popBackStack();
            getFragmentManager().beginTransaction().commit();
        } else {
            super.onBackPressed();
        }
    }

    public List<en_chat> import_data(){
        List<en_chat> chatList = new ArrayList<>();

        chatList.add(new en_chat("Advanced Android Development","+989121207885", "", "I welcome you on behalf of management and hope you will enjoy working with us.", "08:00","08:00","Groups", R.drawable.adv,0));
        chatList.add(new en_chat("MFT","+989120021200", "", "We are so excited to have you on our team! ...", "18:00","23:00","Channels", R.drawable.mft,0));
        chatList.add(new en_chat("allahverdi","+989359172200", "", "هر چیز که در جستن آنی ، آنی", "","23:05","Private", R.drawable.b1,0));
        chatList.add(new en_chat("raha","+989302501247", "اگر هوشمندی به معنی گرای\n" +
                "\n" +
                "که معنی بماند ز صورت به جای\n" +
                "\n" +
                "که را دانش و جود و تقوی نبود\n" +
                "\n" +
                "به صورت درش هیچ معنی نبود", "hi", "08:00","08:00","Private", R.drawable.g1,0));
        chatList.add(new en_chat("sara","+989335353467", "", "There is nothing as precious in life as a true friend, ...", "23:00","23:00","Private", R.drawable.g2,0));
        chatList.add(new en_chat("sadegh","+989121522240","",  "حیلت رها کن عاشقــا دیوانه شو دیوانه شو\n" +
                "و انـدر دل آتش درآ پــــروانـه شــو پروانــــــه شو\n" +
                "هــم خــویش را بیگـــانه کن هم خانه را ویرانه کن\n" +
                "و آنگه بیا با عاشقان هم خانـه شـو هم خانه شــو", "08:00","08:00","Private", R.drawable.b2,1));
        chatList.add(new en_chat("setareh","+989358741550", "", "همه عمر برندارم سر از این خمار مستی", "23:00","23:00","Private", R.drawable.g3,0));
        chatList.add(new en_chat("azadeh","+989360554525", "", "    I don't know how I can say thank you to a friend who understands the all the things I never say and never says anything I don't understand.", "08:00","08:00","Private", R.drawable.g3,1));
        chatList.add(new en_chat("nima","+989376080346","", "با همه جرمم امید با همه خوفم رجاست", "23:00","23:00","Private", R.drawable.b3,0));
        chatList.add(new en_chat("benyamin","+989122123660", "", "People will come and, ...", "08:00","08:00","Private", R.drawable.b4,0));
        chatList.add(new en_chat("yasi","+989335642110", "hi", "hi", "23:00","23:00","Private", R.drawable.g4,0));
        chatList.add(new en_chat("allahverdi","+989359172200", "hi", "", "23:00","10:24","Private", R.drawable.b1,0));

        return chatList;


    }

}