package com.visithraa23.rolehierarchy.main;

import java.util.List;

import com.visithraa23.rolehierarchy.repository.RoleRepository;

public class MainViewModel {

	private MainView mainView;
	private RoleRepository repository;

	public MainViewModel(MainView view) {
		mainView = view;
		repository = RoleRepository.getInstance();
	}

	public void addRootRole(String rootRole) {
		repository.addRootRole(rootRole);
	}

	

}
