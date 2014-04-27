package circlebinder.common.app;

import android.content.Context;
import android.content.Intent;

import net.ichigotake.common.app.Tripper;

import circlebinder.common.R;

public final class ContactTripper implements Tripper {

    private final Context context;

    public ContactTripper(Context context) {
        this.context = context;
    }

    @Override
    public void trip() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(
                Intent.EXTRA_EMAIL,
                context.getResources().getStringArray(R.array.circlebinder_app_contact_emails)
        );
        intent.putExtra(
                Intent.EXTRA_SUBJECT,
                context.getString(R.string.circlebinder_app_contact_subject)
        );
        intent.putExtra(
                Intent.EXTRA_TEXT,
                context.getString(R.string.circlebinder_app_contact_text)
        );
        intent.setType("message/rfc822");
        context.startActivity(intent);
    }
}
