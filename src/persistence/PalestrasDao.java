package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Palestra;

public class PalestrasDao {

	private Connection c;
	
	public PalestrasDao() throws SQLException{
		GenericoDao gDao = new GenericoDao();
		c = gDao.getConnection();
	}
	
	public List<Palestra> consultaPalestraPorAluno(String ra) throws SQLException{
		List<Palestra> lista = new ArrayList<Palestra>();
		StringBuffer sql = new StringBuffer();
		sql.append("select p.ra, p.aluno, p.titulo as cod_titulo, t.titulo, CONVERT(CHAR(10), p.DATA, 103) AS DT, ");
		sql.append("CONVERT(CHAR(10), p.DATA, 108) AS HR, p.titulacao, p.palestrante, ");
		sql.append("p.tipo, p.curso, CAST(p.QUANT AS VARCHAR(2))+' '+p.UNIDADE AS DURACAO ");
		sql.append("from palestras$ p inner join titulo t ");
		sql.append("on p.titulo = t.codigo ");
		sql.append("where RA = ?  ");
		sql.append("order by DATA, TITULO ");
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ps.setString(1, ra);
		ResultSet rs = ps.executeQuery();
		while (rs.next()){
			Palestra p = new Palestra();
			p.setAluno(rs.getString("aluno"));
			p.setCurso(rs.getString("curso"));
			p.setDt(rs.getString("dt"));
			p.setDuracao(rs.getString("duracao"));
			p.setHr(rs.getString("hr"));
			p.setPalestrante(rs.getString("palestrante"));
			p.setRa(rs.getString("ra"));
			p.setTipo(rs.getString("tipo"));
			p.setTitulacao(rs.getString("titulacao"));
			p.setTitulo(rs.getString("titulo"));
			p.setCodTitulo(rs.getInt("cod_titulo"));
			lista.add(p);
		}
		rs.close();
		ps.close();
		return lista;
	}
	
	public String consultaTipoPalestra(int titulo) throws SQLException{
		StringBuffer sql = new StringBuffer();
		sql.append("select TIPO ");
		sql.append("from palestras$ ");
		sql.append("where TITULO = ? ");
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ps.setInt(1, titulo);
		ResultSet rs = ps.executeQuery();
		String tipo = "";
		if (rs.next()){
			tipo = rs.getString("TIPO");
		}
		rs.close();
		ps.close();
		return tipo;
	}
	
	public int consultaAnoPalestra(int titulo) throws SQLException{
		StringBuffer sql = new StringBuffer();
		sql.append("select YEAR(DATA) as ano ");
		sql.append("from palestras$ ");
		sql.append("where TITULO = ? ");
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ps.setInt(1, titulo);
		ResultSet rs = ps.executeQuery();
		int ano = 0;
		if (rs.next()){
			ano = rs.getInt("ano");
		}
		rs.close();
		ps.close();
		return ano;
	}
	
	public String consultaCursoPalestra(int titulo) throws SQLException{
		StringBuffer sql = new StringBuffer();
		sql.append("select CURSO ");
		sql.append("from palestras$ ");
		sql.append("where TITULO = ? ");
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ps.setInt(1, titulo);
		ResultSet rs = ps.executeQuery();
		String curso = "";
		if (rs.next()){
			curso = rs.getString("curso");
		}
		rs.close();
		ps.close();
		return curso;
	}
	
	public String consultaTituloPalestra(int titulo) throws SQLException{
		StringBuffer sql = new StringBuffer();
		sql.append("select titulo ");
		sql.append("from titulo ");
		sql.append("where codigo = ? ");
		PreparedStatement ps = c.prepareStatement(sql.toString());
		ps.setInt(1, titulo);
		ResultSet rs = ps.executeQuery();
		String tit = "";
		if (rs.next()){
			tit = rs.getString("titulo");
		}
		rs.close();
		ps.close();
		return tit;
	}
	
}
