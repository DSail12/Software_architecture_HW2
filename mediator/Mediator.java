package mediator;
import java.util.ArrayList;
import java.util.List;
/** Паттерн Медиатор используется для обеспечения взаимодействия
 * множества объектов через централизованный объект-посредник (медиатор).
*/

// Интерфейс Медиатора
interface ChatMediator {
    void sendMessage(String message, User sender);
    void addUser(User user);
}
// Конкретный Медиатор
class ChatMediatorImpl implements ChatMediator {
    private List<User> users;
    public ChatMediatorImpl() {
        this.users = new ArrayList<>();
    }
    @Override
    public void sendMessage(String message, User sender) {
        for (User user : users) {
            if (user != sender) {
                user.receiveMessage(message);
            }
        }
    }
    @Override
    public void addUser(User user) {
        users.add(user);
    }
}
// Класс Пользователя
class User {
    private String name;
    private ChatMediator chatMediator;
    public User(String name, ChatMediator chatMediator) {
        this.name = name;
        this.chatMediator = chatMediator;
    }
    public void sendMessage(String message) {
        System.out.println(name + " отправил сообщение: " + message);
        chatMediator.sendMessage(message, this);
    }
    public void receiveMessage(String message) {
        System.out.println(name + " получил сообщение: " + message);
    }
}
// Пример использования паттерна Медиатор
public class Mediator {
    public static void main(String[] args) {
        ChatMediator chatMediator = new ChatMediatorImpl();

        User user1 = new User("User1", chatMediator);
        User user2 = new User("User2", chatMediator);
        User user3 = new User("User3", chatMediator);

        chatMediator.addUser(user1);
        chatMediator.addUser(user2);
        chatMediator.addUser(user3);

        user1.sendMessage("Привет, есть кто-нибудь?");
        user2.sendMessage("Привет, User1! Да, я здесь.");
        user3.sendMessage("Привет, обоим! Как дела?");
    }
}