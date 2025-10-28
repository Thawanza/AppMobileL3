package com.example.zinalanalyseme;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

public class RendezvousActivity extends Activity implements OnClickListener {
	
	Button prendrerdv ;
	EditText type , adresse , date , heure ;
	Spinner deplacement ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rendezvous);
		
		// recuperer le buuton 
		prendrerdv = (Button) findViewById(R.id.btnprise);
		
		//recuperer les edit text :
		type = (EditText) findViewById(R.id.etanalyse);
		type.setOnClickListener(this);
		
		adresse = (EditText) findViewById(R.id.etadresse);
		date = (EditText) findViewById(R.id.etdate);
		heure = (EditText) findViewById(R.id.etheure);
		
		// recuperer le spinner :
		deplacement = (Spinner) findViewById(R.id.spdeplacement);
		
		
		// ajouter un date picker :
		Calendar calendar = Calendar.getInstance();
		final int year = calendar.get(Calendar.YEAR);
		final int month = calendar.get(Calendar.MONTH);
		final int day = calendar.get(Calendar.DAY_OF_MONTH);

		date.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				DatePickerDialog datePickerDialog = new DatePickerDialog(
						RendezvousActivity.this,
						new DatePickerDialog.OnDateSetListener() {

							@Override
							public void onDateSet(DatePicker view, int year,
									int month, int day) {
								month = month + 1;
								String datee = day + "/" + month + "/" + year;
								date.setText(datee);
							}
						}, year, month, day);
				datePickerDialog.show();
			}
		});
		
		
		// ajouter un timepicker :

		

		heure.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Calendar calendar = Calendar.getInstance();
				int hours = calendar.get(calendar.HOUR_OF_DAY);
				int mins = calendar.get(Calendar.MINUTE);
				TimePickerDialog timePickerDialog = new TimePickerDialog(
						RendezvousActivity.this,
						new TimePickerDialog.OnTimeSetListener() {

							@Override
							public void onTimeSet(TimePicker view,
									int hourOfDay, int minute) {
								Calendar c = Calendar.getInstance();
								c.set(Calendar.HOUR_OF_DAY, hourOfDay);
								c.set(Calendar.MINUTE, minute);
								c.setTimeZone(TimeZone.getDefault());
								SimpleDateFormat format = new SimpleDateFormat(
										"k:mm a");
								String time = format.format(c.getTime());
								heure.setText(time);
							}
						}, hours, mins, false);
				timePickerDialog.show();
			}
		});
		
		
	}

	@Override
	public void onClick(View v) {
		if (v == type) {
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("Type d'analyse");

			final String[] items = {
					"Numération formule sanguine(fns)",
					"Glycemie",
					"Creatinine sanguine",
					"TSH",
					"Uree sanguine",
					"Crp",
					"proteine c reactive",
					"hemoglobine glyquee(HBa1c)",
					"Triglycerides",
					"Cholesterol TOTAL",
					"Cholesterol LDL",
					"Cholesterol HDL",
					"Transaminases (ASAT / ALAT)",
					"Ferritine",
					"25 hydroxy vitamine d ",
					"lonogramme snguin (NA+,K+,Cl)",
					"TP",
					"VS",
					"vitesse de sedimentation",
					"calcemie",
					"acide urique sanguin",
					"TCk (Temps de cephaline kaolin)",
					"Ft4",
					"phosphayase alcline",
					"Gamma Gt",
					"serologie HIV",
					"Bilirubine (Total+Directe)",
					"Hepatite C - anticorps anti-HCV",
					"Groupage sanguin",
					"Toxoplasmose igg",
					"ECB des urines",
					"TP+inr",
					"Toxoplasmose igm",
					"Ft3",
					"HepatiteB- antigene hbs",
					"Fer serique",
					"chimie des urines",
					"BW(Syphilis)",
					"Fibrinogene",
					"Phosphare sanguin",
					"D dimires",
					"RECHERCHE ARN DU SARS cov2 (RTPCR)",
					"Prolactine(PRL)",
					"VitamineB12(Cobalamine)",
					"Test antigénique SArs cov2",
					"Rubeole igg ",
					"anticorps anti TPO(anticorps anti thyroperoxydase)",
					"Rebeole igm",
					"Fsh",
					"Magnesium serique",
					"LH(hormone luteinisante humaine)",
					"Electrophorese des proteines serique(EPP)",
					"PSA totale",
					"Anticorps anti TG",
					"Oestradiol (E2)",
					"Albumine",
					"Beta HCG(BHCG)",
					"Microalbuminurie",
					"Pth intacte(hormone parathyroidienne)",
					"Proteinurie",
					"Testostrone",
					"Facteur rhumatoide",
					"Hepatite B - anticorps anti -HBs",
					"Hepatite B - anticorps anti -HBs Totaux",
					"Serologie Covid Igg /igm",
					"Clairance de la creatinine",
					"Cortisol seriue",
					"Vitamine b9(folates)",
					"Creatinine urinaire",
					"ASLO (anti streptolysines 0)",
					"Frottis sanguin",
					"FAN",
					"CPK",
					"Ldh",
					"AHM(Hormone anti mullerienne)",
					"PSA libre",
					"Anticorps anti CCP3",
					"ACE(antigene carcino embryonnaire)",
					"Coproparasitologie",
					"Trophonie",
					"Proteins totale(Protidemie)",
					"Ca19 9",
					"Delta 4 androstenedine",
					"17hydroxyprogestrone(17ohp)",
					"Glycemie post prandile(GPP)",
					"Progestrone",
					"TPHA(Treponema pallidum hemagglutination assay)",
					"Ca 125",
					"Lipase(lipsemie)",
					"Albuminurie",
					"Anticorps anti cardioliphine igG",
					"DHEA.s(sulfate de dehydroepiandrosterone)",
					"Anticorps anti cardiolipine igM",
					"Allergenes alimentaire igE Specifique:PanelAlimentaire",
					"Anticorps anti B2 glycoprotine igG",
					"Anticorps anti B2 glycoproteine igM",
					"Hepatite B-anticorps anti-HBC igm",
					"Homocysteine(L homocysteine)",
					"Allergenes respiratoire igE Specifique: Panel respiratoire",
					"VdRL",
					"acide urique urnies",
					"Ca 15 3",
					"Electrophoreses de hemoglobine(EPH)",
					"ACTH",
					"hormone adrenocorticotrophine",
					"CMV(Cytomegalovirus) serologieigg",
					"CMV(cytomegalovirus)",
					"serologie igg",
					"CMV(Cytomegalovirus) serologie igg",
					"CMV(Cytomegalovirus) serologie igm",
					"igo totales immunoglobulilneE",
					"Fructosamine",
					"Procalcitonnie",
					"Lonogramme urinaire(NA+,K+,CL)",
					"AFP,Calcium urinaire",
					"Bilan connectivites",
					"Hepatite A-anticorps igm HAV",
					"Groupagephenotype",
					"Taux de retyculocites",
					"Uree urinaire",
					"Maladie coeliaque igA",
					"Thyroglobuline tg",
					"TIBC",
					"NT pro BNP",
					"Spermoculture",
					"coproculture",
					"TSI",
					"Transferrine",
					"Calcitonine",
					"Auto anticorps specifique des hepathopathies auto immunes(AMA Mé,M3 3E,Sp100,PML,gp210,LKM1,LC 1,SLA,Lp,Ro 52)",
					"Insulinemie",
					"anticorps anti ADn natif(titrage et dosage)",
					"CHlamydie tranchomatis",
					"ECB du prelevement vigital ",
					"Sang dans les selles(hemocultures)",
					"ANCA:anticorps antiMPO et anti PR3",
					"Anticorps anti gliadine",
					"RAI panel complet",
					"igaserique",
					"R.A.I: antiD",
					"Cortisol urinaire",
					"Hepatite B - Antigene hbE",
					"IGF1",
					"Ensyme de conversion de langiotensine",
					"Spermoculture avec recherche de mycoplasme",
					"Helicobacter pylori,serologie , HLa b27",
					"IGE specifique:Melange mixte",
					"Quantiferon",
					"TH",
					"Amalyse sanguine",
					"HepatiteB-anticorps anti-hbe",
					"Mycoplasmes urogenitaux serologie",
					"Immunoglobuline igA serique",
					"Phosphore urinaire",
					"ebv",
					"ECB divers",
					"Clairencede lurée",
					"Immunoglobuline igG serique",
					"Recherche dist par biologie moleculaire",
					"Complement C3",
					"Complement C4",
					"Hemoculture",
					"Mononucleose infectieuse(mni)",
					"Peptide C",
					"Anticorps anti endomysium",
					"Beta 2 microglobulinemie",
					"coombs direct",
					"HBV charge virale",
					"IMMunifixation des proteins serique",
					"Sediments urinaire",
					"Toxoplasmose",
					"Bricellose",
					"Dosage quantitatif des Ig E spécifique anti lait de vache",
					"Immunoglobuline igM serique",
					"Anticorps anti mitochondries", "ECB de pus", "GH STH",
					"Haptoglobine", "Aldolase", "Chaine legeres libres Kappa",
					"chaines legeres libre lambda",
					"Electrophorese des proteines urinaires",
					"Maladie coeliaque igG", "scotch test", "CK MB",
					"Depakine", "G6PD", "Magnisium urinaire",
					"Anticorps anti cellules parietale",
					"Anticorps anti glutamate recepteur type NMDA",
					"Electrophorese sdes lipides", "Anti corps anti NMO ",
					"Anti corps anti acetylcholine recepteur",
					"Calprotectine fécale", "candidas selles",
					"goutte epaisse", "anticorps anti facteur intrinesque",
					"Anticorps specifique des vascularites",
					"anticorps specifique des myopathies inflammatoires",
					"C1 inhibiteur", "chlamydia : recherche ADN par PCR",
					"EBV VCA", "ECB DES ponctions",
					"ECB du prelevemnt urethral", "Glucosurie des 24h",
					"HCV charge viral", "Phosphate acide prostatique",
					"Proteins de Bens Jons",
					"Recherche de spermatozoide dans les urines",
					"serologie herpetique IGG", "serologie herpetique IGM",
					"Anticorps anti transporteur de ZINC8", "ASCA",
					"Amalyse urinaire", "Anticorps ANTI-IA2",
					"Anticorps ani Gangliosides igG",
					"Anticorps ani Gangliosides igM",
					"Anticors specifiques des sclerodermies systemique",
					"CH50 complement hemolytique total", "Compte daddis",
					"Ebbv ebna A igg", "Rubeole test avidite",
					"Serologie hydatique", "Ac htlv i/ii",
					"alpha 1 anti trypsine",
					"anticorps anti -ACIDE GLUTAMIQUE DECARBOXYLASE",
					"Apolipoproteine A1", "Apolipoproteine B", "Brucellose",
					"Ceruleoplasmine", "Chlamydie",
					"Cryoglobulinemie depistage", "HIv charge viral",
					"Lipasurie", "Methanefrine derives hydroxyles",
					"Myoglobine", "Onconeuronaux derives hydroxyles",
					"Myoglobine", "Onconeuronaux", "Resistance globulaire",
					"Test de falciformation", "Anticorps anti peau",
					"Anti corps specifiques de la maladie de good Pasture",
					"Cetosteroides urinaires", "Parasitologie des urines",
					"Phosphatases acide totales",
					"Recherche HPV a haut risque", "Recherche de du",
					"Serdiagnostic de widal et felix", "Tegretol"

			};

			final boolean[] checkedItems = { false, false, false, false, false,
					false, false, false, false, false, false, false, false,
					false, false, false, false, false, false, false, false,
					false, false, false, false, false, false, false, false,
					false, false, false, false, false, false, false, false,
					false, false, false, false, false, false, false, false,
					false, false, false, false, false, false, false, false,
					false, false, false, false, false, false, false, false,
					false, false, false, false, false, false, false, false,
					false, false, false, false, false, false, false, false,
					false, false, false, false, false, false, false, false,
					false, false, false, false, false, false, false, false,
					false, false, false, false, false, false, false, false,
					false, false, false, false, false, false, false, false,
					false, false, false, false, false, false, false, false,
					false, false, false, false, false, false, false, false,
					false, false, false, false, false, false, false, false,
					false, false, false, false, false, false, false, false,
					false, false, false, false, false, false, false, false,
					false, false, false, false, false, false, false, false,
					false, false, false, false, false, false, false, false,
					false, false, false, false, false, false, false, false,
					false, false, false, false, false, false, false, false,
					false, false, false, false, false, false, false, false,
					false, false, false, false, false, false, false, false,
					false, false, false, false, false, false, false, false,
					false, false, false, false, false, false, false, false,
					false, false, false, false, false, false, false, false,
					false, false, false, false, false, false, false, false,
					false, false, false, false, false, false, false, false,
					false, false, false, false, false, false, false };

			builder.setMultiChoiceItems(items, checkedItems,
					new DialogInterface.OnMultiChoiceClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which,
								boolean isChecked) {
							// Gérer la sélection de l'utilisateur
							checkedItems[which] = isChecked;
						}
					});

			builder.setNegativeButton("Cancel",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
								int whichButton) {
							// Cacher la boîte de dialogue
							dialog.dismiss();
						}
					});

			builder.setPositiveButton("OK",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
								int whichButton) {
							// Gérer la sélection de l'utilisateur
							String selectedItems = "";
							for (int i = 0; i < checkedItems.length; i++) {
								if (checkedItems[i]) {
									selectedItems += items[i] + ", ";
								}
							}
							Toast.makeText(getApplicationContext(),
									"Selected: " + selectedItems,
									Toast.LENGTH_LONG).show();
							// pour afficher les analyse selectinner:
							type.setText(selectedItems);
						}
					});

			AlertDialog dialog = builder.create();
			dialog.show();

			// fin de edit text de type danalyse :
		}
		
	}

	

}
