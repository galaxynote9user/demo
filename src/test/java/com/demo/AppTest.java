package com.demo;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * docker run -d -p 9517:4444 --shm-size="2g" selenium/standalone-firefox:latest
 */
public class AppTest {
    public static void main(String[] args) throws MalformedURLException,IOException {
        DesiredCapabilities dc = new DesiredCapabilities();
        //dc.setBrowserName("chrome");
        //dc.setBrowserName("MicrosoftEdge");
        dc.setBrowserName("firefox");
        //dc.setBrowserName("safari");

        URL url = new URL("http://localhost:9517/wd/hub");
        RemoteWebDriver driver = new RemoteWebDriver(url, dc);

        driver.get("https://www.google.com");
        driver.manage().window().maximize();

        //code to print the current url
        System.out.println(driver.getCurrentUrl());

        //code to print the title of the page
        System.out.println(driver.getTitle());

        //code to take current page screenshot and store it as png
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Use FileOutputStream to write the screenshot data to a file
        try (FileOutputStream outputStream = new FileOutputStream("screenshot.png")) {
            outputStream.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        }

        //code to close the browser

        driver.quit();
    }
}
