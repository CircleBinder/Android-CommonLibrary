package net.ichigotake.common.app;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Handler;

import circlebinder.common.R;

public final class FragmentTransit implements Tripper {

    final private FragmentManager mFragmentManager;
    
    private boolean mAddBackStack = true;
    private boolean mIsAnimation = true;
    private Fragment mNextFragment;
    private int mTargetViewId;
    private String mTag;
    
    public FragmentTransit(Activity activity) {
        mFragmentManager = activity.getFragmentManager();
    }
    
    public FragmentTransit(FragmentManager fragmentManager) {
        mFragmentManager = fragmentManager;
    }
    
    public FragmentTransit setNextFragment(int targetViewId, Fragment nextFragment) {
        mTargetViewId = targetViewId;
        mNextFragment = nextFragment;
        return this;
    }

    public FragmentTransit setAddBackStack(boolean flag) {
        mAddBackStack = flag;
        return this;
    }

    public FragmentTransit setTag(String tag) {
        mTag = tag;
        return this;
    }

    @Override
    public void trip() {
        final int targetViewId = mTargetViewId;
        final Fragment nextFragment = mNextFragment;
        
        Runnable runnable = new Runnable() {
            
            @Override
            public void run() {
                FragmentTransaction transaction = mFragmentManager.beginTransaction();
                if (mIsAnimation) {
                    transaction.setCustomAnimations(
                            R.animator.slide_in,
                            R.animator.slide_out,
                            R.animator.slide_in,
                            R.animator.slide_out);
                }
                transaction.replace(targetViewId, nextFragment, mTag);
                if (mAddBackStack) {
                    transaction.addToBackStack(null);
                }
                transaction.commit();
            }
            
        };
        
        new Handler().post(runnable);
    }
    
    public void toPrev() {
        FragmentManager fragmentManager = mFragmentManager;
        fragmentManager.popBackStack();
    }

    public FragmentTransit setNoAnimation() {
        mIsAnimation = false;
        return this;
    }

}
