package circlebinder.common.event;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import circlebinder.common.checklist.ChecklistColor;

public final class Circle implements Parcelable {

    public static class Builder {

        private int id;
        private Space space;
        private Genre genre;
        private ChecklistColor checklistColor;
        private String name;
        private String penName;
        private List<CircleLink> links;

        public Builder() {
            links = new CopyOnWriteArrayList<CircleLink>();
        }

        public Builder(Builder builder) {
            id = builder.id;
            space = builder.space;
            genre = builder.genre;
            checklistColor = builder.checklistColor;
            name = builder.name;
            penName = builder.penName;
            links = builder.links;
        }

        public Circle build() {
            return new Circle(this);
        }

        public Builder addLink(CircleLink link) {
            this.links.add(link);
            return this;
        }

        public Builder setLink(CircleLink link) {
            this.links.clear();
            this.links.add(link);
            return this;
        }

        public Builder setPenName(String penName) {
            this.penName = penName;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setChecklistColor(ChecklistColor checklistColor) {
            this.checklistColor = checklistColor;
            return this;
        }

        public Builder setGenre(Genre genre) {
            this.genre = genre;
            return this;
        }

        public Builder setSpace(Space space) {
            this.space = space;
            return this;
        }

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public void clear() {
            id = 0;
            space = null;
            genre = null;
            checklistColor = null;
            name = null;
            penName = null;
            links.clear();
        }
    }

    private final int id;
    private final Space space;
    private final Genre genre;
    private final ChecklistColor checklistColor;
    private final String name;
    private final String penName;
    private final CircleLinks links;

    private Circle(Builder builder) {
        id = builder.id;
        space = builder.space;
        genre = builder.genre;
        checklistColor = builder.checklistColor;
        name = builder.name;
        penName = builder.penName;
        links = new CircleLinks(builder.links);
    }

    public int getId() {
        return id;
    }

    public Space getSpace() {
        return space;
    }

    public Genre getGenre() {
        return genre;
    }

    public ChecklistColor getChecklistColor() {
        return checklistColor;
    }

    public String getName() {
        return name;
    }

    public String getPenName() {
        return penName;
    }

    public CircleLinks getLinks() {
        return links;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeParcelable(this.space, flags);
        dest.writeParcelable(this.genre, flags);
        dest.writeInt(this.checklistColor == null ? -1 : this.checklistColor.ordinal());
        dest.writeString(this.name);
        dest.writeString(this.penName);
        dest.writeParcelable(this.links, flags);
    }

    private Circle(Parcel in) {
        this.id = in.readInt();
        this.space = in.readParcelable(Space.class.getClassLoader());
        this.genre = in.readParcelable(Genre.class.getClassLoader());
        int tmpChecklistColor = in.readInt();
        this.checklistColor = tmpChecklistColor == -1 ? null : ChecklistColor.values()[tmpChecklistColor];
        this.name = in.readString();
        this.penName = in.readString();
        this.links = in.readParcelable(CircleLinks.class.getClassLoader());
    }

    public static Parcelable.Creator<Circle> CREATOR = new Parcelable.Creator<Circle>() {
        public Circle createFromParcel(Parcel source) {
            return new Circle(source);
        }

        public Circle[] newArray(int size) {
            return new Circle[size];
        }
    };
}
