package tests;

import config.BaseTest;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ConstructorNavigationTest extends BaseTest {

    @Test
    public void bunsTabIsActiveByDefault() {
        assertTrue("Вкладка «Булки» должна быть активна по умолчанию",
                mainPage.isBunsTableActive());
    }

    @Test
    public void canSwitchTabsInConstructor() {
        mainPage.selectSaucesTab();
        assertTrue(mainPage.isSaucesTabActive());

        mainPage.selectFillingsTab();
        assertTrue(mainPage.isFillingsTabActive());

        mainPage.selectBunsTab();
        assertTrue(mainPage.isBunsTableActive());
    }
}
