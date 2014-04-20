package circlebinder.common.event;


import circlebinder.Legacy;

/**
 * {@link Space}
 */
public class CircleSpaceFactory implements Legacy {

    /**
     * "あ01a" のような文字列から {@link Space} を生成する
     * @param name
     * @return space
     */
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
