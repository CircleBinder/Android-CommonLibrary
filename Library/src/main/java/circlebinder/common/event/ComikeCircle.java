package circlebinder.common.event;

/**
 * コミケの申し込みサークル
 * TODO: ComiketCircle へリネームした、Circleクラスはもっと抽象的なものとして分離
 */
public interface ComikeCircle extends Circle {

    public int getPageNo();

    public int getCutIndex();

    public EventDate getDate();

    public String getNameKana();

    public String getBookName();

    public String getUrl();

    public String getMailAddr();

    public String getDescription();

    public String getMemo();

    public long getUpdatedTime();

    public String getUpdatedDateTime();

    public String getCirclemsUrl();

    public String getRssUrl();

    public boolean isUpdated();
}
