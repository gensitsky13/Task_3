package ru.stellarburgers.tests;

import io.qameta.allure.Description;
import org.junit.Test;
import ru.stellarburgers.base.BaseTest;
import ru.stellarburgers.pages.MainPage;

import static org.junit.Assert.assertTrue;

public class ConstructorTabsTest extends BaseTest {

    @Test
    @Description("Переход к разделу 'Булки'")
    public void shouldOpenBunsTab() {
        MainPage main = new MainPage(driver).open();
        main.waitIngredients();
        assertTrue(main.getActiveTabText().contains("Булки"));
    }

    @Test
    @Description("Переход к разделу 'Соусы'")
    public void shouldOpenSaucesTab() {
        MainPage main = new MainPage(driver).open();
        main.openSaucesTab();
        assertTrue(main.getActiveTabText().contains("Соусы"));
    }

    @Test
    @Description("Переход к разделу 'Начинки'")
    public void shouldOpenFillingsTab() {
        MainPage main = new MainPage(driver).open();
        main.openFillingsTab();
        assertTrue(main.getActiveTabText().contains("Начинки"));
    }
}


