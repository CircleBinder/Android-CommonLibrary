package circlebinder.common.dashboard;

import android.test.AndroidTestCase;

import circlebinder.common.test.ParcelUtil;

public final class ChangelogFeedTest extends AndroidTestCase {

    public void testParcelable() {
        String title = "おはよう世界";
        String body = "こんにちは太陽";
        PublishDate publishDate = MockPublishDate.create();
        ChangelogFeed feed = new ChangelogFeed.Builder()
                .setTitle(title)
                .setBody(body)
                .setPublishDate(publishDate)
                .build();

        assertEquals(title, feed.getTitle());
        assertEquals(body, feed.getBody());
        assertEquals(publishDate.getFormattedDate(), feed.getPublishDate().getFormattedDate());
        assertEquals(publishDate.getTimestamp(), feed.getPublishDate().getTimestamp());

        try {
            ChangelogFeed restoredFeed = ParcelUtil.restore(feed);

            assertEquals(feed.getTitle(), restoredFeed.getTitle());
            assertEquals(feed.getBody(), restoredFeed.getBody());
            assertEquals(feed.getPublishDate().getFormattedDate(), restoredFeed.getPublishDate().getFormattedDate());
            assertEquals(feed.getPublishDate().getTimestamp(), restoredFeed.getPublishDate().getTimestamp());
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
