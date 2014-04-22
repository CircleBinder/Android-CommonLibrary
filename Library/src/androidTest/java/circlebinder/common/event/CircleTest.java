package circlebinder.common.event;

import android.test.AndroidTestCase;

import circlebinder.common.checklist.ChecklistColor;
import circlebinder.common.test.ParcelUtil;

public final class CircleTest extends AndroidTestCase {

    public void testParcel() {
        Circle expect = new Circle.Builder()
                .setId(653115)
                .setName("銀河ドリーム")
                .setPenName("銀河宇宙人")
                .setChecklistColor(ChecklistColor.GREEN)
                .setGenre(new Genre.Builder().setName("銀河ジャンル").build())
                .setSpace(new Space.Builder().setName("銀河スペース").build())
                .build();

        try {
            Circle got = ParcelUtil.restore(expect);
            assertEquals(expect.getId(), got.getId());
            assertEquals(expect.getName(), got.getName());
            assertEquals(expect.getPenName(), got.getPenName());
            assertEquals(expect.getChecklistColor(), got.getChecklistColor());
            assertEquals(expect.getGenre().getName(), got.getGenre().getName());
            assertEquals(expect.getSpace().getName(), got.getSpace().getName());
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
