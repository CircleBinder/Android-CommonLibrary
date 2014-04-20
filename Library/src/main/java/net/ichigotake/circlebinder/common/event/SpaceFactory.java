package net.ichigotake.circlebinder.common.event;

public final class SpaceFactory {

    public Space from(String name) {
        Block block = new BlockBuilder()
                .setName(name.substring(0, 1))
                .setArea(new AreaBuilder().setName(name.substring(0, 1)).build())
                .build();
        return new CircleSpaceBuilder()
                .setBlock(block)
                .setNo(Integer.parseInt(name.substring(1, 2)))
                .setNoSub(name.substring(3))
                .build();
    }

}
