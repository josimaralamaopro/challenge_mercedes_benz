package uk.mercedes.tests.pom;

import static uk.mercedes.tests.helpers.SeleniumHelper.*;

public class CookiesPolicyPage {

    private static final String agreeToAllButtonSelector = "button[data-test='handle-accept-all-button']";

    /**
     * Accept cookies policy;
     */
    public void acceptAll() {
        try {
            moveToElementAndClick(findShadowElement(agreeToAllButtonSelector, MEDIUM_TIMEOUT));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
