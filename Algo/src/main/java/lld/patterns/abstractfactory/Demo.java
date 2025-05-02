package lld.patterns.abstractfactory;

public class Demo {
    public static void main(String[] args) {
        MaterialFactory materialFactory = FurnitureFactory.getMaterialFactory("Plastic");
        Furniture chair = materialFactory.getFurniture("Chair");
        System.out.println(chair);
    }
}
