package com.example.repository;
import org.springframework.data.jpa.repository.JpaRepository;
//新增
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entity.Member;

public interface MemberRepository extends JpaRepository<Member,String>{
	
	//新增
	@Query("SELECT COALESCE(SUM(o.amount), 0) FROM Orders o WHERE o.member.id = :memberId")
	Integer calculateTotalSpentByMemberId(String memberId);
	
	//新增
	//@Query("SELECT m, COALESCE(SUM(o.amount), 0) as totalSpent FROM Member m LEFT JOIN Orders o ON m.id = o.member.id GROUP BY m.id ORDER BY totalSpent DESC")
	//List<Object[]> findAllMembersWithTotalSpent();
	
	@Query("SELECT m, COALESCE(SUM(o.amount), 0) as totalSpent FROM Member m LEFT  JOIN Orders o ON m.id = o.member.id WHERE m.shopId = :shopId GROUP BY m.id ORDER BY totalSpent DESC")
	List<Object[]> findAllMembersWithTotalSpent(@Param("shopId") String shopId);
	
	//用email找member
	List<Member>findByShopIdAndMail(String shopId,String mail);
	
	List<Member>findByShopId(String shopId);
	
}
