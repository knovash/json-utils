package org.itacademy.jsonutils.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j2
public class CatalogItem {

    public String name;
    public String price;
    public String brand;
    public String priceMin;
    public String priceMax;

    public CatalogItem(String name, String brand) {
        this.name = name;
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "\nCatalogItem{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", brand='" + brand + '\'' +
                ", priceMin='" + priceMin + '\'' +
                ", priceMax='" + priceMax + '\'' +
                '}';
    }
}
