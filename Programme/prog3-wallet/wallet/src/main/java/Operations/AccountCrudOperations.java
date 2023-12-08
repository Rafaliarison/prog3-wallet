package Operations;

import Model.Account;
import Connection.DatabaseConnection;
import jakarta.el.PropertyNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AccountCrudOperations implements CrudOperations<Account> {
    DatabaseConnection dbConnection = new DatabaseConnection();
    Connection conn = dbConnection.getConnection();
    public Statement statement;
    @Override
    public List<Account> findAll() {
        List<Account> accountList = new ArrayList<>();
        try (Statement statement = conn.createStatement()) {
            String query = "SELECT account.id as account_id, name, currency_id, \"user\".id as user_id, username, email FROM account INNER JOIN \"user\" ON account.user_id = \"user\".id";
            try (ResultSet result = statement.executeQuery(query)) {
                while (result.next()) {
                    int account_id = result.getInt("account_id");
                    String account_name = result.getString("name");
                    int currency_id = result.getInt("currency_id");



                    Account account = new Account(account_id, account_name,currency_id);
                    accountList.add(account);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching users from the database", e);
        }
        return accountList;
    }

    @Override
    public List<Account> saveAll(List<Account> toSave) {
        List<Account> savedAccounts = new ArrayList<>();
        try {
            for (Account account : toSave) {
                String query = "INSERT INTO account (account.name, user_id, currency_id, type) VALUES (?, ?, ?)";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, account.getName());
                preparedStatement.setInt(2, account.getCurrency_id());
                preparedStatement.setString(3, account.getType());

                preparedStatement.executeUpdate();
                savedAccounts.add(account);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return savedAccounts;
    }

    @Override
    public Account save(Account toAdd) {
        try {
            String query = "INSERT INTO account (name, user_id, devise_id, type) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, toAdd.getName());
            preparedStatement.setInt(2, toAdd.getCurrency_id());
            preparedStatement.setString(3, toAdd.getType());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return toAdd;
    }

    @Override
    public Account update(Account toUpdate) {
        try {
            String updateQuery = "UPDATE account SET name=? WHERE id=?";
            PreparedStatement updateStatement = conn.prepareStatement(updateQuery);
            updateStatement.setString(1, toUpdate.getName());
            updateStatement.setInt(2, toUpdate.getAccount_id());
            updateStatement.executeUpdate();

            String selectQuery = "SELECT * FROM account WHERE id=?";
            PreparedStatement selectStatement = conn.prepareStatement(selectQuery);
            selectStatement.setInt(1, toUpdate.getAccount_id());

            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                Account updatedAccount = new Account();
                updatedAccount.setAccount_id(resultSet.getInt("id"));
                updatedAccount.setName(resultSet.getString("name"));
                updatedAccount.setUser_id(String.valueOf(UUID.fromString(resultSet.getString("user_id"))));
                updatedAccount.setCurrency_id(resultSet.getInt("currency_id"));

                System.out.println("Account updated");
                return updatedAccount;
            } else {
                throw new RuntimeException("Failed to retrieve updated account information.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account delete(Account toDelete) {
        return null;
    }


    @Override
    public Account getOne(Account one) throws PropertyNotFoundException {
        return null;
    }

    public Account getOne(int id) throws PropertyNotFoundException {
        try {
            String query = "SELECT account.id as id, name, currency_id, \"user\".id as user_id, username, email FROM account inner join \"user\" on account.user_id = \"user\".id WHERE account.id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setObject(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Account account = new Account();
                account.setAccount_id(resultSet.getInt("id"));
                account.setName(resultSet.getString("name"));
                account.setCurrency_id(resultSet.getInt("currency_id"));

                return account;
            } else {
                throw new PropertyNotFoundException("Account not found with id: " + id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
}
