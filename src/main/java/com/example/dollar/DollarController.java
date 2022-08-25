package com.example.dollar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class DollarController {

    @Autowired
    private final DollarRepository repository;

    DollarController(DollarRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/oficial")
    public String getDollarOficial() {
        String uri = "https://api-dolar-argentina.herokuapp.com/api/dolaroficial";
        RestTemplate restTemplate = new RestTemplate();
        ModelDollar official = restTemplate.getForObject(uri, ModelDollar.class);
        return "El precio de compra es de " + official.getBuyPrice() + "\n" +
               "El precio de venta es de " + official.getVenta();
    }

    @GetMapping("/blue")
    public String getDollarBlue() {
        String uri = "https://api-dolar-argentina.herokuapp.com/api/dolarblue";
        RestTemplate restTemplate = new RestTemplate();
        ModelDollar official = restTemplate.getForObject(uri, ModelDollar.class);
        return "El precio de compra es de " + official.getBuyPrice() + "\n" +
                "El precio de venta es de " + official.getVenta();
    }

    @GetMapping("/riesgopais")
    public String getRiesgoPais() {
        String uri = "https://api-dolar-argentina.herokuapp.com/api/riesgopais";
        RestTemplate restTemplate = new RestTemplate();
        ModelDollar official = restTemplate.getForObject(uri, ModelDollar.class);
        return "El riesgo pais es de " + official.getValor();
    }

    @GetMapping("/{compro}")
    public String getDollarOficial(@PathVariable Double compro) {
        String uri = "https://api-dolar-argentina.herokuapp.com/api/dolaroficial";
        RestTemplate restTemplate = new RestTemplate();
        ModelDollar official = restTemplate.getForObject(uri, ModelDollar.class);
        return "Usted compro " + compro + " usd por un total de " + official.getBuyPrice() * compro * 1.65 + " $ con impuestos";
    }

    @PostMapping("/compra")
    ModelDollar newDollar(@RequestBody ModelDollar newDollar) {
        return repository.save(newDollar);
    }

    @GetMapping("/fromdb/{id}")
    public ModelDollar getDollarFromDb(@PathVariable Long id) {
        return repository.findById(id).get();
    }
}
