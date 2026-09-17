import db.DB;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    // inserir dados

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    try {
        connection = DB.getConnection();

        preparedStatement = connection.prepareStatement(
                "INSERT INTO seller " + "(Name, email, BirthDate, BaseSalary, DepartmentId)" + "VALUES " + "(?, ? ,? , ? , ?)", preparedStatement.RETURN_GENERATED_KEYS
        );

        preparedStatement.setString(1, "Carl Purple");
        preparedStatement.setString(2, "carl@gmail.com");
        preparedStatement.setDate(3, java.sql.Date.valueOf(
                LocalDate.parse("22/04/1995", dateTimeFormatter)));
        preparedStatement.setDouble(4, 3000.0);
        preparedStatement.setInt(5, 4);

        int rowsAffected = preparedStatement.executeUpdate();

        if (rowsAffected > 0) {
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                System.out.println("Done! Id = " + id);
            }
        } else {
            System.out.println("No rows affected!");
        }

        System.out.println("Done! Rows affected " + rowsAffected);
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}
