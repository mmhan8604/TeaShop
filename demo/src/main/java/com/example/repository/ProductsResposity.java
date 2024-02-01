package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entity.Products;

public interface ProductsResposity extends JpaRepository<Products, String> {
	List<Products> findByNameContaining(String name);

	List<Products> findByName(String name);

	// 按照 id 升序排序
	List<Products> findAllByOrderByNameAsc();

	List<Products> findByShopIdOrderByNameAsc(String shopId);



	@Query(value = "SELECT p.name AS product_name, p.price AS product_price, p.picjson AS product_image, "
            + "COALESCE(SUM(od.quantity), 0) AS total_quantity "
            + "FROM Products p "
            + "LEFT JOIN Orderdetails od ON p.id = od.productsid "
            + "LEFT JOIN Orders o ON od.ordersid = o.id "
            + "WHERE p.shop_id = :shopId "
            + "GROUP BY p.id "
            + "ORDER BY total_quantity DESC "
            + "LIMIT 4", nativeQuery = true)
    List<Object[]> findTopSelling4ProductsByShopId(@Param("shopId") String shopId);
    


    
    @Query(value = "SELECT p.name AS productName, COALESCE(SUM(od.quantity), 0) AS totalQuantitySold " +
            "FROM Products p " +
            "LEFT JOIN Orderdetails od ON p.id = od.productsid " +
            "WHERE p.shop_id = :shopId " +
            "GROUP BY p.id, p.name " +
            "ORDER BY totalQuantitySold DESC",nativeQuery= true)
    List<Object[]> findBestSellingProductsByShopId(@Param("shopId") String shopId);
    	

    @Query("SELECT p FROM Products p LEFT JOIN FETCH p.discounts WHERE p.id = :productId")
    Products findProductWithDiscounts(String productId);
    
    @Query("SELECT p, MIN(ad.discount) FROM Products p " +
            "LEFT JOIN p.discounts ad " +
            "WHERE p.shopId = :shopId " +
            "GROUP BY p.id")
     List<Object[]> findProductsAndMinDiscountsByShopId(@Param("shopId") String shopId);


}
