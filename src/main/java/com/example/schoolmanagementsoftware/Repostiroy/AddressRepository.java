package com.example.schoolmanagementsoftware.Repostiroy;

import com.example.schoolmanagementsoftware.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    @Query("select a from Address a where a.id = :addressId")
     Address findAddressById(@Param("addressId") Integer addressId);

}
