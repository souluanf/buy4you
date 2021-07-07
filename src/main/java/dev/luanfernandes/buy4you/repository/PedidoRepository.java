package dev.luanfernandes.buy4you.repository;

import dev.luanfernandes.buy4you.model.enums.StatusPedido;
import dev.luanfernandes.buy4you.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByStatus(StatusPedido status);
}