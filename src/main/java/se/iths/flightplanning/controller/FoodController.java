package se.iths.flightplanning.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se.iths.flightplanning.dto.FoodDto;
import se.iths.flightplanning.exception.EmptyListException;
import se.iths.flightplanning.service.FoodServiceDto;

@RestController
@RequestMapping("food")
public class FoodController {

    private final FoodServiceDto foodServiceDto;

    public FoodController(FoodServiceDto foodServiceDto) {
        this.foodServiceDto = foodServiceDto;
    }

    @PostMapping()
    public ResponseEntity<FoodDto> createFood(@RequestBody FoodDto foodDto) {
        FoodDto createdFood = foodServiceDto.createFood(foodDto);
        return new ResponseEntity<>(createdFood, HttpStatus.CREATED);
    }
    @GetMapping()
    public ResponseEntity<Iterable<FoodDto>> findAllFood() {
        Iterable<FoodDto> allFood = foodServiceDto.findAllFood();
        if (allFood.iterator().hasNext())
            return new ResponseEntity<>(allFood, HttpStatus.OK);
        else
            throw new EmptyListException("Food list is empty.");
    }

    @GetMapping("{id}")
    public FoodDto findFoodById(@PathVariable Long id) {
        return foodServiceDto.getFoodById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Id " + id + " not found."));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteFoodById(@PathVariable Long id) {
        foodServiceDto.deleteFoodById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/")
    @ResponseBody
    public String getFooByIdUsingQueryParam(@RequestParam String id) {
        return "ID: " + id;
    }

}
