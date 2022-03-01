package it.dealercar.Controller;

import it.dealercar.DTO.BrandDTO;
import it.dealercar.Manager.Interface.BrandManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;

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
    public Response insert(@RequestBody BrandDTO brand) {
        brandManager.insert(brand);
        return Response.ok().build();
    }

    @DeleteMapping("delete")
    public Response delete(@RequestParam("id") Long idBrand) {
        brandManager.delete(idBrand);
        return Response.ok().build();
    }

    @PutMapping("put")
    public Response update(@RequestBody BrandDTO brand) {
        brandManager.update(brand);
        return Response.ok().build();
    }

}
