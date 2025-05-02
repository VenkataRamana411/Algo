package lld.patterns.abstractfactory;

public class WoodFactory extends MaterialFactory{
    @Override
    public Furniture getFurniture(String furnitureType) {
        if (furnitureType.equals("Chair")){
            return new WoodenChair();
        }
        return null;
    }
}
