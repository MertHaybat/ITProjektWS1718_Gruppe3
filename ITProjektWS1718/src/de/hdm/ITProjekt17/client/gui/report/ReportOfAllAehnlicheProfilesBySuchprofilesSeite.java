package de.hdm.ITProjekt17.client.gui.report;



import java.util.Vector;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.hdm.ITProjekt17.client.ClientsideSettings;
import de.hdm.ITProjekt17.shared.ReportGeneratorAsync;
import de.hdm.ITProjekt17.shared.bo.Aehnlichkeitsmass;
import de.hdm.ITProjekt17.shared.bo.Profil;
import de.hdm.ITProjekt17.shared.bo.Suchprofil;
import de.hdm.ITProjekt17.shared.report.HTMLReportWriter;
import de.hdm.ITProjekt17.shared.report.PartnervorschlaegeAnhandSuchprofilReport;



public class ReportOfAllAehnlicheProfilesBySuchprofilesSeite extends HTMLResultPanel{
	
	ReportGeneratorAsync reportverwaltung = ClientsideSettings.getReportGenerator();
	
	public ReportOfAllAehnlicheProfilesBySuchprofilesSeite(final Profil pro){
		Aehnlichkeitsmass a = new Aehnlichkeitsmass();
		a.setEigenes_profilid(pro.getId());
		reportverwaltung.deleteAehnlichkeitsmass(a, new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Fehler beim Löschen des Ähnlichkeitsmaß" + caught.getLocalizedMessage());
			}

			@Override
			public void onSuccess(Void result) {
				reportverwaltung.createPartnervorschlaegeAnhandSuchprofilReport(pro, new AsyncCallback<PartnervorschlaegeAnhandSuchprofilReport>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(PartnervorschlaegeAnhandSuchprofilReport result) {
				
				if (result != null){
					HTMLReportWriter hrw = new HTMLReportWriter();
					hrw.process(result);
					append(hrw.getReportText());
					
				}
			}
		});
			}
		});
		
	}
		
}
	
