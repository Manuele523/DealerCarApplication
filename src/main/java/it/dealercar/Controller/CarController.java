package it.dealercar.Controller;


import it.dealercar.DTO.BrandDTO;
import it.dealercar.DTO.ModelDTO;
import it.dealercar.Manager.Interface.CarManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Car/")
public class CarController {

    @Autowired
    private CarManager carManager;

    // MODEL

    @GetMapping("findAll")
    public List<ModelDTO> findAll() {
        return carManager.findAll();
    }

    @PostMapping("findAllModelByBrand")
    public List<ModelDTO> findAllModelByBrand(@RequestParam("id") Long idBrand) {
        return carManager.findAllModelByBrand(idBrand);
    }

    @PostMapping("insertModel")
    public void insertModel(@RequestBody ModelDTO model) {
        carManager.insertModel(model);
    }

    @DeleteMapping("deleteModel")
    public void deleteModel(@RequestParam("id") Long idModel) {
        carManager.deleteModel(idModel);
    }

    @PutMapping("putModel")
    public void updateModel(@RequestBody ModelDTO model) {
        carManager.updateModel(model);
    }

    // BRAND

    @GetMapping("findAllBrand")
    public List<BrandDTO> findAllBrand() {
        return carManager.findAllBrand();
    }

    @PostMapping("insertBrand")
    public void insertBrand(@RequestBody BrandDTO brand) {
        carManager.insertBrand(brand);
    }

    @DeleteMapping("deleteBrand")
    public void deleteBrand(@RequestParam("id") Long idBrand) {
        carManager.deleteBrand(idBrand);
    }

    @PutMapping("putBrand")
    public void updateBrand(@RequestBody BrandDTO brand) {
        carManager.updateBrand(brand);
    }

}
