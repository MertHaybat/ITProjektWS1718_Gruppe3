package de.hdm.ITProjekt17.server.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import de.hdm.ITProjekt17.shared.bo.Profil;
import de.hdm.ITProjekt17.shared.bo.Suchprofil;

public class SuchprofilMapper {

	/**
	 * Die Klasse SuchprofilMapper wird nur einmal instantiiert. Man spricht 
	 * hierbei von einem sogenannten Singleton. Durch static nur einmal vorhanden.
	 * @see suchprofilMapper()
	 */
	
	private static SuchprofilMapper suchprofilMapper = null;
	
	/**
	 * Gesch�tzter Konstruktor - verhindet die M�glichkeit, mit "new" 
	 * neue Instanzen dieser Klasse zu erzeugen.
	 */
	protected SuchprofilMapper(){	
	}
	
	/**
	 * Kann aufgerufen werden durch SuchprofilMapper.suchprofilMapper. Sie stellt die
	 * Singleton-Eigenschaft sicher.
	 * @return Das "SuchprofilMapper-Objekt".
	 * @see SuchprofilMapper
	 */
	public static SuchprofilMapper suchprofilMapper(){
		if (suchprofilMapper == null){
			suchprofilMapper = new SuchprofilMapper();
		}
		
		return suchprofilMapper;
	}
	
		 
		 
		 public Suchprofil insertSuchprofil(Suchprofil such){
				/**
				 * Aufbau der DB Connection
				 */
				Connection con = DBConnection.connection();
				/**
				 * Try und Catch gehören zum Exception Handling 
				 * Try = Versuch erst dies 
				 * Catch = Wenn Try nicht geht versuch es so ..
				 */
				try {
				      Statement stmt = con.createStatement();
				      	/**
						 * Was ist der momentan höchste Primärschlüssel
						 */
				      ResultSet rs = stmt.executeQuery("SELECT MAX(id) AS maxid "
				              + "FROM suchprofil ");
				     	
				      if(rs.next()){
				    	  	/**
							 * Varaible merk erhält den höchsten Primärschlüssel inkrementiert um 1
							 */
				    	  	such.setId(rs.getInt("maxid") + 1);	    	  	
				    	  	/**
				    	  	 * Durchführen der Einfüge Operation via Prepared Statement
				    	  	 */
				    	  		PreparedStatement stmt1 = con.prepareStatement(
				    	  				"INSERT INTO suchprofil (id, minalter, maxalter, geburtsdatum, koerpergroesse, religion, haarfarbe, raucher) "
				    	  				+ "VALUES (?,?,?,?,?,?,?,?) ",
				    	  				Statement.RETURN_GENERATED_KEYS);
				    	  				stmt1.setInt(1, such.getId());
				    	  				stmt1.setInt(2, such.getMinAlter());
				    	  				stmt1.setInt(3, such.getMaxAlter());
				    	  				stmt1.setDate(4, (Date) such.getGeburtsdatum());
				    	  				stmt1.setInt(5, such.getKoerpergroesse());
				    	  				stmt1.setString(6, such.getReligion());
				    	  				stmt1.setString(7, such.getHaarfarbe());
				    	  				stmt1.setBoolean(8, such.getRaucher());
				    	  				
				    	  				
				    	  				stmt1.executeUpdate();
				      }
				}
				catch(SQLException e2){
					e2.printStackTrace();
				}
				return such;
				
			}
			/**
			 * Löschen des Objekt Suchprofil in der Datenbank
			 * @param pro
			 */
			public void deleteProfil(Suchprofil such) {
				/**
				 * Aufbau der DB Connection
				 */
			    Connection con = DBConnection.connection();
			    /**
				 * Try und Catch gehören zum Exception Handling 
				 * Try = Versuch erst dies 
				 * Catch = Wenn Try nicht geht versuch es so ..
				 */
			    try {
			    	/**
				      * Durchführung der Löschoperation
				      */
			     PreparedStatement stmt = con.prepareStatement("DELETE FROM profil " + "WHERE id= ? ");
			     stmt.setInt(1, such.getId());
			     stmt.executeUpdate();

			  
			    }
			    catch (SQLException e2) {
			      e2.printStackTrace();
			    }
			  }
			
			
			/**
			 * Erneutes schreiben in die Datenbank um das Profil Objekt zu aktualisieren
			 * @param pro
			 * @return pro
			 */
			 public Suchprofil updateProfil(Suchprofil such) {
				 	String sql = "UPDATE profil SET  minalter=?, maxalter=?, geburtsdatum=?, koerpergroesse=?, religion=?, haarfarbe=?, raucher=? WHERE id=?";
				 /**
				 	 * Aufbau der Db Connection
				 	 */
				    Connection con = DBConnection.connection();
				    /**
					 * Try und Catch gehören zum Exception Handling 
					 * Try = Versuch erst dies 
					 * Catch = Wenn Try nicht geht versuch es so ..
					 */
				    try {
				    
				    	PreparedStatement stmt = con.prepareStatement(sql);
				    	
				    	
				    	stmt.setInt(1, such.getMinAlter());
				    	stmt.setInt(2, such.getMaxAlter());
				    	stmt.setDate(3, (Date) such.getGeburtsdatum());
				    	stmt.setInt(4, such.getKoerpergroesse());
				    	stmt.setString(5, such.getReligion());
				    	stmt.setString(6, such.getHaarfarbe());
				    	stmt.setBoolean(7, such.getRaucher());

				    	stmt.setInt(8, such.getId());
				    	stmt.executeUpdate();
				    	
				    	System.out.println("Updated");
				   
				    }
				    catch (SQLException e2) {
				      e2.printStackTrace();
				    }

				    /**
				     *  Das Profil wird zurückgegeben
				     */
				    return such;
				  }
			 
