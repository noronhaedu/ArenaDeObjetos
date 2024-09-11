package servicos;

import dao.DAOFactory;
import dao.VitimaDAO;
import model.Pessoa;

public class VitimaServicos {
    public void cadastrarVitima(Pessoa vVO) {
        VitimaDAO vDAO = DAOFactory.geVitimaDAO();
        vDAO.cadastrarVitima(vVO);
    }
}
