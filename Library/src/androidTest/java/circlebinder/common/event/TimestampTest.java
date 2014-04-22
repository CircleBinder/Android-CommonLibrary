package circlebinder.common.event;

import android.test.AndroidTestCase;

import circlebinder.common.test.ParcelUtil;

public final class TimestampTest extends AndroidTestCase {

    public void testParcelable() {
        Timestamp expect = new Timestamp.Builder()
                .setDisplayName("2000-11-18")
                .setTimestamp(653115)
                .build();

        try {
            Timestamp got = ParcelUtil.restore(expect);
            assertEquals(expect.getDisplayName(), got.getDisplayName());
            assertEquals(expect.getTimestamp(), got.getTimestamp());
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }
}
