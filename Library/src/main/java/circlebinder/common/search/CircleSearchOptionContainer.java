package circlebinder.common.search;

import android.support.v7.widget.SearchView;

import net.ichigotake.common.view.inputmethod.SoftInput;

public final class CircleSearchOptionContainer {

    //private final View searchOptionView;
    private final SearchView searchText;
    private final OnSearchActionListener searchActionListener;

    public CircleSearchOptionContainer(SearchView container, OnSearchActionListener listener) {
        //this.searchOptionView = container.findViewById(R.id.circle_search_option);
        this.searchText = container;
        this.searchActionListener = listener;
    }

    public void initialize() {
        //searchOptionView.setOnClickListener(new OnOptionClickListener(searchActionListener));
        searchText.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                SoftInput.hide(searchText);
                searchActionListener.onSearch(getSearchOption());
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                searchActionListener.onSearch(getSearchOption());
                return true;
            }
        });
    }

    public CircleSearchOption getSearchOption() {
        return new CircleSearchOptionBuilder()
                .setKeyword(searchText.getQuery().toString())
                .build();
    }

    public void setSearchOption(CircleSearchOption searchOption) {
        searchText.setQuery(searchOption.getKeyword(), true);
    }

}
