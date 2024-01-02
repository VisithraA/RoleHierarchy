package com.visithraa23.rolehierarchy.screens.addsubrole;

import java.util.Scanner;


public class AddSubRoleView {
	private AddSubRoleViewModel addSubRoleViewModel;

	public AddSubRoleView() {
		addSubRoleViewModel = new AddSubRoleViewModel(this);
	}

	public void addSubRole() {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Sub Role name :");
		String subRole=sc.nextLine();
		System.out.print("Enter reporting to Role Name:");
		String reportingRole=sc.nextLine();
		addSubRoleViewModel.addSubRole(subRole,reportingRole);
	}
}
