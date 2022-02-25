package it.dealercar.Controller;


import it.dealercar.DTO.CarOwnerDTO;
import it.dealercar.Manager.Interface.ServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Service/")
@CrossOrigin(origins = "http://localhost:4200")
public class ServiceController {

    @Autowired
    private ServiceManager serviceManager;

    @PostMapping("buyCar")
    public void buyCar(@RequestParam("idModel") Long idModel, @RequestParam("idOwner") Long idOwner) {
        serviceManager.buyCar(idModel, idOwner);
    }

    @PostMapping("sellCar")
    public void sellCar(@RequestBody CarOwnerDTO carOwner) {
        serviceManager.sellCar(carOwner);
    }

    @PostMapping("changePracticeStatus")
    public void changePracticeStatus(@RequestBody CarOwnerDTO carOwner, @RequestParam("status") String status) {
        serviceManager.changePracticeStatus(carOwner, status);
    }

}
