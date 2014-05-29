package circlebinder.common.search;

import android.support.v7.widget.SearchView;

import net.ichigotake.common.view.inputmethod.SoftInput;

public final class CircleSearchOptionContainer {

    private final SearchView searchText;
    private final OnSearchActionListener searchActionListener;

    public CircleSearchOptionContainer(SearchView container, OnSearchActionListener listener) {
        this.searchText = container;
        this.searchActionListener = listener;
    }

    public void initialize() {
        searchText.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                SoftInput.hide(searchText);
                searchActionListener.onSearch();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                searchActionListener.onSearch();
                return true;
            }
        });
    }

    public String getQuery() {
        return searchText.getQuery().toString();
    }

}
