import java.util.EnumSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.stream.Collector.Characteristics.CONCURRENT;


/**
 * Here in this example we are going to convert the employees dataset to string
 * find the references using the below link
 * https://java8tips.readthedocs.io/en/stable/collectors.html#collectors
 */
public class ToXMLCollector implements Collector<Employee, StringBuffer, String> {
    private static final String XMLSTR = "\n<employee eid='%s'>" + "\n\t" +
            "<name>%s</name>\n\t" +
            "<tech>%s</tech>\n\t" +
            "<salary>%s</salary>\n" +
            "</employee>";

    @Override
    public Supplier<StringBuffer> supplier() {
        System.out.println("supplier ");
        return StringBuffer::new;
    }

    @Override
    public BiConsumer<StringBuffer, Employee> accumulator() {
        System.out.println("accumulator");
        return (sb, e) -> sb.append(String.format(XMLSTR, e.empId, e.name, e.technology, e.salary));
    }

    @Override
    public BinaryOperator<StringBuffer> combiner() {
        System.out.println("combiner");
        return (sb1, sb2) -> sb1.append(sb2.toString());
    }

    @Override
    public Function<StringBuffer, String> finisher() {
        System.out.println("finisher");
        return sb -> String.format("<employees> %s \n</employees>", sb.toString());
    }

    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("characteristics");
        return EnumSet.of(CONCURRENT);
    }
}
