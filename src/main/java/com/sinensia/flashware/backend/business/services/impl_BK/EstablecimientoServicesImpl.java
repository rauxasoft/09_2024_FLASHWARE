package com.sinensia.flashware.backend.business.services.impl_BK;

public class EstablecimientoServicesImpl {

	/*
	
	@Autowired
	private EstablecimientoPLRepository establecimientoRepository;
	
	@Override
	@Transactional
	public Long create(Establecimiento establecimiento) throws BusinessException {
		
		if(establecimiento.getId() != null) {
			throw new BusinessException("El ID del establecimiento ha de ser NULL", true);
		}
		
		Long id = System.currentTimeMillis();
		establecimiento.setId(id);
		
		establecimientoRepository.save(establecimiento);
		
		return id;
	}

	@Override
	public Optional<Establecimiento> read(Long id) {
		return establecimientoRepository.findById(id);
	}

	@Override
	@Transactional
	public void update(Establecimiento establecimiento) throws BusinessException {

		Long id = establecimiento.getId();
		
		boolean existe = establecimientoRepository.existsById(id);
		
		if(!existe) {
			throw new BusinessException("El establecimiento " + id + " no existe. No se puede actualizar.", true);
		}
		
		establecimientoRepository.save(establecimiento);
		
	}

	@Override
	public List<Establecimiento> getAll() {
		return establecimientoRepository.findAll();
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
	
	*/

}
