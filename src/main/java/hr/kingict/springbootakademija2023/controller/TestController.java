package hr.kingict.springbootakademija2023.controller;

import hr.kingict.springbootakademija2023.dto.VegetableDto;
import hr.kingict.springbootakademija2023.form.VegetableForm;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
@RestController
@RequestMapping(value = "api")
public class TestController {
    @GetMapping(value = "/vegetables")
    public ResponseEntity<List<String>> getVegetables(){
        return ResponseEntity
                .ok()
                .header("my header", "something something")
                .body(Arrays.asList("Cabbage", "Pepper", "Broccoli"));
    }
    @GetMapping(value = "/vegetables/{key}")
    public ResponseEntity<String> getVegetable(@PathVariable String key){
        if(key == null){
            return ResponseEntity
                    .badRequest()
                    .build();
        }
        if(key.equalsIgnoreCase("CARR")){
            return ResponseEntity
                    .ok()
                    .body("Carrot");
        }
        return ResponseEntity
                .badRequest()
                .build();

    }
    @PostMapping(value = "/vegetables")
    public ResponseEntity<VegetableDto> saveVegetable(@Valid @RequestBody VegetableForm vegetableForm){
        VegetableDto vegetableDto = new VegetableDto();
        vegetableDto.setName(vegetableForm.getName());
        vegetableDto.setColor(vegetableForm.getColor());
        vegetableDto.setOrganic(vegetableForm.getOrganic());

        return ResponseEntity
                .ok()
                .body(vegetableDto);
    }

}
