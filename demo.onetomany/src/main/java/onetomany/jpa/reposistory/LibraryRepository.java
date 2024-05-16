package onetomany.jpa.reposistory;

import org.springframework.data.jpa.repository.JpaRepository;

import onetomany.jpa.entity.Library;

public interface LibraryRepository extends JpaRepository<Library, Integer> {

}
