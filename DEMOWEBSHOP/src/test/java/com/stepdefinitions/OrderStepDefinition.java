package com.stepdefinitions;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.io.File;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.actions.LoginAction;
import com.actions.OrderAction;
import com.utilities.HelperClass;

import io.cucumber.java.en.Given;

public class OrderStepDefinition {

	WebDriver driver;
	OrderAction order;
	LoginAction login;
	WebDriverWait wait;
	private static final Logger log = LogManager.getLogger(OrderStepDefinition.class);
	public OrderStepDefinition() {

		driver = HelperClass.getDriver();
		order = new OrderAction(driver);
		login = new LoginAction(driver);
	}

	@When("the user clicks the Orders link")
	public void the_user_clicks_the_orders_link() {
		log.info("User clicks Orders link");
		order.waitfororderlink();
		order.clickOrder();
	}

	@Then("the user should see the previously ordered details")
	public void the_user_should_see_the_previously_ordered_details() {
		log.info("Verifying previously ordered details");
		int orderCount = order.countoforders();
		log.info("Order count in order history: {}", orderCount);
	}

	@Given("the user is on the Demo Web Shop homepage")
	public void the_user_is_on_the_demo_web_shop_homepage() {
		driver = HelperClass.getDriver();
		driver.get("https://demowebshop.tricentis.com/");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@Then("the user should be redirected to the login page")
	public void the_user_should_be_redirected_to_the_login_page() {
		order.waitfororderlink();
		order.clickOrder();
		Assert.assertTrue(driver.getCurrentUrl().contains("login"));
		log.info("User successfully redirected to login page");
	}

	@When("the user clicks the Details button")
	public void the_user_clicks_the_details_button() {
		order.clickDetailsButton();
	}

	@Then("the user should see the ordered product information")
	public void the_user_should_see_the_ordered_product_information() {
		order.waitforpoductName();
		String orderProduct = order.getProductText();
		log.info("Ordered product name: {}", orderProduct);
		Assert.assertEquals(orderProduct, "Music 2");
	}

	@When("the user clicks the PDF Invoice button")
	public void the_user_clicks_the_pdf_invoice_button() {
		log.info("User clicks PDF Invoice button");
		order.clickPDF();
	}

	@Then("the invoice PDF should be downloaded successfully")
	public void the_invoice_pdf_should_be_downloaded_successfully() throws Exception  {
		log.info("Starting PDF download validation");
	    Runtime.getRuntime().exec("C:\\Users\\HARITHA\\OneDrive\\Desktop\\Download.exe");
	    Thread.sleep(5000);

	    String downloadPath = "C:\\Users\\Haritha\\Downloads\\";
	    File dir = new File(downloadPath);
	    File latestPDF = null;
	    long lastModified = 0;

	    for (File file : dir.listFiles()) {
	        if (file.getName().endsWith(".pdf")) {
	            if (file.lastModified() > lastModified) {
	                lastModified = file.lastModified();
	                latestPDF = file;
	            }
	        }
	    }
	    Assert.assertNotNull(latestPDF, "PDF not downloaded");
	    log.info("Downloaded PDF file: {}", latestPDF.getName());
	    PDDocument document = PDDocument.load(latestPDF);
	    PDFTextStripper stripper = new PDFTextStripper();
	    String pdfText = stripper.getText(document);
	    document.close();
	    log.info("PDF Content Retrieved Successfully");
	    System.out.println("PDF CONTENT: " + pdfText);
	    String orderProductName = order.getProductText();
	    Assert.assertTrue(pdfText.contains(orderProductName),"Product name not same in  Order page and PDF");
		
	}

	@When("the user clicks the Re-order button")
	public void the_user_clicks_the_re_order_button() {
		order.clickReorder();
	}

	@Then("the previously ordered products should be added to the cart")
	public void the_previously_ordered_products_should_be_added_to_the_cart() {
		String cartProduct =order.cartProductName();
		System.out.println("the cart product nam is: "+cartProduct);
	}
}
