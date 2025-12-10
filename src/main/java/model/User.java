package model;

public class User {
    private String email;
    private String password;
    private String name;

    public User() {
    }

    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public static User randomValidUser() {
        long now = System.currentTimeMillis();
        String email = "autotest" + now + "@yandex.ru";
        String password = "qwerty" + now; // >= 6 символов
        String name = "AutoUser" + now;
        return new User(email, password, name);
    }

    public static User randomWithShortPassword() {
        long now = System.currentTimeMillis();
        String email = "autotest_short" + now + "@yandex.ru";
        String password = "12345"; // меньше 6 символов
        String name = "ShortPwdUser" + now;
        return new User(email, password, name);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
