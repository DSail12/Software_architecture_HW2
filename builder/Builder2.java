package builder;

// Класс продукта, который мы будем строить
class Product {
    private String partA;
    private String partB;
    private String partC;

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public void setPartC(String partC) {
        this.partC = partC;
    }

    public void display() {
        System.out.println("PartA: " + partA);
        System.out.println("PartB: " + partB);
        System.out.println("PartC: " + partC);
    }
}

// Интерфейс для Строителя
interface Builder {
    void buildPartA();
    void buildPartB();
    void buildPartC();
    Product getResult();
}

// Конкретный класс Строителя
class ConcreteBuilder implements Builder {
    private Product product;

    public ConcreteBuilder() {
        this.product = new Product();
    }

    public void buildPartA() {
        product.setPartA("PartA of the product");
    }

    public void buildPartB() {
        product.setPartB("PartB of the product");
    }

    public void buildPartC() {
        product.setPartC("PartC of the product");
    }

    public Product getResult() {
        return product;
    }
}

// Директор, который управляет Строителем
class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct() {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
    }
}

// Клиентский код
public class Builder2 {
    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        director.construct();

        Product product = builder.getResult();
        product.display();
    }
}