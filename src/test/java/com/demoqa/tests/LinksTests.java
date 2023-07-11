package com.demoqa.tests;

import com.demoqa.pages.BrokenLinksImages;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.LinksPage;
import com.demoqa.pages.SidePanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinksTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getElements();
    }

    @Test
    public void getAllLinksTest() {
        new SidePanel(driver).selectLinks();
        new LinksPage(driver).getAllLinks();
    }

    @Test
    public void getBrokenLinks() {
        new SidePanel(driver).selectBrokenLinksImages();
        new BrokenLinksImages(driver).checkBrokenLinks();
    }

}
