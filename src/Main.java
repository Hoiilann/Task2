import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        ArrayList<User> users = User.Initialization();
        users = User.sortLastNames(users);
        System.out.println("\n" +
                "Отсортированы по алфавиту:");
        User.print(users);
        users = User.sortAge(users);
        System.out.println("\n" +
                "Отсортированы по возрасту:");
        User.print(users);
        System.out.println("\n" +
                "Все пользователи старше 7 лет? - "+ User.isAgeGreaterThan7(users));
        System.out.println("\n" +
                "Cредний возраст пользователя - "+ User.averageAgeOfUsers(users));
        System.out.println("\n" +
                "Количество стран, в которых проживают пользователи - "+ User.numberOfCountries(users));

    }
}