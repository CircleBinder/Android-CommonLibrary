package net.ichigotake.circlebinder.common.checklist;

import android.support.v4.app.FragmentManager;

import com.fourmob.colorpicker.ColorPickerDialog;
import com.fourmob.colorpicker.ColorPickerSwatch;

import net.ichigotake.circlebinder.common.event.Circle;

public final class FavoritePicker {

    public static interface OnSelectedListener {

        void onSelected(ChecklistColor color);
    }

    private final OnSelectedListener listener;
    private final FragmentManager fragmentManager;
    private final Circle circle;

    public FavoritePicker(FragmentManager fragmentManager,
                          Circle circle,
                          OnSelectedListener listener) {
        this.fragmentManager = fragmentManager;
        this.circle = circle;
        this.listener = listener;
    }

    public void show() {
        ColorPickerDialog checklistPicker = new ColorPickerDialog();
        checklistPicker.initialize(
                circle.getName(),
                ChecklistColor.colors(),
                circle.getChecklistColor().getColor(),
                3,
                2
        );
        checklistPicker.setOnColorSelectedListener(new OnColorSelectedListenerImpl(listener));
        checklistPicker.show(fragmentManager, null);
    }

    private static class OnColorSelectedListenerImpl implements ColorPickerSwatch.OnColorSelectedListener {

        private final OnSelectedListener listener;

        private OnColorSelectedListenerImpl(OnSelectedListener listener) {
            this.listener = listener;
        }

        @Override
        public void onColorSelected(int i) {
            ChecklistColor color = ChecklistColor.get(i);
            listener.onSelected(color);
        }
    }
}
