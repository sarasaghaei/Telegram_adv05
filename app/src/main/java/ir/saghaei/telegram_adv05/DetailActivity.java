package ir.saghaei.telegram_adv05;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.List;
import ir.saghaei.telegram_adv05.adapter.TextChatAdapter;
import ir.saghaei.telegram_adv05.databinding.ActivityDetailBinding;
import ir.saghaei.telegram_adv05.fragment.MediaBottomSheet;
import ir.saghaei.telegram_adv05.fragment.ProfileContactFragment;
import ir.saghaei.telegram_adv05.room.Appdatabase;
import ir.saghaei.telegram_adv05.room.entity.en_chat;

public class DetailActivity extends AppCompatActivity {

    ActivityDetailBinding detailChatBinding;
    TextChatAdapter adapter;
    MediaBottomSheet bottomSheet;

    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        detailChatBinding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(detailChatBinding.getRoot());

        Intent intent = getIntent();
        name = intent.getStringExtra("name");

        init();
    }

    private void init(){


        detailChatBinding.recyleTextchat.setLayoutManager(new LinearLayoutManager(this));
        List<en_chat> list = Appdatabase.getInstance(this).getChatDAO().select_textchat(name);
        adapter =  new TextChatAdapter(this, list);
        detailChatBinding.recyleTextchat.setAdapter(adapter);

        detailChatBinding.includeToolbars.contactLayot.imgUserchat.setImageResource(list.get(0).getPic());
        detailChatBinding.includeToolbars.contactLayot.tvNamechat.setText(name);
        detailChatBinding.includeToolbars.contactLayot.tvNamechat.setTextSize(16);
        detailChatBinding.includeToolbars.contactLayot.tvLastseen.setTextSize(14);


        detailChatBinding.etWitemessage.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                detailChatBinding.tvSend.setVisibility(View.VISIBLE);
                detailChatBinding.tvMic.setVisibility(View.GONE);
                detailChatBinding.tvAttach.setVisibility(View.GONE);
            }
        });

        detailChatBinding.includeToolbars.tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        detailChatBinding.baselayout.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    finish();
                    return true;
                }
                return false;
            }
        });

        detailChatBinding.tvAttach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheet = new MediaBottomSheet();
                bottomSheet.show(getSupportFragmentManager() , "bottonsheet");

            }
        });

        detailChatBinding.includeToolbars.relativeLayoutdetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ProfileContactFragment fragment = ProfileContactFragment.newInstance(name);
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragmentprofile,fragment,"fragmentprofile")
                        .addToBackStack("fragmentprofile")
                        .commit();
            }
        });


        detailChatBinding.includeToolbars.tvMoremenuDetailchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popupMenu = new PopupMenu(getApplication(),v);
                popupMenu.getMenuInflater().inflate(R.menu.privatemenu,popupMenu.getMenu());
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    popupMenu.setForceShowIcon(true);
                }
                popupMenu.show();

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getTitle().toString()){
                            case "Call":
                                Toast.makeText(DetailActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                                return true;
                            case "Video call":
                                Toast.makeText(DetailActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                                return true;
                            case "Search":
                                Toast.makeText(DetailActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                                return true;
                            case "Share my contact":
                                Toast.makeText(DetailActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                                return true;
                            case "Clear history":
                                Toast.makeText(DetailActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                                return true;
                            case "Unmute":
                                Toast.makeText(DetailActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                                return true;
                            case "Delete chat":
                                Toast.makeText(DetailActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                                return true;
                        }
                        return false;
                    }
                });

            }
        });


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

}