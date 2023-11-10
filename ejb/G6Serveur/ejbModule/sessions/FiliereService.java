package sessions;

import java.util.List;



import dao.IDao;
import dao.IDaoLocal;
import entities.Filiere;
import entities.Role;
import entities.User;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless(name = "filiereS")
public class FiliereService implements IDao<Filiere>{
	@PersistenceContext 
	private EntityManager em;
	
	@Override
	public Filiere create(Filiere o) {
		em.persist(o);
		return o;
	}

	@Override
	public Filiere delete(Filiere o) {
		Filiere filiere = em.find(Filiere.class, o.getId());
		if(filiere != null) {
			em.remove(filiere);
		}
		return filiere;
	}

	@Override
	public Filiere update(Filiere o) {
		Filiere filiere = em.find(Filiere.class, o.getId());
		if(filiere != null) {
			filiere.setCode(filiere.getCode());
			filiere.setName(filiere.getName());
			em.merge(filiere);
			return filiere;
		}
		return null;
	}

	@Override
	public Filiere findById(int id) {
		Filiere filiere = em.find(Filiere.class, id);
		if(filiere == null) throw new RuntimeException("Role introuvable");
		return filiere;
	}

	@Override
	public List<Filiere> findAll() {
		Query query = em.createQuery("select f from Filiere f");
		return query.getResultList();
	}

}
