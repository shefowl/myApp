package com.example.myApp.ShopClasses.Buy;

import java.util.List;

public class CatalogImpl implements ListActions {
    private ProductListImpl catalog = new ProductListImpl();

    @Override
    public void addToList(Product chosenProduct) {
        catalog.addToList(chosenProduct);
    }

    @Override
    public void updateList (Product updateProduct){
        catalog.updateList(updateProduct);
    }

    @Override
    public void deleteFromList(Product deleteProduct) {
        catalog.deleteFromList(deleteProduct);
    }

    @Override
    public List<Product> showAllList() {
        return catalog.showAllList();
    }

    @Override
    public boolean isEmpty() {
        return catalog.isEmpty();
    }

    public void setCatalog(ProductListImpl catalog) {
        this.catalog = catalog;
    }

    public ProductListImpl getCatalog() {
        return catalog;
    }

    public CatalogImpl() {
    }

    public CatalogImpl(ProductListImpl catalog) {
        this.catalog = catalog;
    }
}