			 	/**
				 * Mit der Methode GetAll werden alle Suchprofil in einem Ergebnis-Vektor namens Profil gespeichert und zurückgegeben
				 * @return
				 */
				 public Vector<Suchprofil> getAllProfil() {
					 
					 	/**
					 	 * Aufbau der DB Connection
					 	 */
					    Connection con = DBConnection.connection();
					  
					    Vector<Suchprofil> result = new Vector<Suchprofil>();
					    try {
					    	PreparedStatement stmt = con.prepareStatement("SELECT * FROM suchprofil ");
					    	
					      
					    	ResultSet rs = stmt.executeQuery();
					        
					        /**
					         * Für jeden Eintrag im Suchergebnis wird nun ein Profil-Objekt erstellt.
					         */
					        while (rs.next()) {
					          Suchprofil suchp = new Suchprofil();
					          suchp.setId(rs.getInt("id"));
					          suchp.setMinAlter(rs.getInt("minalter"));
					          suchp.setMaxAlter(rs.getInt("maxalter"));
					          suchp.setGeburtsdatum(rs.getDate("geburtsdatum"));
					          suchp.setKoerpergroesse(rs.getInt("koerpergroesse"));
					          suchp.setReligion(rs.getString("religion"));
					          suchp.setHaarfarbe(rs.getString("haarfarbe"));
					          suchp.setRaucher(rs.getBoolean("raucher"));
					          
					          /**
					           *  Hinzufügen des neuen Objekts zum Ergebnisvektor
					           */
					          result.addElement(suchp);
					        }
					      }
					      catch (SQLException e) {
					        e.printStackTrace();
					      }

					      /**
					       *  Ergebnisvektor zurückgeben
					       */
					      return result;
				 }
			 
			 
			 
			 
			 
			 
			 
			 // Nochmals anschaun......
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 /**
				 * Durch die Methode findByKey kann ein Suchprofil anhand seines Primärschlüssels zurückgegeben werden
				 * @param id
				 * @return
				 */
				public Suchprofil findByKey(int id){
					/**
					 * Aufbau einer Db Connection
					 */
					Connection con = DBConnection.connection();
					/**
					 * Try und Catch gehören zum Exception Handling 
					 * Try = Versuch erst dies 
					 * Catch = Wenn Try nicht geht versuch es so ..
					 */
					try{
						/**
						 * Erstellen eines leeren Statements
						 */
					Statement stmt = con.createStatement();		
					/**
					 * Auswahl alles (*) aus der Tabelle Suchprofil und das Ergebnis wird in der Variablen result gespeichert
					 */
					ResultSet rs = stmt.executeQuery("SELECT * FROM `suchprofil` WHERE `id` = " + id);
					
					if (rs.next()){
						/**
						 * Erstellen eines Suchprofil-Objektes und setzten der Werte 
						 */
						Suchprofil p = new Suchprofil();
						p.setId(rs.getInt("id"));
						p.setMinAlter(rs.getInt("minAlter"));
						p.setMaxAlter(rs.getInt("maxAlter"));
						p.setGeburtsdatum(rs.getDate("geburtsdatum"));
						p.setKoerpergroesse(rs.getInt("koerpergroesse"));
						p.setReligion(rs.getString("religion"));
						p.setHaarfarbe(rs.getString("haarfarbe"));
						p.setRaucher(rs.getBoolean("raucher"));
						
						/**
						 * Rückgabe des Suchprofils p 
						 */
						return p;
					}
				}
					catch (SQLException e2){
						e2.printStackTrace();
						return null;
					}

					return null;
				}	 
}