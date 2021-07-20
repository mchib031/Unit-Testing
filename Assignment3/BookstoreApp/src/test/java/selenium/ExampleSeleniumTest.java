package selenium;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import java.lang.Math;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.Select;

class ExampleSeleniumTest {

  static Process server;
  private WebDriver driver;

  @BeforeAll
  public static void setUpBeforeClass() throws Exception {
    ProcessBuilder pb = new ProcessBuilder("java", "-jar", "bookstore5.jar");
    server = pb.start();
  }

  @BeforeEach
  void setUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("http://localhost:8080/");
    // wait to make sure Selenium is done loading the page
    WebDriverWait wait = new WebDriverWait(driver, 60);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));
  }

  @AfterEach
  public void tearDown() {
    driver.close();
  }

  @AfterAll
  public static void tearDownAfterClass() throws Exception {
    server.destroy();
  }

  @Test
  void test1() {
    WebElement element = driver.findElement(By.id("title"));
    String expected = "YAMAZONE BookStore";
    String actual = element.getText();
    assertEquals(expected, actual);
  }

  @Test
  public void test2() {
    WebElement welcome = driver.findElement(By.cssSelector("p"));
    String expected = "Welcome";
    String actual = welcome.getText();
    assertEquals(expected, getWords(actual)[0]);
    WebElement langSelector = driver.findElement(By.id("locales"));
    langSelector.click();
    WebElement frSelector = driver.findElement(By.cssSelector("option:nth-child(3)"));
    frSelector.click();
    welcome = driver.findElement(By.cssSelector("p"));
    expected = "Bienvenu";
    actual = welcome.getText();
    assertEquals(expected, getWords(actual)[0]);
  }

  private String[] getWords(String s) {
    return s.split("\\s+");
  }
 private void loginAsAdmin() {

    driver.get("http://localhost:8080/admin");
    if (driver.getCurrentUrl().equals("http://localhost:8080/login")){
      WebElement usern = driver.findElement(By.id("loginId"));
      usern.sendKeys("admin");
      WebElement pass = driver.findElement(By.id("loginPasswd"));
      pass.sendKeys("password");
      WebElement login = driver.findElement(By.id("loginBtn"));
      login.click();
    }
    else
    {
      System.out.println("Logged in");
    }
  }

  public void AddBook(){
    loginAsAdmin();
    WebElement cat = driver.findElement(By.id("addBook-category"));
    cat.sendKeys("Fiction");
    WebElement id = driver.findElement(By.id("addBook-id"));
    id.sendKeys("ID1111");
    WebElement title = driver.findElement(By.id("addBook-title"));
    title.sendKeys("Titre");
    WebElement author = driver.findElement(By.id("addBook-authors"));
    author.sendKeys("Auteur");
    WebElement dscp = driver.findElement(By.id("longDescription"));
    dscp.sendKeys("Ceci est une description du livre.");
    WebElement cost = driver.findElement(By.id("cost"));
    cost.sendKeys("100");
    WebElement addBt = driver.findElement(By.name("addBook"));
    addBt.click();
  }
public void DelBook(){
    loginAsAdmin();
    driver.get("http://localhost:8080/admin/catalog");
    WebElement delBt = driver.findElement(By.id("del-ID1111"));
    delBt.click();
  }

  public void AllerPanier(){
    driver.get("http://localhost:8080");
    WebElement search = driver.findElement(By.id("search"));
    search.sendKeys("Fiction");
    WebElement searchBt = driver.findElement(By.id("searchBtn"));
    searchBt.click();
    WebElement addCartBt = driver.findElement(By.id("order-ID1111"));
    addCartBt.click();
    WebElement cartBt = driver.findElement(By.id("cartLink"));
    cartBt.click();
  }

  // Cas de test positif pour F1
  @Test
  public void F1_positive() {
    loginAsAdmin();
    AddBook();
    WebElement feedback = driver.findElement(By.id("feedback"));
    String actualMessage = feedback.getText();
    String expectedMessage = "Successfully added book";
    assertEquals(expectedMessage, actualMessage);
    WebElement search = driver.findElement(By.id("search"));
    search.sendKeys("Fiction");
    WebElement searchBtn = driver.findElement(By.id("searchBtn"));
    searchBtn.click();
    DelBook();
  }
  // Cas de test Négatif pour F1
  @Test
  public void F1_negative() {
    loginAsAdmin();
    WebElement title = driver.findElement(By.id("addBook-title"));
    title.sendKeys("Titre");
    WebElement addBt = driver.findElement(By.name("addBook"));
    addBt.click();
    WebElement feedback = driver.findElement(By.cssSelector("h2"));
    String actualMessage = feedback.getText();
    String expectedMessage = "Validation errors";
    assertEquals(expectedMessage, actualMessage);
  }
  // Cas de test positif pour F2.1
  @Test
  public void F2point1Positive() {
    loginAsAdmin();
    AddBook();
    WebElement search = driver.findElement(By.id("search"));
    search.sendKeys("Fiction");
    WebElement searchBtn = driver.findElement(By.id("searchBtn"));
    searchBtn.click();
    WebElement feedback = driver.findElement(By.cssSelector("h1"));
    String actualMessage = feedback.getText();
    String expectedMessage = "We currently have the following items in category 'Fiction'";
    assertEquals(expectedMessage, actualMessage);
    DelBook();
  }
