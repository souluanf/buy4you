package dev.luanfernandes.buy4you.controller;

import dev.luanfernandes.buy4you.model.Pedido;
import dev.luanfernandes.buy4you.model.enums.StatusPedido;
import dev.luanfernandes.buy4you.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	private PedidoRepository repository;

	@Autowired
	public void PedidoRepository(PedidoRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public String home(Model model) {
		List<Pedido> pedidos = repository.findAll();
		model.addAttribute("pedidos", pedidos);
		return "home"; 
	}

	@GetMapping("/{status}")
	public String porStatus(@PathVariable("status") String status, Model model) {
		List<Pedido> pedidos = repository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
		model.addAttribute("pedidos", pedidos);
		model.addAttribute("status",status);
		return "home";
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public String onError(){
		return "redirect:/home";
	}
}
