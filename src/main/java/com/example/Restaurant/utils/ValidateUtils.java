package com.example.Restaurant.utils;

import com.example.Restaurant.Service.GenericService;
import com.example.Restaurant.domain.BaseEntity;
import com.example.Restaurant.exceptions.InvalidValueException;
import com.example.Restaurant.exceptions.NotEqualsException;
import com.example.Restaurant.exceptions.NotFoundException;
import javax.validation.constraints.NotNull;
import java.util.Collection;

public final class ValidateUtils {
    private static  final String VALID_STRING_REGEX = "[a-zA-Zà-ùÀ-Ù0-9s-]+[,._a-zA-Zà-ùÀ-Ù0-9\\s-]*";

    private ValidateUtils() {
    }

    public static void checkIsTrue(boolean bool, String message, String... msgArgs) {
        if (!bool) {
            throw new InvalidValueException(message, msgArgs);
        }
    }

    public static void checkBiggerThanZero(Long number, String message, String... msgArgs) {
        if (!isBiggerThanZero(number)) {
            throw new InvalidValueException(message, msgArgs);
        }
    }

    public static void checkBiggerThanZero(Integer number, String message, String... msgArgs) {
        Long lng = (number == null ? null : number.longValue());
        checkBiggerThanZero(lng, message, msgArgs);
    }

    public static void checkMustBeNullOrZero(Integer number, String message, String... msgArgs) {
        if (number != null && number > 0) {
            throw new InvalidValueException(message, msgArgs);
        }
    }

    public static void checkFound(Object obj, String message, String... msgArgs) {
        if (obj == null) {
            throw new NotFoundException(message, msgArgs);
        }
    }

    public static void checkNotNullOrEmpty(String str, String message, String... msgArgs) {
        checkNotNull(str, message, msgArgs);
        if (str.trim().isEmpty()) {
            throw new InvalidValueException(message, msgArgs);
        }
    }

    public static void checkNotNull(Object obj, String message, String... msgArgs) {
        if (obj == null) {
            throw new InvalidValueException(message, msgArgs);
        }
    }

    public static void checkEquals(Object obj1, Object obj2, String message, String... msgArgs) {

        final boolean isObjectsNotNull = !(obj1 == null && obj2 == null);

        final boolean hasNull = (obj1 == null || obj2 == null);

        if (isObjectsNotNull && (hasNull || !obj1.equals(obj2))) {
            throw new NotEqualsException(message, msgArgs);
        }
    }

    public static void checkNotEquals(@NotNull Object obj1, @NotNull Object obj2, String message, String... msgArgs) {
        if (obj1.equals(obj2)) {
            throw new InvalidValueException(message, msgArgs);
        }
    }

    public static void checkFound(Collection collection, String message, String... msgArgs) {
        if (collection == null || collection.isEmpty()) {
            throw new NotFoundException(message, msgArgs);
        }
    }

    public static <T extends Comparable<T>> void checkLessThan(T obj1, T obj2, String message, String... msgArgs) {
        if (obj1.compareTo(obj2) > 0) {
            throw new InvalidValueException(message, msgArgs);
        }
    }

    private static <T extends BaseEntity<Long>> void checkEntityWithId(T entity, String message, String... msgArgs) {
        checkIsTrue(entity != null && isBiggerThanZero(entity.getId()), message, msgArgs);
    }

    public static <T extends BaseEntity<Long>> void checkEntityExists(GenericService<T, Long> service, T entity, String message, String... msgArgs) {
        ValidateUtils.checkEntityWithId(entity, message, msgArgs);
        ValidateUtils.checkIsTrue(service.exists(entity.getId()), message, msgArgs);
    }

    private static boolean isBiggerThanZero(Long number) {
        return number != null && number > 0;
    }

    public static void checkId(Long id, String message, String... msgArgs) {
        ValidateUtils.checkIsTrue(isBiggerThanZero(id), message, msgArgs);
    }

    public static void checkStringBetween(String str, String msg, int min, int max, String... msgArgs) {
        if (str == null || str.length() < min || str.length() > max) {
            throw new InvalidValueException(msg, msgArgs);
        }

    }

    public static void checkStringMaxLength(String str, String msg, int max, String... msgArgs) {
        if (str != null && str.length() > max) {
            throw new InvalidValueException(msg, msgArgs);
        }
    }

    public static void checkStringValidCharacters(String str, String msg, String... msgArgs) {

        if(!str.matches(VALID_STRING_REGEX)){
            throw new InvalidValueException(msg, msgArgs);
        }
    }
}