package circlebinder.common.event;

import android.test.AndroidTestCase;

import circlebinder.common.test.ParcelUtil;

public final class NearbyStationTest extends AndroidTestCase {

    public void testParcelable() {
        NearbyStation expect = new NearbyStation.Builder()
                .setDisplay("最寄り駅")
                .build();

        try {
            NearbyStation got = ParcelUtil.restore(expect);
            assertEquals(expect.getDisplay(), got.getDisplay());
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
