package circlebinder.common.checklist;

import java.io.Serializable;

public final class ChecklistBuilder implements Serializable {

    ChecklistColor color;
    String name;

    public Checklist build() {
        return new Checklist(this);
    }

    public ChecklistBuilder setColor(ChecklistColor color) {
        this.color = color;
        return this;
    }

    public ChecklistBuilder setName(String name) {
        this.name = name;
        return this;
    }

}
