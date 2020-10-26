package rek1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ex2 {

    public static int priceCheck(List<String> products, List<Float> productPrices, List<String> productSold, List<Float> soldPrice) {

        Map<String, Float> productsPricesMap = new HashMap<>();

        for (int i = 0; i < products.size(); i++) {
            productsPricesMap.put(products.get(i), productPrices.get(i));
        }

        int incorrect = 0;

        for (int i = 0; i < productSold.size(); i++) {
            if (!productsPricesMap.get(productSold.get(i)).equals(soldPrice.get(i)))
                incorrect++;
        }

        return incorrect;

    }

    public static void main(String[] args) {
        List<String> products = new ArrayList<>();
        products.add("chocolate");
        products.add("cheese");
        products.add("tomato");

        List<Float> productPrices = new ArrayList<>();
        productPrices.add(15f);
        productPrices.add(300.90f);
        productPrices.add(23.44f);

        List<String> productSold = new ArrayList<>();
        productSold.add("cheese");
        productSold.add("tomato");
        productSold.add("chocolate");

        List<Float> soldPrice = new ArrayList<>();
        soldPrice.add(300.90f);
        soldPrice.add(23.44f);
        soldPrice.add(10f);

        priceCheck(products,productPrices,productSold,soldPrice);
    }
}
