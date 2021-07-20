package ir.saghaei.telegram_adv05.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.List;

import ir.saghaei.telegram_adv05.adapter.ChatAdapter;
import ir.saghaei.telegram_adv05.databinding.FragmentAllchatBinding;
import ir.saghaei.telegram_adv05.room.Appdatabase;
import ir.saghaei.telegram_adv05.room.entity.en_chat;

public class PrivateCahtFragment extends Fragment {

    FragmentAllchatBinding binding;
    ChatAdapter adapter;
    List<en_chat> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAllchatBinding.inflate(inflater);

        if(getActivity() != null) {
            binding.recycleAllchat.setLayoutManager(new LinearLayoutManager(getActivity()));
            binding.recycleAllchat.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayout.VERTICAL));
            List<en_chat> list = Appdatabase.getInstance(getActivity()).getChatDAO().select_cat("Private");
            adapter = new ChatAdapter(getActivity(), list);
            binding.recycleAllchat.setAdapter(adapter);
        }
        return binding.getRoot();
    }
}
