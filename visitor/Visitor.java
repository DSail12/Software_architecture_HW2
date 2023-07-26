package visitor;
/**  Паттерн Visitor позволяет добавлять новые операции к объектам
 *  без изменения самих объектов. Он достигается путем добавления
 *  методов "посетителей" в иерархию классов.
*/

// Интерфейс посетителя для компонентов компьютера
interface ComputerPartVisitor {
    void visit(Keyboard keyboard);
    void visit(Monitor monitor);
    void visit(Mouse mouse);
}

// Конкретный посетитель для отображения информации о компонентах
class ComputerPartDisplayVisitor implements ComputerPartVisitor {
    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("Посещение клавиатуры.");
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("Посещение монитора.");
    }

    @Override
    public void visit(Mouse mouse) {
        System.out.println("Посещение мыши.");
    }
}

// Интерфейс компонентов компьютера
interface ComputerPart {
    void accept(ComputerPartVisitor visitor);
}

// Конкретный компонент - Клавиатура
class Keyboard implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor visitor) {
        visitor.visit(this);
    }
}

// Конкретный компонент - Монитор
class Monitor implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor visitor) {
        visitor.visit(this);
    }
}

// Конкретный компонент - Мышь
class Mouse implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor visitor) {
        visitor.visit(this);
    }
}

// Класс компьютера, использующий посетителя
class Computer implements ComputerPart {
    private ComputerPart[] parts;

    public Computer() {
        parts = new ComputerPart[] { new Keyboard(), new Monitor(), new Mouse() };
    }

    @Override
    public void accept(ComputerPartVisitor visitor) {
        for (ComputerPart part : parts) {
            part.accept(visitor);
        }
    }
}

// Пример использования паттерна Visitor
public class Visitor {
    public static void main(String[] args) {
        ComputerPart computer = new Computer();
        ComputerPartVisitor visitor = new ComputerPartDisplayVisitor();
        computer.accept(visitor);
    }
}