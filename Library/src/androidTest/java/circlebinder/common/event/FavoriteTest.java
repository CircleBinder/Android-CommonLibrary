package circlebinder.common.event;

import android.test.AndroidTestCase;

import circlebinder.common.checklist.Checklist;
import circlebinder.common.test.ParcelUtil;

public final class FavoriteTest extends AndroidTestCase {
    
    public void testParcelable() {
        Favorite expect = new Favorite.Builder()
                .setChecklist(new Checklist.Builder().setName("チェックリスト！").build())
                .setCircle(new Circle.Builder().setName("サークル名").build())
                .build();

        try {
            Favorite got = ParcelUtil.restore(expect);
            assertEquals(expect.getChecklist().getName(), got.getChecklist().getName());
            assertEquals(expect.getCircle().getName(), got.getCircle().getName());
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