// Cas de test Négatif pour F2.1
  @Test
  public void F2point1Negative() {
    loginAsAdmin();
    WebElement search = driver.findElement(By.id("search"));
    search.sendKeys("Blob");
    WebElement searchBtn = driver.findElement(By.id("searchBtn"));
    searchBtn.click();
    WebElement feedback = driver.findElement(By.cssSelector("h1"));
    String actualMessage = feedback.getText();
    String expectedMessage = "Sorry we do not have any item matching category 'Blob' at this moment";
    assertEquals(expectedMessage, actualMessage);
  }

  // Cas de test positive pour F2.2
  @Test
  public void F2point2Positive() {
    AddBook();
    driver.get("http://localhost:8080");
    WebElement searchBt = driver.findElement(By.id("searchBtn"));
    searchBt.click();
    String expected = "We currently have the following items in category";
    String actual = driver.findElement(By.tagName("h1")).getText();
    System.out.println("Tous les livres: " + actual);
    boolean bool = actual.contains(expected);
    DelBook();
    assertTrue(bool);

  }

  // Cas de test Négatif pour F2.2
  @Test
  public void F2point2Negative() {
    WebElement search = driver.findElement(By.id("search"));
    WebElement searchBtn = driver.findElement(By.id("searchBtn"));
    searchBtn.click();
    List<WebElement> rows = driver.findElements(By.xpath("//div[@class='content']/table/tbody/tr"));
    int actualNmbOfBooks = rows.size();
    int expectedNmbOfBooks = 5;
    assertFalse(actualNmbOfBooks < expectedNmbOfBooks);
  }


  // Cas de test positive pour F3
  @Test
  public void addBookPositive() {
    AddBook();
    AllerPanier();
    String expected = "1";
    String actual = driver.findElement(By.id("ID1111")).getAttribute("value");
    System.out.println("Panier: " + actual);
    DelBook();
    assertEquals(expected, actual);
  }

 // F3 négative pas implémenté comme nous avons pas accès à la base de données pour savoir la quantité disponible.

  // Cas de test positive pour F4/F4.1
  @Test
  public void checkBookPositive() {
    AddBook();
    driver.get("http://localhost:8080/orderPage");
    boolean isEmpty = false;
    try{
      WebElement box = driver.findElement(By.id("ID1111"));
    }
    catch (Exception e)
    {
      System.out.println(" Empty");
      isEmpty = true;
    }
    boolean bool = isEmpty;
    DelBook();
    assertTrue(bool);
  }

  // Cas de test negative pour F4/F4.1
  @Test
  public void checkBookNegative() {
    AddBook();
    driver.get("http://localhost:8080/orderPage");
    boolean isEmpty = false;
    try{
      WebElement box = driver.findElement(By.id("ID1111"));
    }
    catch (Exception e){
      System.out.println("Empty");
      isEmpty = true;
    }
    boolean value = isEmpty;
    DelBook();
    assertTrue(value);
  }

  // Cas de test positive pour F5/F5.1
  @Test
  public void updateBookPositive() {
    WebElement searchBtn = driver.findElement(By.id("searchBtn"));
    searchBtn.click();
    WebElement addToCartBtn = driver.findElement(By.id("order-hall001"));
    addToCartBtn.click();
    WebElement goToCartBtn = driver.findElement(By.id("cartLink"));
    goToCartBtn.click();
    WebElement bookAdded = driver.findElement(By.id("hall001"));
    bookAdded.clear();
    bookAdded.sendKeys("0");
    WebElement updateBtn = driver.findElement(By.className("updatebt"));
    updateBtn.click();
    WebElement newTotalCost = driver.findElement(By.id("tothall001"));
    String actualNewTotalCost = newTotalCost.getText();
    String expectedNewTotalCost = "$0.00";
    assertEquals(expectedNewTotalCost, actualNewTotalCost);

  }

  // Cas de test negative pour F5/F5.1
  @Test
  public void updateBookNegative() {
    WebElement searchBtn = driver.findElement(By.id("searchBtn"));
    searchBtn.click();
    WebElement addToCartBtn = driver.findElement(By.id("order-hall001"));
    addToCartBtn.click();
    WebElement goToCartBtn = driver.findElement(By.id("cartLink"));
    goToCartBtn.click();
    WebElement bookAdded = driver.findElement(By.id("hall001"));
    bookAdded.clear();
    bookAdded.sendKeys("1.5");
    WebElement updateBtn = driver.findElement(By.className("updatebt"));
    updateBtn.click();
    WebElement newTotalCost = driver.findElement(By.id("tothall001"));
    String actualNewTotalCost = newTotalCost.getText();
    String expectedNewTotalCost = "$39.95";
    assertEquals(expectedNewTotalCost, actualNewTotalCost);
  }

  // Cas de test positive pour F6/F6.1/F6.2
  @Test
  public void checkoutPositive(){
    AddBook();
    AllerPanier();
    WebElement checkoutBt = driver.findElement(By.name("checkout"));
    checkoutBt.click();
    String expectedTotal = "$128.00";
    String expectedTax = "$13.00";
    String expectedShip = "$15.00";
    String actualTotal = driver.findElement(By.id("order_total")).getText();
    String actualTax = driver.findElement(By.id("order_taxes")).getText();
    String actualShip = driver.findElement(By.id("order_shipping")).getText();
    System.out.println("Prix: " + actualTotal + " " + actualTax + " " + actualShip);
    DelBook();
    assertEquals(expectedTotal, actualTotal);
    assertEquals(expectedTax, actualTax);
    assertEquals(expectedShip, actualShip);

  
  }
  // Cas de test negative pour F6/F6.1/F6.2
  @Test
  public void checkoutNegative() {
    AddBook();
    driver.get("http://localhost:8080/orderPage");
    WebElement checkoutBt = driver.findElement(By.name("checkout"));
    checkoutBt.click();
    String expectedTotal = "$0.00";
    String expectedTax = "$0.00";
    String expectedShip = "$0.00";
    String actualTotal = driver.findElement(By.id("order_total")).getText();
    String actualTax = driver.findElement(By.id("order_taxes")).getText();
    String actualShip = driver.findElement(By.id("order_shipping")).getText();
    System.out.println("Prix: " + actualTotal + " " + actualTax + " " + actualShip);
    DelBook();
    assertEquals(expectedTotal, actualTotal);
    assertEquals(expectedTax, actualTax);
    assertEquals(expectedShip, actualShip);
  }
