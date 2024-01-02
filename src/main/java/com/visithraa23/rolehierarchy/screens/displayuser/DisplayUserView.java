package com.visithraa23.rolehierarchy.screens.displayuser;

import java.util.List;
import java.util.Scanner;

import com.visithraa23.rolehierarchy.dto.User;

public class DisplayUserView {
	private DisplayUserViewModel displayUserViewModel;

	public DisplayUserView() {
		displayUserViewModel = new DisplayUserViewModel(this);
	}

	public void displayUser() {
		List<User> users = displayUserViewModel.displayUsers();

		for (User u : users) {
			System.out.println(u.getUserName() + "-" + u.getRole().getRoleName());
		}
	}

	public void displayUserAndSubUser() {
		List<User> users = displayUserViewModel.displayUsers();

		for (User u : users) {

		}
	}

}
