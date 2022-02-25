package it.dealercar.Controller;


import it.dealercar.DTO.CarOwnerDTO;
import it.dealercar.DTO.OwnerDTO;
import it.dealercar.Manager.Interface.OwnerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Owner/")
@CrossOrigin(origins = "http://localhost:4200")
public class OwnerController {

    @Autowired
    private OwnerManager ownerManager;

    @GetMapping("findAll")
    public List<OwnerDTO> findAll() {
        return ownerManager.findAll();
    }

    @PostMapping("findAllCarOfOwner")
    public List<CarOwnerDTO> findAllCarOfOwner(@RequestParam("id") Long idOwner) {
        return ownerManager.findAllCarOfOwner(idOwner);
    }

    @PostMapping("insert")
    public void insert(@RequestBody OwnerDTO owner) {
        ownerManager.insert(owner);
    }

    @DeleteMapping("delete")
    public void delete(@RequestParam("id") Long idOwner) {
        ownerManager.delete(idOwner);
    }

    @PutMapping("update")
    public void update(@RequestBody OwnerDTO owner) {
        ownerManager.update(owner);
    }

}
