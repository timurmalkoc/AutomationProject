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
    @Given("I lands on first page")
    public void i_lands_on_first_page() throws MalformedURLException {
        setUp();
    }
    @When("I add first item on landing page")
    public void i_add_first_item_on_landing_page() throws InterruptedException {
        firstItemPrice = homePage.getFirstItemPrice();
        product = homePage.clickFirstItem();
        Thread.sleep(500);
        cart = product.clickAddBtn();
    }
    @Then("I should see it in the cart")
    public void i_should_see_it_in_the_cart() {
        Assert.assertTrue(!cart.getFirstItemInCart().isEmpty());
    }
    @Then("I should see price in my cart which matches on the item")
    public void i_should_see_price_in_my_cart_which_matches_on_the_item() {
        Assert.assertEquals(firstItemPrice.substring(1),cart.getTotal());
        tearDown();
    }

    @Given("I lands on home page")
    public void i_lands_on_home_page() throws MalformedURLException {
        setUp();
    }
    @When("I add multiple items on landing page")
    public void i_add_multiple_items_on_landing_page() throws InterruptedException {
        cart = homePage.addMultipleItems();
        Thread.sleep(500);
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
        tearDown();
    }

    @When("I click delete link")
    public void i_click_delete_link() {
        cart.deleteItem();
    }
    @Then("Item should be deleted")
    public void item_should_be_deleted() throws InterruptedException {
        Thread.sleep(500);
        int expectedNumberOfItem = 1;
        Assert.assertEquals(expectedNumberOfItem,cart.getTotalNumberOfItem());
        tearDown();
    }

}
