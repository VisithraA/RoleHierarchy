package com.visithraa23.rolehierarchy.main;

import java.util.Scanner;

import com.visithraa23.rolehierarchy.screens.addsubrole.AddSubRoleView;
import com.visithraa23.rolehierarchy.screens.adduser.AddUserView;
import com.visithraa23.rolehierarchy.screens.deleteRole.DeleteRoleView;
import com.visithraa23.rolehierarchy.screens.displayrole.DisplayRoleView;
import com.visithraa23.rolehierarchy.screens.displayuser.DisplayUserView;

public class MainView {
	private MainViewModel mainViewModel;

	public MainView() {
		mainViewModel = new MainViewModel(this);
	}

	public void start() {
		Scanner scan = new Scanner(System.in);
		Boolean condition = true;
//		System.out.println("*********************Create the root role******************");
//		System.out.println("Enter the root role");
//		String rootRole=scan.nextLine();
//		mainViewModel.addRootRole(rootRole);
		do {
			System.out.println(
					"\nOperations:\n\t1.Add SubRole \n\t2.Display Role \n\t3.Delete Role \n\t4.Add User \n\t5.Display User \n\t6.Display User and SubUser\n\t0.exit");
			System.out.print("\nOperation to be Performed:");
			int operation = scan.nextInt();
			switch (operation) {
			case 1: {
				AddSubRoleView addSubRoleView = new AddSubRoleView();
				addSubRoleView.addSubRole();
				break;
			}
			case 2: {
				DisplayRoleView displayRoleView = new DisplayRoleView();
				displayRoleView.displayRole();
				break;
			}
			case 3: {
				DeleteRoleView deleteRoleView = new DeleteRoleView();
				deleteRoleView.deleteRole();
				break;
			}
			case 4: {
				AddUserView addUserView = new AddUserView();
				addUserView.addUser();
				break;
			}
			case 5: {
				DisplayUserView displayUserView = new DisplayUserView();
				displayUserView.displayUser();
				break;
			}
			case 6: {
				DisplayUserView displayUserView = new DisplayUserView();
				displayUserView.displayUserAndSubUser();
				break;
			}
			case 0: {
				condition = false;
				break;
			}
			default:
				System.out.println("Enter valid Input");
				break;
			}
		} while (condition);
		
	}

}
