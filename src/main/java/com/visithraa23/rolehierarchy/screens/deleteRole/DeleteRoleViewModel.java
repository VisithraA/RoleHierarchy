package com.visithraa23.rolehierarchy.screens.deleteRole;

import com.visithraa23.rolehierarchy.repository.RoleRepository;

public class DeleteRoleViewModel {
	private DeleteRoleView deleteRoleView;
	private RoleRepository roleRepository;
	
	public DeleteRoleViewModel(DeleteRoleView view) {
		deleteRoleView=view;
		roleRepository=RoleRepository.getInstance();
	}

	public void deleteRole(String roleName, String transferRole) {
		roleRepository.deleteRole(roleName,transferRole);
	}

}
