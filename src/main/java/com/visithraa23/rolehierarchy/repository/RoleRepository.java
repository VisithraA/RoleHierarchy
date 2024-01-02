package com.visithraa23.rolehierarchy.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.visithraa23.rolehierarchy.dto.Role;
import com.visithraa23.rolehierarchy.dto.User;

public class RoleRepository {
	private static RoleRepository roleRepository;

	public static RoleRepository getInstance() {
		if (roleRepository == null) {
			roleRepository = new RoleRepository();
		}
		return roleRepository;
	}

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void addRootRole(String rootRole) {
		Role role = new Role();
		role.setRoleName(rootRole);
		role.setStatus("Active");
		entityTransaction.begin();
		entityManager.persist(role);
		entityTransaction.commit();
	}

	public void addSubRole(String subRole, String reportingRole) {
		Role role = new Role();
		role.setRoleName(subRole);
		role.setStatus("Active");
		role.setReportingRoleName(reportingRole);
		entityTransaction.begin();
		entityManager.persist(role);
		entityTransaction.commit();
	}

	public List<Role> displayRole() {
		List<Role> allRoles = new ArrayList<Role>();
		Queue<Role> roleQueue = new LinkedList<Role>();

		TypedQuery<Role> query = entityManager.createQuery(
				"SELECT r FROM Role r WHERE r.status = 'active' AND r.reportingRoleName IS NULL", Role.class);
		List<Role> topLevelRoles = query.getResultList();

		roleQueue.addAll(topLevelRoles);

		while (!roleQueue.isEmpty()) {
			Role currentRole = roleQueue.poll();
			allRoles.add(currentRole);

			TypedQuery<Role> subRolesQuery = entityManager.createQuery(
					"SELECT r FROM Role r WHERE r.status = 'active' AND r.reportingRoleName = :parentRole", Role.class);
			subRolesQuery.setParameter("parentRole", currentRole.getRoleName());
			List<Role> subRoles = subRolesQuery.getResultList();

			roleQueue.addAll(subRoles);
		}
		return allRoles;
	}

	public void deleteRole(String roleName, String transferRole) {

		entityTransaction.begin();
		Role roleToDelete = getRoleByName(roleName);
		if (roleToDelete != null) {
			roleToDelete.setStatus("InActive");
			entityManager.merge(roleToDelete);
			// Transfer subroles to a new parent
			List<Role> subRoles = getSubRoles(roleName);
			// System.out.println(subRoles.toString());
			transferSubRoles(subRoles, transferRole);
			entityTransaction.commit();
		} else {
			System.out.println("here  no role available");
		}

	}

	private void transferSubRoles(List<Role> subRoles, String transferRole) {
		for (Role subRole : subRoles) {
			subRole.setReportingRoleName(transferRole);
			entityManager.merge(subRole);
		}
	}

	private List<Role> getSubRoles(String roleName) {
		TypedQuery<Role> query = entityManager.createQuery(
				"SELECT r FROM Role r WHERE r.reportingRoleName = :roleName AND status=:status", Role.class);
		query.setParameter("roleName", roleName).setParameter("status", "Active");
		return query.getResultList();
	}

	private Role getRoleByName(String roleName) {
		TypedQuery<Role> query = entityManager
				.createQuery("SELECT r FROM Role r WHERE r.roleName = :roleName AND r.status = 'active'", Role.class);
		query.setParameter("roleName", roleName);
		return query.getResultList().stream().findFirst().orElse(null);
	}

	public void addUser(String userName, String roleName) {
		User user = new User();
		user.setUserName(userName);
		user.setStatus("Active");
		Role role = getRoleByName(roleName);
		user.setRole(role);
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
	}

	public List<User> displayUsers() {

		TypedQuery<User> query = entityManager
				.createQuery("SELECT u FROM User u JOIN FETCH u.role WHERE u.status = 'active'", User.class);

		return query.getResultList();
	}


	public List<User> getSubUsers(String userName) {
		
		return null;
	}

}
