package lyf.java8.samples.lambda;

public class Lambda2 {

    /**
     * 函数式接口，接口中只能有一个抽象方法
     * @param <F>
     * @param <T>
     */
    @FunctionalInterface
    public static interface Converter<F, T> {
        T converter(F from);
    }

    static class Something {
        String startsWith(String s) {
            return String.valueOf(s.charAt(0));
        }
    }

    interface PersonFactory<P extends Person> {
        P create(String firstName, String lastName);
    }

    public static void main(String[] args) {

        // lambda
        Converter<String, Integer> integerConverter1 = from -> Integer.valueOf(from);
        Integer converted1 = integerConverter1.converter("123");
        System.out.println(converted1);

        // method reference 方法引用
        Converter<String, Integer> integerConverter2 = Integer::valueOf;
        Integer converted2 = integerConverter2.converter("231");
        System.out.println(converted2);

        Something something = new Something();
        Converter<String, String> stringStringConverter = something::startsWith;
        String str = stringStringConverter.converter("Java");
        System.out.println(str);

        // constructor reference
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("li", "jack");
        System.out.println(person.firstName+":"+person.lastName);

    }

}
