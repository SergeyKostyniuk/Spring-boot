package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.ShoesCategory;

@Repository
public interface ShoesCategoryRepository extends JpaRepository<ShoesCategory, Integer>{

}