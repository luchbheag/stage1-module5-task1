package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            for (String elem : x) {
                if (elem.charAt(0) < 'A' || elem.charAt(0) > 'Z') {
                    return false;
                }
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            int length = x.size();
            for (int i = 0; i < length; i++) {
                if (x.get(i) % 2 == 0) {
                    x.add(x.get(i));
                }
            }
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> result = new ArrayList<>();
            System.out.println(values);
            for (String elem : values) {
                long spaces = elem.chars().filter(c -> c == ' ').count();
                if (elem.charAt(0) >= 'A' && elem.charAt(0) <= 'Z'
                        && elem.endsWith(".") && spaces > 2) {
                    System.out.println(elem);
                    result.add(elem);
                }
            }
            return result;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> map = new HashMap<>();
            for (String elem : x) {
                map.put(elem, elem.length());
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (x, y) -> {
            List<Integer> result = new ArrayList<>(x);
            result.addAll(y);
            return result;
        };
    }
}
