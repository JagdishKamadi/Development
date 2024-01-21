package collector;

import stream.Employee;

import java.util.EnumSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class ToXMLCollector implements Collector<Employee, StringBuffer, String> {


    final String xmlStr = "\n   <employee eid='%s'>\n\t"
            + "<name>%s</name>\n\t"
            + "<age>%s</age>\n </employee>";

    @Override
    public Supplier<StringBuffer> supplier() {
        return StringBuffer::new;
    }

    @Override
    public BiConsumer<StringBuffer, Employee> accumulator() {
        return (sb, e) -> sb.append(String.format(xmlStr, e.getId(), e.getName(), e.getAge()));
    }

    @Override
    public BinaryOperator<StringBuffer> combiner() {
        return (sb1, sb2) -> sb1.append(sb2.toString());
    }

    @Override
    public Function<StringBuffer, String> finisher() {
        return sb -> String.format("<employee>%s\n</employee>", sb.toString());
    }

    @Override
    public Set<Characteristics> characteristics() {
        return EnumSet.of(Characteristics.CONCURRENT);
    }
}
