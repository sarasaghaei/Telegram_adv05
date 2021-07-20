package ir.saghaei.telegram_adv05.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import ir.saghaei.telegram_adv05.R;
import ir.saghaei.telegram_adv05.adapter.ContactAdapter;
import ir.saghaei.telegram_adv05.adapter.MainViewPagerAdapter;
import ir.saghaei.telegram_adv05.adapter.SearchViewPagerAdapter;
import ir.saghaei.telegram_adv05.databinding.FragmentContactBinding;
import ir.saghaei.telegram_adv05.databinding.FragmentSearchchatBinding;
import ir.saghaei.telegram_adv05.room.Appdatabase;
import ir.saghaei.telegram_adv05.room.entity.en_chat;

public class SearchChatFragment extends Fragment {

    FragmentSearchchatBinding binding;
    SearchViewPagerAdapter searchadapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSearchchatBinding.inflate(inflater);

        binding.includeToolbar.tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction()
                        .remove(SearchChatFragment.this).commit();
            }
        });
        binding.includeToolbar.etText.setVisibility(View.VISIBLE);
        binding.includeToolbar.etText.setTextColor(ResourcesCompat.getColor(getResources(),R.color.colorPrimaryDark,null));
        binding.includeToolbar.tvTitle.setVisibility(View.GONE);
        binding.includeToolbar.tvMore.setVisibility(View.GONE);
        binding.includeToolbar.etText.setFocusable(true);
        binding.includeToolbar.relativelayoutToolbar.setBackgroundColor(ResourcesCompat.getColor(getResources(),R.color.colorAccent,null));
        binding.includeToolbar.tvBack.setBackgroundResource(R.drawable.ic_back_black);




        //Make viewpager for tab
        Map<String, Fragment> map = new LinkedHashMap<>();

        map.put("Chats", new ChatsFragment());
        map.put("Links", new LinkFragment());
        map.put("Media", new MediaFragment());
        map.put("Files", new FileFragment());
        map.put("Videio", new VideoFragment());


        searchadapter = new SearchViewPagerAdapter(getParentFragmentManager(),map);
        binding.viewpagerSearchchat.setAdapter(searchadapter);
        binding.tabSearchchat.setupWithViewPager(binding.viewpagerSearchchat);



        return binding.getRoot();


    }

}
