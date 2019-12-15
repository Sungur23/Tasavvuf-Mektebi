package soft.bigeran.dervis.Kafileler;

public class KafileModel {


    public String nereden;
    public String nereye;
    public String tarih;
    public String saat;
    public String ücret;
    public String numara;
    public String notlar;
    public String baybayan;
    public int kafilesırası;

    public KafileModel(String nereden, String nereye, String tarih, String saat, String ücret, String numara, String notlar, String baybayan, int kafilesırası) {
        this.nereden = nereden;
        this.nereye = nereye;
        this.tarih = tarih;
        this.saat = saat;
        this.ücret = ücret;
        this.numara = numara;
        this.notlar = notlar;
        this.baybayan = baybayan;
        this.kafilesırası = kafilesırası;
    }
    public KafileModel() {
    }

}