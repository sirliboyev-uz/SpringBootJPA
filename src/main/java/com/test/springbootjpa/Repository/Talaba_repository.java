package com.test.springbootjpa.Repository;

import com.test.springbootjpa.Model.Talaba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Talaba_repository extends JpaRepository<Talaba, Integer> {

}
