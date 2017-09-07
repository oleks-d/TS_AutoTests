package enums;

/**
 * Created by odiachuk on 11.07.17.
 */
public enum ProductTypes {

    MATTRESS("Our Hybrid Mattress"),
    MONITOR("Tomorrow Sleeptracker® Monitor"),
    DRAPES("Tomorrow Drapes"),
    FOAM_PILLOW("Tomorrow Memory Foam Pillow"),
    PLUSH_PILLOW("Tomorrow Plush Pillow"),
    COMFORTER("Tomorrow Comforter"),
    MATTRESS_PROTECTOR("Tomorrow Mattress Protector"),
    SHEETSET("Tomorrow Sheet Set");


    private String value;

    ProductTypes (String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }

    public static ProductTypes getEnum(String value) {
        for(ProductTypes v : values())
            if(v.getValue().equalsIgnoreCase(value)) return v;
        throw new IllegalArgumentException("Can't find Product type " + value);
    }


}
