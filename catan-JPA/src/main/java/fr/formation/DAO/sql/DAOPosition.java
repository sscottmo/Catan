package fr.formation.DAO.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import fr.formation.Classe.Position;
import fr.formation.Classe.Type;
import fr.formation.DAO.IDAOPosition;

public class DAOPosition extends DAOConnectionSQL implements IDAOPosition {

	@Override
	public List<Position> findAll() {
		// TODO Auto-generated method stub
		List<Position> listPosition = new ArrayList<Position>();
		
		try {
			if (connection != null) {
				Statement myStatement = connection.createStatement();
				ResultSet myResult = myStatement.executeQuery("SELECT * FROM position");

				while (myResult.next()) {
//					try {
//						Position position = new Position();
//						position.setId(myResult.getInt("POS_ID"));
//						position.setType(Enum.valueOf(Type.class, myResult.getString("POS_TYPE")));
//						position.setPos(myResult.getInt("POS_POS"));
//						position.setVal(myResult.getInt("POS_VALEUR"));
//											
//						
//						listPosition.add(position);
//					}	
//					catch (SQLException e) {
//						System.out.println("ERREUR !");
//						e.printStackTrace();
//					}
				}
				return listPosition;
			}
		}

		catch (SQLException e) {
			System.out.println("Pbm !");
			e.printStackTrace();
		}
		return null;
		
	}


	@Override
	public Position findById(int id) {
		// TODO Auto-generated method stub
		try {
			if (connection != null) {
				Statement myStatement = connection.createStatement();
				ResultSet myResult = myStatement.executeQuery("SELECT * FROM position");

				while (myResult.next()) {
					try {
						int posId = myResult.getInt("POS_ID");
						if (posId == id) {
							Position position = new Position();
							position.setId(myResult.getInt("POS_ID"));
							position.setType(Enum.valueOf(Type.class, myResult.getString("POS_TYPE")));
							position.setPos(myResult.getInt("POS_POS"));
							position.setVal(myResult.getInt("POS_VALEUR"));
							return position;
						}
						
					}	
					catch (SQLException e) {
						System.out.println("Libelle vide");
						e.printStackTrace();
					}
				}
				return null;
			}
		}
		catch (Exception e) {
			System.out.println("Pbm !");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Position save(Position entity) {
		// TODO Auto-generated method stub
		try {
			connection.setAutoCommit(false);
			PreparedStatement myNewStatement;
			if (entity.getId() == 0) {
			myNewStatement = connection.prepareStatement("INSERT INTO position (POS_POS, POS_VALEUR, POS_TYPE) VALUES (?,?,?)");
			} else {
				myNewStatement = connection.prepareStatement("UPDATE position SET POS_POS = ?, POS_VALEUR = ?, POS_TYPE = ? WHERE POS_ID = ?");
				myNewStatement.setInt(4,entity.getId());
			}
			myNewStatement.setInt(1, entity.getPos());
			myNewStatement.setInt(2, entity.getVal());
			myNewStatement.setString(3, entity.getType().name());
			
			myNewStatement.execute();
			connection.commit();
		}
		catch (SQLException e) {
			System.out.println("Erreur lors de l ajout");
			e.printStackTrace();
				
		}
		return entity;
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
		try {
			if (connection != null) {
				PreparedStatement statement = connection.prepareStatement("DELETE FROM position WHERE POS_ID = ?");
				statement.setInt(1, id);
				statement.execute();
		
			}
		}
		catch (SQLException e) {
			System.out.println("Pbm !");
			e.printStackTrace();
		}
	}



	@Override
	public void delete(Position entity) {
		// TODO Auto-generated method stub
		this.deleteById(entity.getId());
		
	}


	@Override
	public List<Type> listRand(int min, int max) {
		// TODO Auto-generated method stub
		return null;
	}


}
