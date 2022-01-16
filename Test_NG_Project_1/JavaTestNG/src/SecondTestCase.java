import org.testng.annotations.*;

public class SecondTestCase {

    @Test(priority = 7)
    void productName(){
        System.out.println("Finding product with name test");
    }

   @Test(priority = 8)
    void productPrice(){
        System.out.println("Checking product price test");
    }

    @Test (priority = 6)
    void searchProduct(){
        System.out.println("Searching the product");
    }

    @Test(priority = 9)
    void viewProduct(){
        System.out.println("Viewing the searched product");
    }

    @Test(priority = 10)
    void addToCart(){
        System.out.println("Item added to cart test");
    }

    @BeforeTest
    void setUp(){
        System.out.println("++Before++");
    }

    @AfterTest
    void cleanUp(){
        System.out.println("--After Method--");
    }
}
