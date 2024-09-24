package com.sinensia.flashware.backend.business.services.dummy.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import com.sinensia.flashware.backend.business.model.DatosContacto;
import com.sinensia.flashware.backend.business.model.Direccion;
import com.sinensia.flashware.backend.business.model.Tecnico;
import com.sinensia.flashware.backend.business.services.TecnicoServices;

@Service
public class TecnicoDummyServicesImpl implements TecnicoServices{

	private final TreeMap<Long, Tecnico> TECNICOS_DB = new TreeMap<>();
	
	public TecnicoDummyServicesImpl() {
		initObjects();
	}
	
	@Override
	public Long create(Tecnico tecnico) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tecnico> getAll() {
		return new ArrayList<>(TECNICOS_DB.values());
	}
	
	// ************************************************************************
	//
	// Private Methods
	//
	// ************************************************************************
	
	private void initObjects() {
		
		DatosContacto dc1 = new DatosContacto();
		Direccion d1 = new Direccion();
		
		dc1.setEmail("honorio.martin@flashware.com");
		dc1.setTelefonoFijo(null);
		dc1.setTelefonoMovil("689223211");
		
		d1.setDireccion("c/ Muntaner, 23 ático 2");
		d1.setPoblacion("Barcelona");
		d1.setCodigoPostal("08014");
		d1.setProvincia("Barcelona");
		d1.setPais("España");
		
		Tecnico t1 = new Tecnico();
		t1.setId(1000L);
		t1.setNombre("Honorio");
		t1.setApellidos("Martín Salvador");
		t1.setDNI("46002123R");
		t1.setDatosContacto(dc1);
		t1.setDireccion(d1);
		
		DatosContacto dc2 = new DatosContacto();
		Direccion d2 = new Direccion();
		
		dc2.setEmail("carlota.cifuentes@flashware.com");
		dc2.setTelefonoFijo("912209882");
		dc2.setTelefonoMovil("636762233");
		
		d2.setDireccion("c/ Pez Volador, 12 2º 4ª");
		d2.setPoblacion("Madrid");
		d2.setCodigoPostal("80923");
		d2.setProvincia("Madrid");
		d2.setPais("España");
		
		Tecnico t2 = new Tecnico();
		t2.setId(1000L);
		t2.setNombre("Carlota");
		t2.setApellidos("Cifuentes Merino");
		t2.setDNI("42908223T");
		t2.setDatosContacto(dc2);
		t2.setDireccion(d2);
		
		TECNICOS_DB.put(t1.getId(), t1);
		TECNICOS_DB.put(t2.getId(), t2);
	
	}	

}
