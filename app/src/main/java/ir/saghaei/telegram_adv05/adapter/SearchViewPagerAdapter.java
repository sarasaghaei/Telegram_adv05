package ir.saghaei.telegram_adv05.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.Map;

import ir.saghaei.telegram_adv05.fragment.AllCahtFragment;
import ir.saghaei.telegram_adv05.fragment.ChannelsCahtFragment;
import ir.saghaei.telegram_adv05.fragment.ChatsFragment;
import ir.saghaei.telegram_adv05.fragment.FileFragment;
import ir.saghaei.telegram_adv05.fragment.GroupsCahtFragment;
import ir.saghaei.telegram_adv05.fragment.LinkFragment;
import ir.saghaei.telegram_adv05.fragment.MediaFragment;
import ir.saghaei.telegram_adv05.fragment.PrivateCahtFragment;
import ir.saghaei.telegram_adv05.fragment.UnreadCahtFragment;
import ir.saghaei.telegram_adv05.fragment.VideoFragment;

public class SearchViewPagerAdapter extends FragmentPagerAdapter {

    Map<String,Fragment> map;



    public SearchViewPagerAdapter(@NonNull FragmentManager fm , Map<String,Fragment> map) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.map = map;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ChatsFragment();
            case 1:
                return new LinkFragment();
            case 2:
                return new MediaFragment();
            case 3:
                return new FileFragment();
            case 4:
                return new VideoFragment();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return map.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return (CharSequence) map.keySet().toArray()[position];
    }
}
