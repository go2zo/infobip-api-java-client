package infobip.api.model.omni.send;

import java.util.List;

/**
 * Project    : infobip-api-java-client
 * Created by : go2zo
 * Created at : 2020-01-15
 * <p>
 * Description:
 */
public class KakaoAlimData {
    private String text;
    private String templateCode;
    private Long validityPeriod;
    private List<KakaoButtonData> buttons;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    public Long getValidityPeriod() {
        return validityPeriod;
    }

    public void setValidityPeriod(Long validityPeriod) {
        this.validityPeriod = validityPeriod;
    }

    public List<KakaoButtonData> getButtons() {
        return buttons;
    }

    public void setButtons(List<KakaoButtonData> buttons) {
        this.buttons = buttons;
    }
}
