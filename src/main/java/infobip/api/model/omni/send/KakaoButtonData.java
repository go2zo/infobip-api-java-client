package infobip.api.model.omni.send;

/**
 * Project    : infobip-api-java-client
 * Created by : go2zo
 * Created at : 2020-01-15
 * <p>
 * Description:
 */
public class KakaoButtonData {
    private String buttonText;
    private String buttonUrl;

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public String getButtonUrl() {
        return buttonUrl;
    }

    public void setButtonUrl(String buttonUrl) {
        this.buttonUrl = buttonUrl;
    }
}
