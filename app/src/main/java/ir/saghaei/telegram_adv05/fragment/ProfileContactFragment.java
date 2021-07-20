package ir.saghaei.telegram_adv05.fragment;

import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import java.util.LinkedHashMap;
import java.util.Map;

import ir.saghaei.telegram_adv05.R;
import ir.saghaei.telegram_adv05.adapter.ShareMediaViewPagerAdapter;
import ir.saghaei.telegram_adv05.databinding.FragmentProfilecontactBinding;
import ir.saghaei.telegram_adv05.room.Appdatabase;
import ir.saghaei.telegram_adv05.room.entity.en_chat;

public class ProfileContactFragment extends Fragment {

    FragmentProfilecontactBinding binding;
    en_chat userprofile;
    ShareMediaViewPagerAdapter shareadapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        String name = "";

        binding = FragmentProfilecontactBinding.inflate(inflater);
        if(getArguments() != null && getArguments().containsKey("name")){
            name = getArguments().getString("name");
        }

        userprofile = Appdatabase.getInstance(getContext()).getChatDAO().select_userprofile(name);
        binding.contactLayot.tvNamechat.setText(name);
        binding.contactLayot.imgUserchat.setImageResource(userprofile.getPic());
        binding.tvInfo.setText(userprofile.getTell());


        Map<String, Fragment> map = new LinkedHashMap<>();
        map.put("Link",new LinkFragment());
        map.put("Media",new MediaFragment());
        map.put("File",new FileFragment());
        map.put("Video",new VideoFragment());

        shareadapter = new ShareMediaViewPagerAdapter(getParentFragmentManager(),map);
        binding.viewpagerSharemedia.setAdapter(shareadapter);
        binding.tabSharemedia.setupWithViewPager(binding.viewpagerSharemedia);

       /* adapter = new ProfileContactViewPagerAdapter(getActivity().getSupportFragmentManager(),map);
        binding.viewpagerProfilecontact.setAdapter(adapter);
        binding.tabProfilecontact.setupWithViewPager(binding.viewpagerProfilecontact);*/

        binding.switchNotif.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    binding.tvSwitchNotif.setText(R.string.on);
                    binding.switchNotif.getTrackDrawable().setColorFilter
                            (ResourcesCompat.getColor(getResources(), R.color.colorPrimary,null), PorterDuff.Mode.SRC_IN);

                }else {
                    binding.tvSwitchNotif.setText(R.string.off);
                    binding.switchNotif.getTrackDrawable().setColorFilter
                            (ResourcesCompat.getColor(getResources(), R.color.design_default_color_surface,null), PorterDuff.Mode.SRC_IN);
                }
            }
        });
        
        binding.tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction()
                        .remove(ProfileContactFragment.this).commit();
            }
        });

        binding.fabMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction()
                        .remove(ProfileContactFragment.this).commit();
            }
        });
        binding.tvCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Call", Toast.LENGTH_SHORT).show();
            }
        });
        binding.tvVideocall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Video call", Toast.LENGTH_SHORT).show();
            }
        });

        binding.tvMoremenuProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getContext(),v);
                popupMenu.getMenuInflater().inflate(R.menu.profilecontactmenu,popupMenu.getMenu());
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    popupMenu.setForceShowIcon(true);
                }
                popupMenu.show();

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getTitle().toString()){
                            case "Share my contact":
                                Toast.makeText(getContext(), item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                                return true;
                            case "Block user":
                                Toast.makeText(getContext(), item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                                return true;
                            case "Edit contact":
                                Toast.makeText(getContext(), item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                                return true;
                            case "Delete contact":
                                Toast.makeText(getContext(), item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                                return true;
                            case "Start secret chat":
                                Toast.makeText(getContext(), item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                                return true;
                            case "Add to Home screen":
                                Toast.makeText(getContext(), item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                                return true;
                        }
                        return false;
                    }
                });

            }
        });

        return binding.getRoot();
    }

    public static ProfileContactFragment newInstance(String name){
        ProfileContactFragment fragment = new ProfileContactFragment();
        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        fragment.setArguments(bundle);
        return fragment;
    }

}
