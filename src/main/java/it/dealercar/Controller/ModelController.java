package it.dealercar.Controller;


import it.dealercar.DTO.ModelDTO;
import it.dealercar.Manager.Interface.ModelManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@RequestMapping("/Model/")
@CrossOrigin(origins = "http://localhost:4200")
public class ModelController {

    @Autowired
    private ModelManager modelManager;

    @GetMapping("findAll")
    public Response findAll() {
        return Response.ok(modelManager.findAll()).build();
    }

    @PostMapping("findAllModelByBrand")
    public Response findAllModelByBrand(@RequestParam("id") Long idBrand) {
        return Response.ok(modelManager.findAllModelByBrand(idBrand)).build();
    }

    @PostMapping("insert")
    public Response insert(@RequestBody ModelDTO model) {
        modelManager.insert(model);
        return Response.ok().build();
    }

    @DeleteMapping("delete")
    public Response delete(@RequestParam("id") Long idModel) {
        modelManager.delete(idModel);
        return Response.ok().build();
    }

    @PutMapping("put")
    public Response update(@RequestBody ModelDTO model) {
        modelManager.update(model);
        return Response.ok().build();
    }

}
