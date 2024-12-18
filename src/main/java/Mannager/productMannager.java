package Mannager;

import ProductModel.Product;
import java.util.ArrayList;
import java.util.List;

public class productMannager
{
    private static  List<Product> productList = new ArrayList<>();

    public void addProduct(Product product){
        if(productList.contains(product.getName()))throw new RuntimeException("Product already exists");
        productList.add(product);
    }


    public void DeleteProduct(String name){
        boolean isRemoved = productList.removeIf(product -> product.getName().equals(name));
        if (!isRemoved) {
            throw new RuntimeException("Product not found to delete");
        }

    }
    public void updateProduct(String oldname,String newname,double newprice) {
        productList.forEach(product -> {
            if(product.getName().equals(oldname)){
            product.setName(newname);
            product.setPrice( newprice);
        }});
        System.out.println("productUpdated");
    }
    public Product searchProduct(String name) {
        Product product = productList.stream()
                .filter(productEle -> productEle.getName().equals(name))
                .findFirst()
                .orElse(null);
        //System.out.println(product.getName());
        return product;
    }
    public List<Product> getAllProducts() {
        return productList;
    }



}
