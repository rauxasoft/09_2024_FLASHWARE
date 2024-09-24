package com.sinensia.flashware.backend.business.services.dummy.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import com.sinensia.flashware.backend.business.config.BusinessException;
import com.sinensia.flashware.backend.business.model.Categoria;
import com.sinensia.flashware.backend.business.model.DatosContacto;
import com.sinensia.flashware.backend.business.model.Direccion;
import com.sinensia.flashware.backend.business.model.Establecimiento;
import com.sinensia.flashware.backend.business.model.EstadoPedido;
import com.sinensia.flashware.backend.business.model.LineaDetallePedido;
import com.sinensia.flashware.backend.business.model.Pedido;
import com.sinensia.flashware.backend.business.model.Producto;
import com.sinensia.flashware.backend.business.model.Tecnico;
import com.sinensia.flashware.backend.business.services.PedidoServices;

@Service
public class PedidoDummyServicesImpl implements PedidoServices{

	private final TreeMap<Long, Pedido> PEDIDOS_DB = new TreeMap<>();
	
	public PedidoDummyServicesImpl() {
		initObjects();
	}
	
	@Override
	public Long create(Pedido pedido) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Pedido> read(Long numero) {
		return Optional.ofNullable(PEDIDOS_DB.get(numero));
	}

	@Override
	public void update(Pedido producto) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long numero) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Pedido> getAll() {
		return new ArrayList<>(PEDIDOS_DB.values());
	}

	@Override
	public List<Pedido> getBetweenDates(Date desde, Date hasta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pedido> getByEstablecimiento(Long idEstablecimiento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNumeroTotalPedidos() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumeroTotalProductosByEstablecimiento(Long idEstablecimiento) {
		// TODO Auto-generated method stub
		return 0;
	}

	// ************************************************************************
	//
	// Private Methods
	//
	// ************************************************************************
	
	private void initObjects() {
		
		// *************** ESTABLECIMIENTOS **********************
		
		DatosContacto dc1 = new DatosContacto();
		Direccion d1 = new Direccion();
		
		dc1.setEmail("granvia@flashware.com");
		dc1.setTelefonoFijo("93 2203310");
		dc1.setTelefonoMovil("607363081");
		
		d1.setDireccion("Gran Via de Les Corts Catalanes, 240");
		d1.setPoblacion("Barcelona");
		d1.setCodigoPostal("08020");
		d1.setProvincia("Barcelona");
		d1.setPais("España");
		
		Establecimiento establecimiento1 = new Establecimiento();
		establecimiento1.setId(1000L);
		establecimiento1.setNombre("GRAN VIA 2");
		establecimiento1.setDatosContacto(dc1);
		establecimiento1.setDireccion(d1);
		
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
		
		Establecimiento establecimiento2 = new Establecimiento();
		establecimiento2.setId(1001L);
		establecimiento2.setNombre("VAGUADA");
		establecimiento2.setDatosContacto(dc2);
		establecimiento2.setDireccion(d2);
		
		// *************** PRODUCTOS **********************
		
		Producto p1 = new Producto();
		Producto p2 = new Producto();
		Producto p3 = new Producto();
		Producto p4 = new Producto();
		Producto p5 = new Producto();
		Producto p6 = new Producto();
		Producto p7 = new Producto();
		
		Date fecha1 = null;
		Date fecha2 = null;
		Date fecha3 = null;
		Date fecha4 = null;
		Date fecha5 = null;
		Date fecha6 = null;
		Date fecha7 = null;
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			fecha1 = sdf1.parse("01/11/2021");
			fecha2 = sdf1.parse("05/11/2021");
			fecha3 = sdf1.parse("05/11/2021");
			fecha4 = sdf1.parse("06/11/2021");
			fecha5 = sdf1.parse("08/11/2021");
			fecha6 = sdf1.parse("08/11/2021");
			fecha7 = sdf1.parse("11/11/2021");
			
		} catch (ParseException e) {
			
		}
		
		p1.setCodigo(100L);
		p1.setNombre("Alfombrilla Mouse R.Madrid");
		p1.setDescripcion("Fantástica alfombrilla...");
		p1.setCategoria(Categoria.CONSUMIBLE);
		p1.setPrecio(2.0);
		p1.setFechaAlta(fecha1);
		p1.setDescatalogado(true);
		
		p2.setCodigo(101L);
		p2.setNombre("Alfombrilla Mouse F.C.Barcelona");
		p2.setDescripcion("Fantástica alfombrilla...");
		p2.setCategoria(Categoria.CONSUMIBLE);
		p2.setPrecio(27.0);
		p2.setFechaAlta(fecha2);
		p2.setDescatalogado(false);
		
		p3.setCodigo(102L);
		p3.setNombre("Ordenador Epson D40");
		p3.setDescripcion("Fantástico ordenador...");
		p3.setCategoria(Categoria.HARDWARE);
		p3.setPrecio(560.0);
		p3.setFechaAlta(fecha3);
		p3.setDescatalogado(false);
		
		p4.setCodigo(103L);
		p4.setNombre("ContaNerd Deluxe");
		p4.setDescripcion("Fantástico programa de contabilidad...");
		p4.setCategoria(Categoria.SOFTWARE);
		p4.setPrecio(44.0);
		p4.setFechaAlta(fecha4);
		p4.setDescatalogado(false);
		
		p5.setCodigo(104L);
		p5.setNombre("Impresora Pluxton F14");
		p5.setDescripcion("Fantástic impresora...");
		p5.setCategoria(Categoria.HARDWARE);
		p5.setPrecio(140.0);
		p5.setFechaAlta(fecha5);
		p5.setDescatalogado(false);
		
		p6.setCodigo(105L);
		p6.setNombre("Cartucho impresora Pluxton Negro 2R");
		p6.setDescripcion("Fantástico cartucho...");
		p6.setCategoria(Categoria.CONSUMIBLE);
		p6.setPrecio(17.0);
		p6.setFechaAlta(fecha6);
		p6.setDescatalogado(false);
		
		p7.setCodigo(106L);
		p7.setNombre("Antivirus Caarsperky");
		p7.setDescripcion("Fantástico antivirus...");
		p7.setCategoria(Categoria.SOFTWARE);
		p7.setPrecio(18.0);
		p7.setFechaAlta(fecha7);
		p7.setDescatalogado(false);
		
		// *************** TECNICOS **********************
		
		DatosContacto dcTecnico = new DatosContacto();
		Direccion dTecnico = new Direccion();
		
		dcTecnico.setEmail("jose.galvez.tec@flashware.com");
		dcTecnico.setTelefonoFijo(null);
		dcTecnico.setTelefonoMovil("621447612");
		
		dTecnico.setDireccion("c/ Negreira, 23 4º 2ª");
		dTecnico.setPoblacion("Badalona");
		dTecnico.setCodigoPostal("08003");
		dTecnico.setProvincia("Barcelona");
		dTecnico.setPais("España");
		
		Tecnico tecnico = new Tecnico();
		tecnico.setId(892223L);
		tecnico.setDNI("42998121Y");
		tecnico.setNombre("Pepín");
		tecnico.setApellidos("Gálvez Ridruejo");
		tecnico.setDatosContacto(dcTecnico);
		tecnico.setDireccion(dTecnico);
		
		// *************** LINEAS_DETALLE ***************
		
		LineaDetallePedido ld1 = new LineaDetallePedido();
		LineaDetallePedido ld2 = new LineaDetallePedido();
		LineaDetallePedido ld3 = new LineaDetallePedido();
		LineaDetallePedido ld4 = new LineaDetallePedido();
		LineaDetallePedido ld5 = new LineaDetallePedido();
		
		ld1.setProducto(p3);
		ld1.setCantidad(1);
		ld1.setPrecio(p3.getPrecio());
		
		ld2.setProducto(p1);
		ld2.setCantidad(5);
		ld2.setPrecio(0);

		ld3.setProducto(p3);
		ld3.setCantidad(5);
		ld3.setPrecio(p3.getPrecio() - p3.getPrecio() * 0.15);
		
		ld4.setProducto(p2);
		ld4.setCantidad(10);
		ld4.setPrecio(p2.getPrecio());
		
		ld5.setProducto(p4);
		ld5.setCantidad(1);
		ld5.setPrecio(p4.getPrecio());
		
		List<LineaDetallePedido> lineas1 = Arrays.asList(ld1, ld2);
		List<LineaDetallePedido> lineas2 = Arrays.asList(ld3, ld4, ld5);
		
		// *************** PEDIDOS **********************
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Date fechaPedido1 = null;
		Date fechaPedido2 = null;
		
		try {
			fechaPedido1 = sdf2.parse("14/09/2024 17:12");
			fechaPedido2 = sdf2.parse("14/09/2024 17:44");
		} catch(Exception e) {
			
		}
		
		Pedido pedido1 = new Pedido();
		pedido1.setNumero(49892214L);
		pedido1.setFechaHora(fechaPedido1);
		pedido1.setEstablecimiento(establecimiento1);
		pedido1.setCliente(null);
		pedido1.setTecnico(tecnico);
		pedido1.setEstado(EstadoPedido.EN_PROCESO);
		pedido1.setLineas(lineas1);
		pedido1.setObservaciones(null);
		
		Pedido pedido2 = new Pedido();
		pedido2.setNumero(49892215L);
		pedido2.setFechaHora(fechaPedido2);
		pedido2.setEstablecimiento(establecimiento1);
		pedido2.setCliente(null);
		pedido2.setTecnico(tecnico);
		pedido2.setEstado(EstadoPedido.NUEVO);
		pedido2.setLineas(lineas2);
		pedido2.setObservaciones("Pasarán a recoger");
		
		PEDIDOS_DB.put(pedido1.getNumero(), pedido1);
		PEDIDOS_DB.put(pedido2.getNumero(), pedido2);
		
	}
}
