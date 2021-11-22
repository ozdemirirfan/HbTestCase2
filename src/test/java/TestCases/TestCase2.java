package TestCases;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;

import static java.util.concurrent.TimeUnit.SECONDS;

public class TestCase2 {
    public static WebDriver driver;
    public static String baseUrl;
    private Label alert;


    @Given("Kullanıcı Hepsiburada.com sitesini ziyaret eder")
    public void KullaniciHepsiburadacomSitesiniZiyaretEder() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3000, SECONDS);
        driver.manage().timeouts().pageLoadTimeout(3000, SECONDS);
        driver.manage().window().maximize();
        baseUrl = "https://hepsiburada.com/";
        driver.get(baseUrl);
    }
    @When("Kullanıcı, Kitap, Müzik, Film, Hobi kategorisine girer.")
    public void KategoriSecimi() throws InterruptedException {
        Thread.sleep(5000);

        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[4]/div/div/div/div/div/div/div/div[1]/div/ul/li[9]/span/span")).click();
        }

    @And("Uzaktan Kumandalı Arabalar münüsüne tıklar.")
    public void MenuSecimi() {


        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[4]/div/div/div/div/div/div/div/div[1]/div/ul/li[9]/div/div/div[1]/div[2]/ul/li/ul[3]/li/a[2]/span")).click();

            }

    @And("drone yedek parçalarından bir ürün seçer.")
    public void UrunSecimi() throws InterruptedException {

        driver.findElement(By.xpath("/html/body/div[3]/main/div[2]/div/div[7]/div/div[1]/div/div/div/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/div/div[10]")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//html/body/div[3]/main/div[2]/div/div[7]/div/div[2]/div/div[2]/div/div/div/div/div/div/div/ul/li[5]/div/a/div[2]/div[1]")).click();

        String originalHandle = driver.getWindowHandle();

        for (String handle1 : driver.getWindowHandles()) {
            driver.switchTo().window(handle1);

        }
    }

    @And("Ürünü sepete ekler.")
    public void SepeteEkleme() throws InterruptedException {

        Thread.sleep(6000);
        driver.findElement(By.id("addToCart")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[5]/div/div/div/div/div/div/div[1]/div/div[1]/div[2]/button[1]")).click();
        Thread.sleep(3000);


    }

    @Then("Ürünün sepete eklendiği görülür.")
    public void SepetKontrol() {

        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/section/section/ul/li[1]"));

        driver.quit();
    }


}