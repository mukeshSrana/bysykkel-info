package no.oslo.bysykkel.api;

public class StasjonStatusInformasjon {
    private String stationId;

    private String navn;

    private String adresse;

    private int kapasitet;

    private int ledigSykler;

    private int tilgjengeligeLaaser;

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getKapasitet() {
        return kapasitet;
    }

    public void setKapasitet(int kapasitet) {
        this.kapasitet = kapasitet;
    }

    public int getLedigSykler() {
        return ledigSykler;
    }

    public void setLedigSykler(int ledigSykler) {
        this.ledigSykler = ledigSykler;
    }

    public int getTilgjengeligeLaaser() {
        return tilgjengeligeLaaser;
    }

    public void setTilgjengeligeLaaser(int tilgjengeligeLaaser) {
        this.tilgjengeligeLaaser = tilgjengeligeLaaser;
    }
}
