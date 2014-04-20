package circlebinder.common.search;

import android.view.View;
import android.widget.EditText;

import circlebinder.common.R;
import net.ichigotake.common.widget.CursorSwitchOnFocusChangeListener;
import net.ichigotake.common.widget.OnFocusChangeListeners;

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

    public CircleSearchOption getSearchOption() {
        return new CircleSearchOption.Builder()
                .setKeyword(searchText.getText().toString())
                .build();
    }

}
