package com.microlistics.wms;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import io.agroal.api.AgroalDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@ApplicationScoped
public class OracleService {
    @Inject
    AgroalDataSource dataSource;

    public String getDatabaseVersion() {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM v$version");
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
        return "No data";
    }

    // public List<String> getUserData() {
    //     List<String> results = new ArrayList<>();

    //     String query = "SELECT email FROM iw_web_user"; // Ganti dengan tabel dan kolom Anda
    //     try (Connection connection = dataSource.getConnection();
    //          PreparedStatement statement = connection.prepareStatement(query);
    //          ResultSet resultSet = statement.executeQuery()) {

    //         while (resultSet.next()) {
    //             results.add(resultSet.getString(1)); // Ambil kolom pertama
    //         }

    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         results.add("Error: " + e.getMessage());
    //     }

    //     return results;
    // }
}