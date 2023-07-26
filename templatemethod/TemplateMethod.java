package templatemethod;
/** Паттерн Template Method определяет "шаблонный" алгоритм, где
 * определенные шаги оставлены абстрактными, чтобы их реализовали подклассы.
*/


// Абстрактный класс для приготовления напитков
abstract class BeverageMaker {
    // Шаблонный метод, определяющий последовательность приготовления напитка
    public final void prepareBeverage() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
        System.out.println("Напиток готов!");
    }
    abstract void brew();
    abstract void addCondiments();

    // Общие шаги, реализованные в базовом классе
    void boilWater() {
        System.out.println("Кипятим воду");
    }
    void pourInCup() {
        System.out.println("Переливаем в чашку");
    }
}
// Конкретные классы для различных типов напитков
class TeaMaker extends BeverageMaker {
    @Override
    void brew() {
        System.out.println("Завариваем чай");
    }

    @Override
    void addCondiments() {
        System.out.println("Добавляем лимон");
    }
}
class CoffeeMaker extends BeverageMaker {
    @Override
    void brew() {
        System.out.println("Варим кофе");
    }
    @Override
    void addCondiments() {
        System.out.println("Добавляем сахар и молоко");
    }
}
// Пример использования паттерна Template Method
public class TemplateMethod {
    public static void main(String[] args) {
        System.out.println("Приготовление чая:");
        BeverageMaker teaMaker = new TeaMaker();
        teaMaker.prepareBeverage();

        System.out.println("\nПриготовление кофе:");
        BeverageMaker coffeeMaker = new CoffeeMaker();
        coffeeMaker.prepareBeverage();
    }
}