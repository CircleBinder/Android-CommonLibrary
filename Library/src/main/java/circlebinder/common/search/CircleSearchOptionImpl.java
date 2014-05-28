package circlebinder.common.search;

import android.os.Parcel;

import circlebinder.common.checklist.ChecklistColor;
import circlebinder.common.event.Block;

final class CircleSearchOptionImpl implements CircleSearchOption, android.os.Parcelable {

    private final String keyword;
    private final Order order;
    private final Block block;
    private final ChecklistColor checklistColor;

    CircleSearchOptionImpl(CircleSearchOptionBuilder builder) {
        keyword = builder.keyword;
        order = builder.order;
        block = builder.block;
        checklistColor = builder.checklistColor;
    }

    @Override
    public Order getOrder() {
        return order;
    }

    @Override
    public boolean hasKeyword() {
        return keyword != null;
    }

    @Override
    public CharSequence getKeyword() {
        return keyword;
    }

    @Override
    public boolean hasBlock() {
        return block != null;
    }

    @Override
    public Block getBlock() {
        return block;
    }

    @Override
    public boolean hasChecklist() {
        return checklistColor != null;
    }

    @Override
    public ChecklistColor getChecklist() {
        return checklistColor;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.keyword);
        dest.writeSerializable(this.order);
        dest.writeParcelable(this.block, 0);
        dest.writeInt(this.checklistColor == null ? -1 : this.checklistColor.ordinal());
    }

    private CircleSearchOptionImpl(Parcel in) {
        this.keyword = in.readString();
        this.order = (Order) in.readSerializable();
        this.block = in.readParcelable(Block.class.getClassLoader());
        int tmpChecklistColor = in.readInt();
        this.checklistColor = tmpChecklistColor == -1 ? null : ChecklistColor.values()[tmpChecklistColor];
    }

    public static Creator<CircleSearchOptionImpl> CREATOR = new Creator<CircleSearchOptionImpl>() {
        public CircleSearchOptionImpl createFromParcel(Parcel source) {
            return new CircleSearchOptionImpl(source);
        }

        public CircleSearchOptionImpl[] newArray(int size) {
            return new CircleSearchOptionImpl[size];
        }
    };
}
