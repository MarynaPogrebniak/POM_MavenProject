package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLinksImages extends BasePage{
    public BrokenLinksImages(WebDriver driver) {
        super(driver);
    }


    @FindBy(tagName = "a")
    List<WebElement> links;
    public BrokenLinksImages checkBrokenLinks() {

        for (int i = 0; i < links.size(); i++) {
            WebElement el = links.get(i);
            String url = el.getAttribute("href");
            verifyLinks(url);
        }
        return this;
    }
}
