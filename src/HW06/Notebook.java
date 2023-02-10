package HW06;

import java.util.Objects;

class Notebook {
    private String os;
    private String brand;
    private String model;
    private int rom;
    private int hdd;
    private int screenDiagonal;
    private String screenResolution;
    private String targetOfUse;
    private String properties;


    public Notebook(String os,
                    String brand, String model,
                    int rom, int hdd,
                    int screenDiagonal, String screenResolution,
                    String targetOfUse) {
        this.os = os;
        this.brand = brand;
        this.model = model;
        this.rom = rom;
        this.hdd = hdd;
        this.screenDiagonal = screenDiagonal;
        this.screenResolution = screenResolution;
        this.targetOfUse = targetOfUse;
        this.properties = String.format("%s %s %s %d %d %d %s %s",
                getOs(), getBrand(), getModel(), getRom(), getHdd(),
                getScreenDiagonal(), getScreenResolution(), getTargetOfUse());
    }

    @Override
    public String toString() {
        return String.format("""
                                        
                        %s %s
                        Операционная система: %s
                        HDD: %d, ROM: %d, экран %d" %s
                        Рекомендуемое применение: %s
                        """,
                getBrand(), getModel(), getOs(), getHdd(), getRom(), getScreenDiagonal(), getScreenResolution(), getTargetOfUse());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notebook notebook = (Notebook) o;
        return rom == notebook.rom
                && hdd == notebook.hdd
                && screenDiagonal == notebook.screenDiagonal
                && Objects.equals(os, notebook.os)
                && Objects.equals(brand, notebook.brand)
                && Objects.equals(model, notebook.model)
                && Objects.equals(screenResolution, notebook.screenResolution);
    }

    @Override
    public int hashCode() {
        return Objects.hash(os, brand, model, rom, hdd, screenDiagonal, screenResolution);
    }
//    region Getters

    public String getOs() {
        return os;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getRom() {
        return rom;
    }

    public int getHdd() {
        return hdd;
    }

    public int getScreenDiagonal() {
        return screenDiagonal;
    }

    public String getScreenResolution() {
        return screenResolution;
    }

    public String getTargetOfUse() {
        return targetOfUse;
    }

    public String getProperties() {
        return properties;
    }
//    endregion Getters
}