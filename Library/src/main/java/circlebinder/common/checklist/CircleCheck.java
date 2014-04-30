package circlebinder.common.checklist;

import circlebinder.common.R;

public enum CircleCheck {

    UNCHECK(0, R.string.circlebinder_circlebinder_circle_check_uncheck),
    CHECKED(1, R.string.circlebinder_circlebinder_circle_check_checked),
    ;

    private final int statudId;
    private final int statusNameResource;

    private CircleCheck(int statusId, int statusName) {
        this.statudId = statusId;
        this.statusNameResource = statusName;
    }

    public int getId() {
        return statudId;
    }

    public int getStatusNameResource() {
        return statusNameResource;
    }

    public static CircleCheck get(boolean isChecked) {
        return (isChecked) ? CHECKED : UNCHECK;
    }
}
