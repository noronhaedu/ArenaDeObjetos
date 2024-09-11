package dao;

public class DAOFactory {
    private static VitimaDAO vDao = new VitimaDAO();

    public static VitimaDAO geVitimaDAO() {
        return vDao;
    }
}
