package infobip.api.model.omni.send;

/**
 * Project    : infobip-api-java-client
 * Created by : go2zo
 * Created at : 2020-01-15
 * <p>
 * Description:
 */
public class KakaoChinguData {
    private String text;
    private Long validityPeriod;
    private String imageUrl;
    private boolean isPromotional;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getValidityPeriod() {
        return validityPeriod;
    }

    public void setValidityPeriod(Long validityPeriod) {
        this.validityPeriod = validityPeriod;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isPromotional() {
        return isPromotional;
    }

    public void setPromotional(boolean promotional) {
        isPromotional = promotional;
    }
}
