package circlebinder.common.event;

import android.content.Context;
import android.support.v4.view.ActionProvider;
import android.view.View;
import android.widget.Spinner;

import net.ichigotake.common.widget.ArrayAdapter;
import net.ichigotake.common.widget.OnItemSelectedEventListener;
import net.ichigotake.common.widget.OnItemSelectedListener;

import java.util.Collection;

import circlebinder.common.checklist.SelectorViewHolder;

public final class CircleBlockFilterActionProvider extends ActionProvider {

    private final OnItemSelectedListener<Block> onItemSelectedListener;
    private Spinner blockIconView;

    public CircleBlockFilterActionProvider(Context context, Collection<Block> blocks) {
        super(context);
        this.onItemSelectedListener = new OnItemSelectedListener<Block>();
        this.blockIconView = new Spinner(getContext());
        ArrayAdapter<Block, SelectorViewHolder> adapter = new ArrayAdapter<Block, SelectorViewHolder>(
                getContext(),
                new BlockSelectorBinder()
        );
        adapter.addAll(blocks);
        blockIconView.setAdapter(adapter);
        blockIconView.setOnItemSelectedListener(onItemSelectedListener);
    }

    public void addOnItemSelectedListener(OnItemSelectedEventListener<Block> listener) {
        onItemSelectedListener.addOnItemSelectedListener(listener);
    }

    public void setSelection(Block block) {
        final int position;
        if (block == null) {
            position = 0;
        } else if (block.getId() > 0) {
            position = block.getId();
        } else {
            position = 1;
        }
        blockIconView.setSelection(position);
    }

    @Override
    public View onCreateActionView() {
        return blockIconView;
    }

    @Override
    public boolean onPerformDefaultAction() {
        return super.onPerformDefaultAction();
    }

}
