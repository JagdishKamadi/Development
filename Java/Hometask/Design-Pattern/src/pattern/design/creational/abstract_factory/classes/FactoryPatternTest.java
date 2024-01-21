package pattern.design.creational.abstract_factory.classes;
import pattern.design.creational.abstract_factory.factoryclassses.*;

public class FactoryPatternTest {
    public static void main(String[] args) {
        Computer pc = ComputerFactory.getComputer(new PCFactory("4gb","1024gb","2.3gh"));
        System.out.println(pc);

        Computer server = ComputerFactory.getComputer(new PCFactory("64gb","1mgb","1mgh"));
        System.out.println(server);

        Computer laptop = ComputerFactory.getComputer(new PCFactory("8gb","102gb","2.4gh"));
        System.out.println(laptop);
    }

}
