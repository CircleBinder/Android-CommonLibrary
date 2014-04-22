package circlebinder.common.event;

import android.test.AndroidTestCase;

import circlebinder.common.test.ParcelUtil;

public final class EventDayTest extends AndroidTestCase {

    public void testParcelable() {
        EventDay expect = new EventDay.Builder()
                .setName("今日")
                .build();

        try {
            EventDay got = ParcelUtil.restore(expect);
            assertEquals(expect.getName(), got.getName());
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
