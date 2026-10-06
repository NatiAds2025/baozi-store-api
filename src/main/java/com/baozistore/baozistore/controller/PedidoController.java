package com.baozistore.baozistore.controller;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.baozistore.baozistore.model.Pedido;
import com.baozistore.baozistore.repository.PedidoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;


@RestController
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("/pedidos")
    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }
    
    @PostMapping("/pedidos")
    public Pedido adicionar(@RequestBody Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
    
    @GetMapping("/pedidos/{id}")
    public Pedido buscarPorId(@PathVariable Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }
    
    @PutMapping("/pedidos/{id}")
    public Pedido atualizar(@PathVariable Long id, @RequestBody Pedido pedido) {
        pedido.setId(id);
        return pedidoRepository.save(pedido);
    }
    
    @DeleteMapping("/pedidos/{id}")
    public void excluir(@PathVariable Long id) {
        pedidoRepository.deleteById(id);
    }
    
}
