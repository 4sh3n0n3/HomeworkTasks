import java.util.*;

/**
 * Created by User on 23.03.2017.
 */
public class MySetOperations {
    public Collection intersection(Collection firColl, Collection secColl) {
        Collection returnCollection = new TreeSet();
        /*
        Когда делал ещё один вложенный итератор foreach,
        IntellIJ посоветовала подправить код.
        Нажал Alt + Enter и вылезло следующее:
         */
        for (Object x : firColl) {
            secColl.stream().filter(x::equals).forEach(returnCollection::add);
        }
        // Немного функциональщины, как итог...
        return returnCollection;
    }

    public Collection union(Collection firColl, Collection secColl) {
        Collection returnCollection = new TreeSet();
        firColl.stream().forEach(returnCollection::add);
        secColl.stream().forEach(returnCollection::add);
        // Так как метод add() у Set исключает дублирование элементов, опускаем проверку на дублирование
        return returnCollection;
    }

    public Collection subtraction(Collection firColl, Collection secColl) {
        Collection returnCollection = new TreeSet();
        for (Object x : firColl) {
            secColl.stream().filter(y -> !x.equals(y)).forEach(y -> {
                returnCollection.add(x);
            });
        }
        return returnCollection;
    }
}
