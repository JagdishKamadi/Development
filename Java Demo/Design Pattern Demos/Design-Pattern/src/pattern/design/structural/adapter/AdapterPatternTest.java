package pattern.design.structural.adapter;

public class AdapterPatternTest {

    public static void main(String[] args) {
        ChromeDriver a = new ChromeDriver();
        a.getElement();
        a.selectElement();
        System.out.println();

        IEDriver e = new IEDriver();
        // pass the object of IEDriver
        WebDriver wID = new WebDriverAdapter(e);
        wID.getElement();
        wID.selectElement();

    }
}
