package soft.bigeran.dervis.MainFragments.TabDiger.SubFragments.Interfaces;

public interface CompassListener {
    void onNewAzimuth(float azimuth);
    void onAccelometerExist(boolean value);
    void onMagneticFieldExist(boolean value);
}