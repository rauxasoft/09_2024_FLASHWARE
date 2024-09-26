package com.sinensia.flashware.backend.integration.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sinensia.flashware.backend.business.model.Categoria;
import com.sinensia.flashware.backend.business.model.Producto;
import com.sinensia.flashware.backend.business.model.dtos.ProductoDTO2;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

	List<Producto> findByPrecioBetweenOrderByPrecioDesc(Double min, Double max);
	
	List<Producto> findByCategoria(Categoria categoria);
	
	@Query("SELECT p.codigo, CONCAT(p.nombre, ' (', p.categoria, ')'), p.precio FROM Producto p ORDER BY p.codigo")
	List<Object[]> findProductoDTO1();

	@Query("SELECT new com.sinensia.flashware.backend.business.model.dtos.ProductoDTO2(                      "
	 + "              p.codigo,                                                                              "
	 + "              CAST(YEAR(p.fechaAlta) AS STRING),                                                     "
	 + "              p.nombre,                                                                              "
	 + "              CASE                                                                                   "
	 + "               WHEN (LENGTH(p.descripcion) >= 45) THEN CONCAT(SUBSTRING(p.descripcion, 1,34), '...') "
	 + "               ELSE p.descripcion                                                                    "
	 + "              END,                                                                                   "
     + "              p.precio,                                                                              "
	 + "              ROUND(p.precio + (p.precio * 0.21), 2)                                                 "
	 + "            )                                                                                        "
	 + "      FROM Producto p                                                                                "
	 + "  ORDER BY p.codigo                                                                                  ")
	List<ProductoDTO2> findProductoDTO2();
	
	@Query("UPDATE Producto p SET p.precio = p.precio + (p.precio * :porcentaje / 100) WHERE p.codigo IN :ids")
	@Modifying
	int incrementarPrecio(Long[] ids, double porcentaje);
	
	@Query("UPDATE Producto p SET p.precio = p.precio + (p.precio * :porcentaje / 100) WHERE p IN :productos")
	@Modifying
	int incrementarPrecio(List<Producto> productos, double porcentaje);
	
	@Query("SELECT COUNT(p) FROM Producto p WHERE p.categoria = :categoria")
	long contarNumeroProductosPorCategoria(Categoria categoria);
}
