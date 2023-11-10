package sessions;

import java.util.List;


import dao.IDao;
import dao.IDaoLocal;
import entities.Role;
import entities.User;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless(name = "roleS")
public class RoleService implements IDao<Role>{
	@PersistenceContext 
	private EntityManager em;

	@Override
	public Role create(Role o) {
		em.persist(o);
		return o;
	}

	@Override
	public Role delete(Role o) {
		Role role = em.find(Role.class, o.getId());
		if(role != null) {
			em.remove(role);
		}
		return role;
	}

	@Override
	public Role update(Role o) {
		Role role = em.find(Role.class, o.getId());
		if(role != null) {
			role.setName(role.getName());
			role.setUser(role.getUser());
			em.merge(role);
			return role;
		}
		return null;
	}

	@Override
	public Role findById(int id) {
		Role role = em.find(Role.class, id);
		if(role == null) throw new RuntimeException("Role introuvable");
		return role;
	}

	@Override
	public List<Role> findAll() {
		Query query = em.createQuery("select r from Role r");
		return query.getResultList();
	}
}
