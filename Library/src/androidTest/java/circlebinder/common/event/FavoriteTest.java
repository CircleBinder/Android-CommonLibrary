package circlebinder.common.event;

import android.test.AndroidTestCase;

import circlebinder.common.checklist.ChecklistColor;
import circlebinder.common.test.ParcelUtil;

public final class FavoriteTest extends AndroidTestCase {
    
    public void testParcelable() {
        Favorite expect = new Favorite.Builder()
                .setChecklistColor(ChecklistColor.LIGHT_BLUE)
                .setCircle(new Circle.Builder().setName("サークル名").build())
                .build();

        try {
            Favorite got = ParcelUtil.restore(expect);
            assertEquals(expect.getChecklist(), got.getChecklist());
            assertEquals(expect.getCircle().getName(), got.getCircle().getName());
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}