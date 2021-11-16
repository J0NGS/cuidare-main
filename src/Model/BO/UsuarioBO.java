package Model.BO;

import java.sql.*;
import java.util.*;

import Model.DAO.BaseDAO;
import Model.DAO.BaseInterDAO;
import Model.DAO.UsuarioDAO;
import Model.VO.UsuarioVO;

public class UsuarioBO<VO extends UsuarioVO> {

    static private BaseInterDAO<UsuarioVO> usuario_dao = new UsuarioDAO<UsuarioVO>();

    public UsuarioVO autenticar(UsuarioVO vo) {
        ResultSet usuario_rs = usuario_dao.buscarPorLogin(vo);
        try {
            
        } catch (Exception e) {
            //TODO: handle exception
        }

        return vo;
    }
}