package banking;

import org.sqlite.SQLiteConnection;
import org.sqlite.SQLiteDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CardDatabase {
    String name;
    BankSystem bankSystem;

    public CardDatabase(BankSystem bankSystem) {
        name = "cards.db";
        this.bankSystem = bankSystem;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void connect() {
        String url = "jdbc:sqlite:" + name;

        SQLiteDataSource dataSource = new SQLiteDataSource();
        dataSource.setUrl(url);

        try (Connection con = dataSource.getConnection()) {
            try (Statement statement = con.createStatement()) {
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS card(" +
                        "id INTEGER," +
                        "number TEXT," +
                        "pin TEXT," +
                        "balance INTEGER DEFAULT 0)");
                ResultSet resultSet = statement.executeQuery("SELECT * FROM card");
                while (resultSet.next()) {
                    String number = resultSet.getString("number");
                    String pin = resultSet.getString("pin");
                    int balance = resultSet.getInt("balance");
                    bankSystem.insertAccount(number, pin, balance);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addCard(String number, String pin) {
        String url = "jdbc:sqlite:" + name;

        SQLiteDataSource dataSource = new SQLiteDataSource();
        dataSource.setUrl(url);

        try (Connection con = dataSource.getConnection()) {
            try (Statement statement = con.createStatement()) {
                statement.executeUpdate(String.format("INSERT INTO card VALUES (%d, %s, %s, %d)", bankSystem.size(), number, pin, 0));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCard(String number) {
        String url = "jdbc:sqlite:" + name;

        SQLiteDataSource dataSource = new SQLiteDataSource();
        dataSource.setUrl(url);

        try (Connection con = dataSource.getConnection()) {
            try (Statement statement = con.createStatement()) {
                statement.executeUpdate(String.format("DELETE FROM card WHERE number = '%s'", number));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
