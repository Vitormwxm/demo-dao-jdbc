import db.DB;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    // inserir dados
    DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

    Department department = departmentDao.findById(1);

    System.out.println(department);

}
