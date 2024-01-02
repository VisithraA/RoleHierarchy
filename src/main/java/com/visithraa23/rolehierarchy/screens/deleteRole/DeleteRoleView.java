package com.visithraa23.rolehierarchy.screens.deleteRole;

import java.util.Scanner;

public class DeleteRoleView {

	private DeleteRoleViewModel deleteRoleViewModel;

	public DeleteRoleView() {
		deleteRoleViewModel = new DeleteRoleViewModel(this);
	}

	public void deleteRole() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Role to be deleted");
		String roleName = sc.nextLine();
		System.out.println("Enter the Role to be transferred");
		String transferRole = sc.nextLine();
		deleteRoleViewModel.deleteRole(roleName, transferRole);
	}
}
