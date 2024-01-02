package com.visithraa23.rolehierarchy.screens.displayuser;

import java.util.List;

import com.visithraa23.rolehierarchy.dto.User;
import com.visithraa23.rolehierarchy.repository.RoleRepository;

public class DisplayUserViewModel {
	private DisplayUserView displayUserView;
	private RoleRepository roleRepository;
	
	public DisplayUserViewModel(DisplayUserView view) {
		displayUserView=view;
		roleRepository=RoleRepository.getInstance();
	}

	public List<User> displayUsers() {
		return roleRepository.displayUsers();
	}

	public List<User> getSubUsers(String userName) {
		
		return roleRepository.getSubUsers(userName);
	}

}
