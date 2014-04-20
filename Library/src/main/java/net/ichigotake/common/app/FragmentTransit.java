package net.ichigotake.common.app;

import android.content.Context;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;

import net.ichigotake.circlebinder.common.R;

public final class FragmentTransit implements PaneTripper {

    final private FragmentManager mFragmentManager;
    
    private boolean mAddBackStack = true;
    private boolean mIsAnimation = true;
    private Fragment mNextFragment;
    private int mTargetViewId;
    private String mTag;
    
    public FragmentTransit(ActionBarActivity activity) {
        mFragmentManager = activity.getSupportFragmentManager();
    }
    
    public FragmentTransit(FragmentActivity activity) {
        mFragmentManager = activity.getSupportFragmentManager();
    }
    
    public FragmentTransit(FragmentManager fragmentManager) {
        mFragmentManager = fragmentManager;
    }
    
    public static FragmentTransit from(Context context) {
        final FragmentTransit transit;
        if (context instanceof ActionBarActivity) {
            ActionBarActivity activity = (ActionBarActivity) context;
            transit = new FragmentTransit(activity);
        } else if (context instanceof FragmentActivity) {
            FragmentActivity activity = (FragmentActivity) context;
            transit = new FragmentTransit(activity);
        } else {
            throw new IllegalStateException(
                    "Context not contain ActionBarActivity or FragmentActivity");
        }
        return transit;
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
                            R.anim.fade_in,
                            R.anim.fade_out,
                            R.anim.fade_in,
                            R.anim.fade_out);
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
