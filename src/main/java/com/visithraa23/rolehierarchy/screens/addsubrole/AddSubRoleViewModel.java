package com.visithraa23.rolehierarchy.screens.addsubrole;


import com.visithraa23.rolehierarchy.repository.RoleRepository;

public class AddSubRoleViewModel {
	private AddSubRoleView addSubRoleView;
	private RoleRepository roleRepository;

	public AddSubRoleViewModel(AddSubRoleView view) {
		addSubRoleView = view;
		roleRepository = RoleRepository.getInstance();
	}

	public void addSubRole(String subRole, String reportingRole) {
		roleRepository.addSubRole(subRole,reportingRole);
	}
	

}
