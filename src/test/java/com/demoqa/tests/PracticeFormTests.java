package com.demoqa.tests;

import com.demoqa.data.StudentData;
import com.demoqa.pages.AlertsPage;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.PracticeFormPage;
import com.demoqa.pages.SidePanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeFormTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getForms();
        new SidePanel(driver).selectPracticeForm();

    }

    @Test
    public void fillPracticeFormTest() {
        new PracticeFormPage(driver).hideIframes();
        new PracticeFormPage(driver).enterPersonalData("Katrin", "Smith",
                "katrin@gmail.com", "1234567891")
                .selectGender("Female")
                .typeDate("03 May 2022")
                .addSubject(new String[] {"Maths", "English", "Physics"})
                .selectHobby(new String[]{"Sports", "Reading", "Music"})
                .uploadFile("C:/Tools/sea.jpg")
                .enterAddress("Berlin, Hauptstr. 17")
                .selectState("NCR")
                .selectCity("Delhi")
                .submit()
        ;
    }

    @Test
    public void fillPracticeFormWithFinalDataTest() {
        new PracticeFormPage(driver).hideIframes();
        new PracticeFormPage(driver).enterPersonalData(StudentData.FIRST_NAME,
                        StudentData.LAST_NAME, StudentData.EMAIL, StudentData.PHONE)
                .selectGender(StudentData.GENDER)
                .typeDate(StudentData.B_DAY)
                .addSubject(StudentData.SUBJECTS)
                .selectHobby(StudentData.HOBBIES)
                .uploadFile(StudentData.PHOTO)
                .enterAddress(StudentData.ADDRESS)
                .selectState(StudentData.STATE)
                .selectCity(StudentData.CITY)
                .submit()
        ;
        new PracticeFormPage(driver).submitMessageConfirmResult("Thanks for submitting the form");
    }
}
