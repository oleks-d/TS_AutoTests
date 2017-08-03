package utils;

import enums.ProductTypes;

import java.util.HashMap;
import java.util.Objects;

/**
 * Created by odiachuk on 28.07.17.
 */
public class ProductSync {

    static HashMap<ProductTypes, Boolean> productSelectionProcessStartedFlag = setDefaultValues();

    private static HashMap<ProductTypes,Boolean> setDefaultValues() {
        HashMap<ProductTypes, Boolean> result = new HashMap<ProductTypes, Boolean>();
        ProductTypes type = ProductTypes.MATTRESS;
        Object[] possibleValues = type.getDeclaringClass().getEnumConstants();
        for (Object key :  possibleValues)
            result.put((ProductTypes)key, false);
        return result;
    }

    final static int MAX_WAIT_TIMEOUT = 300; // max timeout 5 min
    static ReporterManager reporter = ReporterManager.Instance;

    // check that some test is already trying to add product to cart
    public static void check(ProductTypes type){
        reporter.info("TRYING CHECK: " + type);
        // if someone already started product selection process - wait
        int i = 0;
        while (productSelectionProcessStartedFlag.get(type)){
            try {
                Thread.sleep(1000);
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            };
            reporter.info("WAIT " + i);
            //if max timeout reached - uncheck flag
            if(i > MAX_WAIT_TIMEOUT){
                uncheck(type);
            }
        }
        //check that test already started adding of product to cart
        synchronized (ProductSync.class){
            reporter.info("CHECK: " + type);
            productSelectionProcessStartedFlag.put(type, true);
        }
    }

    // uncheck flag
    public static void uncheck(ProductTypes type){
        synchronized (ProductSync.class){
            reporter.info("UNCHECK: " + type);
            productSelectionProcessStartedFlag.put(type, false);
        }
    }
}
