package m.kash.bookmyshowoct24.services;

import m.kash.bookmyshowoct24.models.Show;
import m.kash.bookmyshowoct24.models.ShowSeat;
import m.kash.bookmyshowoct24.models.ShowSeatType;
import m.kash.bookmyshowoct24.repositories.ShowSeatTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCalculatorService {
    private ShowSeatTypeRepository showSeatTypeRepository;

    public PriceCalculatorService(ShowSeatTypeRepository showSeatTypeRepository){
        this.showSeatTypeRepository=showSeatTypeRepository;
    }
    public int calculatePrice(List<ShowSeat> showSeats, Show show){
        List<ShowSeatType> showSeatTypes= showSeatTypeRepository.findAllByShow(show);

        int amount = 0;
        for (ShowSeat showSeat: showSeats){
            for (ShowSeatType showSeatType: showSeatTypes){
                if (showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())){
                    amount += showSeatType.getPrice();
                    break;
                }
            }
        }
        return amount;
    }
}