//Cas de test positive pour F7
  @Test
  public void RemoveBook() throws InterruptedException{
    AddBook();
    TimeUnit.SECONDS.sleep(1);
    DelBook();
    List<WebElement> tdList = driver.findElements(By.tagName("td"));
    boolean bool = true;
    for (int i = 0; i < tdList.size(); i++)
    {
      List<WebElement> list = driver.findElements(By.tagName("td"));
      if (list.size() > tdList.size() && i > tdList.size()){
        i = tdList.size();
      }try{
        if (list.get(i).getAttribute("id").contains("ID1111")){
          bool = false;
          break;
        }
      }
      catch (Exception e)
      {
      }
    }
    assertTrue(bool);
  }

  // Cas de test negative pour F7 ne peut pas etre implemente car le catalogue est vide, 
  // alors rien qui peut etre enleve.

  // Cas de test positive pour F8 
  @Test
  public void Authentification(){
    String expected = "http://localhost:8080/login";
    String actual = "";
    driver.get("http://localhost:8080");
    driver.get("http://localhost:8080/admin");
    actual = driver.getCurrentUrl();
    boolean add = expected.equals(actual);
    driver.get("http://localhost:8080/admin/catalog");
    actual = driver.getCurrentUrl();
    boolean remove = expected.equals(actual);
    boolean res = add && remove;
    assertTrue(res);
  }

