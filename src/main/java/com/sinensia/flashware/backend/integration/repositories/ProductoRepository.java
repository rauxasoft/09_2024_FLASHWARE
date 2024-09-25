package com.sinensia.flashware.backend.integration.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sinensia.flashware.backend.business.model.Categoria;
import com.sinensia.flashware.backend.business.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

	List<Producto> findByPrecioBetweenOrderByPrecioDesc(Double min, Double max);
	
	List<Producto> findByCategoria(Categoria categoria);
	
	@Query("SELECT p.codigo, CONCAT(p.nombre, ' (', p.categoria, ')'), p.precio FROM Producto p")
	List<Object[]> findProductoDTO1();
	
}
