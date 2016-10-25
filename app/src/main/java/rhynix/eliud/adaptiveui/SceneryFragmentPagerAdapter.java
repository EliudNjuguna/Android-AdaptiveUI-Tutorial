package rhynix.eliud.adaptiveui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by eliud on 10/26/16.
 */

public class SceneryFragmentPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT =2;
    private String tabTitles[] = new String[]{"Scenery","Details"};

    public SceneryFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new ImageFragment();
            case 1:
                return new InfoFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
