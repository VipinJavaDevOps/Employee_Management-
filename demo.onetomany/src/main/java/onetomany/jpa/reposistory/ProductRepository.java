package onetomany.jpa.reposistory;

import org.springframework.data.jpa.repository.JpaRepository;

import onetomany.jpa.entity.Product;

public interface ProductRepository extends JpaRepository <Product,Integer >{

}
