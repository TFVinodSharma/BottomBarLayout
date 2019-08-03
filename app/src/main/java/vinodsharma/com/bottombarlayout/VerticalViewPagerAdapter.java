package vinodsharma.com.bottombarlayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class VerticalViewPagerAdapter extends FragmentStatePagerAdapter {
    public VerticalViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        ChildFragment Child =new ChildFragment();
        Bundle b=new Bundle();
        b.putString("parent",String.valueOf(position));
        Child.setArguments(b);
        return Child;
    }

    @Override
    public int getCount() {
        return 10;
    }
}
