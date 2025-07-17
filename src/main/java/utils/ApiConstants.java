package utils;

public class ApiConstants {
    private ApiConstants() {} // Запрещаем создание экземпляров

    public static final class Patterns {
        public static final String JWT = "^[A-Za-z0-9-_=]+\\.[A-Za-z0-9-_=]+\\.?[A-Za-z0-9-_.+/=]*$";

        private Patterns() {} // Также запрещаем инстанцирование
    }

    public static final class Auth {
        public static final String BEARER_TYPE = "Bearer";
        public static final String ROLE_USER = "ROLE_USER";
    }
}