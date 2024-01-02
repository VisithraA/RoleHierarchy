package com.visithraa23.rolehierarchy.screens.displayrole;

import java.util.List;

import com.visithraa23.rolehierarchy.dto.Role;

public class DisplayRoleView {
	private DisplayRoleViewModel displayRoleViewModel;
	
	public DisplayRoleView(){
		displayRoleViewModel=new DisplayRoleViewModel(this);
	}

	public void displayRole() {
		List<Role> list=displayRoleViewModel.displayRole();
		for(Role li:list) {
			System.out.print(li.getRoleName()+",");
		}
		System.out.println();
	}
}
