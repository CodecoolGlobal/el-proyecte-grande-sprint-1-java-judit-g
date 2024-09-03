package com.codecool.ratemydrivinginstructorbackend.repository.school.schooladdress;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolAddressRepository extends JpaRepository<SchoolAddress, Long> {
}
