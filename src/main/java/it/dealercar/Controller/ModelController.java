package it.dealercar.Controller;


import it.dealercar.DTO.ModelDTO;
import it.dealercar.Manager.Interface.ModelManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Model/")
@CrossOrigin(origins = "http://localhost:4200")
public class ModelController {

    @Autowired
    private ModelManager modelManager;

    @GetMapping("findAll")
    public List<ModelDTO> findAll() {
        return modelManager.findAll();
    }

    @PostMapping("findAllModelByBrand")
    public List<ModelDTO> findAllModelByBrand(@RequestParam("id") Long idBrand) {
        return modelManager.findAllModelByBrand(idBrand);
    }

    @PostMapping("insert")
    public void insert(@RequestBody ModelDTO model) {
        modelManager.insert(model);
    }

    @DeleteMapping("delete")
    public void delete(@RequestParam("id") Long idModel) {
        modelManager.delete(idModel);
    }

    @PutMapping("put")
    public void update(@RequestBody ModelDTO model) {
        modelManager.update(model);
    }

}
