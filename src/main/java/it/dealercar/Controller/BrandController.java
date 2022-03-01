package it.dealercar.Controller;

import it.dealercar.DTO.BrandDTO;
import it.dealercar.Manager.Interface.BrandManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Brand/")
@CrossOrigin(origins = "http://localhost:4200")
public class BrandController {

    @Autowired
    private BrandManager brandManager;

    @GetMapping("findAll")
    public List<BrandDTO> findAll() {
        return brandManager.findAll();
    }

    @PostMapping("insert")
    public void insert(@RequestBody BrandDTO brand) {
        brandManager.insert(brand);
    }

    @DeleteMapping("delete")
    public void delete(@RequestParam("id") Long idBrand) {
        brandManager.delete(idBrand);
    }

    @PutMapping("put")
    public void update(@RequestBody BrandDTO brand) {
        brandManager.update(brand);
    }

}
