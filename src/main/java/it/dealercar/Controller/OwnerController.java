package it.dealercar.Controller;


import it.dealercar.DTO.OwnerDTO;
import it.dealercar.Manager.Interface.OwnerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;

@RestController
@RequestMapping("/Owner/")
@CrossOrigin(origins = "http://localhost:4200")
public class OwnerController {

    @Autowired
    private OwnerManager ownerManager;

    @GetMapping("findAll")
    public Response findAll() {
        return Response.ok(ownerManager.findAll()).build();
    }

    @PostMapping("findAllCarOfOwner")
    public Response findAllCarOfOwner(@RequestParam("id") Long idOwner) {
        return Response.ok(ownerManager.findAllCarOfOwner(idOwner)).build();
    }

    @PostMapping("insert")
    public Response insert(@RequestBody OwnerDTO owner) {
        return Response.ok(ownerManager.insert(owner)).build();
    }

    @DeleteMapping("delete")
    public Response delete(@RequestParam("id") Long idOwner) {
        return Response.ok(ownerManager.delete(idOwner)).build();
    }

    @PutMapping("update")
    public Response update(@RequestBody OwnerDTO owner) {
        return Response.ok(ownerManager.update(owner)).build();
    }

}