@Test
  public void testcase1(){
    loginAsAdmin();
    String expected = "http://localhost:8080/admin";
    String actual = driver.getCurrentUrl();
    assertEquals(expected, actual);
  }

  @Test
  public void testcase1point2(){
    driver.get("http://localhost:8080/admin");
    WebElement username = driver.findElement(By.id("loginId"));
    username.sendKeys("admin");
    WebElement pwd = driver.findElement(By.id("loginPasswd"));
    pwd.sendKeys("wrongpwd");
    WebElement loginBt = driver.findElement(By.id("loginBtn"));
    loginBt.click();
    String expected1 = "http://localhost:8080/login?error";
    String actual1 = driver.getCurrentUrl();
    System.out.println( actual1);
    username = driver.findElement(By.id("loginId"));
    username.sendKeys("admin");
    pwd = driver.findElement(By.id("loginPasswd"));
    pwd.sendKeys("password");
    loginBt = driver.findElement(By.id("loginBtn"));
    loginBt.click();
    String expected2 = "http://localhost:8080/admin";
    String actual2 = driver.getCurrentUrl();
    System.out.println(actual2);
    assertEquals(expected1, actual1);
    assertEquals(expected2, actual2);
  }

  @Test
  public void testcase2(){
    loginAsAdmin();
    WebElement signoutBt = (WebElement) driver.findElement(By.xpath("//*[@value='Sign out']"));
    signoutBt.click();
    String expected = "http://localhost:8080/login?logout";
    String actual = driver.getCurrentUrl();
    System.out.println( actual);
    assertEquals(expected, actual);
  }


  @Test
  public void testcase3(){
    AddBook();
    String expectedFB = "Successfully";
    String actualFB = driver.findElement(By.id("feedback")).getText();
    System.out.println( actualFB);
    boolean bool = actualFB.contains(expectedFB);
    DelBook();
    assertTrue(bool);
  }

  
  @Test
  public void testcase3et2(){
    loginAsAdmin();
    WebElement cat = driver.findElement(By.id("addBook-category"));
    cat.sendKeys("CAT2");
    WebElement id = driver.findElement(By.id("addBook-id"));
    id.sendKeys("ID2222");
    WebElement title = driver.findElement(By.id("addBook-title"));
    title.sendKeys("TITLE2");
    WebElement author = driver.findElement(By.id("addBook-authors"));
    author.sendKeys("AUTHOR2");
    WebElement dscp = driver.findElement(By.id("longDescription"));
    dscp.sendKeys("Ceci est une description");
    WebElement cost = driver.findElement(By.id("cost"));
    cost.sendKeys("cost");
    WebElement addBt = driver.findElement(By.name("addBook"));
    addBt.click();
    String expectedFB = "errors";
    String actualFB = driver.findElement(By.id("feedback")).getText();
    System.out.println(actualFB);
    assertTrue(actualFB.contains(expectedFB));
  }

  @Test
  public void testcase3et3(){
    loginAsAdmin();
    WebElement cat = driver.findElement(By.id("addBook-category"));
    cat.sendKeys("CAT2");
    WebElement id = driver.findElement(By.id("addBook-id"));
    id.sendKeys("ID2222");
    WebElement title = driver.findElement(By.id("addBook-title"));
    title.sendKeys("TITLE2");
    WebElement author = driver.findElement(By.id("addBook-authors"));
    author.sendKeys("AUTHOR2");
    WebElement dscp = driver.findElement(By.id("longDescription"));
    dscp.sendKeys("Ceci est une description");
    WebElement cost = driver.findElement(By.id("cost"));
    cost.sendKeys("");
    WebElement addBt = driver.findElement(By.name("addBook"));
    addBt.click();
    String expectedFB = "errors";
    String actualFB = driver.findElement(By.id("feedback")).getText();
    System.out.println( actualFB);
    assertTrue(actualFB.contains(expectedFB));
  }

  @Test
  public void testcase4point1(){
    AddBook();
    WebElement search = driver.findElement(By.id("search"));
    search.sendKeys("Fiction");
    WebElement searchBt = driver.findElement(By.id("searchBtn"));
    searchBt.click();
    String expected = "We currently have the following items in category";
    String actual = driver.findElement(By.tagName("h1")).getText();
    System.out.println( actual);
    boolean bool = actual.contains(expected);
    DelBook();
    assertTrue(bool);
  }

  @Test
  public void testcase4et2(){
    AddBook();
    WebElement searchBt = driver.findElement(By.id("searchBtn"));
    searchBt.click();
    String expected = "We currently have the following items in category";
    String actual = driver.findElement(By.tagName("h1")).getText();
    System.out.println( actual);
    boolean bool = actual.contains(expected);
    DelBook();
    assertTrue(bool);
  }


  @Test
  public void testcase4et3(){
    loginAsAdmin();
    WebElement search = driver.findElement(By.id("search"));
    search.sendKeys("CAT");
    WebElement searchBt = driver.findElement(By.id("searchBtn"));
    searchBt.click();
    String expected = "Sorry";
    String actual = driver.findElement(By.tagName("h1")).getText();
    System.out.println( actual);
    assertTrue(actual.contains(expected));
  }

  @Test
  public void testcase5() throws InterruptedException{
    AddBook();
    TimeUnit.SECONDS.sleep(1);
    DelBook();
    List<WebElement> tdList = driver.findElements(By.tagName("td"));
    boolean bool = true;
    for (int i = 0; i < tdList.size(); i++){
      List<WebElement> list = driver.findElements(By.tagName("td"));
      if (list.size() > tdList.size() && i > tdList.size())
      {
        i = tdList.size();
      }
      try{
        if (list.get(i).getAttribute("id").contains("ID1111")){
          bool = false;
          break;
        }
      }
      catch (Exception e){
      }
    }
    assertTrue(bool);
  }

  @Test
  public void testcase6(){
    AddBook();
    AllerPanier();
    String expected = "1";
    String actual = driver.findElement(By.id("ID1111")).getAttribute("value");
    System.out.println( actual);
    DelBook();
    assertEquals(expected, actual);
  }

  @Test
  public void testcase7(){
    AddBook();
    driver.get("http://localhost:8080");
    driver.get("http://localhost:8080/orderPage");
    boolean isEmpty = false;
    try{
      WebElement box = driver.findElement(By.id("ID1111"));
    }
    catch (Exception e){
      System.out.println("panier vide");
      isEmpty = true;
    }
    boolean bool = isEmpty;
    DelBook();
    assertTrue(bool);
  }

  @Test
  public void testcase8et1(){
    AddBook();
    AllerPanier();
    WebElement inputBox = driver.findElement(By.id("ID1111"));
    inputBox.clear();
    inputBox.sendKeys("2");
    WebElement updateBt = driver.findElement(By.name("updateOrder"));
    updateBt.click();
    WebElement searchBt = driver.findElement(By.id("searchBtn"));
    searchBt.click();
    WebElement cartBt = driver.findElement(By.id("cartLink"));
    cartBt.click();
    String expected = "2";
    String actual = driver.findElement(By.id("ID1111")).getAttribute("value");
    System.out.println( actual);
    DelBook();
    assertEquals(expected, actual);
  }

  @Test
  public void testcase8et2(){
    AddBook();
    AllerPanier();
    WebElement inputBox = driver.findElement(By.id("ID1111"));
    inputBox.clear();
    inputBox.sendKeys("0");
    WebElement updateBt = driver.findElement(By.name("updateOrder"));
    updateBt.click();
    WebElement searchBt = driver.findElement(By.id("searchBtn"));
    searchBt.click();
    WebElement cartBt = driver.findElement(By.id("cartLink"));
    cartBt.click();
    boolean isEmpty = false;
    try{
      WebElement box = driver.findElement(By.id("ID1111"));
    }
    catch (Exception e){
      System.out.println("panier vide");
      isEmpty = true;
    }
    boolean bool = isEmpty;
    DelBook();
    assertTrue(bool);
  }

  @Test
  public void testcase9(){
    AddBook();

    AllerPanier();
    WebElement checkoutBt = driver.findElement(By.name("checkout"));
    checkoutBt.click();
    String expectedTotal = "$128.00";
    String expectedTax = "$13.00";
    String expectedShip = "$15.00";
    String actualTotal = driver.findElement(By.id("order_total")).getText();
    String actualTax = driver.findElement(By.id("order_taxes")).getText();
    String actualShip = driver.findElement(By.id("order_shipping")).getText();
    System.out.println(" " + actualTotal + " " + actualTax + " " + actualShip);
    DelBook();
    assertEquals(expectedTotal, actualTotal);
    assertEquals(expectedTax, actualTax);
    assertEquals(expectedShip, actualShip);
  }


  @Test
  public void testcase10(){
    loginAsAdmin();
    WebElement selectBar = driver.findElement(By.id("locales"));
    Select sel = new Select(selectBar);
    sel.selectByValue("fr-CA");
    String expectedUrl = "http://localhost:8080/admin?lang=fr-CA";
    String expectedTitle = "Librairie Y'AMAZONE";
    String actualUrl = driver.getCurrentUrl();
    String actualTitle = driver.findElement(By.id("title")).getText();
    System.out.println( actualUrl);
    System.out.println( actualTitle);
    assertEquals(expectedUrl, actualUrl);
    assertEquals(expectedTitle, actualTitle);
  }

}
