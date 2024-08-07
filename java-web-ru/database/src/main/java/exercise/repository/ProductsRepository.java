package exercise.repository;

import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import exercise.dto.products.ProductPage;
import exercise.model.Product;

import java.sql.SQLException;
import java.sql.Statement;

public class ProductsRepository extends BaseRepository {

    // BEGIN
  //  private static List<Product> entities;
    public static void save(Product product) throws SQLException{
        String sql = "INSERT INTO products (title, price) VALUES (?, ?);";
        try (var conn = dataSource.getConnection();
                var preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, product.getTitle());
            preparedStatement.setString(2, String.valueOf(product.getPrice()));
            preparedStatement.executeUpdate();
            var generatedKeys = preparedStatement.getGeneratedKeys();

            if (generatedKeys.next()) {
                product.setId(generatedKeys.getLong(1));
            } else {
                throw new SQLException("DB have not returned an id after saving an entity");
            }
        }
        }

    public static Optional<Product> find(Long id) throws SQLException {
        String sql = "SELECT * FROM products WHERE id = ? ;";
        try (var conn = dataSource.getConnection();
            var preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                String title = resultSet.getString("title");
                int price = resultSet.getInt("price");
                Product product = new Product(title, price);
                product.setId(id);
                return Optional.of(product);
            }
            return Optional.empty();
    }

    }

    public static List<Product> getEntities() throws SQLException{
        String sql = "SELECT * FROM products;";
        try (var conn = dataSource.getConnection();
             var preparedStatement =conn.prepareStatement(sql);
             ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Product> result = new ArrayList<>();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String title = resultSet.getString("title");
                int price = resultSet.getInt("price");
                Product product = new Product(title, price);
                product.setId(id);
                result.add(product);
            }
            return result;
        }

    }

    // END
}
