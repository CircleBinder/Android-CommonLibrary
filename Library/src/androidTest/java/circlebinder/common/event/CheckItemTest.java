package circlebinder.common.event;

import android.test.AndroidTestCase;

import circlebinder.common.test.ParcelUtil;

public final class CheckItemTest extends AndroidTestCase {

    public void testParcel() {
        CheckItem expect = new CheckItem.Builder()
                .setCircleId(653115)
                .setName("本")
                .setChecked(true)
                .setPrice(300)
                .setNum(10)
                .setType(1)
                .build();

        try {
            CheckItem got = ParcelUtil.restore(expect);
            assertEquals(expect.getCircleId(), got.getCircleId());
            assertEquals(expect.getType(), got.getType());
            assertEquals(expect.getName(), got.getName());
            assertEquals(expect.getPrice(), got.getPrice());
            assertEquals(expect.getNum(), got.getNum());
            assertEquals(expect.isChecked(), got.isChecked());
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

}
