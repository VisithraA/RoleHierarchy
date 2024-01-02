package com.visithraa23.rolehierarchy.screens.displayrole;

import java.util.List;

import com.visithraa23.rolehierarchy.dto.Role;
import com.visithraa23.rolehierarchy.repository.RoleRepository;

public class DisplayRoleViewModel {
	private DisplayRoleView displayRoleView;
	private RoleRepository repository;

	public DisplayRoleViewModel(DisplayRoleView view) {
		displayRoleView=view;
		repository=RoleRepository.getInstance();
	}

	public List<Role> displayRole() {
		List<Role> list = repository.displayRole();
		return list;
	}
}
