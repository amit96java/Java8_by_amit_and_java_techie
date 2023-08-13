package io.amit.by_java_techie.collections_with_java8.consumer_predicate_supplier.supplier;

import java.util.function.Supplier;

public class SupplierWithInterface implements Supplier<String> {
    /**
     * Gets a result.
     *
     * @return a result
     */
    @Override
    public String get() {
        return "hi amit";
    }

    public static void main(String[] args) {
        Supplier<String> supplier = new SupplierWithInterface();
        System.out.println(supplier.get());
    }
}
