package academy.softserve.sprint10;

/*
*
*Develop a database with tables Roles, Employee, Directions and Projects.
The Roles table contains the id (primary key), roleName.
The Directions table contains the id (primary key), directionName.
The Projects table contains id (primary key), projectName, directionId (foreign key).
The Employee table contains id (primary key), firstName, roleId (foreign key), projectId (foreign key).

Create next methods of the MyUtils class.
public Connection createConnection() throws SQLException
public void closeConnection() throws SQLException
public Statement createStatement() throws SQLException
public void closeStatement() throws SQLException
public void createSchema(String schemaName) throws SQLException
public void dropSchema() throws SQLException
public void useSchema() throws SQLException

Methods for creating tables
public void createTableRoles() throws SQLException
public void createTableDirections() throws SQLException
public void createTableProjects() throws SQLException
public void createTableEmployee() throws SQLException
public void dropTable(String tableName) throws SQLException

Methods for insert data to tables
public void insertTableRoles(String roleName) throws SQLException
public void insertTableDirections(String directionName) throws SQLException
public void insertTableProjects(String projectName, String directionName) throws SQLException
public void insertTableEmployee(String firstName, String roleName, String projectName) throws SQLException

Methods to obtaining data from tables
public int getRoleId(String roleName) throws SQLException
public int getDirectionId(String directionName) throws SQLException
public int getProjectId(String projectName) throws SQLException
public int getEmployeeId(String firstName) throws SQLException
public List<String> getAllRoles() throws SQLException
public List<String> getAllDirestion() throws SQLException
public List<String> getAllProjects() throws SQLException
public List<String> getAllEmployee() throws SQLException
public List<String> getAllDevelopers() throws SQLException
public List<String> getAllJavaProjects() throws SQLException
public List<String> getAllJavaDevelopers() throws SQLException

For example, for a given data

you should get by method getAllJavaDevelopers()
[Ira, Ivan, Petro].

*
*
* */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyUtils {
    private Connection connection;
    private Statement statement;
    private String schemaName;

    public Connection createConnection() throws SQLException {
        DriverManager.registerDriver(new org.h2.Driver());
        connection = DriverManager.getConnection("jdbc:h2:mem:test", "", "");
        return connection;
    }

    public void closeConnection() throws SQLException {
        // code
        connection.close();
    }

    public Statement createStatement() throws SQLException {
        // code
        statement = connection.createStatement();
        return statement;
    }

    public void closeStatement() throws SQLException {
        // code
        statement.close();
    }

    public void createSchema(String schemaName) throws SQLException {
        // code
        this.schemaName = schemaName;
        String sql = String.format("CREATE SCHEMA IF NOT EXISTS %s;", schemaName);
        statement.execute(sql);
    }

    public void dropSchema() throws SQLException {
        // code
        String sql = String.format("DROP SCHEMA IF EXISTS %s CASCADE;", this.schemaName);
        statement.execute(sql);
    }

    public void useSchema() throws SQLException {
        // code
        statement.execute(String.format("USE %s;", this.schemaName));
    }

    public void createTableRoles() throws SQLException {
        // code
        String sql = "CREATE TABLE IF NOT EXISTS Roles (" +
                "id int NOT NULL AUTO_INCREMENT," +
                "roleName varchar(255) NOT NULL," +
                "PRIMARY KEY (id));";
        statement.execute(sql);
    }

    public void createTableDirections() throws SQLException {
        // code
        String sql = "CREATE TABLE IF NOT EXISTS Directions (" +
                "id int NOT NULL AUTO_INCREMENT," +
                "directionName varchar(255) NOT NULL," +
                "PRIMARY KEY (id));";
        statement.execute(sql);
    }

    public void createTableProjects() throws SQLException {
        // code
        String sql = "CREATE TABLE IF NOT EXISTS Projects (" +
                "id int NOT NULL AUTO_INCREMENT," +
                "projectName varchar(255) NOT NULL," +
                "directionId int NOT NULL," +
                "PRIMARY KEY (id)," +
                "FOREIGN KEY (directionId) REFERENCES Directions(id));";
        statement.execute(sql);
    }

    public void createTableEmployee() throws SQLException {
        // code
        String sql = "CREATE TABLE IF NOT EXISTS Employee (" +
                "id int NOT NULL AUTO_INCREMENT," +
                "firstName varchar(255) NOT NULL," +
                "roleId int NOT NULL," +
                "projectId int NOT NULL," +
                "PRIMARY KEY (id)," +
                "FOREIGN KEY (roleId) REFERENCES Roles(id)," +
                "FOREIGN KEY (projectId) REFERENCES Projects(id));";
        statement.execute(sql);
    }

    public void dropTable(String tableName) throws SQLException {
        // code
        String sql = String.format("DROP TABLE %s;", tableName);
        statement.execute(sql);
    }

    public void insertTableRoles(String roleName) throws SQLException {
        // code
        String sql = "INSERT INTO Roles(roleName) VALUES(?);";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, roleName);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertTableDirections(String directionName) throws SQLException {
        // code
        String sql = "INSERT INTO Directions(directionName) VALUES(?);";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, directionName);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertTableProjects(String projectName, String directionName) throws SQLException {
        // code
        String sql = "INSERT INTO Projects(projectName, directionId) VALUES(?,?);";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, projectName);
            ps.setInt(2, getDirectionId(directionName));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertTableEmployee(String firstName, String roleName, String projectName) throws SQLException {
        // code
        String sql = "INSERT INTO Employee(firstName, roleId, projectId) VALUES(?,?,?);";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, firstName);
            ps.setInt(2, getRoleId(roleName));
            ps.setInt(3, getProjectId(projectName));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getRoleId(String roleName) throws SQLException {
        // code
        int result = -1;
        String sql = "SELECT ID from ROLES WHERE ROLENAME = ?;";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, roleName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int getDirectionId(String directionName) throws SQLException {
        // code
        int result = -1;
        String sql = "SELECT ID from DIRECTIONS WHERE DIRECTIONNAME = ?;";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, directionName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int getProjectId(String projectName) throws SQLException {
        // code
        int result = -1;
        String sql = "SELECT ID from PROJECTS WHERE PROJECTNAME = ?;";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, projectName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int getEmployeeId(String firstName) throws SQLException {
        // code
        int result = -1;
        String sql = "SELECT ID from EMPLOYEE WHERE firstName = ?;";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, firstName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<String> getAllRoles() throws SQLException {
        // code
        List<String> rolesList = new ArrayList<>();
        String sql = "SELECT roleName from ROLES;";
        try (ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                rolesList.add(rs.getString("roleName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rolesList;
    }

    public List<String> getAllDirestion() throws SQLException {
        // code
        List<String> directionList = new ArrayList<>();
        String sql = "SELECT directionName from Directions;";
        try (ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                directionList.add(rs.getString("directionName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return directionList;
    }

    public List<String> getAllProjects() throws SQLException {
        // code
        List<String> projectList = new ArrayList<>();
        String sql = "SELECT projectName from Projects;";
        try (ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                projectList.add(rs.getString("projectName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projectList;
    }

    public List<String> getAllEmployee() throws SQLException {
        // code
        List<String> employeeList = new ArrayList<>();
        String sql = "SELECT firstName from Employee;";
        try (ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                employeeList.add(rs.getString("firstName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public List<String> getAllDevelopers() throws SQLException {
        // code
        List<String> developersList = new ArrayList<>();
        String sql = "SELECT firstName from Employee WHERE roleId =?;";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, getRoleId("Developer"));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                developersList.add(rs.getString("firstName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return developersList;
    }

    public List<String> getAllJavaProjects() throws SQLException {
        // code
        List<String> projectsList = new ArrayList<>();
        String sql = "SELECT DISTINCT projectName from Projects WHERE directionId =?;";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, getDirectionId("Java"));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                projectsList.add(rs.getString("projectName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projectsList;
    }

    public List<String> getAllJavaDevelopers() throws SQLException {
        // code
        List<String> javaDevelopersList = new ArrayList<>();
        String sql = "SELECT e.firstName\n" +
                "from Employee e\n" +
                "         JOIN Projects p ON e.projectId = p.id\n" +
                "         JOIN Directions d ON p.directionId = d.id\n" +
                "         JOIN Roles r ON e.roleId = r.id\n" +
                "WHERE r.roleName = ? AND d.directionName = ?;";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, "Developer");
            ps.setString(2, "Java");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                javaDevelopersList.add(rs.getString("firstName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return javaDevelopersList;
    }
}


