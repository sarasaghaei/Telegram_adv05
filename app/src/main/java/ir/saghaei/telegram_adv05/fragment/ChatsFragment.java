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

import ir.saghaei.telegram_adv05.adapter.ContactAdapter;
import ir.saghaei.telegram_adv05.adapter.SearchChatAdapter;
import ir.saghaei.telegram_adv05.databinding.FragmentChatsBinding;
import ir.saghaei.telegram_adv05.room.Appdatabase;
import ir.saghaei.telegram_adv05.room.entity.en_chat;

public class ChatsFragment extends Fragment {
    FragmentChatsBinding binding;
    SearchChatAdapter adaptersearchchat;
    ContactAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentChatsBinding.inflate(inflater);

        if(getActivity() != null) {
            binding.recycleChatscontact.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
            List<en_chat> list = Appdatabase.getInstance(getActivity())
                    .getChatDAO().select_cat("Private");
            adaptersearchchat = new SearchChatAdapter(getActivity(), list);
            binding.recycleChatscontact.setAdapter(adaptersearchchat);

            binding.recycleContact.setLayoutManager(new LinearLayoutManager(getActivity()));
            binding.recycleContact.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayout.VERTICAL));
            List<en_chat> listall = Appdatabase.getInstance(getActivity()).getChatDAO().getall();
            adapter = new ContactAdapter(getActivity(), listall);
            binding.recycleContact.setAdapter(adapter);
        }

        return binding.getRoot();
    }
}
