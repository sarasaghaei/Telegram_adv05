package ir.saghaei.telegram_adv05.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ir.saghaei.telegram_adv05.databinding.FragmentMediaBinding;

public class MediaFragment extends Fragment {

    FragmentMediaBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMediaBinding.inflate(inflater);
        return binding.getRoot();
    }
}
