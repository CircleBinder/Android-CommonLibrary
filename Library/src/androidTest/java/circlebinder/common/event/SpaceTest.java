package circlebinder.common.event;

import android.test.AndroidTestCase;

import circlebinder.common.test.ParcelUtil;

public final class SpaceTest extends AndroidTestCase {

    public void testParcelable() {
        Space expect = new Space.Builder()
                .setName("桃")
                .setSimpleName("P")
                .setNo(33)
                .setNoSub("c")
                .setBlockName("ブロック名")
                .build();

        try {
            Space got = ParcelUtil.restore(expect);
            assertEquals(expect.getName(), got.getName());
            assertEquals(expect.getNo(), got.getNo());
            assertEquals(expect.getNoSub(), got.getNoSub());
            assertEquals(expect.getBlockName(), got.getBlockName());
            assertEquals(expect.getSimpleName(), got.getSimpleName());
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
