package circlebinder.common.dashboard;

public final class DashboardItem {

    public final static class Builder {
        private int iconResource;
        private String label;
        private String sectionTitle;
        private long sectionTitleId;

        public DashboardItem build() {
            return new DashboardItem(this);
        }

        public Builder setIconResource(int drawable) {
            this.iconResource = drawable;
            return this;
        }

        public Builder setLabel(String label) {
            this.label = label;
            return this;
        }

        public Builder setSectionTitle(String title) {
            this.sectionTitle = title;
            return this;
        }

        public Builder setSectionTitleId(long id) {
            this.sectionTitleId = id;
            return this;
        }

    }

    private final int iconResource;
    private final String label;
    private final String sectionTitle;
    private final long sectionTitleId;

    private DashboardItem(Builder builder) {
        this.iconResource = builder.iconResource;
        this.label = builder.label;
        this.sectionTitle = builder.sectionTitle;
        this.sectionTitleId = builder.sectionTitleId;
    }

    public int getIconResource() {
        return iconResource;
    }

    public String getLabel() {
        return label;
    }

    public String getSectionTitle() {
        return sectionTitle;
    }

    public long getSectionTitleId() {
        return sectionTitleId;
    }

}
