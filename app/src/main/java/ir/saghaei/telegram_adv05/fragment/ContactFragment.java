package ir.saghaei.telegram_adv05.fragment;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.List;

import ir.saghaei.telegram_adv05.R;
import ir.saghaei.telegram_adv05.adapter.ContactAdapter;
import ir.saghaei.telegram_adv05.databinding.FragmentContactBinding;
import ir.saghaei.telegram_adv05.room.Appdatabase;
import ir.saghaei.telegram_adv05.room.entity.en_chat;

public class ContactFragment extends Fragment {

    FragmentContactBinding binding;
    ContactAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentContactBinding.inflate(inflater);

        FragmentManager fm = getParentFragmentManager();
        fm.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                getParentFragmentManager().beginTransaction()
                        .remove(ContactFragment.this).commit();
            }
        });

        binding.includeToolbar.tvTitle.setText(R.string.new_message);
        binding.includeToolbar.tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction()
                        .remove(ContactFragment.this).commit();
            }
        });
        binding.includeToolbar.tvMore.setBackgroundResource(R.drawable.ic_search_white);
        binding.includeToolbar.tvMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.includeToolbar.etText.setVisibility(View.VISIBLE);
                binding.includeToolbar.tvTitle.setVisibility(View.GONE);
                binding.includeToolbar.tvMore.setVisibility(View.GONE);
                binding.includeToolbar.etText.setFocusable(true);

            }
        });

        binding.btnAddgroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), binding.btnAddgroup.getText().toString() , Toast.LENGTH_SHORT).show();
            }
        });

        binding.btnSecretchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), binding.btnSecretchat.getText().toString() , Toast.LENGTH_SHORT).show();
            }
        });

        binding.btnNewchannel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), binding.btnNewchannel.getText().toString() , Toast.LENGTH_SHORT).show();
            }
        });

        binding.fabAddchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Add Contact", Toast.LENGTH_SHORT).show();
            }
        });

        if(getActivity() != null) {
            binding.recycleContact.setLayoutManager(new LinearLayoutManager(getActivity()));
            binding.recycleContact.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayout.VERTICAL));
            List<en_chat> list = Appdatabase.getInstance(getActivity()).getChatDAO().getall();
            adapter = new ContactAdapter(getActivity(), list);
            binding.recycleContact.setAdapter(adapter);
        }

        return binding.getRoot();
    }


}
