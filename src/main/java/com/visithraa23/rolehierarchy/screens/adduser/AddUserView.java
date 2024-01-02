package com.visithraa23.rolehierarchy.screens.adduser;

import java.util.Scanner;

import com.visithraa23.rolehierarchy.dto.User;

public class AddUserView {

	private AddUserViewModel addUserViewModel;
	
	public AddUserView () {
		addUserViewModel=new AddUserViewModel(this);
	}

	public void addUser() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the User");
		String userName=sc.nextLine();
		System.out.println("Enter the Role");
		String role=sc.nextLine();
		addUserViewModel.addUser(userName,role);
	}
}
