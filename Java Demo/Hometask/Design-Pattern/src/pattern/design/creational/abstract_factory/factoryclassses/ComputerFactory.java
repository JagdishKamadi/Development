package pattern.design.creational.abstract_factory.factoryclassses;
import pattern.design.creational.abstract_factory.classes.Computer;

public class ComputerFactory {

    // so that we cannot make the object
    private ComputerFactory(){}
    public static Computer getComputer(AbstractComputerFactory abstractComputerFactory)
    {
        return abstractComputerFactory.createComputer();
    }
}
