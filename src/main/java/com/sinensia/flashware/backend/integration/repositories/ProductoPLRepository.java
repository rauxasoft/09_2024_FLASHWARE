package com.sinensia.flashware.backend.integration.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sinensia.flashware.backend.business.model.dtos.ProductoDTO2;
import com.sinensia.flashware.backend.integration.model.CategoriaPL;
import com.sinensia.flashware.backend.integration.model.ProductoPL;

public interface ProductoPLRepository extends JpaRepository<ProductoPL, Long> {

	List<ProductoPL> findByPrecioBetweenOrderByPrecioDesc(Double min, Double max);
	
	List<ProductoPL> findByCategoria(CategoriaPL categoria);
	
	@Query("SELECT p.codigo, CONCAT(p.nombre, ' (', p.categoria, ')'), p.precio FROM ProductoPL p ORDER BY p.codigo")
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
	 + "      FROM ProductoPL p                                                                                "
	 + "  ORDER BY p.codigo                                                                                  ")
	List<ProductoDTO2> findProductoDTO2();
	
	@Query("UPDATE ProductoPL p SET p.precio = p.precio + (p.precio * :porcentaje / 100) WHERE p.codigo IN :ids")
	@Modifying
	int incrementarPrecio(Long[] ids, double porcentaje);
	
	@Query("UPDATE ProductoPL p SET p.precio = p.precio + (p.precio * :porcentaje / 100) WHERE p IN :productos")
	@Modifying
	int incrementarPrecio(List<ProductoPL> productos, double porcentaje);
	
	@Query("SELECT COUNT(p) FROM ProductoPL p WHERE p.categoria = :categoria")
	long contarNumeroProductosPorCategoria(CategoriaPL categoria);
	
	@Query("SELECT p.categoria, COUNT(p) FROM ProductoPL p GROUP BY p.categoria")
	List<Object[]> getEstadisticaNumeroProductos();
	
	@Query("SELECT p.categoria, ROUND(AVG(p.precio), 2) FROM ProductoPL p GROUP BY p.categoria")
	List<Object[]> getEstadisticaPreciosmedios();
}
