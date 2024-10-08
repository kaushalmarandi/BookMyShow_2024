package m.kash.bookmyshowoct24.repositories;

import m.kash.bookmyshowoct24.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    Optional<Booking> findById(Long bookingId);
}
