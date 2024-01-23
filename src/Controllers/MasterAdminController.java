package Controllers;

import Model.User;

public class MasterAdminController {
    private AdminController adminController;

    public MasterAdminController(AdminController mainAdminController) {
        this.adminController = mainAdminController;
    }




    public void setAdmin(User user) {
        adminController.setUser(user);
    }


}
