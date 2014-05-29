package circlebinder.common.event;

import android.test.AndroidTestCase;

import circlebinder.common.test.ParcelUtil;

public final class EventTest extends AndroidTestCase {

    public void testParcelable() {
        Event expect = new Event.Builder()
                .setName("イベント名")
                .setDay(new EventDay.Builder().setName("今日").build())
                .setLocation(new Location.Builder().setDisplayName("場所").build())
                .build();

        try {
            Event got = ParcelUtil.restore(expect);
            assert expect.getName().equals(got.getName());
            assert expect.getDay().equals(got.getDay());
            assert expect.getLocation().getDisplayName().equals(got.getLocation().getDisplayName());
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
