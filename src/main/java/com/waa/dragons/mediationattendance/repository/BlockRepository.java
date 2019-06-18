<<<<<<< HEAD
package com.waa.dragons.mediationattendance.repository;

import com.waa.dragons.mediationattendance.domain.Block;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BlockRepository extends CrudRepository<Block, Integer> {
}
=======
package com.waa.dragons.mediationattendance.repository;

import com.waa.dragons.mediationattendance.domain.Block;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.Optional;


@Repository
public interface BlockRepository extends CrudRepository<Block, Integer> {


    Optional<Block> findBlockByStartDateLessThanEqualAndEndDateGreaterThanEqual(LocalDate startDate, LocalDate endDate);
}
>>>>>>> 024eb1b62b34cac2b1487b2a179662675ca36953
