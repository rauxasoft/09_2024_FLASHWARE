package com.sinensia.flashware.backend.integration.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import com.sinensia.flashware.backend.business.model.Establecimiento;

@DataJpaTest
@Sql(scripts = {"classpath:data/h2/schema_test.sql", "classpath:data/h2/data_test.sql"})
public class EstablecimientoRepositoryTest {

	@Autowired
	private EstablecimientoRepository establecimientoRepository;
	
	@Test
	void findByNombreLikeIgnoreCaseTest() {
		
		List<Establecimiento> establecimientos = establecimientoRepository.findByNombreLikeIgnoreCase("nTO 1");
		
		assertEquals(1, establecimientos.size());
		
		Establecimiento establecimiento = establecimientos.get(0);
		assertEquals(1L, establecimiento.getId());
	}
	
}
