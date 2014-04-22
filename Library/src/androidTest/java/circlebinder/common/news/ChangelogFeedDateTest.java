package circlebinder.common.news;

import android.test.AndroidTestCase;

import circlebinder.common.test.ParcelUtil;

public final class ChangelogFeedDateTest extends AndroidTestCase {

    public void testParselable() {
        ChangelogFeedDate expect = new ChangelogFeedDate.Builder()
                .setFormattedDate("2013-04-05")
                .setTimestamp(100)
                .build();

        try {
            ChangelogFeedDate got = ParcelUtil.restore(expect);
            assertEquals(expect.getFormattedDate(), got.getFormattedDate());
            assertEquals(expect.getTimestamp(), got.getTimestamp());
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
    }
}
