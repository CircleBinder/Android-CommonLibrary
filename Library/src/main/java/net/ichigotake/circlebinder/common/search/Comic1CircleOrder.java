package net.ichigotake.circlebinder.common.search;

public enum Comic1CircleOrder implements Order {

    CIRCLE_NAME_ASC(Sequence.ASC),
    CIRCLE_SPACE_ASC(Sequence.ASC),
    DEFAULT(Sequence.ASC),
    ;

    private final Sequence sequence;

    private Comic1CircleOrder(Sequence sequence) {
        this.sequence = sequence;
    }

    @Override
    public Sequence getSequence() {
        return sequence;
    }

    public static Comic1CircleOrder get(String value) {
        Comic1CircleOrder got = DEFAULT;
        for (Comic1CircleOrder order : values()) {
            if (order.name().equals(value)) {
                got = order;
            }
        }
        return got;
    }
}
