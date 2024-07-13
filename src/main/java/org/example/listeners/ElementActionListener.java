package org.example.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

public class ElementActionListener implements WebDriverListener {
    private static final Logger LOGGER = LogManager.getLogger(TestListeners.class);
    @Override
    public void beforeGet(WebDriver driver, String url) {
        LOGGER.info("Open url https://megatop.by/");
    }
    @Override
    public void afterClick(WebElement element) {
        LOGGER.info("Click on " + element.getTagName() + " element");
    }
    @Override
    public void afterGetText(WebElement element, String result) {
        LOGGER.info("Get text from element " + element.getTagName());
    }
    @Override
    public void afterFindElement(WebElement element, By locator, WebElement result) {
        LOGGER.info("Find element " + element.getTagName() + " on page");
    }
}
