import Application.Adapters.RGBtoHSLSmartLightBulbAdapter;
import Domain.Classes.HSLSmartLightBulb;
import Domain.Interfaces.IHSLSmartLightBulb;
import Domain.Interfaces.IRGBSmartLightBulb;

public class Main {
    public static void main(String[] args) {
        IHSLSmartLightBulb bulb = new HSLSmartLightBulb();
        IRGBSmartLightBulb bulb_ = new RGBtoHSLSmartLightBulbAdapter(bulb);
        bulb_.setColor(0, 191, 255);
    }
}