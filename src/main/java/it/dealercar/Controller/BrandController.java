package it.dealercar.Controller;

import it.dealercar.DTO.BrandDTO;
import it.dealercar.Manager.Interface.BrandManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;

@RestController
@RequestMapping("/Brand/")
@CrossOrigin(origins = "http://localhost:4200")
public class BrandController {

    @Autowired
    private BrandManager brandManager;

    @GetMapping("findAll")
    public Response findAll() {
        return Response.ok(brandManager.findAll()).build();
    }

    @PostMapping("insert")
    public Response insert(@RequestBody BrandDTO brand) {
        return Response.ok(brandManager.insert(brand)).build();
    }

    @DeleteMapping("delete")
    public Response delete(@RequestParam("id") Long idBrand) {
        return Response.ok(brandManager.delete(idBrand)).build();
    }

    @PutMapping("put")
    public Response update(@RequestBody BrandDTO brand) {
        return Response.ok(brandManager.update(brand)).build();
    }

}
