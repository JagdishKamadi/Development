package com.epam.repository;

import com.epam.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface LibraryRepository extends JpaRepository<Library,Integer> {
    @Modifying
    @Query("delete from Library l where l.username=?1 and l.bookId=?2")
    int deleteByUsernameAndBookId(String username,int bookId);
}
