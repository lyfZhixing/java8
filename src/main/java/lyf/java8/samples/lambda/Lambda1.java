package lyf.java8.samples.lambda;

import java.util.*;

public class Lambda1 {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("pater", "name", "mike", "xenia");

        // 匿名类原始写法
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });

        /**
         * lambda
         * (Type a , Type b, ……) -> {
         *      statment1;
         *      statment2;
         *      ……
         *      return statmentX
         * }
         * 单参数，单语句时：
         *  a -> statment1
         */


        // 使用lambda简化后
        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });

        // 当只有一条语句时
        Collections .sort(names, (String a, String b) -> b.compareTo(a));

        // 省略Type
        Collections.sort(names, (a,b) -> b.compareTo(a));

        System.out.println(names);

        names.sort(Collections.reverseOrder());

        System.out.println(names);

        // 方法引用
        names.forEach(System.out :: println);

        List<String> names2 = Arrays.asList("peter", null, "anna", "mike", "xenia");
        names2.sort(Comparator.nullsLast(String::compareTo));
        System.out.println(names2);

        List<String> names3 = null;

        Optional.ofNullable(names3).ifPresent(list -> list.sort(Comparator.naturalOrder()));

        System.out.println(names3);
    }
}
