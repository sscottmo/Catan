package fr.formation.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.formation.Classe.Carte;
import fr.formation.Classe.CarteDev;

public class DAOCarte extends DAOConnectionSQL implements IDAOCarte {

	@Override
	public List<Carte> findAll() {
		// TODO Auto-generated method stub
		List<Carte> listProduit = new ArrayList<Carte>();
		
		try {
			if (connection != null) {
				Statement myStatement = connection.createStatement();
				ResultSet myResult = myStatement.executeQuery("SELECT * FROM carte");

				while (myResult.next()) {
					try {
						Carte carte = new Carte();
						carte.setId(myResult.getInt("CARTE_ID"));
						carte.setCarteDev(Enum.valueOf(CarteDev.class, myResult.getString("CARTE_CARTEDEV")));
											
						
						listProduit.add(carte);
					}	
					catch (SQLException e) {
						System.out.println("ERREUR !");
						e.printStackTrace();
					}
				}
				return listProduit;
			}
		}

		catch (SQLException e) {
			System.out.println("Pbm !");
			e.printStackTrace();
		}
		return null;
		
	}


	@Override
	public Carte findById(int id) {
		// TODO Auto-generated method stub
		try {
			if (connection != null) {
				Statement myStatement = connection.createStatement();
				ResultSet myResult = myStatement.executeQuery("SELECT * FROM CARTE");

				while (myResult.next()) {
					try {
						int carteId = myResult.getInt("CARTE_ID");
						if (carteId == id) {
							Carte carte = new Carte();
							carte.setCarteDev(Enum.valueOf(CarteDev.class, myResult.getString("CARTE_CARTEDEV")));
							carte.setId(myResult.getInt("CARTE_ID"));
							return carte;
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
	public Carte save(Carte entity) {
		// TODO Auto-generated method stub
		try {
			connection.setAutoCommit(false);
			PreparedStatement myNewStatement;
			if (entity.getId() == 0) {
				myNewStatement = connection.prepareStatement("INSERT INTO carte (CARTE_CARTEDEV) VALUES (?)");
			} else {
				myNewStatement = connection.prepareStatement("UPDATE carte SET CARTE_CARTEDEV = ? WHERE CARTE_ID = ?");
				myNewStatement.setInt(2,entity.getId());
			}
			myNewStatement.setString(1, entity.getCarteDev().name());
			
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
				PreparedStatement statement = connection.prepareStatement("DELETE FROM carte WHERE CARTE_ID = ?");
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
	public void delete(Carte entity) {
		// TODO Auto-generated method stub
		this.deleteById(entity.getId());
		
	}


}
