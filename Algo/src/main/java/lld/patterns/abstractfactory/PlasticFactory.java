package lld.patterns.abstractfactory;

public class PlasticFactory extends MaterialFactory{
    @Override
    public Furniture getFurniture(String furnitureType) {
        if (furnitureType.equals("Chair")){
            return new PlasticChair();
        }
        return null;
    }
}
