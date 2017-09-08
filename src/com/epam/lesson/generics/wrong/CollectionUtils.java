package com.epam.lesson.generics.wrong;

import java.util.Collection;

public class CollectionUtils {
    public static <S extends Number, D extends Number> Collection<D>
                                            convert(Collection<S> source,
                                               Converter<S, D> converter)
    {
        return null;
    }

    public interface Converter<T, V> {
        V conver(T item);
    }

}
