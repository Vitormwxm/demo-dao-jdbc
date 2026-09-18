import db.DB;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    // inserir dados
    SellerDao sellerDao = DaoFactory.createSellerDao();

    Seller seller = sellerDao.findById(3);

    System.out.println(seller);

    List<Seller> list = sellerDao.findByDepartment(new Department(2,null));
    for (Seller obj : list) {
        System.out.println(obj);
    }
}
