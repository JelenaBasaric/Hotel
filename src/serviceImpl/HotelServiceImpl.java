package serviceImpl;

import domain.Hotel;
import genericService.HotelService;
import repositoryImpl.HotelRepositoryImpl;

/**
 *
 * @author Jelena Basaric
 */
public class HotelServiceImpl implements HotelService{
    private final HotelRepositoryImpl  hotelRepository;

    public HotelServiceImpl() {
         hotelRepository=new HotelRepositoryImpl();
    }
    

    @Override
    public Hotel find() {
       Hotel hotel= hotelRepository.find();
       return hotel.getIstance();
           }
    
}
