package lld.patterns.abstractfactory;

public class FurnitureFactory {
    public static MaterialFactory getMaterialFactory(String material){
        switch (material){
            case "Plastic":
                return new PlasticFactory();
            case "Wood":
                return new WoodFactory();
            default:
                return null;
        }
    }
}
