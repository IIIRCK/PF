
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConn{
    private Connection connection;
    private static Statement statement;

   static List<Producto> catalogo = new ArrayList<>();

    public DBConn()throws Exception
    {
        Class.forName("oracle.jdbc.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:30001/prueba","jumege","1234");
        statement = connection.createStatement();
    }

    public void select() throws Exception {
        String qry = "SELECT * FROM CATALOGO";
        PreparedStatement ps = connection.prepareStatement(qry);
        try {
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData md = rs.getMetaData();
            int columnCount = md.getColumnCount();

            // Print column names
            for (int i = 1; i <= columnCount; i++) {
                String columnName = md.getColumnName(i);
                System.out.print(columnName + "\t\t");
            }
            System.out.println();

            // Print data rows
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String columnValue = rs.getString(i);
                    System.out.print(columnValue + "\t\t");
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            ps.close();
        }
    }


    public void insert(String b) throws SQLException {
        String qry = "INSERT INTO PRUEBA (TXT) VALUES (?)";
        PreparedStatement ps = connection.prepareStatement(qry);
        try{
            ps.setString(1,b);
            ps.executeUpdate();
        }finally {
            ps.close();
        }
    }

    public void update(int a, String b) throws SQLException {
        String qry = "UPDATE PRUEBA SET TXT = ?  where id_prueba = ?";
        PreparedStatement ps = connection.prepareStatement(qry);
        try{
            ps.setString(1,b);
            ps.setInt(2,a);
            ps.executeUpdate();
        }finally {
            ps.close();
        }
    }
    public void close() throws Exception
    {
        statement.close();
        connection.close();
    }

    public void delete(int a ) throws SQLException {
        String qry = "DELETE FROM PRUEBA WHERE ID_PRUEBA = ? ";
        PreparedStatement ps = connection.prepareStatement(qry);
        try{
            ps.setInt(1,a);
            ps.executeUpdate();
        }finally {
            ps.close();
        }
    }

    public void fill_catalogo() throws SQLException{
        String qry = "SELECT  * FROM CATALOGO";
        PreparedStatement ps = connection.prepareStatement(qry);
        try{
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                catalogo.add(new Producto(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),new Producto.Categoria(rs.getString(5))));
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            ps.close();
        }
    }
    public void load_catalogo() throws SQLException{
        String qry = "INSERT INTO CATALOGO (ID_CATALOGO, NOMBRE, DESCRIPCION, PRECIO, CATEGORIA) VALUES (?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(qry);
        List<Producto> catalogo = Catalogo.get_productos();
        try{
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                 for ( Producto p: catalogo) {
                    ps.setInt(1,p.getId());
                    ps.setString(2,p.getNombre());
                    ps.setString(3,p.getMarca());
                ps.setInt(4,p.getPrecio());
                ps.setString(5,p.getCategoria().get_Nombre());

                 }

            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            ps.close();
        }
    }





    public static void println(String x){
        System.out.println(x);
    }

    public static void main(String[] args)throws Exception {
        DBConn m = new DBConn();
        ResultSet rs =  statement.executeQuery("SELECT * FROM CATALOGO");
        ResultSetMetaData md = rs.getMetaData();
        println(md.getColumnName(1)+" "+ md.getColumnName(2) +" "+ md.getColumnName(3) +" "+ md.getColumnName(4) +" "+ md.getColumnName(5));
        m.select();
        //m.insert("aaa");
        //m.select();
        //m.update(0,"ora");
        //m.select();
        //m.delete(3);
        //m.fill_catalogo();

        catalogo.forEach(p->{
            System.out.println(p.getId());
        });
        m.close();
    }
}