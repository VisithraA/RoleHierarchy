package com.visithraa23.rolehierarchy.screens.adduser;

import com.visithraa23.rolehierarchy.repository.RoleRepository;

public class AddUserViewModel {

	private AddUserView addUserView;
	private RoleRepository roleRepository;

	public AddUserViewModel(AddUserView view) {
		addUserView = view;
		roleRepository = RoleRepository.getInstance();
	}

	public void addUser(String userName, String role) {
		roleRepository.addUser(userName,role);
	}

}
