package com.example.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.entity.Products;

public interface ProductsResposity extends JpaRepository<Products, String>{
	List<Products> findByNameContaining(String name);
	List<Products> findByName(String name);
	// 按照 id 升序排序
    List<Products> findAllByOrderByNameAsc();
    List<Products> findByShopIdOrderByNameAsc(String shopId);
    
    
    @Query(value = "SELECT p.name AS productName, COALESCE(SUM(od.quantity), 0) AS totalQuantitySold " +
            "FROM Products p " +
            "LEFT JOIN Orderdetails od ON p.id = od.productsid " +
            "WHERE p.shop_id = :shopId " +
            "GROUP BY p.id, p.name " +
            "ORDER BY totalQuantitySold DESC",nativeQuery= true)
    List<Object[]> findBestSellingProductsByShopId(@Param("shopId") String shopId);
    	
}
