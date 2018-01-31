package de.hdm.ITProjekt17.client.gui.report;



import java.util.Vector;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DatePicker;

import de.hdm.ITProjekt17.client.ClientsideSettings;
import de.hdm.ITProjekt17.shared.PartnerboerseAdministrationAsync;
import de.hdm.ITProjekt17.shared.ReportGeneratorAsync;
import de.hdm.ITProjekt17.shared.bo.Auswahleigenschaft;
import de.hdm.ITProjekt17.shared.bo.Freitexteigenschaft;
import de.hdm.ITProjekt17.shared.bo.Info;
import de.hdm.ITProjekt17.shared.bo.Profil;

import de.hdm.ITProjekt17.shared.bo.Profil.Geschlecht;
import de.hdm.ITProjekt17.shared.bo.Profil.Haarfarbe;
import de.hdm.ITProjekt17.shared.bo.Profil.Raucher;
import de.hdm.ITProjekt17.shared.report.HTMLReportWriter;

public class ReportOfAllAehnlicheProfilesBySuchprofilesSeite extends VerticalPanel{

	private static ReportGeneratorAsync rgPartnerboerse = ClientsideSettings.getReportGenerator();
	
//	private IdentitySelectionReport isreport = null;
//		
//		/**
//		 * Konstruktor, dem eine Instanz der IdentitySelectionReport und der Menubar übergeben wird.
//		 * @param identitySelectionReport
//		 */
//		
//		public public ReportOfAllAehnlicheProfilesBySuchprofilesSeite(IdentitySelectionReport isreport) {
//			this.isreport = isreport;
//		}
	
		protected String getHeadlineText() {
			// TODO Auto-generated method stub
			return "<h1>Report für alle ähnlihen Profiles anhand der angelegten Suchprofile</h1>";
		}
}
	
//		protected void run() {
//		final Showcase showcase = this;
//			
//			/**
//			 * Auslesen der ReportGeneratorAsync Instanz
//			 */		
//			ReportGeneratorAsync reportGenerator = ClientsideSettings.getReportGenerator();
//			
//			
//			/**
//			 * Bei erfolgreichem Callback werden alle Bewerbungen die auf eigene Ausschreibungen eingingen als
//			 * Report ausgegeben.
//			 */
//			reportGenerator.createReportOfAllAehnlicheProfilesBySuchprofilesSeite(isreport.getSelectedIdentityAsObjectReport(),
//					new AsyncCallback<ReportOfAllAehnlicheProfilesBySuchprofilesSeite>() {
//	
//						@Override
//						public void onFailure(Throwable caught) {
//							showcase.append("Fehler: "+ caught.getMessage());
//							
//						}
//	
//						@Override
//						public void onSuccess(ReportOfAllAehnlicheProfilesBySuchprofilesSeite result) {
//							if(result!= null){
//								
//								HTMLReportWriter writer = new HTMLReportWriter();
//							
//								writer.process(result);
//								
//								showcase.append(writer.getReportText());
//								}
//							
//						}
//					});
//			
//		}
	
