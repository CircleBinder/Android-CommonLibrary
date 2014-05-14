package circlebinder.common.search;

import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import net.ichigotake.common.widget.CursorSwitchOnFocusChangeListener;
import net.ichigotake.common.widget.OnFocusChangeListeners;

import circlebinder.common.R;

public final class CircleSearchOptionContainer {

    private final View searchOptionView;
    private final EditText searchText;
    private final OnFocusChangeListeners focusChangeListeners;
    private final OnSearchActionListener searchActionListener;

    public CircleSearchOptionContainer(View container, OnSearchActionListener listener) {
        this.searchOptionView = container.findViewById(R.id.circle_search_option);
        this.searchText = (EditText)container.findViewById(R.id.circle_search_keyword);
        this.focusChangeListeners = new OnFocusChangeListeners();
        this.searchActionListener = listener;
    }

    public void initialize() {
        //searchOptionView.setOnClickListener(new OnOptionClickListener(searchActionListener));
        searchText.setOnEditorActionListener(
                new OnEditorActionListenerImpl(searchActionListener, this)
        );
        searchText.setOnFocusChangeListener(focusChangeListeners);
        focusChangeListeners.addOnFocusChangeListener(new CursorSwitchOnFocusChangeListener());
    }

    public void addOnFocusChangeListener(View.OnFocusChangeListener listener) {
        focusChangeListeners.addOnFocusChangeListener(listener);
    }

    public void addTextChangedListener(TextWatcher listener) {
        searchText.addTextChangedListener(listener);
    }

    public CircleSearchOption getSearchOption() {
        return new CircleSearchOption.Builder()
                .setKeyword(searchText.getText().toString())
                .build();
    }

    public void setSearchOption(CircleSearchOption searchOption) {
        searchText.setText(searchOption.getKeyword());
    }

}
