package net.ichigotake.circlebinder.common.event;

import android.os.Parcel;

public final class GenreBuilder {

    private int id;
    private String name;

    public Genre build() {
        return new GenreImpl(this);
    }

    private static class GenreImpl implements Genre {

        private final int id;
        private final String name;

        public GenreImpl(GenreBuilder builder) {
            id = builder.id;
            name = builder.name;
        }

        @Override
        public int getId() {
            return id;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {

        }
    }

    public GenreBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public GenreBuilder setName(String name) {
        this.name = name;
        return this;
    }
}
