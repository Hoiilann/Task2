
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class User {
    private final String firstName, lastName, country;
    private final int age;
    private final long id;

    public User(int age, String country, String firstName, String lastName, long id) {
        this.age = age;
        this.country = country;
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    public String getFirstName() {
        return firstName;
    }

    public long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }
    public static ArrayList<User> Initialization(){
        String firstName, lastName, country;
        int age, counter = 0;
        long id;
        Random rand = new Random();
        ArrayList<User> users = new ArrayList<>();
        String[] firstNames = {"Леонардо","Райан","Джонни","Киану","Роберт", "Генри", "Брэд","Кристиан"};
        String[] lastNames={"ДиКаприо","Гослинг","Депп","Ривз","Паттисон","Кавилл","Питт","Бэйл"};
        String[] countries = {"Россия","Япония","Мадагаскар","Северная Корея", "Гонконг","Китай","Уругвай"};
        firstName = firstNames[rand.nextInt(firstNames.length)];
        lastName = lastNames[rand.nextInt(lastNames.length)];
        country = countries[rand.nextInt(countries.length)];
        age = rand.nextInt(100)+1;
        id = rand.nextLong(999999);
        users.add(new User(age, country, firstName, lastName, id));
        while(users.size()<firstNames.length){
            firstName = firstNames[rand.nextInt(firstNames.length)];
            lastName = lastNames[rand.nextInt(lastNames.length)];
            country = countries[rand.nextInt(countries.length)];
            age = rand.nextInt(100)+1;
            id = rand.nextLong(999999);
            for (User user : users) {
                if (firstName.equals(user.getFirstName()) ||
                        lastName.equals(user.getLastName())) {
                    counter = 1;
                    break;
                }
            }
            if (counter==0){
                users.add(new User(age, country, firstName, lastName, id));
            }
            counter = 0;
        }
        return users;
    }
    public static void print(ArrayList<User> users){
        System.out.printf("%-10s%10s%10s%10s%15s%n","Фамилия","Имя","ID","Возраст","Страна");
        for (User user : users) {
            System.out.printf("%-10s%10s%10s%10s%15s%n", user.getLastName(),
                    user.getFirstName(), user.getId(),
                    user.getAge(), user.getCountry());
        }
    }
    public static ArrayList<User> sortLastNames(ArrayList<User> users) {
        String[] lastNames = new String[users.size()];
        for (int i = 0;i<users.size();i++) {
            lastNames[i]=users.get(i).getLastName();
        }
        Arrays.sort(lastNames);
        ArrayList<User> users1 = new ArrayList<>();
        for (int i = 0;i< lastNames.length;i++) {
            for (int j = 0; j < lastNames.length; j++) {
                if (lastNames[i].equals(users.get(j).getLastName())) {
                    users1.add(users.get(j));
                    break;
                }
            }
        }
        return users1;
    }
    public static ArrayList<User> sortAge(ArrayList<User> users) {
        int[] ages = new int[users.size()];
        for (int i = 0;i<users.size();i++) {
            ages[i]=users.get(i).getAge();
        }
        Arrays.sort(ages);
        ArrayList<User> users1 = new ArrayList<>();
        for (int i = 0;i< ages.length;i++) {
            for (int j = 0; j < ages.length; j++) {
                if (ages[i]==users.get(j).getAge()) {
                    users1.add(users.get(j));
                    break;
                }
            }
        }
        return users1;
    }
    public static boolean isAgeGreaterThan7 (ArrayList<User> users) {
        for (int i = 0;i<users.size();i++) {
            if (users.get(i).getAge()<7){
                return false;
            }
        }
        return true;
    }
    public static double averageAgeOfUsers (ArrayList<User> users) {
        int sum = 0;
        for (int i = 0;i<users.size();i++) {
            sum+=users.get(i).getAge();
        }
        return (double) sum /users.size();
    }
    public static int numberOfCountries (ArrayList<User> users) {
        int number = 0;
        for (int i = 0;i<users.size();i++){
            if (i==0) {
                number++;
            }
            if (i>0){
                for (int j = 0;j<i; j++){
                    if (users.get(i).getCountry().equals(users.get(j).getCountry())){
                        number--;
                        break;
                    }
                }
                number++;
            }
        }
        return number;
    }


}
