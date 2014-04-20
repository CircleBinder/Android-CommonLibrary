package circlebinder.common.event;

import android.os.Parcel;

import circlebinder.common.checklist.ChecklistColor;

public final class CircleBuilder {

    private int id;
    private Space space;
    private Genre genre;
    private ChecklistColor checklistColor;
    private String name;
    private String penName;

    public CircleBuilder() {}

    public CircleBuilder(CircleBuilder builder) {
        id = builder.id;
        space = builder.space;
        genre = builder.genre;
        checklistColor = builder.checklistColor;
        name = builder.name;
        penName = builder.penName;
    }
    public Circle build() {
        return new CircleImpl(this);
    }

    private static class CircleImpl implements Circle, android.os.Parcelable {

        private final int id;
        private final Space space;
        private final Genre genre;
        private final ChecklistColor checklistColor;
        private final String name;
        private final String penName;

        private CircleImpl(CircleBuilder builder) {
            id = builder.id;
            space = builder.space;
            genre = builder.genre;
            checklistColor = builder.checklistColor;
            name = builder.name;
            penName = builder.penName;
        }

        @Override
        public int getId() {
            return id;
        }

        @Override
        public Space getSpace() {
            return space;
        }

        @Override
        public Genre getGenre() {
            return genre;
        }

        @Override
        public ChecklistColor getChecklistColor() {
            return checklistColor;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String getPenName() {
            return penName;
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
        }

        private CircleImpl(Parcel in) {
            this.id = in.readInt();
            this.space = in.readParcelable(Space.class.getClassLoader());
            this.genre = in.readParcelable(Genre.class.getClassLoader());
            int tmpChecklistColor = in.readInt();
            this.checklistColor = tmpChecklistColor == -1 ? null : ChecklistColor.values()[tmpChecklistColor];
            this.name = in.readString();
            this.penName = in.readString();
        }

        public static Creator<CircleImpl> CREATOR = new Creator<CircleImpl>() {
            public CircleImpl createFromParcel(Parcel source) {
                return new CircleImpl(source);
            }

            public CircleImpl[] newArray(int size) {
                return new CircleImpl[size];
            }
        };
    }

    public CircleBuilder setPenName(String penName) {
        this.penName = penName;
        return this;
    }

    public CircleBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CircleBuilder setChecklistColor(ChecklistColor checklistColor) {
        this.checklistColor = checklistColor;
        return this;
    }

    public CircleBuilder setGenre(Genre genre) {
        this.genre = genre;
        return this;
    }

    public CircleBuilder setSpace(Space space) {
        this.space = space;
        return this;
    }

    public CircleBuilder setId(int id) {
        this.id = id;
        return this;
    }

}
