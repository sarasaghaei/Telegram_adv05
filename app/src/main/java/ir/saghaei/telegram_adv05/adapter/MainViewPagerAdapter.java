package ir.saghaei.telegram_adv05.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.Map;

import ir.saghaei.telegram_adv05.fragment.AllCahtFragment;
import ir.saghaei.telegram_adv05.fragment.ChannelsCahtFragment;
import ir.saghaei.telegram_adv05.fragment.GroupsCahtFragment;
import ir.saghaei.telegram_adv05.fragment.PrivateCahtFragment;
import ir.saghaei.telegram_adv05.fragment.UnreadCahtFragment;

public class MainViewPagerAdapter extends FragmentPagerAdapter {

    Map<String,Fragment> map;



    public MainViewPagerAdapter(@NonNull FragmentManager fm , Map<String,Fragment> map) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.map = map;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new AllCahtFragment();
            case 1:
                return new PrivateCahtFragment();
            case 2:
                return new GroupsCahtFragment();
            case 3:
                return new ChannelsCahtFragment();
            case 4:
                return new UnreadCahtFragment();
            default:
                return null;
        }

       // return (Fragment) map.values().toArray()[position];
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
