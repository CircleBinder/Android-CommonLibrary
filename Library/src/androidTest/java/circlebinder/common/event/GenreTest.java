package circlebinder.common.event;

import android.test.AndroidTestCase;

import circlebinder.common.test.ParcelUtil;

public final class GenreTest extends AndroidTestCase {

    public void testParcel() {
        Genre expect = new Genre.Builder()
                .setId(653115)
                .setName("ジャンル！")
                .build();

        try {
            Genre got = ParcelUtil.restore(expect);
            assertEquals(expect.getId(), got.getId());
            assertEquals(expect.getName(), got.getName());
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