//	private TextBox tbemail = new TextBox();
//	private TextBox tbvorname = new TextBox();
//	private TextBox tbnachname = new TextBox();
//	private DateBox geburtsdatum = new DateBox();
//	private ListBox lbhaarfarbe = new ListBox();
//	private TextBox tbreligion = new TextBox();
//	private TextBox tbkörpergröße = new TextBox();
//	private ListBox lbraucher = new ListBox();
//	private ListBox lbgeschlecht = new ListBox();
//	private TextBox tbfreitext = new TextBox();
//
//	
//	private ListBox lbinteresse = new ListBox();
//	private ListBox lbwohnsituation = new ListBox();	
//	private ListBox lbausbildung = new ListBox();
//	private ListBox lbkörperbau = new ListBox();
//	
//	private Label lb1 = new Label("Vorname: ");
//	private Label lb2 = new Label("Nachname: ");
//	private Label lb3 = new Label("Geburtsdatum: ");
//	private Label lb4 = new Label("Haarfarbe: ");
//	private Label lb5 = new Label("Religion: ");
//	private Label lb6 = new Label("Körpergröße: ");
//	private Label lb7 = new Label("Raucher: ");
//	private Label lb8 = new Label("Geschlecht: ");
//	private Label lb9 = new Label("Was du sonst noch über dich sagen willst:");
//	private Label lb10 = new Label("Interessiert an: ");
//	private Label lb11 = new Label("Wohnsituation: ");
//	private Label lb12 = new Label("Ausbildung: ");
//	private Label lb14 = new Label("Körperbau: ");
//	
//
//	
//	private Button ok = new Button("Bestätigen");
//	private Button abbrechen = new Button("Abbrechen");
//	private Button löschen = new Button ("löschen");
//	
//	private FlexTable ft1 = new FlexTable();
//	private FlexTable ft2 = new FlexTable();
//
//	private Profil p1 = new Profil();
//	
//	private VerticalPanel vpanel = new VerticalPanel();
//	private VerticalPanel vpanel2 = new VerticalPanel();
//	private HorizontalPanel hpanel = new HorizontalPanel();
//	
//	private Auswahleigenschaft a = new Auswahleigenschaft();
//	private Auswahleigenschaft b = new Auswahleigenschaft();
//	private Auswahleigenschaft c = new Auswahleigenschaft();
//	private Auswahleigenschaft d = new Auswahleigenschaft();
//	private Freitexteigenschaft e = new Freitexteigenschaft();
//	
//	
//	public ReportOfAllAehnlicheProfilesBySuchprofilesSeite(final String email){
//		Window.alert("Willkommen auf MOFOS. Tragen Sie bitte nachfolgend die Daten zu Ihrer Person ein.");
//		
//		ft1.setWidget(1, 0, lb1);
//		ft1.setWidget(1, 1, tbvorname);
//		ft1.setWidget(2, 0, lb2);
//		ft1.setWidget(2, 1, tbnachname);
//		ft1.setWidget(3, 0, lb8);
//		ft1.setWidget(3, 1, lbgeschlecht);
//		ft1.setWidget(4, 0, lb3);
//		ft1.setWidget(4, 1, geburtsdatum);
//		ft1.setWidget(5, 0, lb4);
//		ft1.setWidget(5, 1, lbhaarfarbe);
//		ft1.setWidget(6, 0, lb5);
//		ft1.setWidget(6, 1, tbreligion);
//		ft1.setWidget(7, 0, lb6);
//		ft1.setWidget(7, 1, tbkörpergröße);
//		ft1.setWidget(8, 0, lb7);
//		ft1.setWidget(8, 1, lbraucher);
//		ft1.setWidget(9, 0, ok);
//		ft1.setWidget(9, 1, abbrechen);
//		
//		ft2.setWidget(0, 0, lb10);
//		ft2.setWidget(0, 1, lbinteresse);
//		ft2.setWidget(1, 0, lb11);
//		ft2.setWidget(1, 1, lbwohnsituation);
//		ft2.setWidget(2, 0, lb12);
//		ft2.setWidget(2, 1, lbausbildung);
//		ft2.setWidget(4, 0, lb14);
//		ft2.setWidget(4, 1, lbkörperbau);
//		ft2.setWidget(5, 0, lb9);
//		ft2.setWidget(6, 0, tbfreitext);
//			
//		tbfreitext.setPixelSize(225, 150);
//
//		vpanel.add(ft1);
//		vpanel2.add(ft2);
//		hpanel.add(vpanel);
//		hpanel.add(vpanel2);
//
//		this.add(hpanel);
//		
//		//Interesse
//				if(lbinteresse.getSelectedIndex()==0){
//					a.setWert("Frauen");
//				}
//				else if(lbinteresse.getSelectedIndex()==1){
//					a.setWert("Männer");
//				}
//				else if(lbinteresse.getSelectedIndex()==2){
//					a.setWert("Beides");
//				}
//				
//				//Wohnsituation
//				if(lbwohnsituation.getSelectedIndex()==0){
//					b.setWert("Bei den Eltern");
//				}
//				else if(lbwohnsituation.getSelectedIndex()==1){
//					b.setWert("Alleine");
//				}
//				else if(lbwohnsituation.getSelectedIndex()==2){
//					b.setWert("In einer WG");
//				}
//				else if(lbwohnsituation.getSelectedIndex()==3){
//					b.setWert("Im Wohnheim");
//				}
//				
//				//Ausbildung
//				if(lbausbildung.getSelectedIndex()==0){
//					c.setWert("Kein Abschluss");
//				}
//				else if(lbausbildung.getSelectedIndex()==1){
//					c.setWert("Schüler");
//				}
//				else if(lbausbildung.getSelectedIndex()==2){
//					c.setWert("Student");
//				}
//				else if(lbausbildung.getSelectedIndex()==3){
//					c.setWert("Absolvent");
//				}
//						
//				//Körperbau
//				if(lbkörperbau.getSelectedIndex()==0){
//					d.setWert("dünn");
//				}
//				else if(lbkörperbau.getSelectedIndex()==1){
//					d.setWert("durchschnittlich");
//				}
//				else if(lbkörperbau.getSelectedIndex()==2){
//					d.setWert("sportlich");
//				}
//				else if(lbkörperbau.getSelectedIndex()==3){
//					d.setWert("muskulös");
//				}
//				else if(lbkörperbau.getSelectedIndex()==4){
//					d.setWert("mollig");
//				}
//				else if(lbkörperbau.getSelectedIndex()==5){
//					d.setWert("dick");
//				}
//			
//		//ListBox Raucher befüllen.
//		
//		Raucher b1 = Raucher.A;
//		Raucher b2 = Raucher.B;
//		Raucher b3 = Raucher.C;
//		Raucher b4 = Raucher.D;
//		Raucher b5 = Raucher.E;
//	      lbraucher.addItem(Profil.word(b1));
//	      lbraucher.addItem(Profil.word(b2));
//	      lbraucher.addItem(Profil.word(b3));
//	      lbraucher.addItem(Profil.word(b4));
//	      lbraucher.addItem(Profil.word(b5));
//		  
//		//ListBox Geschlecht befüllen.
//		Geschlecht c1 = Geschlecht.m;
//		Geschlecht c2 = Geschlecht.w;
//		Geschlecht c3 = Geschlecht.s;
//	      lbgeschlecht.addItem(Profil.word(c1));
//	      lbgeschlecht.addItem(Profil.word(c2));
//	      lbgeschlecht.addItem(Profil.word(c3));
//	      
//			//ListBox Haarfarbe befüllen.
//
//			Haarfarbe h1 = Haarfarbe.A;
//			Haarfarbe h2 = Haarfarbe.B;
//			Haarfarbe h3 = Haarfarbe.C;
//			Haarfarbe h4 = Haarfarbe.D;
//			Haarfarbe h5 = Haarfarbe.E;
//			  lbhaarfarbe.addItem(Profil.word(h1));
//			  lbhaarfarbe.addItem(Profil.word(h2));
//			  lbhaarfarbe.addItem(Profil.word(h3));
//			  lbhaarfarbe.addItem(Profil.word(h4));
//			  lbhaarfarbe.addItem(Profil.word(h5));
//
//		  
//		//ListBox Interesse befüllen.
//			
//	      lbinteresse.addItem("Frauen");
//	      lbinteresse.addItem("Männer");
//	      lbinteresse.addItem("Beides");	  
//	      
//			//ListBox Wohnsituation befüllen.
//			
//	      lbwohnsituation.addItem("Bei den Eltern");
//	      lbwohnsituation.addItem("Alleine");
//	      lbwohnsituation.addItem("In einer WG");
//	      lbwohnsituation.addItem("Im Wohnheim");
//
//			//ListBox Ausbildung befüllen.
//			
//	      lbausbildung.addItem("Kein Abschluss");
//	      lbausbildung.addItem("Schüler");
//	      lbausbildung.addItem("Student");
//	      lbausbildung.addItem("Absolvent");
//	      
//	      //ListBox Körperbau befüllen.
//	      
//	      lbkörperbau.addItem("dünn");     
//	      lbkörperbau.addItem("durchschnittlich");
//	      lbkörperbau.addItem("sportlich");
//	      lbkörperbau.addItem("muskulös");
//	      lbkörperbau.addItem("mollig");
//	      lbkörperbau.addItem("dick");
//		
//		// Create a date picker
//			final DatePicker datepicker_geburtsdatum = new DatePicker();
//			geburtsdatum.setFormat(new DateBox.DefaultFormat(DateTimeFormat.getFormat("dd-MM-yyyy")));
//			geburtsdatum.getDatePicker().setYearArrowsVisible(true);
//			geburtsdatum.getDatePicker().setYearAndMonthDropdownVisible(true);
//			geburtsdatum.getDatePicker().setVisibleYearCount(10);
//
//		 // Set the value in the text box when the user selects a date
////			datepicker_geburtsdatum.addValueChangeHandler(new ValueChangeHandler<Date>(){
////
////				@Override
////				public void onValueChange(ValueChangeEvent<Date> event) {
////					Date date = event.getValue();
////		            String dateString = df.format(date);
////		                    DateTimeFormat.getFormat("MM/dd/yyyy").format(date);
////		                    text.setText(dateString);
////		                 
////				}
////			});
//			
////		    datepicker_geburtsdatum.setValue(new Date(), true);
//		   
//		    
//		    ok.addClickHandler(new ClickHandler(){
//
//				@Override
//				public void onClick(ClickEvent event) {
//					pbverwaltung.createProfil(email, tbvorname.getValue(), tbnachname.getValue(), geburtsdatum.getValue(), 
//							Integer.parseInt(tbkörpergröße.getValue()),
//							tbreligion.getValue(), lbhaarfarbe.getSelectedValue(), lbraucher.getSelectedValue(), lbgeschlecht.getSelectedValue(), new AsyncCallback<Profil>(){
//					
//								@Override
//								public void onFailure(Throwable caught) {
//									// TODO Auto-generated method stub
//							Window.alert("Fehlerhafte Eingabe");		
//								}
//
//								@Override
//								public void onSuccess(Profil result) {
//									p1 = result;
//									
//									
//								}
//					});
//					
//					Window.alert("Sie haben sich erfolgreich mit folgender E-Mail angemeldet: " + email);
//					pbverwaltung.createInfo(email, 1, "", lbinteresse.getSelectedValue(), new AsyncCallback<Info>(){
//
//						@Override
//						public void onFailure(Throwable caught) {
//							// TODO Auto-generated method stub
//							
//						}
//
//						@Override
//						public void onSuccess(Info result) {
//							pbverwaltung.createInfo(email, 2, "", lbwohnsituation.getSelectedValue(), new AsyncCallback<Info>(){
//
//								@Override
//								public void onFailure(Throwable caught) {
//									// TODO Auto-generated method stub
//									
//								}
//
//								@Override
//								public void onSuccess(Info result) {
//									pbverwaltung.createInfo(email, 3, "", lbausbildung.getSelectedValue(), new AsyncCallback<Info>(){
//
//										@Override
//										public void onFailure(Throwable caught) {
//											// TODO Auto-generated method stub
//											
//										}
//
//										@Override
//										public void onSuccess(Info result) {
//											pbverwaltung.createInfo(email, 4, "", lbkörperbau.getSelectedValue(), new AsyncCallback<Info>(){
//
//												@Override
//												public void onFailure(Throwable caught) {
//													// TODO Auto-generated method stub
//													
//												}
//
//												@Override
//												public void onSuccess(Info result) {
//													pbverwaltung.createInfo(email, 5, tbfreitext.getValue(), "", new AsyncCallback<Info>(){
//
//														@Override
//														public void onFailure(Throwable caught) {
//															// TODO Auto-generated method stub
//															
//														}
//
//														@Override
//														public void onSuccess(Info result) {
//															RootPanel.get("Details").clear();
//															RootPanel.get("Details").add(new ReportOfAllAehnlicheProfilesBySuchprofilesSeite(p1));
//															RootPanel.get("Navigator").clear();
//															RootPanel.get("Navigator").add(new Menubar(p1));
//														}
//														
//													});
//													
//												}
//												
//											});
//										}
//										
//									});
//								}
//								
//							});
//							
//						}
//						
//					});
//				}
//				
//		    });
//				
//		RootPanel.get("Details").clear();
//		RootPanel.get("Details").add(this);
//	}
//	
//	
//	public ReportOfAllAehnlicheProfilesBySuchprofilesSeite(final Profil profil){
//		ft1.setWidget(1, 0, lb1);
//		ft1.setWidget(1, 1, tbvorname);
//		ft1.setWidget(2, 0, lb2);
//		ft1.setWidget(2, 1, tbnachname);
//		ft1.setWidget(3, 0, lb8);
//		ft1.setWidget(3, 1, lbgeschlecht);
//		ft1.setWidget(4, 0, lb3);
//		ft1.setWidget(4, 1, geburtsdatum);
//		ft1.setWidget(5, 0, lb4);
//		ft1.setWidget(5, 1, lbhaarfarbe);
//		ft1.setWidget(6, 0, lb5);
//		ft1.setWidget(6, 1, tbreligion);
//		ft1.setWidget(7, 0, lb6);
//		ft1.setWidget(7, 1, tbkörpergröße);
//		ft1.setWidget(8, 0, lb7);
//		ft1.setWidget(8, 1, lbraucher);
//		ft1.setWidget(9, 0, ok);
//		ft1.setWidget(9, 1, abbrechen);
//		ft1.setWidget(9, 2, löschen);
//
//		ft2.setWidget(0, 0, lb10);
//		ft2.setWidget(0, 1, lbinteresse);
//		ft2.setWidget(1, 0, lb11);
//		ft2.setWidget(1, 1, lbwohnsituation);
//		ft2.setWidget(2, 0, lb12);
//		ft2.setWidget(2, 1, lbausbildung);
//		ft2.setWidget(4, 0, lb14);
//		ft2.setWidget(4, 1, lbkörperbau);
//		ft2.setWidget(5, 0, lb9);
//		ft2.setWidget(6, 0, tbfreitext);
//		
//		tbfreitext.setPixelSize(250, 150);
//		
//		geburtsdatum.setFormat(new DateBox.DefaultFormat(DateTimeFormat.getFormat("dd-MM-yyyy")));
//        geburtsdatum.getDatePicker().setYearArrowsVisible(true);
//		geburtsdatum.getDatePicker().setYearAndMonthDropdownVisible(true);
//		geburtsdatum.getDatePicker().setVisibleYearCount(100);
//		
//		
//		//ListBox Raucher befüllen.
//		
//		Raucher b1 = Raucher.A;
//		Raucher b2 = Raucher.B;
//		Raucher b3 = Raucher.C;
//		Raucher b4 = Raucher.D;
//		Raucher b5 = Raucher.E;
//	      lbraucher.addItem(Profil.word(b1));
//	      lbraucher.addItem(Profil.word(b2));
//	      lbraucher.addItem(Profil.word(b3));
//	      lbraucher.addItem(Profil.word(b4));
//	      lbraucher.addItem(Profil.word(b5));
//		  
//		//ListBox Geschlecht befüllen.
//
//			Geschlecht c1 = Geschlecht.m;
//			Geschlecht c2 = Geschlecht.w;
//			Geschlecht c3 = Geschlecht.s;
//		      lbgeschlecht.addItem(Profil.word(c1));
//		      lbgeschlecht.addItem(Profil.word(c2));
//		      lbgeschlecht.addItem(Profil.word(c3));
//		      
//		//ListBox Haarfarbe befüllen.
//
//			Haarfarbe h1 = Haarfarbe.A;
//			Haarfarbe h2 = Haarfarbe.B;
//			Haarfarbe h3 = Haarfarbe.C;
//			Haarfarbe h4 = Haarfarbe.D;
//			Haarfarbe h5 = Haarfarbe.E;
//			  lbhaarfarbe.addItem(Profil.word(h1));
//			  lbhaarfarbe.addItem(Profil.word(h2));
//			  lbhaarfarbe.addItem(Profil.word(h3));
//			  lbhaarfarbe.addItem(Profil.word(h4));
//			  lbhaarfarbe.addItem(Profil.word(h5));
//
//	      
//			//ListBox Interesse befüllen.
//			
//	      lbinteresse.addItem("Frauen");
//	      lbinteresse.addItem("Männer");
//	      lbinteresse.addItem("Beides");	  
//	      
//			//ListBox Wohnsituation befüllen.
//			
//	      lbwohnsituation.addItem("Bei den Eltern");
//	      lbwohnsituation.addItem("Alleine");
//	      lbwohnsituation.addItem("In einer WG");
//	      lbwohnsituation.addItem("Im Wohnheim");
//
//			//ListBox Ausbildung befüllen.
//			
//	      lbausbildung.addItem("Kein Abschluss");
//	      lbausbildung.addItem("Schüler");
//	      lbausbildung.addItem("Student");
//	      lbausbildung.addItem("Absolvent");
//				      
//	      //ListBox Körperbau befüllen.
//	      
//	      lbkörperbau.addItem("dünn");     
//	      lbkörperbau.addItem("durchschnittlich");
//	      lbkörperbau.addItem("sportlich");
//	      lbkörperbau.addItem("muskulös");
//	      lbkörperbau.addItem("mollig");
//	      lbkörperbau.addItem("dick");
//		
//		tbemail.setValue(profil.getEmail());
//		tbvorname.setValue(profil.getVorname());
//		tbnachname.setValue(profil.getNachname());
//		geburtsdatum.setValue(profil.getGeburtsdatum());
//		tbreligion.setValue(profil.getReligion());
//		tbkörpergröße.setValue(String.valueOf(profil.getKoerpergroesse()));
//		
//
//		
//		//Raucher
//		if(profil.getRaucher()==Profil.word(b1)){
//			lbraucher.setSelectedIndex(0);
//		}
//		else if(profil.getRaucher()==Profil.word(b2)){
//			lbraucher.setSelectedIndex(1);
//		}
//		else if(profil.getRaucher()==Profil.word(b3)){
//			lbraucher.setSelectedIndex(2);
//		}else if(profil.getRaucher()==Profil.word(b4)){
//			lbraucher.setSelectedIndex(3);
//		}else if(profil.getRaucher()==Profil.word(b5)){
//			lbraucher.setSelectedIndex(4);
//		}
//		
//		
//		//Geschlecht
//		if(profil.getGeschlecht()==Profil.word(c1)){
//			lbgeschlecht.setSelectedIndex(0);
//		}
//		else if(profil.getGeschlecht()==Profil.word(c2)){
//			lbgeschlecht.setSelectedIndex(1);
//		}
//		else if(profil.getGeschlecht()==Profil.word(c3)){
//			lbgeschlecht.setSelectedIndex(2);
//		}
//		
//		//Haarfarbe
//		if(profil.getHaarfarbe()==Profil.word(h1)){
//			lbhaarfarbe.setSelectedIndex(0);
//		}
//		else if(profil.getHaarfarbe()==Profil.word(h2)){
//			lbhaarfarbe.setSelectedIndex(1);
//		}
//		else if(profil.getHaarfarbe()==Profil.word(h3)){
//			lbhaarfarbe.setSelectedIndex(2);
//		}
//		else if(profil.getHaarfarbe()==Profil.word(h4)){
//			lbhaarfarbe.setSelectedIndex(3);
//		}
//		else if(profil.getHaarfarbe()==Profil.word(h5)){
//			lbhaarfarbe.setSelectedIndex(4);
//		}
//		
//		//Interesse
//		if(lbinteresse.getSelectedIndex()==0){
//			a.setWert("Frauen");
//		}
//		else if(lbinteresse.getSelectedIndex()==1){
//			a.setWert("Männer");
//		}
//		else if(lbinteresse.getSelectedIndex()==2){
//			a.setWert("Beides");
//		}
//		
//		//Wohnsituation
//		if(lbwohnsituation.getSelectedIndex()==0){
//			b.setWert("Bei den Eltern");
//		}
//		else if(lbwohnsituation.getSelectedIndex()==1){
//			b.setWert("Alleine");
//		}
//		else if(lbwohnsituation.getSelectedIndex()==2){
//			b.setWert("In einer WG");
//		}
//		else if(lbwohnsituation.getSelectedIndex()==3){
//			b.setWert("Im Wohnheim");
//		}
//		
//		//Ausbildung
//		if(lbausbildung.getSelectedIndex()==0){
//			c.setWert("Kein Abschluss");
//		}
//		else if(lbausbildung.getSelectedIndex()==1){
//			c.setWert("Schüler");
//		}
//		else if(lbausbildung.getSelectedIndex()==2){
//			c.setWert("Student");
//		}
//		else if(lbausbildung.getSelectedIndex()==3){
//			c.setWert("Absolvent");
//		}
//				
//		//Körperbau
//		if(lbkörperbau.getSelectedIndex()==0){
//			d.setWert("dünn");
//		}
//		else if(lbkörperbau.getSelectedIndex()==1){
//			d.setWert("durchschnittlich");
//		}
//		else if(lbkörperbau.getSelectedIndex()==2){
//			d.setWert("sportlich");
//		}
//		else if(lbkörperbau.getSelectedIndex()==3){
//			d.setWert("muskulös");
//		}
//		else if(lbkörperbau.getSelectedIndex()==4){
//			d.setWert("mollig");
//		}
//		else if(lbkörperbau.getSelectedIndex()==5){
//			d.setWert("dick");
//		}
//		
//		löschen.addClickHandler(new ClickHandler(){
//
//			@Override
//			public void onClick(ClickEvent event) {
//				pbverwaltung.delete(profil, new AsyncCallback<Void>(){
//
//					@Override
//					public void onFailure(Throwable caught) {
//						// TODO Auto-generated method stub
//						
//					}
//
//					@Override
//					public void onSuccess(Void result) {
//						Window.alert("Profil wurde erfolgreich gelöscht. Starten Sie die Seite neu.");
//						RootPanel.get("Navigator").clear();
//						RootPanel.get("Details").clear();
//					}
//					
//				});
//				
//			}
//			
//		});
//		abbrechen.addClickHandler(new ClickHandler(){
//
//			@Override
//			public void onClick(ClickEvent event) {
//			RootPanel.get("Details").clear();
//			RootPanel.get("Details").add(new ReportOfAllAehnlicheProfilesBySuchprofilesSeite(profil));
//				
//			}
//			
//		});
//		ok.addClickHandler(new ClickHandler(){
//
//			@Override
//			public void onClick(ClickEvent event) {
//				profil.setGeburtsdatum(geburtsdatum.getValue());
//				profil.setGeschlecht(lbgeschlecht.getSelectedValue());
//				profil.setHaarfarbe(lbhaarfarbe.getSelectedValue());
//				profil.setKoerpergroesse(Integer.parseInt(tbkörpergröße.getValue()));
//				profil.setNachname(tbnachname.getValue());
//				profil.setRaucher(lbraucher.getSelectedValue());
//				profil.setReligion(tbreligion.getValue());
//				profil.setVorname(tbvorname.getValue());
//				pbverwaltung.save(profil, new AsyncCallback<Void>(){
//
//					@Override
//					public void onFailure(Throwable caught) {
//						// TODO Auto-generated method stub
//						
//					}
//
//					@Override
//					public void onSuccess(Void result) {
//						
//						
//						}
//					
//				});	
//				pbverwaltung.getAllInfobyProfil(profil, new AsyncCallback<Vector<Info>>() {
//
//					@Override
//					public void onFailure(Throwable caught) {
//						// TODO Auto-generated method stub
//						
//					}
//
//					@Override
//					public void onSuccess(Vector<Info> result) {
//						for (Info info : result) {
//							switch (info.getAuswahleigenschaftid()) {
//							case 1: info.setAuswahleigenschaftWert(lbinteresse.getSelectedValue());
//							pbverwaltung.save(info, new AsyncCallback<Void>() {
//
//								@Override
//								public void onFailure(Throwable caught) {
//									// TODO Auto-generated method stub
//									
//								}
//
//								@Override
//								public void onSuccess(Void result) {
//									// TODO Auto-generated method stub
//									
//								}
//							});
//							break;
//							case 2: info.setAuswahleigenschaftWert(lbwohnsituation.getSelectedValue());
//							pbverwaltung.save(info, new AsyncCallback<Void>() {
//
//								@Override
//								public void onFailure(Throwable caught) {
//									// TODO Auto-generated method stub
//									
//								}
//
//								@Override
//								public void onSuccess(Void result) {
//									// TODO Auto-generated method stub
//									
//								}
//							});
//							break;
//							case 3: info.setAuswahleigenschaftWert(lbausbildung.getSelectedValue());
//							pbverwaltung.save(info, new AsyncCallback<Void>() {
//
//								@Override
//								public void onFailure(Throwable caught) {
//									// TODO Auto-generated method stub
//									
//								}
//
//								@Override
//								public void onSuccess(Void result) {
//									// TODO Auto-generated method stub
//									
//								}
//							});
//							break;
//							case 4: info.setAuswahleigenschaftWert(lbkörperbau.getSelectedValue());
//							pbverwaltung.save(info, new AsyncCallback<Void>() {
//
//								@Override
//								public void onFailure(Throwable caught) {
//									// TODO Auto-generated method stub
//									
//								}
//
//								@Override
//								public void onSuccess(Void result) {
//									// TODO Auto-generated method stub
//									
//								}
//							});
//								break;
//							case 5: info.setFreitexteigenschaftWert(tbfreitext.getValue());
//							pbverwaltung.save(info, new AsyncCallback<Void>() {
//
//								@Override
//								public void onFailure(Throwable caught) {
//									// TODO Auto-generated method stub
//									
//								}
//
//								@Override
//								public void onSuccess(Void result) {
//									RootPanel.get("Details").clear();
//									RootPanel.get("Details").add(new ReportOfAllAehnlicheProfilesBySuchprofilesSeite(profil));
//								}
//							});
//							break;
//							default:
//								break;
//							}
//							
//						}
//						
//					}
//					
//				});
//				
//			}
//			
//		});
//		
//	    pbverwaltung.getInfoIdByProfilId(profil, new AsyncCallback<Vector<Info>>() {
//			
//			@Override
//			public void onSuccess(Vector<Info> result) {
//				
//				for (Info info : result) {
//					
//					int o = info.getAuswahleigenschaftid();
//					
//					
//					switch (o) {
//					case 1: 
//						String wert = info.getAuswahleigenschaftWert();
//						switch (wert) {
//						case "Frauen":
//							lbinteresse.setSelectedIndex(0);
//							break;
//						case "Männer": lbinteresse.setSelectedIndex(1);
//							
//							break;
//
//						case "Beides": lbinteresse.setSelectedIndex(2);
//						break;
//						default:
//							break;
//						}
//						break;
//
//					case 2: 
//						String wert2 = info.getAuswahleigenschaftWert();
//						switch (wert2) {
//						
//						case "Bei den Eltern": lbwohnsituation.setSelectedIndex(0);
//							
//							break;
//							
//						case "Alleine": lbwohnsituation.setSelectedIndex(1);
//							break;
//						case "In einer WG": lbwohnsituation.setSelectedIndex(2);
//							break;
//						case "Im Wohnheim": lbwohnsituation.setSelectedIndex(3);
//						default:
//							break;
//						}
//						
//					case 3: 
//						String wert3 = info.getAuswahleigenschaftWert();
//						switch (wert3) {
//						case "Kein Abschluss": lbausbildung.setSelectedIndex(0);
//						break;
//						case "Schüler": lbausbildung.setSelectedIndex(1); break;
//						case "Student": lbausbildung.setSelectedIndex(2);
//						break;
//						case "Absolvent": lbausbildung.setSelectedIndex(3);
//							
//							break;
//
//						default:
//							break;
//						}
//						
//					case 4: 
//						String wert4 = info.getAuswahleigenschaftWert();
//						switch (wert4) {
//						case "dünn":
//							lbkörperbau.setSelectedIndex(0);
//							break;
//						case "durchschnittlich": 
//							lbkörperbau.setSelectedIndex(1);
//							break;
//						case "sportlich": lbkörperbau.setSelectedIndex(2);
//						break;
//						case "muskulös": lbkörperbau.setSelectedIndex(3);
//						break;
//						case "mollig": lbkörperbau.setSelectedIndex(4);
//						break;
//						case "dick": lbkörperbau.setSelectedIndex(5);
//						default:
//							break;
//						}
//					case 5:
//						tbfreitext.setValue(info.getFreitexteigenschaftWert());
//						
//					default:
//						break;
//					}
//					
//					
//					
//					
//				}
//				
//			}
//			
//			@Override
//			public void onFailure(Throwable caught) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
//		vpanel.add(ft1);
//		vpanel2.add(ft2);
//		hpanel.add(vpanel);
//		hpanel.add(vpanel2);
//
//		this.add(hpanel);
//	}
//}