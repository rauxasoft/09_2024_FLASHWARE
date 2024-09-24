package com.sinensia.flashware.backend.business.services.dummy.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import com.sinensia.flashware.backend.business.model.DatosContacto;
import com.sinensia.flashware.backend.business.model.Direccion;
import com.sinensia.flashware.backend.business.model.Establecimiento;
import com.sinensia.flashware.backend.business.services.EstablecimientoServices;

@Service
public class EstablecimientoDummyServicesImpl implements EstablecimientoServices{

	private final TreeMap<Long, Establecimiento> ESTABLECIMIENTOS_DB = new TreeMap<>();
	
	public EstablecimientoDummyServicesImpl() {
		initObjects();
	}
	
	@Override
	public Long create(Establecimiento establecimiento) {
		
		if(establecimiento.getId() != null) {
			throw new IllegalStateException("El id del establecimiento ha de ser NULL");
		}

		establecimiento.setId(ESTABLECIMIENTOS_DB.size() > 0 ? ESTABLECIMIENTOS_DB.lastKey() +1 : 1);
		
		ESTABLECIMIENTOS_DB.put(establecimiento.getId(), establecimiento);
		
		return establecimiento.getId();
	}

	@Override
	public Optional<Establecimiento> read(Long id) {
		return Optional.ofNullable(ESTABLECIMIENTOS_DB.get(id));
	}

	@Override
	public void update(Establecimiento establecimiento) {
	
		Long id = establecimiento.getId();
		
		if(!ESTABLECIMIENTOS_DB.containsKey(id)) {
			throw new IllegalStateException("El establecimiento " + id + " no existe. No se puede actualizar");
		}
		
		ESTABLECIMIENTOS_DB.replace(id, establecimiento);
		
	}

	@Override
	public List<Establecimiento> getAll() {
		return new ArrayList<>(ESTABLECIMIENTOS_DB.values());
	}

	@Override
	public List<Establecimiento> getByNombreLike(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Establecimiento> getByPoblacionLike(String poblacion) {
		// TODO Auto-generated method stub
		return null;
	}

	// ************************************************************************
	//
	// Private Methods
	//
	// ************************************************************************
	
	private void initObjects() {
		
		DatosContacto dc1 = new DatosContacto();
		Direccion d1 = new Direccion();
		
		dc1.setEmail("granvia@flashware.com");
		dc1.setTelefonoFijo("93 2203310");
		dc1.setTelefonoMovil("6298971");
		
		d1.setDireccion("Gran Via de Les Corts Catalanes, 240");
		d1.setPoblacion("Barcelona");
		d1.setCodigoPostal("08020");
		d1.setProvincia("Barcelona");
		d1.setPais("España");
		
		Establecimiento e1 = new Establecimiento();
		e1.setId(1000L);
		e1.setNombre("GRAN VIA 2");
		e1.setDatosContacto(dc1);
		e1.setDireccion(d1);
		
		DatosContacto dc2 = new DatosContacto();
		Direccion d2 = new Direccion();
		
		dc2.setEmail("vaguada@flashware.com");
		dc2.setTelefonoFijo("91 2274040");
		dc2.setTelefonoMovil("684505050");
		
		d2.setDireccion("c/ Palacios, 23");
		d2.setPoblacion("Madrid");
		d2.setCodigoPostal("89667");
		d2.setProvincia("Madrid");
		d2.setPais("España");
		
		Establecimiento e2 = new Establecimiento();
		e2.setId(1001L);
		e2.setNombre("VAGUADA");
		e2.setDatosContacto(dc2);
		e2.setDireccion(d2);
		
		ESTABLECIMIENTOS_DB.put(e1.getId(), e1);
		ESTABLECIMIENTOS_DB.put(e2.getId(), e2);
	
	}
	
}
