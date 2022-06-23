package stepDefinitions;

import framework.Cart;
import framework.Product;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utils.TestBase;

import java.net.MalformedURLException;

public class CartStepDefinitions extends TestBase {
    Product product;
    Cart cart;
    String firstItemPrice;

    @Given("I lands on home page")
    public void i_lands_on_home_page() throws MalformedURLException {
        setUp();
    }

    @When("I add first item on landing page")
    public void i_add_first_item_on_landing_page() {
        firstItemPrice = homePage.getFirstItemPrice();
        product = homePage.clickFirstItem();
        cart = product.clickAddBtn();
    }
    @Then("I should see it in the cart")
    public void i_should_see_it_in_the_cart() {
        Assert.assertTrue(!cart.getFirstItemInCart().isEmpty());
    }
    @Then("I should see price in my cart which matches on the item")
    public void i_should_see_price_in_my_cart_which_matches_on_the_item() {
        Assert.assertEquals(firstItemPrice.substring(1),cart.getTotal());
    }

    @When("I add multiple items on landing page")
    public void i_add_multiple_items_on_landing_page() {
        cart = homePage.addMultipleItems();
    }
    @Then("I should see them in the cart")
    public void i_should_see_them_in_the_cart() {
        int expectedNumberOfItems = 3;
        Assert.assertEquals(cart.getTotalNumberOfItem(),expectedNumberOfItems);
    }
    @Then("I should see the total price calculated right")
    public void i_should_see_the_total_price_calculated_right() {
        System.out.println("get cart total= "+ cart.getTotal());
        Assert.assertEquals(cart.getTotal(),cart.getTotalOfList());
    }

    @When("I click delete link")
    public void i_click_delete_link() {
        cart.deleteItem();
    }
    @Then("Item should be deleted")
    public void item_should_be_deleted() {
        int expectedNumberOfItem = 0;
        Assert.assertEquals(expectedNumberOfItem,cart.getTotalNumberOfItem());
    }

    @When("I refresh the page")
    public void i_refresh_the_page() {
        cart.refreshCartPage();
    }

    @Then("close browser")
    public void close_browser() {
        tearDown();
    }

    @Then("I click place order btn")
    public void i_click_place_order_btn() {
        cart.clickPlaceOrder();
    }
    @When("I filled the purchase with name= {string}, country= {string}, city= {string}, credit cart= {string} month= {string}, year= {string}")
    public void i_filled_the_purchase_with_name_country_city_credit_cart_month_year(String name, String country, String city, String card, String month, String year) {
        cart.fillPurchaseForm(name,country,city,card, month, year);
    }

    @When("I get success message with {string}")
    public void i_get_success_message_with(String expectedResult) {
        Assert.assertEquals(cart.successMsg(),expectedResult);
    }

    @When("I click cart")
    public void i_click_cart() {
        cart = homePage.clickCart();
    }
    @When("I click {string}")
    public void i_click(String btn) {
        if (btn.equals("Place Order Button")){
            cart.clickPlaceOrderBtn();
        }
    }
    @Then("It should get an error message")
    public void it_should_get_an_error_message() {
        Assert.assertFalse(cart.errorMessage());
    }
}
