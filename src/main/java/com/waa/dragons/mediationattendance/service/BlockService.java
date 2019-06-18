<<<<<<< HEAD
package com.waa.dragons.mediationattendance.service;

public interface BlockService {
}
=======
package com.waa.dragons.mediationattendance.service;

import com.waa.dragons.mediationattendance.domain.Block;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public interface BlockService {
    Optional<Block> findBlockByStartDateLessThanEqualAndEndDateGreaterThanEqual(LocalDate startDate, LocalDate endDate);

}
>>>>>>> 024eb1b62b34cac2b1487b2a179662675ca36953
